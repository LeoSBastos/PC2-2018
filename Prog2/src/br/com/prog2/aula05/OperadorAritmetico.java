package br.com.prog2.aula05;

public class OperadorAritmetico {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		//+
		int c = a + b;
		System.out.println("operacao= "+c);
		//-
		c = b-a;
		System.out.println("operacao= "+c);
		//*
		c = a*b;
		System.out.println("operacao= "+c);
		// /
		c = b/a;
		System.out.println("operacao= "+c);
		//%
		c = b%a;
		System.out.println("operacao= "+c);
		//++
		c=a++;
		System.out.println("operacao= "+c);
		//--
		c=b--;
		System.out.println("operacao= "+c);
		//=
		c=a;
		System.out.println("operacao= "+c);
		//+=
		c+=a;
		System.out.println("operacao= "+c);
		//-=
		c-=a;
		System.out.println("operacao= "+c);
		//*=
		c*=a;
		System.out.println("operacao= "+c);
		// /=
		c/=a;
		System.out.println("operacao= "+c);
		//%=
		c%=a;
		System.out.println("operacao= "+c);
		//==
		System.out.println("operacao= "+(a==b));
		//!=
		System.out.println("operacao= "+(a!=b));
		//<
		System.out.println("operacao= "+(a<b));
		//>
		System.out.println("operacao= "+(a>b));
		//<=
		System.out.println("operacao= "+(a<=b));
		//>=
		System.out.println("operacao= "+(a>=b));
		//&&
		System.out.println("operacao= "+(a==b&&b==c));
		//&
		System.out.println("operacao= "+(a==b&b==a));
		//||
		System.out.println("operacao= "+(a==b||b==c));
		//|
		System.out.println("operacao= "+(a==b|b==a));
		//!
		boolean s = (a==b);
		System.out.println("operacao= "+(!s));
	} 

}
