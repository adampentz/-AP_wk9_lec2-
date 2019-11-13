package edu.cgcc.cs260;

public class AVLNode {
	//members
	public int key, height, balance;
	public AVLNode parent, left, right;
	private Person data;
	
	/**
	 * Constructor for AVL Tree Node
	 * @param k key value for data
	 * @param p parent node for AVL node
	 */
	AVLNode(int k, AVLNode p){
		key = k;
		parent = p;
		data = Person.generatePerson();
	}
	
	//public member functions
	public Person getData() {
		return data;
	}
}
