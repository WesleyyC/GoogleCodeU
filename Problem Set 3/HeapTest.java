public class HeapTest{
	public static void main(String[] args) {
		int[] unorderd_array = {1, 3, 5, 2, 4, 7, 8, 2, 9};
		Heap orderHeap = new Heap(unorderd_array);
		orderHeap.printHeap();
		orderHeap.popLargest();
		orderHeap.printHeap();
		orderHeap.popLargest();
		orderHeap.printHeap();
		// expecting
		// 9 4 8 3 1 7 5 2 2 
		// 8 4 7 3 1 2 5 2 
		// 7 4 5 3 1 2 2
	}
}