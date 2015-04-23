/// Wesley Wei Qian
// 04/22/15
// QueryStream Class
// I forget most of the methods 
// including converting string into array and create timestamp 
// So i skip phase1 for this exercise

import java.util.*;	// iterator object

public class QueryStream implements Iterable <String>{
	private Query[] stream;
	private int wholeStreamSize;

	public QueryStream(Query[] stream){
		this.stream=stream;
		this.wholeStreamSize = totalWordsCount(stream);
	}

	public Iterator <String> iterator(){
        Iterator <String> theIterator = new Iterator <String>() {
        	
        	private int totalGiven = 0;

        	private int currentQurey = 0;

        	private int currentWord = 0;

            public boolean hasNext() {
            	return totalGiven < wholeStreamSize;
            }

            public String next() {

            	// check if we still have next
            	if(!hasNext()){
            		throw new ArrayIndexOutOfBoundsException("Too Greedy!");
            	}

            	// check if the current query still have words
            	if(currentWord >= stream[currentQurey].size()){	//if no
            		
					//increment current query
            		currentQurey ++;
            		// reset word counter
            		currentWord = 0;

            		return "Time between querys: " + String.valueOf(stream[currentQurey].getTimestamp()-stream[currentQurey-1].getTimestamp()) + " milliseconds";

            	}else{	// if current query still have words
            		 // get the string
	            	String toBeReturn = stream[currentQurey].getWord(currentWord);

	            	// increment the count
	            	currentWord++;
	            	totalGiven++;

	            	return toBeReturn;
            	}
            }

            public void remove() {
                throw new UnsupportedOperationException("Coming Soon.");
            }
        };

        return theIterator;
	}

	private int totalWordsCount(Query[] stream){
		int counter = 0;
		for(Query singeQuery: stream){
			counter = counter+singeQuery.size();
		}
		return counter;
	}
}