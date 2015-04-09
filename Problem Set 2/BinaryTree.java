// Wesley Wei Qian
// Binary Tree with a root

import java.util.List; 

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
		return this.root.flatten();
	}

	public BinaryTreeNode getRoot(){
		return this.root;
	}

	public void printFlattenList(){
		for(String str: this.flatten()){
			System.out.print(str+",");
		}
		System.out.println();
	}
}
