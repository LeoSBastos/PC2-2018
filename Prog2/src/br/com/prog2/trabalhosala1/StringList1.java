package br.com.prog2.trabalhosala1;

import java.util.ArrayList;

public class StringList1 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < 200; i++) {
			arr.add("Eu escrevi isso sem loop " + (i + 1) + " vezes");
			for (String s : arr) {
				System.out.println(s);
			}
		}
	}
}
