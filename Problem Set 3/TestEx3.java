public class TestEx3{
	public static void main(String[] args) {

		int[] unorderdArray = {5,3,9,4,3,3,8,3,3};

		Ex3 test = new Ex3(unorderdArray);	// the ex3 with whole sorting
		Ex3Heap test_eff = new Ex3Heap(unorderdArray);	// the ex3 heap with prtial sort

		System.out.println(test.nthLargest(1));
		System.out.println(test_eff.nthLargest(1));
		// 9
		System.out.println(test.nthLargest(4));
		System.out.println(test_eff.nthLargest(4));
		// 4
		//System.out.println(test.nthLargest(-1));
		System.out.println(test_eff.nthLargest(-1));
		// error
	}
}