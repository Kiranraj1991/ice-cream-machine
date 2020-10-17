package com.deloitte.model;
//Coins accepted by Ice cream Machine
public enum Coin {
	
	CENT(1), NICKLE(5), DIME(10), QUARTER(25);
	
	private int amount;

	private Coin(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	
}
