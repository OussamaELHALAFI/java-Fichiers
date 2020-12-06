package com.esisa.java.io.app01.dao;

import java.util.Vector;

import com.esisa.java.io.app01.models.Product;

public interface ProductDAO {
	public Vector<Product> load();
	public void save(Vector<Product> list);

}
