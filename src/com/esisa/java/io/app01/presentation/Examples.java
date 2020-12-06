package com.esisa.java.io.app01.presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Vector;

import com.esisa.java.io.app01.business.ProductManager;
import com.esisa.java.io.app01.dao.BinaryFileProductDAO;
import com.esisa.java.io.app01.dao.FlatFileProductDAO;
import com.esisa.java.io.app01.dao.ProductDAO;
import com.esisa.java.io.app01.models.Product;

public class Examples {

	public Examples() {
		//exp01();
		exp11();
	}
	
	void exp01() {
		ProductDAO dao = new FlatFileProductDAO("resources/products.txt");
		ProductManager pm = new ProductManager(dao);
		
		pm.insert(new Product(101, "Clavier", 267));
		pm.insert(new Product(102, "Ecran", 1300));
		pm.insert(new Product(103, "Souris", 180));
		
		pm.update(new Product(102, "Scanner", 750));
		
		pm.save();
	}
	
	void exp02() {
		ProductDAO dao = new FlatFileProductDAO("resources/products.txt");
		ProductManager pm = new ProductManager(dao);
		Product t[] = pm.select();
		for (Product product : t) {
			System.out.println(" - " + product.getName());
		}
	}
	
	void exp03() {
		ProductDAO dao = new FlatFileProductDAO("resources/products.txt");
		ProductManager pm = new ProductManager(dao);
		pm.insert(new Product(104, "Ecran", 1450));
		pm.save();
	}
	
	void exp04() {
		ProductDAO dao = new FlatFileProductDAO("resources/products.txt");
		ProductManager pm = new ProductManager(dao);
		pm.delete(102);
		pm.save();
	}
	
	void exp05() {
		ProductDAO dao = new BinaryFileProductDAO("resources/products.bin");
		ProductManager pm = new ProductManager(dao);
		
		pm.insert(new Product(101, "Clavier", 267));
		pm.insert(new Product(102, "Ecran", 1300));
		pm.insert(new Product(103, "Souris", 180));
		
		pm.update(new Product(102, "Scanner", 750));
		
		pm.save();
	}
	
	void exp06() {
		ProductDAO dao = new BinaryFileProductDAO("resources/products.bin");
		ProductManager pm = new ProductManager(dao);
		Product t[] = pm.select();
		for (Product product : t) {
			System.out.println(" - " + product.getName() + " : " + product.getPrice());
		}
	}
	
	void exp07() {
		ProductDAO dao = new BinaryFileProductDAO("resources/products.bin");
		ProductManager pm = new ProductManager(dao);
		ProductListDialog d1 = new ProductListDialog(null);
		d1.setService(pm);
		d1.setVisible(true);
	}
	
	void exp007() {
		Product p1 = new Product(101, "Clavier", 270);
		try {
			OutputStream os = new FileOutputStream("resources/products.obj");
			ObjectOutputStream out = new ObjectOutputStream(os);
			//serialisation de l'objet p1
			out.writeObject(p1.getName());
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void exp08() {
		try {
			InputStream is = new FileInputStream("resources/products.obj");
			ObjectInputStream in = new ObjectInputStream(is);
			Product p1 = (Product)in.readObject();
			in.close();
			System.out.println(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void exp09() {
		Vector<Product> list = new Vector<>();
		list.add(new Product(101, "Clavier", 270));
		list.add(new Product(102, "Souris", 1600));
		list.add(new Product(103, "Ecrn", 189));
		try {
			OutputStream os = new FileOutputStream("resources/products.obj");
			ObjectOutputStream out = new ObjectOutputStream(os);
			out.writeObject(list);
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	void exp10() {
		try {
			InputStream is = new FileInputStream("resources/products.obj");
			ObjectInputStream in = new ObjectInputStream(is);
			Vector<Product> list = (Vector<Product>)in.readObject();
			in.close();
			
			for (Product product : list) {
				System.out.println(product.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void exp11() {
		File f = new File(".");
		System.out.println(" - Name : " + f.getName());
		System.out.println(" - Path : " + f.getAbsolutePath());
		System.out.println(" - File : " + f.isFile());
		System.out.println(" - Directory : " + f.isDirectory());
		System.out.println(" - length : " + f.length());
		
		System.out.println("------------------- content ------------------");
		File content[] = f.listFiles();
		for (File file : content) {
			System.out.println(" - " + file.getName() + " : " + file.isFile());
		}
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}
