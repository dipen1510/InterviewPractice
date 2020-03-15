package com.multithread;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Synchronization example
		 */
		IntCounter ic = new IntCounter();
		final String resource1 = "Thread1";
		final String resource2 = "Thread2";
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		/*
		 * Threadlocal and deadlock example
		 */
		myThread mt = new myThread(ic,resource1, resource2);
		myThread mt3 = new myThread(ic,resource1, resource2);
		myThread2 mt2 = new myThread2(ic,resource2, resource1);
		System.out.println("ThreadName: " + Thread.currentThread().getName());
		
		mt.start();
		mt2.start();
		mt3.start();
		
		/*
		 * how to use wait(), notify(), notifyAll()
		 * 
		 * bank transaction example
		 */
		final Customer cs = new Customer();
		new Thread() {
			public void run() {
				cs.withdrow(15000);
			}
		}.start();
		
		new Thread() {
			public void run() {
				cs.deposite(15000);
			}
		}.start();
		
		/*
		 * Deadloack example
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1) {
					System.out.println("lock1");
					try {
		            	Thread.sleep(100);
		            	System.out.println("wait");
		            }catch(Exception e) {
		            	System.out.println(e);
		            }
					synchronized(lock2) {
						System.out.println("lock2");
					}
				}
				
				
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1) {
					System.out.println("lock2");
					try {
		            	Thread.sleep(100);
		            	System.out.println("wait");
		            }catch(Exception e) {
		            	System.out.println(e);
		            }
					synchronized(lock2) {
						System.out.println("lock1");
					}
				}
				
				
			}
			
		}).start();

	}

}
