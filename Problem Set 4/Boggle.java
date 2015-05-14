// Wesley Wei Qian
// Boggle Board Game
// Google Code U
// May-15-15

// Check word from a Boggle board should be faster with a whole Dictionary

import java.util.*;

public class Boggle{

	// make the board an char array
	public static final char[] BOARD = {'a','c','d','k','b','p','f','g','h','i','p','j','k','e','l','l'};
	//[a, c, d, k
    // b, p, f, g 
    // h, i, p, j
    // k, e, l, l]
    public static HashMap<Character,ArrayList<Integer>> charMap = new HashMap<Character,ArrayList<Integer>>();
    public static HashMap<Integer, Character> indexMap = new HashMap<Integer, Character>();

	public static void main(String[] args) {
		buildCharMap();

		// Use a String to Test instead of a Dictionary
		// Test 1
		String test1 = "Apple";

	}

	public static void buildCharMap(){
		for(int i = 0; i < BOARD.length; i++){
			char ch = BOARD[i];
			indexMap.put(i,ch);
			if(charMap.containsKey(ch)){
				ArrayList<Integer> old = charMap.get(ch);
				old.add(i);
			}else{
				ArrayList<Integer> newL = new ArrayList<Integer>();
				newL.add(i);
				charMap.put(ch,newL);
			}
		}
	}

	public static boolean inBoggle(String str){
		// check argument
		if(str == null){
			throw new IllegalArgumentException("The input String cannot be null.");
		}
		// get the lenth
		int strLen = str.length();
		if(strLen > 16){
			throw new IllegalArgumentException("The length of the string must be less than 16");
		}
		// transform to lower case
		str = str.toLowerCase();
		return boggleIter(str,new HashSet<Integer>(),strLen);
	}

	public static boolean boggleIter(String str, HashSet<Integer> taken, int strLen){
		char ch = str.charAt(0);
	}







}