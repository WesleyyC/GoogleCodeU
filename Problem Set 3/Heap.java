// Wesley Wei Qian
// lienar construct heap

// I originally write this code in the EX3, 
// so there are some varialbe passing does not make much sense
// and this is no way a industry-strength data structure
// since the time is limited

// The Heap is actually a binary full tree align to left
// so this can be done with an array
// sicne the time is limited
// i use an array while a ArrayList might be a better choice

// In the tree, the parent is always larger than the child
// while the size relationship between siblings is unkown


public class Heap{

	private int[] heap;
	private int currentSize;

	// build the heap
	public Heap(int[] unorderedArray){

		// get the size of the heap
		this.currentSize = unorderedArray.length;

		// build the heap in linear time
		// by building from the bottom
		// the proof is a bit complicated
		for(int i = unorderedArray.length-1; i >= 0; i--){
			percdown(i, unorderedArray);
		}

		this.heap = unorderedArray;
	}

	// following three method is index traversing between node
	// and if there is no such relative node, -1 is returned

	// traverse to the parent of the current index
	private int parent(int i){
		if(i>0){
			return (i-1)/2;
		}else{
			return -1;
		}
	}
	// traverse to the left child index
	private int lChild(int i, int size){
		if(2*i+1 < size){
			return 2*i+1;
		}else{
			return -1;
		}
	}
	// traverse to the right child index
	private int rChild(int i, int size){
		if(2*i+2 < size){
			return 2*i+2;
		}else{
			return -1;
		}
	}

	// exchange the cell i and j in the heap 
	private void exchange(int[] heap, int i, int j){
		int temp = heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}

	// reset the relationship for cell i
	// where it goes up if it is larger than its parent
	private void percup(int i, int[] heap){
		while (i>0 && heap[i]>heap[parent(i)]){	// if i is larger than its parent
			exchange(heap, i, parent(i));	// exchange their position
			i=parent(i);	// and now i is in its parent's position and we go on.
		}
	}

	// reset the relationship for cell i 
	// where it goes down if it is smaller than its child.
	private void percdown(int i, int[] heap){
		while(checkGoDown(i, heap)){	// if i is a leaf and smaller than one of its children
			int j = largerChild(i, heap);	// get the index of its larger child
			exchange(heap, i, j);	// exchange i with its larger child
			i = j;	// now i is its larger child and life goes on
		}
	}

	// check if cell i has the right to go down
	// or if i is a leaf or it is smaller than any of its child
	private boolean checkGoDown (int i, int[] heap){
		if(lChild(i, currentSize) != -1 && heap[i]<heap[lChild(i, currentSize)]){	// if there is right child and it is smaller than i
			return true;
		}else if(rChild(i, currentSize) != -1 && heap[i]<heap[rChild(i, currentSize)]){	// if there is left child and it is smaller than i
			return true;
		}else{
			return false;
		}
	}

	// return i's larger child index
	private int largerChild (int i, int[] heap){
		if(lChild(i, currentSize) != -1 && rChild(i, currentSize) != -1){	// if i has two children
			// compare them and return the largest
			if(heap[lChild(i, currentSize)]>heap[rChild(i, currentSize)]){
				return lChild(i, currentSize);
			}else{
				return rChild(i, currentSize);
			}
		}else{	// if i only has one child, return it
			return lChild(i, currentSize);
		}
	}

	// delete the largest in the tree and reset the relationship
	// this can be done in log(n) time
	public int popLargest(){
		if(currentSize<= 0){
			throw new IndexOutOfBoundsException("Too Greedy!");
		}else{
			exchange(heap, 0, currentSize-1);	// change the postion of the largest and the smallest
			percdown(0,heap);	// and move the smallest down to reset the relationship right
			return heap[currentSize-- - 1];	// return the largest at the end and decerment the size
		}
	}

	// return the size of the heap
	public int size(){
		return currentSize;
	}

	// print heap to check
	public void printHeap(){
		for(int i = 0; i < currentSize; i++){
			System.out.print(heap[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
}