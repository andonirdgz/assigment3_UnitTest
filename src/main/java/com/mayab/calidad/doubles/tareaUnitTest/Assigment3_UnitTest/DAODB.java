package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

import java.util.HashMap;

public class DAODB implements DAO {
	
	HashMap<Integer, Account> accountsHashMap = new HashMap<Integer, Account>();
	HashMap<String, Double> transactions = new HashMap<String, Double>();
	
	@Override
	public void addAccount(Account a) {
		
	}

	@Override
	public void deleteAccount(Account a) {
		
	}

	@Override
	public void deposit(Account a, int amount) {
		
	}

	@Override
	public void withdraw(Account a, int amount) {
		
	}

	@Override
	public int getNumeroDeCuentas() {
		return 0;
	}

	@Override
	public Account getAccount(int id) {
		return null;
	}
	
	
	public HashMap<Integer, Account> getHashMap(){
		return null;
	}

}
