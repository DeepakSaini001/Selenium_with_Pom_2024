package org.utils;

import java.io.IOException;
import java.io.InputStream;

import org.Objects.BillingAddress;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

	public static BillingAddress desirilization(InputStream is, BillingAddress billingAddress)
			throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(is, billingAddress.getClass());

	}

}
