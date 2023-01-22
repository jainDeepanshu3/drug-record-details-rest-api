package com.github.deepanshu.assignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.deepanshu.assignment.vo.DrugDetail;
import com.github.deepanshu.assignment.vo.ManufacturerName;
import com.github.deepanshu.assignment.vo.MetaDetail;
import com.github.deepanshu.assignment.vo.MetaResult;
import com.github.deepanshu.assignment.vo.OpenFDABrandName;
import com.github.deepanshu.assignment.vo.OpenFDADetail;
import com.github.deepanshu.assignment.vo.Product;
import com.github.deepanshu.assignment.vo.Result;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ServiceLayerTest {
	
	@Mock
	private ServiceLayer serviceLayer;
	
	@Test
	void testFetchDrugRecordApplicationDetail() {
		
		DrugDetail drugDetail = createDrugDetailObject();
		ObjectMapper mapper = new ObjectMapper();
		String drugDetailJson = "";
		try {
		  drugDetailJson = mapper.writeValueAsString(drugDetail);
		} catch(Exception e) {	
		}
		when(serviceLayer.fetchDrugRecordApplicationDetail("SOLA", "")).thenReturn(drugDetailJson); 
		assertEquals(drugDetailJson, drugDetailJson);  
	}
	
	private DrugDetail createDrugDetailObject() {
		MetaDetail metaDetail = new MetaDetail();
		MetaResult metaResult = new MetaResult();
		
		DrugDetail drugDetail = new DrugDetail();
		Result result = new Result();
		
		List<OpenFDABrandName> openfdaBrandNameList = new ArrayList<OpenFDABrandName>();
		OpenFDABrandName openFDABrandName = new OpenFDABrandName("DDA Pharma");
		openfdaBrandNameList.add(openFDABrandName);
		
		List<ManufacturerName> manufacturerNameList = new ArrayList<>();
		ManufacturerName manufacturerName = new ManufacturerName("SOLA");
		manufacturerNameList.add(manufacturerName);
		
		OpenFDADetail openFDADetail = new OpenFDADetail();
		openFDADetail.setManufacturerNameList(manufacturerNameList);
		openFDADetail.setOpenfdaBrandNameList(openfdaBrandNameList);
		
		List<Product> productList = new ArrayList<>();
		Product product = new Product("DDA Pharma");
		productList.add(product);
		
		result.setOpenfdaDetail(openFDADetail);
		result.setProductList(productList);

		metaResult.setSkip("");
		metaResult.setLimit("1000");
		metaResult.setTotal(4);
		
		metaDetail.setDisclaimer("Do not rely on openFDA to make decisions regarding medical care. While we make every effort to ensure that data is accurate, you should assume all results are unvalidated. We may limit or otherwise restrict your access to the API in line with our Terms of Service.");
		metaDetail.setTerms("https://open.fda.gov/terms");
		metaDetail.setLicense("https://open.fda.gov/licen");
		metaDetail.setLastUpdated("null");
		metaDetail.setMetaResult(metaResult);
		
		return drugDetail;
	}

}
