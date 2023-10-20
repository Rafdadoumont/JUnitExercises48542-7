package org.example.exercise1;

import org.example.exercise1.Product;
import org.example.exercise1.ProductNotFoundException;

import java.util.*;

public class ShoppingCart {
	
	private final ArrayList<Product> products;
	
	public ShoppingCart() {
		products = new ArrayList<Product>();
	}
	
	public double getBalance() {
		double balance = 0.00;
		for (Product item : products) {
			balance += item.getPrice();
		}
		return balance;
	}
	
	public void addItem(Product item) {
		products.add(item);
	}
	
	public void removeItem(Product item)
			throws ProductNotFoundException {
		if (!products.remove(item)) {
			throw new ProductNotFoundException();}
	}
	
	public int getItemCount() {
		return products.size();
	}
	
	public void empty() {
		products.clear();
	}
}

