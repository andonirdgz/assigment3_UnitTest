package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

public interface DAO {
	
	void addAccount(Account a);
	
	void deleteAccount(Account a);
	
	void deposit(Account a, int amount);
	
	void withdraw(Account a, int amount);
	
	int getNumeroDeCuentas();
	
	Account getAccount(int id);
}
