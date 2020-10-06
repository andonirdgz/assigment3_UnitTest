package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class TestAlerts {
	
	private AlertListener  alert;
	private Account account;
	
	@Before
	public void beforTest() {
		
		alert = mock(AlertListener.class);
		account = new Account(1, "testUser", 1000, 1, alert);
		
	}
	
	@Test
	public void testAlertSendingIfBalanceBelow100() {
		
		System.out.println("Balance: " + account.getBalance());
		account.debit(892);
		System.out.println("Balance after: " + account.getBalance());
		
		verify(alert).sendAlert(account.getHolder() + ", your account balance is below 100");
		
	}

}
