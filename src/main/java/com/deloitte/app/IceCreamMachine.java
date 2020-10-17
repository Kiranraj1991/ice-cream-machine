package com.deloitte.app;
import java.util.List;

import com.deloitte.model.Coin;
import com.deloitte.model.Flavors;
import com.deloitte.model.Product;

// the interface contains the methods to be implemented by the Ice cream machine
public interface IceCreamMachine {

	public Product getProduct();
	public void acceptCoin(Coin coin);
	public int getPrice(Flavors flavor);
	public List<Coin> payBack();
	public void CurrentStanding();
	
}
