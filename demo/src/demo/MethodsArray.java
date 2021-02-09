package demo;

import java.util.Arrays;

public class MethodsArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[] {"a","c","c","c","c","c","a","b","a"};
		System.out.println(findMostFrequent(s));

	}
	/**
	public static String findMostFrequent(String[] arrayReference) {
		   String mostCommon;
		   int times;     // The number of times the current element has appeared previously
		   int mostTimes; // The number of times the most common element has appeared
		   int index;

		   // Zero length arrays don't contain anything
		   if (arrayReference.length == 0) {  
		       return null;
		   }

		   // Sort the array
		   Arrays.sort(arrayReference);   // modify the string it self -----> do not want
		   //System.out.println(Arrays.toString(arrayReference));
		            
		   mostCommon = arrayReference[0]; // Make sure method works with 1-element arrays
		   times = 0; 
		   mostTimes = 0; 
		         
		   // Start loop at one in order to use index - 1
		   for (index = 1; index < arrayReference.length; ++index) {
		                    
		      // The next element matches the last one
		      if (arrayReference[index - 1].equals(arrayReference[index])) {
		         ++times;
		      }
		      else {  // new element was found, restart the count
		         times = 0;
		      } 
		                    
		      // Check to see if old element was most common so far
		      if (times > mostTimes) {
		         mostTimes = times;
		         mostCommon = arrayReference[index - 1];
		      }
		   } 
		           
		   return mostCommon;
		}
		*/
	
	public static String findMostFrequent(String[] arrayReference) {
		   String mostCommon;
		   int times;     // The number of times the current element has appeared previously
		   int mostTimes; // The number of times the most common element has appeared
		   int index;
		   String[] arrayCopy;

		   // Zero length arrays don't contain anything
		   if (arrayReference.length == 0) {  
		       return null;
		   }

		   // Make a copy of arrayReference to avoid a side effect
		   arrayCopy = Arrays.copyOf(arrayReference, arrayReference.length);         
		   Arrays.sort(arrayCopy);  // Sort the array copy
		            
		   mostCommon = arrayCopy[0]; // Make sure method works with 1-element arrays
		   times = 0; 
		   mostTimes = 0; 
		         
		   // Start loop at one in order to use index - 1
		   for (index = 1; index < arrayCopy.length; ++index) {
		                    
		      // The next element matches the last one
		      if (arrayCopy[index - 1].equals(arrayCopy[index])) {
		         ++times;
		      }
		      else {  // new element was found, restart the count
		         times = 0;
		      } 
		                    
		      // Check to see if old element was most common so far
		      if (times > mostTimes) {
		         mostTimes = times;
		         mostCommon = arrayCopy[index - 1];
		      }
		   } 
		   //System.out.println(Arrays.toString(arrayReference));
		           
		   return mostCommon;
		}

}
