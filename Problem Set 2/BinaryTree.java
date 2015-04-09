// Wesley Wei Qian
// Binary Tree with a root

import java.util.*; 

public class BinaryTree{

	// one filed indiate the root
	private BinaryTreeNode root;

	// constructor with root
	public BinaryTree(BinaryTreeNode root){
		this.root = root;
	}

	// flatten method, which will produce a list containg the data from all the nodes of the tree
	// which is the flatten of the root.
	public List<String> flatten(){
		List<String> flattenList = new LinkedList <String>();
		this.root.flatten(flattenList);
		return flattenList;
	}

	// // this is the versoin cooperated with the addAll version flatten
	// public List<String> flatten(){
	// 	return this.root.flatten();
	// }

	// get the root
	public BinaryTreeNode getRoot(){
		return this.root;
	}

	// a method that print out the flatten list
	// I can make this a toString method, but that is not interesting for this question
	public void printFlattenList(){
		for(String str: this.flatten()){
			System.out.print(str+",");
		}
		System.out.println();
	}
}
