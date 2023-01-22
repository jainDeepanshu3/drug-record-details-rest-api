package com.github.deepanshu.assignment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.deepanshu.assignment.util.DrugRecordUtil;
import com.github.deepanshu.assignment.vo.DrugDetail;
import com.github.deepanshu.assignment.vo.Error;
import com.github.deepanshu.assignment.vo.ErrorResponse;
import com.github.deepanshu.assignment.vo.ManufacturerName;
import com.github.deepanshu.assignment.vo.MetaDetail;
import com.github.deepanshu.assignment.vo.MetaResult;
import com.github.deepanshu.assignment.vo.OpenFDABrandName;
import com.github.deepanshu.assignment.vo.Result;

@Service
public class ServiceLayer {

	private static final Logger logger = LoggerFactory.getLogger(ServiceLayer.class);

	private final RestTemplate restTemplate;

	@Value("${api.url}")
	private String apiPathUrl;

	@Autowired
	public ServiceLayer(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	DrugRecordUtil drugRecordUtil;

	public String fetchDrugRecordApplicationDetail(String manufacturerName, String brandName) {

		if (drugRecordUtil.stringNullEmptyCheck(manufacturerName)) {
			return "{No Match found}";
		}

		String drugsfdaApi = apiPathUrl + manufacturerName + "&limit=99";
		DrugDetail drugDetailResponse = null;
		String drugDetailResponseJson = null;
		try {
			drugDetailResponse = restTemplate.getForObject(drugsfdaApi, DrugDetail.class);
			
			/**
			 * Filter Drug Details response based on manufacturer name
			 **/
			drugDetailResponse = updateDrugRecordDetilBasedOnManufacturerName(drugDetailResponse, manufacturerName);

			/**
			 * Filter Drug Details response based on brand name
			 **/
			if (!drugRecordUtil.stringNullEmptyCheck(brandName)) {
				drugDetailResponse = updateDrugRecordDetilBasedOnBrandName(drugDetailResponse, brandName);
			}

			// converting Object to JsonString
			drugDetailResponseJson = drugRecordUtil.ObjectToJsonString(drugDetailResponse);

		} catch (Exception e) {
			logger.error("error occurred while fetching drug detail record {}", e);
			Error error = new Error();
			error.setMessage(e.getMessage());
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError(error);
			return drugRecordUtil.ObjectToJsonString(errorResponse);
		}
		return drugDetailResponseJson;
	}
	
	private DrugDetail updateDrugRecordDetilBasedOnManufacturerName(DrugDetail drugDetailResponse, String manufacturerName) {
		List<Result> results = drugDetailResponse.getResultList();

		if (results != null && results.size() > 0) {
			for (int i = results.size() - 1; i >= 0; i--) {
				List<ManufacturerName> openFDManufacturerNamesList = results.get(i).getOpenfdaDetail()
						.getManufacturerNameList();
				if (openFDManufacturerNamesList != null && openFDManufacturerNamesList.size() > 0) {
					boolean isManufacturerNameExisit = false;
					for (ManufacturerName openFDAManufacturerName : openFDManufacturerNamesList) {
						if (openFDAManufacturerName.getManufacturerName().toLowerCase().contains(manufacturerName.toLowerCase())) {
							isManufacturerNameExisit = true;
						}
					}
					if (!isManufacturerNameExisit) {
						results.remove(i);
					}
				}
			}
			MetaDetail metaDetail = new MetaDetail();
			MetaResult metaResult = new MetaResult();
			metaResult.setTotal(results.size());
			metaDetail.setMetaResult(metaResult);
			drugDetailResponse.setResultList(results);
			drugDetailResponse.setMetaDetail(metaDetail);
		} else {
			return drugDetailResponse;
		}
		return drugDetailResponse;
	}

	private DrugDetail updateDrugRecordDetilBasedOnBrandName(DrugDetail drugDetailResponse, String brandName) {

		List<Result> results = drugDetailResponse.getResultList();

		if (results != null && results.size() > 0) {
			for (int i = results.size() - 1; i >= 0; i--) {
				List<OpenFDABrandName> openFDABrandNameList = results.get(i).getOpenfdaDetail()
						.getOpenfdaBrandNameList();
				if (openFDABrandNameList != null && openFDABrandNameList.size() > 0) {
					boolean isBrandNameExisit = false;
					for (OpenFDABrandName openFDABrandName : openFDABrandNameList) {
						if (openFDABrandName.getBrandName().toLowerCase().contains(brandName.toLowerCase())) {
							isBrandNameExisit = true;
						}
					}
					if (!isBrandNameExisit) {
						results.remove(i);
					}
				}
			}
			MetaDetail metaDetail = new MetaDetail();
			MetaResult metaResult = new MetaResult();
			metaResult.setTotal(results.size());
			metaDetail.setMetaResult(metaResult);
			drugDetailResponse.setResultList(results);
			drugDetailResponse.setMetaDetail(metaDetail);
			drugDetailResponse.setResultList(results);
		} else {
			return drugDetailResponse;
		}
		return drugDetailResponse;
	}
}
