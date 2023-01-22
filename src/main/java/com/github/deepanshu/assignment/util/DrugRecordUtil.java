package com.github.deepanshu.assignment.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DrugRecordUtil {

	public boolean stringNullEmptyCheck(String str) {
		if (StringUtils.isBlank(str) || (str.startsWith("\"") && str.endsWith("\""))
				|| (str.startsWith("\'") && str.endsWith("\'")) || ((str.startsWith("\'")
						|| (str.startsWith("\"")) && (str.length() == 2 || str.length() == 1 || str.length() == 0)))) {
			return true;
		} else {
			return false;
		}
	}

	public String ObjectToJsonString(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {

		}
		return obj.toString();
	}

}
