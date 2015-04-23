// Wesley Wei Qian
// Exercise 2 Phase 2
// 04/22/15

// After some wikipedia, 
// I remember there is a great thing Heap which is good for partial ordering
// In theory, we can build a heap with n element in O(n) if precup the leaf from bottom
// and then to extract the k largest element, we need O(log(n)) which will give us the total runtime
// O(n+klog(n))

// However, to implement heap in java, i think the only option will be PriorityQueue.
// While it gives us O(log(n)) time for enqueu/dequeue, 
// I am not sure how efficiency it is for the initial construction
// So we might need to implment this ourselves,
// and since this is a very interesting problem,
// I might implment such heap myself, if there is more time.

// remember to import!!!!!
import java.util.*;

public class Ex3{

	// array field
	private int[] orderedArray;

	public Ex3(int[] unorderedArray){

		// the array is an object so no return!!!!!
		Arrays.sort(unorderedArray);

		// pass the sort unorderd Array to the field
		this.orderedArray = unorderedArray;
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