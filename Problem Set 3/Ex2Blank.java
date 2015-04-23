// Wesley Wei Qian
// Exercise 2 Phase 1

// there is two way to appraoch this, 
// one is easies to program O(nlog(n))

// and the other one is the fastest  
// with O(n) time but also O(n) space
// and the collection of integers need to be non-negative integers
// the idea for the second idea is use an extra array, 
// whose indexes indicates the number in the collection
// and the value associate with the indexes is the time of appearence
// since it only works with non-negative number, we can forget it for now.



public class Ex2Blank{
	public static void main(String[] args) {
		// build up test case
	}

	// basic idea is check the middle number is the the same as the two ends.
	// with some complication in the collection with even length
	// since it needs to be MORE than 50% to be majority
	public static Integer hasMajority(List <Integer> collection){

		//O(nlog(n))
		collection.sort();

		int length = collection.size();

		if(length%2 = 1){	// if length is odd
			if(collection.get(length/2) == collection.get(0) || collection.get(length/2) == collection.get(length-1)){
				return collection.get(length/2);
			}else{
				return null;
			}
		}else{	// if the length is even
			if(collection.get(length/2 - 1) == collection.get(length-1)){
				return collection.get(length-1);
			}else if(collection.get(length/2)==collection.get(0)){
				return collection.get(0);
			}else{
				return null;
			}
		}
	}


}