package com.renho.chapter5.recipe01.core;

import java.util.Date;
import java.util.List;

import com.renho.chapter5.recipe01.util.Product;
import com.renho.chapter5.recipe01.util.ProductListGenerator;

public class Client {

	public static void main(String[] args) {
		long start = (new Date()).getTime();
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(8000000);
		
		for(int i=0; i<products.size(); i++) {
			products.get(i).setPrice(products.get(i).getPrice() * 0.2);
		}
		long end = (new Date()).getTime();
		System.out.println(end - start);
	}

}
