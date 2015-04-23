// Wesley Wei Qian
// Exercise 2 Phase 1
// 04/22/15

// I can't think of a more efficient appraoch than nlog(n) for now.

public class Ex3{

	// array field
	private int[] orderedArray;

	public Ex3(int[] unorderedArray){

		// pass the sort unorderd Array to the field
		this.orderedArray = Array.sort(unorderedArray);
	}

	// the nthLargest number
	public int nthLargest(int n){

		// check range
		if(n<1 || n>orderedArray.length){
			throw new IllegalArgumentException("range must be > 0 and < the length");
		}

		// the array is from smallest to the largest 
		// and n=1 is suppose to return the largest
		return this.orderedArray[orderedArray.length-n];
	}
}