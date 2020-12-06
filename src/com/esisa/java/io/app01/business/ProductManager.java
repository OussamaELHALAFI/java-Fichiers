package com.esisa.java.io.app01.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.Vector;

import com.esisa.java.io.app01.dao.ProductDAO;
import com.esisa.java.io.app01.models.Product;

public class ProductManager {
	private ProductDAO productDAO;
	private Vector<Product> list;

	public ProductManager() {
		list = new Vector<>();
	}

	public ProductManager(ProductDAO productDAO) {
		setProductDAO(productDAO);
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
		load();
	}

	public void insert(Product P) {
		list.add(P);
	}
	
	public void update(Product p) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == p.getId()) {
				list.set(i, p);
				return;
			}
		}
	}
	
	public void delete(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return;
			}
		}		
	}
	
	public Product[] select() {
		Product t[] = new Product[list.size()];
		list.toArray(t);
		return t;
	}
	
	public void save() {
		productDAO.save(list);
	}
	
	public void load() {
		list = productDAO.load();
	}

}
