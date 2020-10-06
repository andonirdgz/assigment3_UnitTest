package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestCommisions {
	
	private Account account;
	
	@Before
	public void beforeTest() {
		account = mock(Account.class);
		setUpAccount();
	}
	
	public void setUpAccount() {
		when(account.getComisionsList()).thenReturn(new ArrayList<Integer>());
		
		when(account.getCommisionRate()).then(new Answer<Float>() {
			public Float answer(InvocationOnMock invocation) throws Throwable {
				float commision = 0.0f;
		    	if (account.getZone() == 1 ) {
		    		commision = 0.01f;
				}else if (account.getZone() == 2) {
					commision = 0.02f;
				}else if (account.getZone() == 3) {
					commision = 0.03f;
				}
				return commision;
			}
		});
		
		when(account.getZone()).thenReturn(1);
		when(account.getBalance()).thenReturn(1000);
	}
	
	@Test
	public void testCommisions() {
		when(account.debit(anyInt())).then(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Integer arg = (Integer) invocation.getArguments()[0];
				account.getComisionsList().add((int) (arg * account.getCommisionRate()));
				return false;
			}
		});
		
		when(account.credit(anyInt())).then(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Integer arg = (Integer) invocation.getArguments()[0];
				account.getComisionsList().add((int) (arg * account.getCommisionRate()));
				return false;
			}
		});
		
		when(account.calculateCommisionsTotal()).then(new Answer<Float>() {
			public Float answer(InvocationOnMock invocation) throws Throwable{
				float commisions = 0.0f;
				for(float i:account.getComisionsList()) {
					commisions += i;
				}
				return commisions;
			}
		});
		
		account.debit(100);
		account.debit(200);
		account.credit(300);
		
		assertThat(account.calculateCommisionsTotal(), is(6));
 	}
	
}
