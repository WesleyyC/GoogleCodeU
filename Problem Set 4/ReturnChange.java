// Wesley Wei Qian
// Code_U
// Returnning Change
// May-14-2015
// the way I do it is very easy to write
// but it is not necessary the most efficient algorithm

import java.util.Arrays;

public class ReturnChange{
	public static void main(String[] args) {
		int[] change = {1,2};
		int total = 3;
		System.out.println(wayToCount(change,total));
	}

	// i don't really need this method, but I want to make sure that
	// the change array is in ascending order and I don't want the client to worry about it;
	// another way to handle the order problem is put it in the recursive method,
	// but i don't want to do the sorting again again even the change array is in order
	public int makeChange(int total, int[] change){
		// sort the change array first
		Arrays.sort(change);
		// put it in the recursive call
		return wayToCount(change,total);
	}

	// a recursive method that will return the way to count
	public static int wayToCount(int[] change, int total){

		if(total<0){	// if the total is less than zero
			return 0;	// it means the current count is not posssible, so return 0
		}else if(total ==0){	// if the total get to exactly zero
			return 1;	// it means the current counting is possible, so return 1
		}

		// initialize a counter for counting the possible way
		int count = 0;

		// we want to make the problem smaller, more specifically a smaller total
		// by substracting it with every denominations
		// to deal with multiple counting, we calculate all the possible case for larger denominator first
		// and then go to smaller denominator with smaller 'change' array (i.e. a one without the larger denominator)
		for(int i = change.length; i>=1; i--){
			// a smaller case
			int newTotal = total-change[i-1];
			// a smaller array
			int[] newChange = Arrays.copyOfRange(change,0,i);
			// count recursively
			count=count+wayToCount(newChange, newTotal);
		}

		return count;
	}
}