package com.deloitte.app;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.exceptions.NotEnoughChangeException;
import com.deloitte.exceptions.NotPaidException;
import com.deloitte.exceptions.OutOfStockException;
import com.deloitte.model.Coin;
import com.deloitte.model.CoinRegister;
import com.deloitte.model.Flavors;
import com.deloitte.model.IceCreamStore;
import com.deloitte.model.Product;


//Implementation of Ice cream Machine
public class IceCreamMachineImpl implements IceCreamMachine {

	//register of Coins in the ice cream machine
	private CoinRegister coinRegister = new CoinRegister();
	//ice cream present in the ice cream machine
	private IceCreamStore iceCreamStore = new IceCreamStore();
	// the flavor selected by the customer
	private Flavors selectedFalvor;
	//the current balance
	private int balance;
	//total amount of sales
	private int transaction;

	
	//initialiation
	public IceCreamMachineImpl() {
		// Add few coins and few flavors of Ice cream e.g 10 each

		for (Coin c : Coin.values())
			coinRegister.put(c, 10);

		for (Flavors f : Flavors.values())
			iceCreamStore.put(f, 10);
	}

	
	//change to be paid  i.e total amount given by customer- the price of flavor selected 
	@Override
	public List<Coin> payBack() {
		int amt = balance - selectedFalvor.getPrice();
		List<Coin> changes = getBalance(amt);
		updateCoinRegister(changes);
		balance = 0;
		selectedFalvor = null;
		return changes;
	}

	
	// the coin put by the customer
	@Override
	public void acceptCoin(Coin coin) {
		balance = balance + coin.getAmount();
		coinRegister.addCoin(coin);
	}

	
	// Product contains the ice cream and the change
	@Override
	public Product getProduct() {
		
		Flavors flavor=fetchIceCream();
		transaction+=selectedFalvor.getPrice();
		List<Coin> balance=payBack();

		Product p= new Product(flavor, balance);
		
		return p;
	}

	
	//get the price of the ice cream flavor selected by customer
	@Override
	public int getPrice(Flavors flavor) {
		if (iceCreamStore.flavorExists(flavor)) {
			selectedFalvor = flavor;
			return selectedFalvor.getPrice();
		} else
			throw new OutOfStockException(flavor.getFlavorName() + " is out of stock,please choose different flavour");
	}
	
	// gives the total trading, ice cream flavors present in the machine and the coin register
	@Override
	public void CurrentStanding() {
		System.out.println("Total Trading : "+ transaction);
		System.out.println("Ice Cream Store Status :");
		for (Flavors f : Flavors.values()) {
			System.out.println(f.getFlavorName()+" Quantity : "+ iceCreamStore.getQuantity(f));
		}
		
		System.out.println("Coin Register Status : ");
		for (Coin c : Coin.values()) {
			System.out.println(c.name()+" Quantity : "+coinRegister.getQuantity(c));
		}
		
	}

	public List<Coin> getBalance(int amt) throws NotEnoughChangeException {
		List<Coin> changes = new ArrayList<Coin>();
		;
		if (amt > 0) {
			long amount = balance;
			while (amount > 0) {
				if (amount >= Coin.QUARTER.getAmount() && coinRegister.coinExists(Coin.QUARTER)) {
					changes.add(Coin.QUARTER);
					amount = amount - Coin.QUARTER.getAmount();
					continue;

				} else if (amount >= Coin.DIME.getAmount() && coinRegister.coinExists(Coin.DIME)) {
					changes.add(Coin.DIME);
					amount = amount - Coin.DIME.getAmount();
					continue;

				} else if (amount >= Coin.NICKLE.getAmount() && coinRegister.coinExists(Coin.NICKLE)) {
					changes.add(Coin.NICKLE);
					amount = amount - Coin.NICKLE.getAmount();
					continue;

				} else if (amount >= Coin.CENT.getAmount() && coinRegister.coinExists(Coin.CENT)) {
					changes.add(Coin.CENT);
					amount = amount - Coin.CENT.getAmount();
					continue;

				} else {
					throw new NotEnoughChangeException("Not enough change,Please select another flavor");
				}
			}
		}
		return changes;
	}

	private Flavors fetchIceCream() {
		if (checkAmount()) {
			if(hasEnoughChange()) {
				iceCreamStore.withdraw(selectedFalvor);
				return selectedFalvor;
			}
			else throw new NotEnoughChangeException("Not enough change in register");
		}
		
		else {
			int remaining=selectedFalvor.getPrice()-balance;
			throw new NotPaidException("Amount not sufficient,Please add amount "+ remaining);
		}
	}

	private boolean checkAmount() {
		if (balance >= selectedFalvor.getPrice())
			return true;

		return false;
	}

	private void updateCoinRegister(List<Coin> coins) {
		for (Coin c : coins) {
			coinRegister.withdraw(c);
		}
	}

	private boolean hasEnoughChange() {
		int amt=balance=selectedFalvor.getPrice();
		
		try {
			getBalance(amt);
		}
		catch (NotEnoughChangeException e) {
			
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

}
