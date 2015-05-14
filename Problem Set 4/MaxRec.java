// Wesley Wei Qian
// Maximum Rectable under a histogram
// Google Code U
// Use Dynamic Programming with a O(n^2) space and O(n^2) time efficiency

// run test mode by 
// java -ea MaxRec

public class MaxRec{
	public static void main(String[] args) {
		// Test 1
		int[] test1 = {2, 1, 3, 4, 2, 3, 1};
		int max1 = getMaxRec(test1);
		System.out.println(max1);
		assert max1==8:"The result should be 8";

		// Test 2
		int[] test2 = {2, 1, 3, 1, 20, 1, 1};
		int max2 = getMaxRec(test2);
		System.out.println(max2);
		assert max2==20:"The result should be 20";

		// Test 3
		int[] test3 = {2, 2, 3, 4, 2, 3, 1};
		int max3 = getMaxRec(test3);
		System.out.println(max3);
		assert max3==12:"The result should be 12";
	}

	public static int getMaxRec(int[] hist){
		// check argument
		if(hist == null){
			throw new IllegalArgumentException("The input hist array cannot be null.");
		}

		// get the length
		int histLen = hist.length;

		// create a table for dynamic programming
		int[][][] areaTable = new int [histLen][histLen][2];
		// only the upper right corner will be filled
		//areaTable[i][j]=[bottom, height] of the maximum rectangle from i to j

		// for single rectagle
		for(int i = 0; i < histLen; i++){
			areaTable[i][i][0]=1;
			areaTable[i][i][1]=hist[i];
		}
		// get the size of a larger trainagle from a larger triangle
		for(int len = 1; len < histLen; len++){
			for(int i = 0; i < histLen-len; i++){
				int j = i+len;
				areaTable[i][j][0]= areaTable[i][j-1][0]+1;
				areaTable[i][j][1]= Math.min(areaTable[i][j-1][1],hist[j]);
			}
		}

		// initinalize the max
		int max = 0;
		// loop through all the pair and get the max
		for(int i = 0; i < histLen; i++){
			for(int j = i; j < histLen; j++){
				max=Math.max(max, areaTable[i][j][0]*areaTable[i][j][1]);
			}
		}

		return max;
	}
}