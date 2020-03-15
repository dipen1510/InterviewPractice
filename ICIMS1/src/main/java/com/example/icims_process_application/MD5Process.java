package com.example.icims_process_application;

import org.springframework.util.DigestUtils;

public class MD5Process {
	Item[] items;
	MD5Process(Item[] items){
		this.items = items;
	}

	public void readSeq() throws InterruptedException {
		for(Item item : items) {
			//converting uid into md5 hash
			String result = DigestUtils.md5DigestAsHex(item.uid.getBytes());
			System.out.println("uid : " + item.uid + " : md5Hash value : " + result + " : " + Thread.currentThread().getName());
		}
	}
}
