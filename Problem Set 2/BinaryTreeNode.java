// Wesley Wei Qian
// Node for Binary Tree

import java.util.*; 

public class BinaryTreeNode{

	// simple data filed
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	private String value;

	// constructor with only value input
	public BinaryTreeNode(String value){
		this.value = value;
		this.rightChild = null;
		this.leftChild = null;
	}

	// constructor with all the value
	public BinaryTreeNode(String value, BinaryTreeNode leftChild, BinaryTreeNode rightChild){
		this.value = value;
		this.rightChild = rightChild;
		this.leftChild = leftChild;
	}

	// child setter
	public void setLeftChild (BinaryTreeNode leftChild){
		this.leftChild=leftChild;
	}
	public void setRightChild (BinaryTreeNode rightChild){
		this.rightChild=rightChild;
	}

	// child getter
	public BinaryTreeNode getLeftChild(){
		return this.leftChild;
	}
	public BinaryTreeNode getRightChild(){
		return this.rightChild;
	}

	// flattern method, which will contain its' children nodes values
	// I didn't use addAll version because this method can save a little running time.
	// even though that is more intuitive
	public void flatten(List<String> flattenList){
		// if the right child is not null, get to the right child
		if (this.getLeftChild() != null) {
			this.getLeftChild().flatten(flattenList);
		}
		// add the current node value to the flattern list
		flattenList.add(this.toString());

		// if the left child is not null, get to the right child
		if (this.getRightChild() != null) {
			this.getRightChild().flatten(flattenList);
		}
	}

	// // flattern method, which will contain its' children nodes values
	// public List<String> flatten(){
	// 	// declare the List we are going to return
	// 	List<String> flattenList = new LinkedList <String> ();
	// 	// if the right child is not null, get to the right child
	// 	if (this.getLeftChild() != null) {
	// 		flattenList.addAll(this.getLeftChild().flatten());
	// 	}
	// 	// add the current node value to the flattern list
	// 	flattenList.add(this.value);

	// 	// if the left child is not null, get to the right child
	// 	if (this.getRightChild() != null) {
	// 		flattenList.addAll(this.getRightChild().flatten());
	// 	}


	// 	// return the flattenList
	// 	return flattenList;
	// }

	// toString
	public String toString(){
		return value;
	}


}