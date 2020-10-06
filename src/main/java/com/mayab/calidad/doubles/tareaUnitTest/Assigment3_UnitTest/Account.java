package com.mayab.calidad.doubles.tareaUnitTest.Assigment3_UnitTest;

public class Account {
    
    int balance;
    String holder;
    int zone;
    AlertListener alerts;
	private int id;

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

    void debit(int balance) {
    	float c = getCommision();
    	float multiplier = 1 + c;
        this.balance -= balance * multiplier;
        
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
    }

    void credit(int balance) {
    	float c = getCommision();
    	float multiplier = 1 - c;
        this.balance += balance * multiplier;
    }
    
    float getCommision() {
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
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
}
