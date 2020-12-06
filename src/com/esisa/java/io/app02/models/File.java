package com.esisa.java.io.app02.models;

public class File extends DiskComponent {

	/*public File() {
	}*/

	public File(String name, long size, DiskComponent parent) {
		super(name, size, parent);
	}

	public File(String name, long size) {
		super(name, size);
	}

	public boolean isFile() {
		return true;
	}

	public boolean isFolder() {
		return false;
	}

	public void print(String margin) {
		System.out.println(margin + " - " + getName());
	}

}
