package com.example.icims_process_application;

import java.util.Arrays;
import java.util.List;

public class Items {

	Item[] items;

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Items [items=" + Arrays.toString(items) + "]";
	}
	
	
}
