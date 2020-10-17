package com.deloitte.model;
import java.util.HashMap;
import java.util.Map;

//This is used to hold Ice cream flavors
public class IceCreamStore {

	private Map<Flavors, Integer> totalIceCream= new HashMap<Flavors, Integer>();
	
	public int getQuantity(Flavors flavor) {
		if(totalIceCream.get(flavor)!=null)
			return totalIceCream.get(flavor);
		else return 0;
	}
	
	public void addFlavor(Flavors flavor) {
		totalIceCream.put(flavor, getQuantity(flavor)+1);
	}
	
	public boolean flavorExists(Flavors flavor) {
		return getQuantity(flavor)>0;
	}
	
	public void withdraw(Flavors flavor) {
		if(flavorExists(flavor)) {
			totalIceCream.put(flavor, totalIceCream.get(flavor)-1);
		}
	}
	
	public void put(Flavors flavor,int quantity) {
		totalIceCream.put(flavor,quantity);
	}
}
