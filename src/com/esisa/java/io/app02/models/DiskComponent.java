package com.esisa.java.io.app02.models;

abstract public class DiskComponent {
	private String name;
	private long size;
	private DiskComponent parent = null;

	public DiskComponent() {
		
	}

	public DiskComponent(String name) {
		super();
		this.name = name;
	}

	public DiskComponent(String name, long size) {
		super();
		this.name = name;
		this.size = size;
	}

	public DiskComponent(String name, long size, DiskComponent parent) {
		super();
		this.name = name;
		this.size = size;
		this.parent = parent;
	}

	public DiskComponent(String name, DiskComponent parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public DiskComponent getParent() {
		return parent;
	}

	public void setParent(DiskComponent parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return parent + "/" + getName();
	}
	
	public void print() {
		print("");
	}
	
	abstract public boolean isFile();

	abstract public boolean isFolder();
	
	abstract public void print(String margin);

}
