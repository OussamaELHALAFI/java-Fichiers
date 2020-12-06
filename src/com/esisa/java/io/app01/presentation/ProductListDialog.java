package com.esisa.java.io.app01.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.esisa.java.io.app01.business.ProductManager;
import com.esisa.java.io.app01.models.Product;
import com.esisa.java.io.app01.presentation.components.Form;

public class ProductListDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private ProductManager service;
	private Form form;
	private Product list[];
	private int current = 0;
	
	public ProductManager getService() {
		return service;
	}

	public void setService(ProductManager service) {
		this.service = service;
		list = service.select();
		print();
	}
	
	public void print() {
		if (current >= 0 && current < list.length) {
			form.setValue(0, list[current].getId());
			form.setValue(1, list[current].getName());
			form.setValue(2, list[current].getPrice());
		}
	}

	public void init() {
		setTitle("Listes des produits");
		form = new Form();
		form.addTextField("Identificateur", 15);
		form.addTextField("Titre", 40);
		form.addTextField("Prix", 10);
		
		form.addButtons("Premier");
		form.addButtons("Precedent");
		form.addButtons("Suivant");
		form.addButtons("Dernier");
		
		form.addActionListenerToButton(this);
		setContentPane(form);
		pack();
		setResizable(false);
	}
	
	public ProductListDialog(JFrame parent) {
			super(parent, true);
			init();
			setLocationRelativeTo(parent);//afficher la forme au centre de nouveau document
		}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton src = (JButton)e.getSource();
			if (src.getText().equals("Premier")) {
				current = 0;
			}
			else if (src.getText().equals("Precedent")) {
				if(current > 0) current--;
			}
			else if (src.getText().equals("Suivant")) {
				if (current < list.length - 1 ) current++;
			}
			else if (src.getText().equals("Dernier")) {
				current = list.length - 1;
			}
			print();
		}
	}

}
