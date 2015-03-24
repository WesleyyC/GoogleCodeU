// EX4 Sparse Matrix

public class SparseMatrix{
	public static void main(String[] args) {
		// Define Matrices
		int[][] test_matrix_1 = {{0,0,0,0},{0,6,0,0},{8,0,0,4}};
		int[][]	test_matrix_2 = {};
		int[][] test_matrix_3 = {{1,2},{3,4}};

		// Test!
		printSparseMatrix(test_matrix_1);	// print out 3 line
		printSparseMatrix(test_matrix_2);	// print out nothing
		printSparseMatrix(test_matrix_3);
	}

	// only output the element that is not zero
	public static void printSparseMatrix(int [][] the_matrix){	// A more generic input?
		System.out.println("The Non-Zero Value:");

		// A flag for all zero output.
		boolean nothing = true;

		// Loop through the matrix
		for (int i = 0; i < the_matrix.length; i++){	// check each line
			for (int j = 0; j < the_matrix[1].length; j++){	// check each colum
				if(the_matrix[i][j]!=0){	// check if the cell is 0
					// if is not zero, output in format [row, column]: value;
					System.out.printf("[%d, %d]: %d\n",i,j,the_matrix[i][j]);
					// set the flag to false seems there is non-zero value
					nothing = false;
				}
			}
		}

		// Notify the value is all zero according to the flag
		if(nothing){System.out.println("It is all zero!!!");}
		
		System.out.println("Output End.");
		System.out.println();
	}
}