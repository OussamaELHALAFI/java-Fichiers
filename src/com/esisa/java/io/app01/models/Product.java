package com.esisa.java.io.app01.models;

import java.io.Serializable;

public class Product implements Serializable{
	private int id;
	private String name;
	private double price;

	public Product() {
		
	}
	
	public Product(String row) {
		String t[] = row.split(",");

		this.name = t[1];
		
		try {
			this.id = Integer.parseInt(t[0]);
		}
		catch (Exception e) {}
		try {
			this.price = Double.parseDouble(t[2]);	
		}
		catch (Exception e) {}
		
	}

	@Override
	public String toString() {
		return id + "," + name + "," + price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
