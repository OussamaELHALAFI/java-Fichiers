package com.esisa.java.io.app01.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

import com.esisa.java.io.app01.models.Product;

public class BinaryFileProductDAO implements ProductDAO {
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Vector<Product> load() {
		Vector<Product> list = new Vector<>();
		File f = new File(source);
		if(f.exists()) {
			try {
				FileInputStream fis = new FileInputStream(source);
				DataInputStream in = new DataInputStream(fis);
				int np = in.readInt();
				for (int i = 0; i < np; i++) {
					Product p = new Product();
					list.add(p);
					p.setId(in.readInt());
					int n = in.readInt();
					byte t[] = new byte[n];
					in.read(t);
					p.setName(new String(t));
					p.setPrice(in.readDouble());
				}
				in.close();
				}
			catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
		}
		return list;
	}

	public BinaryFileProductDAO(String source) {
		super();
		this.source = source;
	}

	public void save(Vector<Product> list) {
		try {
			FileOutputStream fos = new FileOutputStream(source);
			DataOutputStream out = new DataOutputStream(fos);
			out.writeInt(list.size());
			for (Product p : list) {
				out.writeInt(p.getId());
				out.writeInt(p.getName().length());
				out.writeBytes(p.getName());
				out.writeDouble(p.getPrice());
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

}
