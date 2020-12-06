package com.esisa.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Examples {

	public Examples() {
		exp01();
	}
/*
 *Ecriture texte a l'aide de la classe : FileWriter
 *char, int, char[], String
 */
	void exp01() {
		try {
			FileWriter out = new FileWriter("resources/Exp01.txt");
			out.write("Une caine de caractè\rres\n");
			out.write('A');
			out.write(65);
			out.write(new char[] {' ', 'J', 'A', 'V', 'A'});
			out.close();
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exp02() {
		try {
			PrintWriter out = new PrintWriter("resources/Exp02.txt");
			out.write("Une caine de caractères");
			out.write('A');
			out.write(65);
			out.write(new char[] {' ', 'J', 'A', 'V', 'A'});
			
			out.println();
			out.println(65);
			out.println(3.14);
			out.println("Une nouvelle chaine de caracteres");
			out.println(true);
			out.println(new point(20, 30));
			out.println(new point(45, 34));
			out.println(new point(79, 17));
			
			out.close();
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exp03() {
		try {
			PrintStream out = new PrintStream("resources/Exp03.txt");
			//out.write("Une caine de caractères");
			out.write('A');
			out.write(65);
			//out.write(new char[] {' ', 'J', 'A', 'V', 'A'});
			
			out.println();
			out.println(65);
			out.println(3.14);
			out.println("Une nouvelle chaine de caracteres");
			out.println(true);
			out.println(new point(20, 30));
			out.println(new point(45, 34));
			out.println(new point(79, 17));
			
			out.close();
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exp04() {
		int c;
		//char[] a=null;
		try {
			//FileReader in = new FileReader("resources/Exp02.txt");
			FileReader in = new FileReader("src/com/esisa/java/io/Examples.java");
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			
			
			in.close();
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exp05() {
		try {
			FileReader in = new FileReader("src/com/esisa/java/io/Examples.java");
			char t[] = new char[100];
			int n = in.read(t);
			while(n > 0) {
				String s = new String(t, 0, n);
				System.out.print("[" + s + "]");
				n = in.read(t);
			}
			
			
			in.close();
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exp06() {
		try {
			File f = new File("src/com/esisa/java/io/Examples.java");
			if (f.exists()) {
			int n = (int)f.length();
			FileReader in = new FileReader(f);
			char t[] = new char[n];
			in.read(t);
			String s = new String(t);
			System.out.print(s);
			n = in.read(t);
			in.close();
		}
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		new Examples();
	}
	
}



