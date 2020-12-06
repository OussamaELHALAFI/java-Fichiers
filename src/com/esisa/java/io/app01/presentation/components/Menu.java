package com.esisa.java.io.app01.presentation.components;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private String path = "resources/icons/";
	private String suffix = ".png";
	private Vector<JMenuItem> items;
	
	public Menu() {
		items = new Vector<>();
	}

	public Menu(String M[][]) {
		items = new Vector<>();
		for (int i = 0; i < M.length; i++) {
			addMenu(M[i]);
		}
	}
	
	public void addMenu(String t[]) {
		JMenu m = new JMenu(t[0]);
		add(m);
		for (int j = 1; j < t.length; j++) {
			if (t[j].equals("-")) {
				m.addSeparator();
			}
			else
			{
				ImageIcon icon = new ImageIcon(path + t[j].toLowerCase() + suffix);
				JMenuItem item = new JMenuItem(t[j], icon);
				m.add(item);
				items.add(item);
			}
		}
	}
	
	public void addActionListener(ActionListener listener) {
		for (JMenuItem item : items) {
			item.addActionListener(listener);
		}
	}
	
	
}
