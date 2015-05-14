// Wesley Wei Qian
// Finding the longest Palindrome in a string
// Google Code U
// May-14-15
// Using O(n^2) space to ahcience an O(n^2) time efficiency

public class StringPalindrome{

	public static void main(String[] args) {
		// Test 1
		String str1 = "12111122221212121";
		int[] result1 = palindrome(str1);
		// extract the longest palindrome
		String pal1 = str1.substring(result1[1],result1[0]+result1[1]);
		System.out.println(pal1);
		assert pal1.equals("2121212"):"the result should be 2121212";

		// Test 2
		String str2 = "121111";
		int[] result2 = palindrome(str2);
		// extract the longest palindrome
		String pal2 = str2.substring(result2[1],result2[0]+result2[1]);
		System.out.println(pal2);
		assert pal1.equals("1111"):"the result should be 1111";

		// Test 3
		String str3 = "123";
		int[] result3 = palindrome(str3);
		// extract the longest palindrome
		String pal3 = str3.substring(result3[1],result3[0]+result3[1]);
		System.out.println(pal3);
		assert pal3.equals("1"):"the result should be 1";
	}

	public static int[] palindrome(String str){

		// check argument
		if(str == null){
			throw new IllegalArgumentException("The input String cannot be null.");
		}

		// initinalize
		int[] result = {1,0};	// initial length is 1 and index is 0

		// get the length of the string
		int strLength = str.length();

		// when the length is only 1
		if(strLength==1){
			return result;
		}

		// when the length is only 2
		if(strLength==2){
			if(str.charAt(0)==str.charAt(1)){
				result[0]=2;
			}
			return result;
		}

		// build a table that support dynamic programming
		// and only modify the upper left corner
		boolean[][] palindromeTable = new boolean[strLength][strLength];

		// diagnol is always true since O(n)
		for(int i = 0; i < strLength; i++){
			palindromeTable[i][i] = true;
		}

		// calculate the character right next to each other
		// in O(n) time
		// this can be generalize into the next for loop
		// but it will make an extra special case, so I would rather deal with it here
		for(int i = 0; i < strLength-1; i++){
			palindromeTable[i][i+1]=str.charAt(i)==str.charAt(i+1);
		}

		// build the larger case from the new case in O(n^2) time
		for(int len = 2; len < strLength; len++){
			for(int i = 0; i < strLength-len; i++){
				// the result depend on the two new character 
				// and if the inner strings are palindrome
				// to check the inner string, we go to the lower left cell in the matrix
				// which has already been modify in the previous round.
				palindromeTable[i][i+len]=palindromeTable[i+1][i+len-1]&&str.charAt(i)==str.charAt(i+len);
			}
		}

		// after we build the table, we can start counting
		// this can be done in O(n^2)
		for(int i = 0; i < strLength; i++){

			// we know palindromeTable[i][i] must be true
			int largestJ = i;
			// check the later cell
			for(int j = i+1; j < strLength; j++){
				// if there is a true, we update the largestJ
				// since j is increment with the for loop
				// we can be sure that the j must be larger than largestJ
				if(palindromeTable[i][j]){
					largestJ = j;
				}
			}
			// calculate the largest palindrome length for string that start with index i
			int longestLengthForI = largestJ - i + 1;
			// if such length is larger than the largest, update the result
			if(longestLengthForI>result[0]){
				result[0]=longestLengthForI;
				result[1]=i;
			}
		}

		return result;
	}
}