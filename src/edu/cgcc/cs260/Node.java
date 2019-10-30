package edu.cgcc.cs260;

public class Node {
	//members
	public int data;
	public Node left;
	public Node right;

	//constructor
	public Node(String d) {
		try {
			data = Integer.parseInt(d.trim());
		}
		catch(NumberFormatException e) {
			System.err.println("Unable to convert \"" + d + "\" to an integer.");
		}
		catch(Exception e) {
			System.err.println("A general error occured.");
		}
	}
	
	//member functions
	
}
