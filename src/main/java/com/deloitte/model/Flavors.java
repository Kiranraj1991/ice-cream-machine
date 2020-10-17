package com.deloitte.model;
//Ice cream flavors present in the Ice cream machine

public enum Flavors {

	CHOCOLATE("Chocolate", 11), VANILLA("Vanilla", 21), STRAWBERRY("Strawberry", 10);
	
	private String flavorName;
	private int price;
	
	private Flavors(String flavorName, int price) {
		this.flavorName = flavorName;
		this.price = price;
	}
	
	public String getFlavorName() {
		return flavorName;
	}
	
	public int getPrice() {
		return price;
	}
	
}
