package com.deloitte.model;
import java.util.HashMap;
import java.util.Map;

//This is used to hold coins
public class CoinRegister {

private Map<Coin, Integer> totalCoin= new HashMap<Coin, Integer>();
	
	public int getQuantity(Coin coin) {
		if(totalCoin.get(coin)!=null)
			return totalCoin.get(coin);
		else return 0;
	}
	
	public void addCoin(Coin coin) {
		totalCoin.put(coin, getQuantity(coin)+1);
	}
	
	public boolean coinExists(Coin coin) {
		return getQuantity(coin)>0;
	}
	
	public void withdraw(Coin coin) {
		if(coinExists(coin)) {
			totalCoin.put(coin, totalCoin.get(coin)-1);
		}
	}
	
	public void put(Coin coin,int quantity) {
		totalCoin.put(coin,quantity);
	}
}
