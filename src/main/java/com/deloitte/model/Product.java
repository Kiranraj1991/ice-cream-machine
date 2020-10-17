package com.deloitte.model;
import java.util.List;

//Product contains the final stuff--> ice cream + change
public class Product {

	private Flavors flavor;
	private List<Coin> coins;
	
	
	public Product(Flavors flavor, List<Coin> coins) {
		super();
		this.flavor = flavor;
		this.coins = coins;
	}


	public Flavors getFlavor() {
		return flavor;
	}


	public List<Coin> getCoins() {
		return coins;
	}
	
	
	
}
