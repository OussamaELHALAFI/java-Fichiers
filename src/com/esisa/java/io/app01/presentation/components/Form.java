package com.esisa.java.io.app01.presentation.components;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Form extends JPanel {

	private static final long serialVersionUID = 1L;

	private int labelWidth = 100;
	private JPanel container;
	private ButtonPanet buttons;
	
	private Vector<LabeledTextFeild> fields;
		
	
	public Form() {
		this(100);
	}


	public Form(int labelWidth) {
		super();
		fields = new Vector<>();
		this.labelWidth = labelWidth;
		
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		add("Center", p1);
		
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		p1.add(container);
		
		buttons = new ButtonPanet();
		add("South", buttons);
	}
	
	public void addButtons(String label) {
		buttons.addButtons(label);
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setButtons(String ...labels) {
		/*for (int i = 0; i < labels.length; i++) {
			buttons.addButtons(labels[i]);
		}*/
		buttons = new ButtonPanet();
		add("south", buttons);
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}

	public void addTextField(String label, int size) {
		LabeledTextFeild t = new LabeledTextFeild(label, size, labelWidth);
		container.add(t);
		fields.add(t);
	}
	
	public void addActionListenerToButton(ActionListener listener) {
		buttons.addActionListener(listener);
	}
	
	public String getValue(int index) {
		return fields.get(index).getValue();
	}
	
	public int getIntValue(int index) {
		String s = getValue(index);
		int value = 0;
		try {
			value = Integer.parseInt(s);
		}
		catch (Exception e) {
			System.out.println("Erreur de parsing\n");
		}
		return value;
	}
	
	public double getDoubleValue(int index) {
		String s = getValue(index);
		double value = 0;
		try {
			value = Double.parseDouble(s);
		}
		catch (Exception e) {
			System.out.println("Erreur de parsing\n");
		}
		return value;
	}
	
	public void setValue(int index, Object value) {
		LabeledTextFeild f = fields.get(index);
		f.setValue(value);
	}

}
