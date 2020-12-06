package com.esisa.java.io.app02;

import com.esisa.java.io.app02.models.DiskComponent;

public class Examples {
	
	public Examples() {
		exp01();
	}
	
	void exp01() {
		DiskManager manager = new DiskManager(".");
		DiskComponent root = manager.getRoot();
		root.print();
		System.out.println("Content size : " + root.getSize() + " Octets");
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}
