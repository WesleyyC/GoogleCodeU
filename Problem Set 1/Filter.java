// Ex2 Array Filtering
// I like LAMBDA function!!!!!!!!!!!!

import java.util.*;

public class Filter{

	// A filter function will return an array of even number from the input
	// in order
	public static int[] evens(int[] input){
		if(input==null){
			return null;
		}

		// Create an result array list because we don't know the length
		List<Integer> result = new ArrayList<Integer>();

		// Traverse the input
		for(int i = 0; i < input.length; i++){
			if(input[i]%2==0){
				// if the input is even, add it to the list
				result.add(input[i]);
			}
		}

		// Return an array by converting the ArrayList
		return convertIntegers(result);
	}

	// Convert ArrayList<Integer> to int[]
	public static int[] convertIntegers(List<Integer> integers)
	{
	    // Initiate the result array
	    int[] result = new int[integers.size()];

	    // Use an iterator to optimize time waste
	    Iterator<Integer> iterator = integers.iterator();

	    // Transfering
	    for (int i = 0; i < result.length; i++)
	    {
	        result[i] = iterator.next().intValue();
	    }
	    return result;
	}

	// Testing function
	public static void main (String[] args){
		// FirstTest
		int[] test1 = {8,6,7,5,3,0,9};
		int[] ans = evens(test1);
		System.out.println("test1 results: ");
		for(int i = 0; i<ans.length; i++){
			System.out.println(ans[i]);
		}

		// SecondTest
		int[] test2 = {2,7,18,28,18,28,45,90,45};
		ans = evens(test2);
		System.out.println("test2 results: ");
		for(int i = 0; i<ans.length; i++){
			System.out.println(ans[i]);
		}

	}
}