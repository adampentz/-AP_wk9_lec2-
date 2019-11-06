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
	
	private void printLevel(BSTNode rt, int level) {
		//base case
		if(rt == null)
			return;
		
		//Start at level 1 and continue on each branch
		if(level == 1)
			printData(rt);
		else if(level > 1){
			printLevel(rt.left, level - 1);
			printLevel(rt.right, level - 1);
		}
	}
	
	private BSTNode insert(BSTNode rt, int key) {
		//base case: if null, create new node
		if(rt == null)
			rt = new BSTNode(key);
		//otherwise: compare keys and insert into correct location
		else {
			if(key <= rt.getKey())
				rt.left = insert(rt.left, key);
			else
				rt.right = insert(rt.right, key);
		}
		
		return rt;
	}
	
    private BSTNode deleteNode(BSTNode rt, int key) {
    	//Base case: root is null, return root
        if(rt == null) 
        	return null;
        
        //the node to delete is in the left sub tree
        if(key < rt.getKey())
        	rt.left = deleteNode(rt.left, key);
        
        //the node to delete is in the right sub tree
        else if(key > rt.getKey())
        	rt.right = deleteNode(rt.right, key);
        else {
        	//case 1: no children
        	if(rt.left == null && rt.right == null) {
        		rt = null;
        	}
        	//case 2: right child
        	else if(rt.left == null) {
        		rt = rt.right;
        	}
        	//case 3: left child
        	else if(rt.right == null) {
        		rt = rt.left;
        	}
        	//case 4: two children
        	else {
        		//store node with smallest key in right subtree
        		BSTNode temp = minNode(rt.right);
        		
        		//duplicate the node to new location
        		rt.setKey(temp.getKey());
        		rt.setData(temp.getData());
        		rt.right = deleteNode(rt.right, temp.getKey());
        	}
        	
        }
        
        //update parent node reference
        return rt;
    }
    
    private BSTNode minNode(BSTNode rt) {
        //base case: node is null
    	if(rt == null)
            return null;
    	
    	//case 1: a smaller key exists to the left
        if(rt.left != null)
        	return minNode(rt.left);
        
        //return node with smallest key
        return rt;
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
	
	public void levelOrder() {
		
		//get the height of the tree
		int height = getHeight(root);
		
		//print each height
		for(int i = 1; i <= height; i++)
			printLevel(root, i);
	}
	
	
	
	
}
