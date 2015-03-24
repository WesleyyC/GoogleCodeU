// EX3 Collatz Sequences

// Time efficient?

class Collatz{

	static int loopCount(int x){
		// check input
		if(x<1){
			return 0;	//no length
		}

		// sequence number count
		int i = 1;
		while(x!=1){
			if(x%2==0){
				x=x/2;
			}else{
				x=3*x+1;
			}
			i++;
		}

		// return the count
		return i;
	}

	static int maxLoop(int x, int y){
		int max_length = 0;
		for(int i = x; i<=y; i++){
			int i_length=loopCount(i);
			if(i_length > max_length){
				max_length=i_length;
			}
		}
		return max_length;
	}

	public static void main(String[] args){
		System.out.println(maxLoop(1,100000));	//351
		System.out.println(loopCount(7));	//17
	}

}