package com.multithread;

public class IntCounter {
	
	protected long count = 0;
	
	public long counter(long value) {
		
		
		
		try {
			//Thread.sleep(1000);
			synchronized (this){
				this.count = this.count + value;
			}
		}catch(Exception e)
		{
			System.out.println(e);
		
		}
		
		return this.count;
		
	}

}
