// Wesley Wei Qian
// Boggle Board Game
// Google Code U
// May-15-15

// This is written in a limited time so it's pretty ... ugly.

// This is for testing a single string. 
// If we want to get all the possible words from a dictionary, we should start from the boggle board instead of matching string.

import java.util.*;

public class Boggle{

	// make the board an char array
	public static final char[] BOARD = {'a','c','d','k','b','p','f','g','h','i','p','j','k','e','l','l'};
	//[a, c, d, k
    // b, p, f, g 
    // h, i, p, j
    // k, e, l, l]

    // a map record the indexes of each character. Since there can be multiple positions, so the value is a list
    public static HashMap<Character,ArrayList<Integer>> charMap = new HashMap<Character,ArrayList<Integer>>();

	public static void main(String[] args) {
		// filled the maps
		buildCharMap();

		// Use a String to Test instead of a Dictionary
		// Test 1
		String test1 = "apple";
		if(inBoggle(test1)){
			System.out.println("In Boggle!");
		}else{
			System.out.println("Nah!");
		}

	}

	// Build the cha->[indexes] map
	public static void buildCharMap(){
		// for all the character on the board
		for(int i = 0; i < BOARD.length; i++){
			// current character
			char ch = BOARD[i];
			
			if(onBoard(ch)){	// if we already have a list for this character
				ArrayList<Integer> old = charMap.get(ch);
				old.add(i);	// extend it
			}else{	// otherwise
				ArrayList<Integer> newL = new ArrayList<Integer>();
				newL.add(i);
				charMap.put(ch,newL);	// create one
			}
		}
	}

	// Check if a character actually exist on the board
	public static boolean onBoard(char ch){
		return charMap.containsKey(ch);
	}

	// Check if a word is in the boggle
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

		// pass to a recursive function, where -1 indicates that it has no previous index
		return boggleIter(str,new HashSet<Integer>(),strLen, -1);
	}

	// a recursive function that will check if the first character of the string
	// can be reached with the previous index
	public static boolean boggleIter(String str, HashSet<Integer> taken, int strLen, int previous){
		// the first character
		char ch = str.charAt(0);
		// by default, we assume we cannot go on.
		boolean continueBoggle = false;

		if(onBoard(ch)&&canMove(ch, taken, previous)){	// if the character is on the board, and there is at least one possible move
			
			if(strLen==1){	// the base case and no need to move on.
				return true;
			}else{	// if there is a smaller case
				// we get all the possible move
				ArrayList<Integer> possibleMove = getPossibleMove(ch, taken,previous);
				// loop through each possible move, and for each move, we give a recursive call.
				Iterator<Integer> iterPossible = possibleMove.iterator();
				while(iterPossible.hasNext()&&!continueBoggle){	//once we have one true continueBoggle, we can just return true.
					int index = iterPossible.next();
					HashSet<Integer> newTaken = new HashSet<Integer>(taken);
					newTaken.add(index);
					// recursive down with a smaller string, an update previous index, string length and fianlly a larger "taken" set
					continueBoggle = boggleIter(str.substring(1),newTaken, strLen-1, index);
				}
				return continueBoggle;
			}

		}else{	// the character is not on board or there is no possible move
			return false;	// this track is not possible.
		}
	}

	// check if there is a possible move for ch, with the previous position and a taken set
	public static boolean canMove(char ch, HashSet<Integer> taken, int previous){
		// we already know ch is on board, so we get a list of its possible indexes
		ArrayList<Integer> possiblePosition = charMap.get(ch);
		// loop through these list of indexes
		Iterator<Integer> iterPossible = possiblePosition.iterator();
		while(iterPossible.hasNext()){
			int index = iterPossible.next();
			// if there is an index that is not in taken and reachable from previous,
			// we return true;
			if(!taken.contains(index)&&reachable(previous,index)){
				return true;
			}
		}
		// after iterating the whole thing without success, we return false;
		return false;
	}

	// similar to canMove(), after knwoing there is a move, we get the list of the possible move
	public static ArrayList<Integer> getPossibleMove(char ch, HashSet<Integer> taken, int previous){
		// possible move initiate
		ArrayList<Integer> possiblePosition = new ArrayList<Integer>();
		// the whole list of indexes
		ArrayList<Integer> potentialPosition = charMap.get(ch);
		// we loop through the list of indexes
		Iterator<Integer> iterPossible = potentialPosition.iterator();
		while(iterPossible.hasNext()){
			int index = iterPossible.next();
			// if there is an index that is not in taken and reachable from previous,
			// we add it to the possible position
			if(!taken.contains(index)&&reachable(previous,index)){
				possiblePosition.add(index);
			}
		}
		return possiblePosition;
	}


	// check if we can get to current position from previous position
	public static boolean reachable(int previous, int current){
		//	if it is the start, we can go to everywhere
		if(previous == -1){
			return true;
		}
		// get the index diff between the previous and current position
		int diff = Math.abs(previous-current);
		// check
		if(diff==1){ // left & right
			return true;
		}else if(diff==3){	// upper right & lower left
			return true;
		}else if(diff==4){	// up & down
			return true;
		}else if(diff==5){	// upper left & lower right
			return true;
		}else{
			return false;	// the current is not reachable from the previous position
		}
	}

}