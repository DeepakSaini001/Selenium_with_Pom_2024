package org.dataproviders;

import org.Objects.Product;
import org.testng.annotations.DataProvider;
import org.utils.JacksonUtils;

import java.io.IOException;

public class MyDataProvider {

	@DataProvider(name = "getFeaturedProducts", parallel = false)
	public Object[] getFeaturedProducts() throws IOException {
		return JacksonUtils.deserializeJson("products.json", Product[].class);
	}
}
