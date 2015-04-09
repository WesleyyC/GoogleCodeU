// Welsey Wei Qian
// Google Code_U Set2
// Filter List

import java.util.Arrays; 
import java.util.List; 
import java.util.ArrayList;


public class FilterList{ 
	// Filter Function
	public static List <Integer> evens (List <Integer> input){

		// create a even counter to decide the size of the new arrayList
		int counter =0;

		// iterate the input to count the even number
		// therefore we can preset the capacity and save time in allocating memeory
		for (Integer n : input){
			if(Integer.valueOf(n)%2==0){
				counter ++;
			}
		}

		// initial the filter list
		List <Integer> filteredList = new ArrayList <Integer> (counter);

		// iterate the input again and this time append to the new list
		for (Integer n : input){
			if(Integer.valueOf(n)%2==0){
				filteredList.add(n);
			}
		}

		return filteredList;
	}

	// Main Function for testing
	public static void main (String [] args){ 

		//************************* TEST CASE 1 *************************
		List <Integer> test1 = new ArrayList <Integer> (Arrays.asList(8,6,7,5,3,0,9)); 
		List <Integer> ans = evens(test1); 
		//Expectedoutput:8,6,0
		for (Integer n : ans){
			System.out.print(Integer.valueOf(n)+","); 
		}
		System.out.println();

		//************************* TEST CASE 2 *************************
		List <Integer> test2= new ArrayList <Integer> (Arrays.asList(2,7,18,28,18,28,45,90,45));
		ans = evens(test2); 
		//Expectedoutput:2,18,28,18,28,90 
		for (Integer n : ans){
			System.out.print(Integer.valueOf(n)+","); 
		}

		System.out.println();

		//************************* TEST CASE 3*************************
		List <Integer> test3= new ArrayList <Integer> ();
		ans = evens(test3); 
		//Expectedoutput:nothing
		for (Integer n : ans){
			System.out.print(Integer.valueOf(n)+","); 
		}

		System.out.println();

		//************************* TEST CASE 4 *************************
		List <Integer> test4= new ArrayList <Integer> (Arrays.asList(-2,7,-18,-28,18,28,45,90,45));
		ans = evens(test4); 
		//Expectedoutput:-2,-18,-28,18,28,90 
		for (Integer n : ans){
			System.out.print(Integer.valueOf(n)+","); 
		}

		System.out.println();
	}
}
