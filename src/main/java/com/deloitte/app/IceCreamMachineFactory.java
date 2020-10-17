package com.deloitte.app;


// Factory class to create Ice cream machine instances
public class IceCreamMachineFactory {
	
	public static IceCreamMachine newIceCreamMachine() {
		return new IceCreamMachineImpl();
	}

}
