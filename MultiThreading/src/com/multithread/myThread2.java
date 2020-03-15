package com.multithread;

public class myThread2 extends Thread{
	IntCounter i1;
	String resource1;
	String resource2;
	myThread2(IntCounter i1, String resource1, String resource2){
		this.i1= i1;
		this.resource1 = resource1;
		this.resource2 = resource2;
	}
	
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	@Override
	public void run() {
			threadLocal.set((int) (Math.random()*100));
			
			
            //Thread.sleep(1);
            //System.out.println("ThreadName : " + Thread.currentThread().getName()+ " : " + threadLocal.get());
            
            synchronized(resource2){
            	System.out.println(resource2);
            }
            try {
            	Thread.sleep(1000);
            }catch(Exception e) {
            	System.out.println(e);
            }
            synchronized(resource1){
            	System.out.println(resource1);
            }
            System.out.println(i1.counter(4));
		
		
	}

}
