// Wesley Wei Qian
// Exercise 2 Phase 2

// there is two way to appraoch this, 
// one is easies to program O(nlog(n))

// and the other one is the fastest  
// with O(n) time but also O(n) space
// and the collection of integers need to be non-negative integers
// the idea for the second idea is use an extra array, 
// whose indexes indicates the number in the collection
// and the value associate with the indexes is the time of appearence
// since it only works with non-negative number, we can forget it for now.

// remember to import util for data structure
// do we need to import specific package
import java.util.*;

public class Ex2{
	public static void main(String[] args) {
		// build up test case

		// only 50% null
		List <Integer> test_1 = new ArrayList <Integer>();
		test_1.add(1);
		test_1.add(-1);
		test_1.add(0);
		test_1.add(1);
		// expected null
		testUnit(hasMajority(test_1));

		// odd number
		List <Integer> test_2 = new ArrayList <Integer>();
		test_2.add(1);
		test_2.add(-1);
		test_2.add(0);
		test_2.add(1);
		test_2.add(1);
		// expected 1
		testUnit(hasMajority(test_2));

		// even numver
		List <Integer> test_3 = new ArrayList <Integer>();
		test_3.add(1);
		test_3.add(-1);
		test_3.add(1);
		test_3.add(1);
		// expected 1
		testUnit(hasMajority(test_3));

		// empty collection
		List <Integer> test_4 = new ArrayList <Integer>();
		// expected null
		testUnit(hasMajority(test_4));


	}

	// basic idea is check the middle number is the the same as the two ends.
	// with some complication in the collection with even length
	// since it needs to be MORE than 50% to be majority
	public static Integer hasMajority(List <Integer> collection){

		// need to check empty
		if(collection.isEmpty()){
			return null;
		}

		//O(nlog(n))
		// the sorting algorithm is in the Collection class
		Collections.sort(collection);

		int length = collection.size();

		// check equal is ==
		if(length%2 == 1){	// if length is odd
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

	public static void testUnit(Integer n){
		if(n != null){
			System.out.println(n);
		}else{
			System.out.println("This is null!");
		}
	}

}