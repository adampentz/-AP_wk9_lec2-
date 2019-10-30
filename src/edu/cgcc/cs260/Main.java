package edu.cgcc.cs260;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		//Create tree nodes
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		Node k = new Node("K");
		
		//build tree manually
		Node root = a;
		root.left = b; root.right = c;
		b.left = d; b.right = e;
		d.left = h; d.right = i;
		e.left = j;
		c.left = f; c.right = g;
		g.left = k;
		
		BinaryTree bt = new BinaryTree(root);
		
		System.out.print("In Order Traverse: ");
		bt.traverseInOrder(bt.root);
		System.out.println();
		System.out.print("Pre Order Traverse: ");
		bt.traversePreOrder(bt.root);
		System.out.println();
		System.out.print("Post Order Traverse: ");
		bt.traversePostOrder(bt.root);
		
	}

}
