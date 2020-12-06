package com.esisa.java.io.app01.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Vector;

import com.esisa.java.io.app01.models.Product;

public class FlatFileProductDAO implements ProductDAO {
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public FlatFileProductDAO() {
		
	}

	public FlatFileProductDAO(String source) {
		super();
		this.source = source;
	}
	
	public Vector<Product> load() {
		Vector<Product>list = new Vector<>();
		File f = new File(source);
		if (f.exists()) {
			try {
			Reader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);
			String row = in.readLine();
			while(row != null) {
				Product p = new Product(row);
				list.add(p);
				row = in.readLine();
			}
			}
			catch (Exception e) {
				System.out.println("erreur : " + e.getMessage());
			}
		}

		return list;
	}

	public void save(Vector<Product> list) {
		// TODO Auto-generated method stub
		try {
			//BufferedWriter w = new BufferedWriter(out);
			//w.write(Product.tos);
			PrintWriter out = new PrintWriter(source);
			for (Product product : list) {
				out.println(product);
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

}
