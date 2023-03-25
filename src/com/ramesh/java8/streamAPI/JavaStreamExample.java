package com.ramesh.java8.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamExample {
	private static List<Product> productsList = new ArrayList<Product>();

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6};
		Arrays.stream(a).filter(x->x%2==0).map(x->x*x).forEach(System.out::println);
		Arrays.stream(a).boxed().filter(x->x%2==0).map(x->x*x).collect(Collectors.toList());
		List aList = Arrays.asList(a);

		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		// Without Java 8 Stream API'S
		withoutStreamAPI();
		// With Java 8 Stream API'S
		withStreamAPI();
		// With Java 8 Stream API'S and Method Reference
		withStreamAPIMethodReference();
	}

	private static void withoutStreamAPI() {
		// without Stream API's
		List<Float> productPriceList = new ArrayList<Float>();
		// filtering data of list
		for (Product product : productsList) {
			if (product.getPrice() > 25000) {
				// adding price to a productPriceList
				productPriceList.add(product.getPrice());
			}
		}

		// displaying data
		for (Float price : productPriceList) {
			System.out.println(price);
		}
	}

	private static void withStreamAPI() {
		// filtering data of list
		List<Float> productPriceList = productsList.stream()
				.filter((product) -> product.getPrice() > 25000)
				.map((product) -> product.getPrice()).collect(Collectors.toList());
		// displaying data
		productPriceList.forEach((price) -> System.out.println(price));
	}

	private static void withStreamAPIMethodReference() {
		// filtering data of list
		List<Float> productPriceList = productsList.stream()
				.filter((product) -> product.getPrice() > 25000)
				.map(Product::getPrice)
				.collect(Collectors.toList());
		// displaying data
		productPriceList.forEach(System.out::println);
	}
}