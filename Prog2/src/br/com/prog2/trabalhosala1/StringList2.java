package br.com.prog2.trabalhosala1;

import java.util.ArrayList;

public class StringList2 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		String string1 = "Hello";
		String string2 = ", ";
		String string3 = "World!\n";
		
		arr.add(string1);
		arr.add(string2);
		arr.add(string3);
		arr.add(string1);
		arr.add(string2);
		arr.add(string3);
		
		System.out.println(arr.size());
		for(String s : arr){
			System.out.print(s);
		}
	}

}
