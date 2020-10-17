package com.deloitte.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.deloitte.app.IceCreamMachine;
import com.deloitte.app.IceCreamMachineFactory;
import com.deloitte.exceptions.NotPaidException;
import com.deloitte.exceptions.OutOfStockException;
import com.deloitte.model.Coin;
import com.deloitte.model.Flavors;
import com.deloitte.model.Product;

public class IceCreamMachineTest {

	private static IceCreamMachine iceCreamMachine;

	@BeforeClass
	public static void intiailize() {
		iceCreamMachine = IceCreamMachineFactory.newIceCreamMachine();
	}

	@AfterClass
	public static void destroy() {
		iceCreamMachine = null;
	}

	@Test
	public void buyProductWithExactAmount() {

		int price = iceCreamMachine.getPrice(Flavors.STRAWBERRY);

		assertEquals(Flavors.STRAWBERRY.getPrice(), price);

		iceCreamMachine.acceptCoin(Coin.DIME);

		Product p = iceCreamMachine.getProduct();
		Flavors f = p.getFlavor();
		List<Coin> refund = p.getCoins();

		assertEquals(Flavors.STRAWBERRY, f);

		assertTrue(refund.isEmpty());

	}


	@Test(expected = OutOfStockException.class)
	public void testSoldOut() {
		for (int i = 0; i < 11; i++) {
			iceCreamMachine.getPrice(Flavors.CHOCOLATE);
			iceCreamMachine.acceptCoin(Coin.QUARTER);
			iceCreamMachine.getProduct();
		}
	}

	@Test(expected = NotPaidException.class)
	public void testNotPaidException() {
		iceCreamMachine.getPrice(Flavors.CHOCOLATE);
		iceCreamMachine.getProduct();
	}

}
