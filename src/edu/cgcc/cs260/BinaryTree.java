package edu.cgcc.cs260;

public class BinaryTree {
	
	//members
	private BSTNode root;
	
	//constructor
	BinaryTree(BSTNode rt){
		root = rt;
	}
	
	//private member functions
	private void printData(BSTNode rt) {
		System.out.print("(" + rt.getKey() + ")" + rt.getData().getName() + " ");
	}
	
	private void printPreOrder(BSTNode rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print pre order
		printData(rt);
		printPreOrder(rt.left);
		printPreOrder(rt.right);
	}
	
	private void printInOrder(BSTNode rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print in order
		printInOrder(rt.left);
		printData(rt);
		printInOrder(rt.right);
	}
	
	private void printPostOrder(BSTNode rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print post order
		printPostOrder(rt.left);
		printPostOrder(rt.right);
		printData(rt);
	}
	
	private int getSize(BSTNode rt) {
		int size = 0;
		
		//base case, size is zero if root is null
		if(rt == null)
			return size;
		
		//Get the size of tree
		size += getSize(rt.left);
		size += getSize(rt.right);
		
		return size;
	}
	
	private int height(BSTNode rt) {
		//base case: root is null
		if(rt == null)
			return 0;
		else {
			//get height of each sub tree
			int lHeight = height(rt.left);
			int rHeight = height(root.right);
			
			//return the largest
			if(lHeight > rHeight)
				return lHeight + 1;
			else
				return rHeight + 1;
		}
	}
	
	private void printLevel(BSTNode rt, int level) {
		//base case
		if(rt == null)
			return;
		
		//Start at level 1 and continue on each branch
		if(level == 1)
			printData(rt);
		else if(level > 1) {
			printLevel(rt.left, level - 1);
			printLevel(rt.right, level - 1);
		}
	}
	
	//insert data recursively
	private BSTNode insert(BSTNode node, int key) {
		//base case: if null, create new node
		if(node == null)
			node = new BSTNode(key);
		//otherwise: compare keys and insert into correct location
		else {
			if(key <= node.getKey())
				node.left = insert(node.left, key);
			else
				node.right = insert(node.right, key);
		}
		
		return node;
	}
	
	//public member functions
	public void insert(int key) {
		root = insert(root, key);
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public int nodeCount() {
		return getSize(root);
	}
	
	public void preOrder() {
		printPreOrder(root);
	}
	
	public void inOrder() {
		printInOrder(root);
	}
	
	public void postOrder() {
		printPostOrder(root);
	}
	
	public void levelOrder() {
		
		//get the height of the tree
		int height = height(root);
		
		//print each height
		for(int i = 1; i <= height; i++)
			printLevel(root, i);
	}
	
	
	
	
}
