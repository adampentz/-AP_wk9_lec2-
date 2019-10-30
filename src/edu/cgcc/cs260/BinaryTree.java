package edu.cgcc.cs260;

public class BinaryTree {
	
	//members
	Node root;
	
	//constructor
	BinaryTree(Node rt){
		root = rt;
	}
	
	//private member functions
	
	
	//public member functions
	public void traversePreOrder(Node rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print pre order
		System.out.print(rt.data + " ");
		traversePreOrder(rt.left);
		traversePreOrder(rt.right);
	}
	
	public void traverseInOrder(Node rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print in order
		traverseInOrder(rt.left);
		System.out.print(rt.data + " ");
		traverseInOrder(rt.right);
	}
	
	public void traversePostOrder(Node rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print post order
		traversePostOrder(rt.left);
		traversePostOrder(rt.right);
		System.out.print(rt.data + " ");
	}
	
	
}
