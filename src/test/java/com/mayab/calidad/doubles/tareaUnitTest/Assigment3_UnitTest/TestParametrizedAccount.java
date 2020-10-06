package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParametrizedAccount {
	
	AlertListener alert;
	
	@Parameters
	public static Iterable data() {
		
		return Arrays.asList(new Object[][] {
			{1, 1, 1000}, {2, 2, 2000}, {3, 3, 3000}
		});
		
	}
	
	private int id;
	private int zone;
	private int balance;
	private int expectedZone;
	private int expectedBalance;
	
	
	public TestParametrizedAccount(int id, int zone, int balance) {
		
		this.id = id;
		this.zone = zone;
		this.balance = balance;
		this.expectedZone = zone;
		this.expectedBalance = balance;
		
	}
	
	@Test
	public void testCrearCuentas() {
		
		Account account = new Account(id, "user", balance, zone, alert);
		
		assertThat(account.getZone(), is(expectedZone));
		assertThat(account.getBalance(), is(expectedBalance));
		
	}
}
