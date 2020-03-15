package com.example.icims_process_application;

public class Item {

	long index;
	String uid;
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Item [index=" + index + ", uid=" + uid + "]";
	}
	
	
}
