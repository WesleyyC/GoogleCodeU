// Wesley Wei Qian
// 05/13/15
// the k'th ugly number
// ugly number is the number whose divider are either 1,2,3 or 5;

// there might be a faster way and I have attempt to do so
// however, there is no success as the order problem cannot be addressed. 
// My attemption is left in the comment

// run test mode by 
// java -ea UglyNum

import java.util.Arrays;

public class UglyNum{

	public static void main(String[] args) {

		// Here are the first 10 Ugly numbers: 
		// 1, 2, 3, 4, 5, 6, 8, 9, 10, and 12.

		// the first test test case should return 12
		int test1 = 10;
		int the10th = theKthUgly(test1);
		System.out.println(the10th);
		assert the10th==12 : "the 10th ugly number should be 12";

		// the second test case should return 5
		int test2 = 5;
		int the5th = theKthUgly(test2);
		System.out.println(the5th);
		assert the5th==5 : "the 5th ugly number should be 5";
	}

	// return the kth ugly number
	// by looping from 1, 2, 3... and count how many ugly number we have encounterd
	public static int theKthUgly(int k){

		// check if the argument is legal
		if(k < 1){
			throw new IllegalArgumentException("the k'th must be more than 0");
		}

		// we assume the first ugly number is 1
		int theKth = 1;
		// count how many ugly number we have already count
		int count = 1;
		// once we reach the kth ugly number, we terminate
		while(count<k){
			// we increment the tracer first
			theKth++;
			// if the tracer is an ugly number
			if(uglyCheck(theKth)){
				// we increment the counter
				count++;
			}
		}

		return theKth;
	}

	// check if an number is a ugly number 
	// by checking the remainder for 2, 3 and 5;
	// if it is divisible by either 2, 3 or 5, return true;
	public static boolean uglyCheck(int n){
		if(n%2==0){
			return true;
		}else if(n%3==0){
			return true;
		}else if(n%5==0){
			return true;
		}else{
			return false;
		}
	}



	// // the divider constant, include 4 because it is easier to update the
	// private static final int[] DIVIDER = {2,3,5};

	// public static void main(String[] args) {
	// 	System.out.println(Arrays.toString(uglySequence(10)));
	// }

	// // public static int theKthUgly(int n){

	// // }

	// public static int[] uglySequence(int n){
	// 	if(n < 1){
	// 		throw new IllegalArgumentException("the k'th must be more than 0");
	// 	}

	// 	int[] seq = new int[n];
	// 	seq[0]=1;

	// 	int filled = 1;

	// 	int currentTraceIndex = 0;
	// 	int currentDividerIndex = 0;

	// 	while(filled < n){
	// 		int dividerIndex = currentDividerIndex % 3;
	// 		seq[filled]=seq[currentTraceIndex]*DIVIDER[dividerIndex];
	// 		filled++;
	// 		if(dividerIndex == 2){
	// 			currentTraceIndex++;
	// 		}
	// 		currentDividerIndex++;
	// 	}


	// 	return seq;
	// }
}