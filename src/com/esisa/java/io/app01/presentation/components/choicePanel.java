package com.esisa.java.io.app01.presentation.components;

import java.awt.FlowLayout;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class choicePanel extends JPanel {
	public static final int CHECK = 0;
	public static final int RADIO = 1;
	public static final int COMBO = 2;
	
	public int style = CHECK;
	private ButtonGroup group;
	
	private Hashtable<String, JCheckBox> components;

	public choicePanel(String label) {
		// TODO Auto-generated constructor stub
		if (!label.contains(":")) {
			label = label + " : ";
		}
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel(label));
		
		components = new Hashtable<>();
		group = new ButtonGroup();
	}
	
	public choicePanel(int style, String label) {
		this(label);
		this.style = style;
	}
	
	public choicePanel(int style, String label, String ...choices) {
		this(style, label);
		for ( String choice : choices) {
			addChoice(choice);
		}
	}
	
	public choicePanel(String label, String ...choices) {
		this(label);
		for (String choice : choices) {
			addChoice(choice);
		}
	}

	public void addChoice(String choice) {
		if (style == CHECK) {
		JCheckBox b = new JCheckBox(choice);
		add(b);
		components.put(choice, b);
		}
		else if (style == RADIO) {
			JRadioButton b = new JRadioButton(choice);
			add(b);
			group.add(b);
		}
	}
	
	public void setChoice0(String choice, boolean state) {
		for (int i = 1; i < getComponentCount(); i++) {
			JCheckBox b = (JCheckBox)getComponent(i);
			if (b.getText().contentEquals(choice)) {
				b.setSelected(state);
			}
		}
	}
	
	public void setChoice(String choice, boolean state) {
		JCheckBox b = components.get(choice);
		if (b != null) {
			b.setSelected(state);
		}
}
	
	public String []getChoices() {
		String t[];
		Vector<String> v = new Vector<>();
		for (int i = 1; i < getComponentCount(); i++) {
			JCheckBox b = (JCheckBox)getComponent(i);
			if (b.isSelected()) {
				v.add(b.getText());
			}
		}
		t = new String[v.size()];
		v.toArray(t);
		return t;
	}
	
	
	
}
