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
// So now I have time, I implement my own heap and here we go

// remember to import!!!!!
import java.util.*;

public class Ex3Heap{

	// array field
	private int[] unorderedArray;
	// the partial sort heap
	private Heap theHeap;

	public Ex3Heap(int[] unorderedArray){

		// pass the sort unorderd Array to the field
		this.unorderedArray = unorderedArray;
		// build the heap
		theHeap = new Heap(this.unorderedArray);
	}

	// the nthLargest number
	public int nthLargest(int n){

		// check range
		if(n<1 || n>this.theHeap.size()){
			throw new IllegalArgumentException("range must be > 0 and < the length");
		}

		int theOne=0;
		// keep poping until we get to the largest nth.
		while(n>0){
			theOne = theHeap.popLargest();
			n--;	// decrement n
		}

		return theOne;

	}


}