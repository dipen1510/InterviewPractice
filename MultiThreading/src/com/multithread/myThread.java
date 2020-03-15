package com.multithread;

public class myThread extends Thread{
	IntCounter i1;
	String resource1;
	String resource2;
	myThread(IntCounter i1, String resource1, String resource2){
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
            synchronized(resource1){
            	System.out.println(resource1);
            }
            try {
            	Thread.sleep(100);
            }catch(Exception e) {
            	System.out.println(e);
            }
            synchronized(resource2){
            	System.out.println(resource2);
            }
        
            System.out.println(i1.counter(10));
	}

}
