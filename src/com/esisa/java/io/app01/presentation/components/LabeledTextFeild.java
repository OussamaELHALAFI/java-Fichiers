package com.esisa.java.io.app01.presentation.components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextFeild extends JPanel {

	private static final long serialVersionUID = 1L;

	public LabeledTextFeild(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if (!label.contains(":")) label = label + " : ";
		JLabel l1 = new JLabel(label);
		JTextField t1 = new JTextField(size);
		add(l1);
		add(t1);
	}
	
	public LabeledTextFeild(String label, int size, int labelWidth) {
		this(label, size);
		JLabel l1 = (JLabel)getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, getPreferredSize().height));
	}

	public String getValue() {
		JTextField t1 = (JTextField)getComponent(1);
		return t1.getText();
	}
	
	public void setValue(Object value) {
		JTextField t1 = (JTextField)getComponent(1);
		t1.setText("" + value);
	}
	
}
