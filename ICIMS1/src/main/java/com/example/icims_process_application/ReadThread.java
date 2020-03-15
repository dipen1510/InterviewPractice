package com.example.icims_process_application;

public class ReadThread extends Thread{

	MD5Process md5Hash;
	
	ReadThread(MD5Process md5Hash){
		this.md5Hash = md5Hash;
	}
	@Override
    public void run() {
        try {
        	md5Hash.readSeq();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
