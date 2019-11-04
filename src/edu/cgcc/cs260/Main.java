package edu.cgcc.cs260;
public class Main {

	public static void main(String[] args) {
		//recurse through file system
		/*
		 * System.out.println("\n\n\nRecursion Get:\n"); Recursion.q.clear();
		 * Recursion.recursionGet(Recursion.root);
		 * 
		 * while(!Recursion.q.isEmpty()) { System.out.println(Recursion.q.remove()); }
		 */
		
		
		//iterate through file system
		/*
		 * System.out.println("\n\n\nIterative Get:\n");
		 * Recursion.iterativeGet(Recursion.root);
		 * 
		 * while(!Recursion.q.isEmpty()) { System.out.println(Recursion.q.remove()); }
		 */
		
		
		/*
		 * //Create tree nodes BSTNode a = new BSTNode("A"); BSTNode b = new
		 * BSTNode("B"); BSTNode c = new BSTNode("C"); BSTNode d = new BSTNode("D");
		 * BSTNode e = new BSTNode("E"); BSTNode f = new BSTNode("F"); BSTNode g = new
		 * BSTNode("G"); BSTNode h = new BSTNode("H"); BSTNode i = new BSTNode("I");
		 * BSTNode j = new BSTNode("J"); BSTNode k = new BSTNode("K");
		 * 
		 * //build tree manually BSTNode root = a; root.left = b; root.right = c; b.left
		 * = d; b.right = e; d.left = h; d.right = i; e.left = j; c.left = f; c.right =
		 * g; g.left = k;
		 * 
		 * BinaryTree bt = new BinaryTree(root);
		 * 
		 * System.out.print("Pre Order Traverse: "); bt.preOrder();
		 * System.out.println(); System.out.print("In Order Traverse: "); bt.inOrder();
		 * System.out.println(); System.out.print("Post Order Traverse: ");
		 * bt.postOrder();
		 */
		BinaryTree bt = new BinaryTree(null);
		bt.insert(11);
		bt.insert(6);
		bt.insert(8);
		bt.insert(19);
		bt.insert(4);
		bt.insert(10);
		bt.insert(5);
		bt.insert(17);
		bt.insert(43);
		bt.insert(49);
		bt.insert(31);
		
		bt.levelOrder();
	}

}
