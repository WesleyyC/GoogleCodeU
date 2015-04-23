// Wesley Wei Qian
// 04/22/15
// Query Class
// I forget most of the methods 
// including converting string into array and create timestamp 
// So i skip phase1 for this exercise

import java.util.*;

public class QueryTest{
	public static void main(String[] args) {
		Query query1 = new Query("happy birth day");
		Query query2 = new Query("i am wesley");
		Query query3 = new Query("");
		Query query4 = new Query("this is for google code u program");
		Query[] testArray = {query1, query2,query3,query4};
		QueryStream test = new QueryStream(testArray);

		Iterator testIter = test.iterator();
		while(testIter.hasNext()){
			System.out.println(testIter.next());
		}
		// Expected
		// happy
		// birth
		// day
		// :timestamp
		// i
		// am
		// wesley
		// :timestamp
		// EMPTY SPACE
		// :timestamp
		// this
		// is
		// for
		// google
		// code
		// u
		// program


	}
}