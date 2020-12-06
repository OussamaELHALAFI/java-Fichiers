package com.esisa.java.io.app02.models;

import java.util.Vector;

public class Folder extends DiskComponent {
	private Vector<DiskComponent> children;
	
	public Folder(String name, DiskComponent parent) {
		super(name, parent);
		children = new Vector<>();
	}

	public Folder(String name) {
		super(name);
		children = new Vector<>();
	}
	
	public void addChild(DiskComponent cmp) {
		children.add(cmp);
	}
	
	public DiskComponent getChild(int index) {
		return children.get(index);
	}
	
	public int size() {
		return children.size();
	}
	
	public Vector<DiskComponent> getChildren() {
		return children;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isFolder() {
		return true;
	}

	public void print(String margin) {
		System.out.println(margin + "<" + getName() + ">");
		for (DiskComponent cmp : children) {
			cmp.print(margin + "   ");//indantation
		}
	}
	
	public long getSize() {
		long size = 0;
		for (DiskComponent cmp : children) {
			size += cmp.getSize();
		}
		return size;
	}

}
