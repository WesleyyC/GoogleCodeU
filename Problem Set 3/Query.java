// Wesley Wei Qian
// 04/22/15
// Query Class
// I forget most of the methods 
// including converting string into array and create timestamp 
// So i skip phase1 for this exercise

public class Query{

	private String words;	// a single string including all the words
	private long timestamp;	// the timestamp for the creation of the time stamp
	private String[] words_array;	//the array contains all the wordds in that single string
	private int size;

	// the constructor
	public Query (String words){
		this.words=words;
		this.timestamp=System.currentTimeMillis();
		// split the string by white space using regexp
		this.words_array=this.words.split("\\s+");
		this.size=this.words_array.length;
	}

	// get the time stamp
	public long getTimestamp(){
		return timestamp;
	}

	// get the number of words
	public int size(){
		return size;
	}

	// get the word in an array with a specific index
	public String getWord (int n){
		return words_array[n];
	}

}