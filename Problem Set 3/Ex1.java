// Wesley Wei Qian
// Exercise 1 Phase 2 with reference
// 04/21/15

// not sure if we need to import the class TrivialDictionary
// import java.X.TrivialDictionary
import java.util.*; // import data structure

public class Ex1Blank{

	// build a hashset for the dictionary 
	// so that confirm existence will be constant time
	// if the query is not a lot, we might waste time for traverse the whole dictionary
	// so if the query is small, i probably will build a hashmap to store the word we have checked
	// to prevent double counting
	// global varialbe

	// need to add static for modification
	private static Set <String> dictionary = new HashSet <String> ();
	// or can I do new HashSet <String> (TrivialDictionary)?

	public static void main(String[] args) {
		// dont have the class, so cannot run, but the compile seems fine except that it cannot find the symbol

		// build the dictionary
		parseDictionary();

		// test!
		testUnit(null);
		testUnit("Apple");
		testUnit("Happy");

	}

	// build a hashset for the dictionary
	public static void parseDictionary(){
		// set up an counter for looping
		long i = 0;	// In case int is not large enough for i\
		// or can i just use int since we know the size of the dict?

		// loop till out of index
		while (TrivialDictionary.wordAt(i)!=null){
			dictionary.add(TrivialDictionary.wordAt(i));
			i++;
		}
	}

	// check the existence
	public static boolean isInDictionary (String word) {
		// not sure about the checking syntax, but this is what i would do

		// and it is actually contains!!!!!!
		return dictionary.contains(word);
	}

	// a simlple is in dict?
	public static void testUnit(String word){
		if(isInDictionary(word)){
			System.out.println(word+ " is in the dict!");
		}else{
			System.out.println(word+ "? nah...");
		}
	}
}