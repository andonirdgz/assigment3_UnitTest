package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

import java.util.ArrayList;

public class Account {
    
    private int balance;
    private String holder;
    private int zone;
    private AlertListener alerts;
	private int id;
	private ArrayList<Integer> transactions = new ArrayList<>();
	private ArrayList<Integer> commisions = new ArrayList<>();
	

    public Account(Integer id, String holder, int initialBalance, int zone, AlertListener alert){
        this.id = id;
    	this.holder = holder;
        this.balance = initialBalance;
        this.zone = zone;
        this.alerts = alert;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    
    public int getZone() {
    	return this.zone;
    }

    boolean debit(int balance) {
    	float c = getCommisionRate();
    	float multiplier = 1 + c;
    	int commision = (int) (balance * multiplier);
        this.balance -= commision;
        
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
        
        this.transactions.add(balance);
        this.commisions.add(commision);
        
        return false;
    }

    boolean credit(int balance) {
    	float c = getCommisionRate();
    	float multiplier = 1 - c;
    	float commision = balance * multiplier;
        this.balance += commision;
        
        this.transactions.add(balance);
        this.commisions.add((int) commision);
        return false;
    }
    
    float getCommisionRate() {
    	float commision = 0.0f;
    	if (this.zone == 1 ) {
    		commision = 0.01f;
		}else if (this.zone == 2) {
			commision = 0.02f;
		}else if (this.zone == 3) {
			commision = 0.03f;
		}
		return commision;
    }
    
    int calculateCommisionsTotal() {
    	int total = 0;
    	for (Integer i: this.commisions) {
			total += i; 
		}
    	return total;
    }
    
    public ArrayList<Integer> getComisionsList() {
		return commisions;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
}
