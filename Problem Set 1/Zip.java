// ex1 Array Zip and Join

class Zip {

	// The testing method main
	public static void main (String [] args){
		// defining test case
		int euler[] = {2,7,18,28,18,28,45,90,45};
		int jenny[] = {8,6,7,5,3,0,9};

		// join!
		boolean divisible[] = join(euler,jenny);

		// printing output
		for(int i = 0; i < divisible.length; i++){
			System.out.println(divisible[i]);
		}
	}

	static boolean[] join(int[] y, int[] z){

		// The array cannot be null
		if(y==null || z==null){
			return null;
		}

		// Check the output length
		int output_length = Math.min(y.length,z.length);

		// Initial output array
		boolean[] boolean_output = new boolean[output_length];

		// Calculate the value
		for(int i = 0; i< boolean_output.length; i++){
			if(z[i]==0){
				// if the divider is 0, it is automatically false
				boolean_output[i]=false;
			}else{
				// the value is true if y[i] can be divided by z[i]
				boolean_output[i]=y[i]%z[i]==0;
			}
		}

		return boolean_output;
	}

}