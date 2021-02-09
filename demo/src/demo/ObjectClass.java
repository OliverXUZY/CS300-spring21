package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class ObjectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "32";
		Integer.parseInt(str1) ;   // Returns int value 32
		System.out.println(str1);
		
		/**
		// Decimal to Binary
		Scanner scnr = new Scanner(System.in);
	      int decimalInput;
	      String binaryOutput;
	      
	      System.out.print("Enter a decimal number: ");
	      decimalInput = scnr.nextInt();
	      
	      binaryOutput = Integer.toBinaryString(decimalInput);
	      
	      System.out.println("The binary representation of " + decimalInput +
	                         " is " + binaryOutput);
	      scnr.close();
	      */
	      
	      ArrayList<Integer> myInts = new ArrayList<Integer>();
	      myInts.clear();
	      System.out.print(myInts);

	}
			

}
