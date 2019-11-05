package edu.cgcc.cs260;

public class BSTNode {
	//members
	private int key;
	private Person data;
	public BSTNode left;
	public BSTNode right;

	//constructor
	public BSTNode(int k) {
		key = k;
		data = Person.generatePerson();
	}
	
	//member functions
	public int getKey() {
		return key;
	}
	
	public void setKey(int k) {
		key = k;
	}
	
	public Person getData() {
		return data;
	}
}
