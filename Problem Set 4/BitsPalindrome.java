// Wesley Wei Qian
// Google Code U Problem Set 4
// Bits Palindrome
// 05-02-15

public class BitsPalindrome{

	public static void main(String[] args) {
		// the check range
		int range = 40;

		// check from 1 ~ range
		for(int i = 1; i <= range; i++){
			if(palindrome(i)){	// if the number is palidrome
				// print it out and show its binary expression
				System.out.print(i);
				// this will help checking if it is palindrome
				System.out.print(" -> " + Integer.toString(i,2));
				System.out.println();
			}
		}
	}

	// check if a num is palindrome in binary
	// consider the leading 0 is unlimited
	public static boolean palindrome (int num){
		// convert the number to binary in string expression
		String str = Integer.toString(num,2);
		// get the length of the binary string
		int strLength = str.length();
		// the number of zero we put in the head
		int reverseDif = 0;
		// allow to add zero
		boolean leadingZero = true;

		// head index is zero and tail index is length-1
		int headIndex = 0;

		// only need to check half the range
		for(int tailIndex = strLength-1;tailIndex>headIndex;tailIndex--){
			// update head index
			// the reverseDif will handle the case will extra 0 appears in the head 
			// (aka not moving the head index while we decrement the tail index)
			headIndex = strLength-1 - tailIndex - reverseDif;
			// check if we are sting in the leading zero
			if(leadingZero&&str.charAt(tailIndex)!='0'){
				// then we do not allow a pass when the current char is '0'
				// this might not be necessary since the comparison will be mess up anyway
				leadingZero = false;
			}

			if(str.charAt(headIndex) == str.charAt(tailIndex)){	// if there is a match, continue
				continue;
			}else if(leadingZero && str.charAt(tailIndex) == '0'){	// if there is not match, but we are still allow to add zero
				reverseDif++;	// we continue and increment the reverseDif so that the head index remains in the same position
			}else{	// otherwise, this is not a palindrome
				return false;
			}
		}

		// if pass all match, it is a palindrome
		return true;
	}
}