package com.multithread;

public class Customer {
	
	int amount = 10000;
	
	synchronized void withdrow(int amount) {
		
		if(this.amount < amount) {
			System.out.println("wait for deposite");
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		this.amount -= amount;
		System.out.println("withdraw completed...");  
		System.out.println(this.amount);
	}
	
	synchronized void deposite(int amount) {
		this.amount += amount;
		System.out.println("deposite done");
		System.out.println(this.amount);
		notifyAll();
	}

}
