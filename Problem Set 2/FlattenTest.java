// Wesley Wei Qian
// Test for flatterning method in Binary Tree class

public class FlattenTest{
	public static void main(String[] args) {

		// Set up the tree
		BinaryTreeNode a = new BinaryTreeNode("a");
		BinaryTreeNode b = new BinaryTreeNode("b");
		BinaryTreeNode c = new BinaryTreeNode("c",a,b);
		BinaryTreeNode d = new BinaryTreeNode("d");
		BinaryTreeNode e = new BinaryTreeNode("e",c,d);
		BinaryTreeNode f = new BinaryTreeNode("f");
		f.setLeftChild(e);
		BinaryTreeNode g = new BinaryTreeNode("g");
		BinaryTreeNode h = new BinaryTreeNode("h",f,g);
		BinaryTreeNode i = new BinaryTreeNode("i");
		BinaryTreeNode j = new BinaryTreeNode("j");
		BinaryTreeNode k = new BinaryTreeNode("k",i,j);
		BinaryTreeNode l = new BinaryTreeNode("l");
		BinaryTreeNode m = new BinaryTreeNode("m",l,k);
		BinaryTreeNode n = new BinaryTreeNode("n");
		BinaryTreeNode o = new BinaryTreeNode("o",m,n);
		BinaryTreeNode p = new BinaryTreeNode("p",o,h);
		BinaryTreeNode q = new BinaryTreeNode("q");
		BinaryTreeNode r = new BinaryTreeNode("r");
		r.setLeftChild(q);
		BinaryTreeNode s = new BinaryTreeNode("s");
		s.setRightChild(r);
		BinaryTreeNode root = new BinaryTreeNode("root",s,p);	// this is the root
		// expected result is s,q,r,root,l,m,i,k,j,o,n,p,a,c,b,e,d,f,h,g,
		// since the flatten list is a depth first search

		// Set up the tree
		BinaryTree tree = new BinaryTree(root);

		// Print out the result
		tree.printFlattenList();
	}
}