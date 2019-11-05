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
	
	private int getHeight(BSTNode rt) {
		//base case: root is null
		if(rt == null)
			return 0;
		else {
			//get height of each sub tree
			int lHeight = getHeight(rt.left);
			int rHeight = getHeight(root.right);
			
			//return the largest
			if(lHeight > rHeight)
				return lHeight + 1;
			else
				return rHeight + 1;
		}
	}
	
//	private void printLevel(BSTNode rt, int level) {
//		//base case
//		if(rt == null)
//			return;
//		
//		//Start at level 1 and continue on each branch
//		if(level == 1)
//			printData(rt);
//		else if(level > 1) {
//			printLevel(rt.left, level - 1);
//			printLevel(rt.right, level - 1);
//		}
//	}
	
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
	
    private BSTNode deleteNode(BSTNode rt, int key) {
    	//Base case: root is null, return root
        if(rt == null) 
        	return rt;
 
        if(key < rt.getKey()) {
            rt.left = deleteNode(rt.left, key);
        } else if(key > rt.getKey()) {
            rt.right = deleteNode(rt.right, key);
        } else {
            // node with no leaf nodes
            if(rt.left == null && rt.right == null) {
                System.out.println("deleting "+key);
                return null;
            } else if(rt.left == null) {
                // node with one node (no left node)
                System.out.println("deleting "+key);
                return rt.right;
            } else if(rt.right == null) {
                // node with one node (no right node)
                System.out.println("deleting "+key);
                return rt.left;
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                int minValue = minValue(rt);
                rt.setKey(minValue);
                rt.right = deleteNode(rt.right, minValue);
                System.out.println("deleting "+key);
            }
        }
 
        return rt;
    }
    
    private int minValue(BSTNode rt) {
    	 
        if(rt.left != null) {
            return minValue(rt.left);
        }
        return rt.getKey();
    }
	
    private BSTNode findNode(BSTNode rt, int key) {
    	// Base Cases: root is null or key is present at root 
        if (rt==null || rt.getKey()==key) 
            return root; 
      
        // val is greater than root's key 
        if (rt.getKey() > key) 
            return findNode(rt.left, key); 
      
        // val is less than root's key 
        return findNode(rt.right, key); 
    }
    
	//public member functions
	public void insert(int key) {
		root = insert(root, key);
	}
	
	public void delete(int key) {
		 
        deleteNode(root, key);
    }
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public int size() {
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
	
	public BSTNode search(int key) {
		return findNode(root,key);
	}
	
//	public void levelOrder() {
//		
//		//get the height of the tree
//		int height = getHeight(root);
//		
//		//print each height
//		for(int i = 1; i <= height; i++)
//			printLevel(root, i);
//	}
	
	
	
	
}
