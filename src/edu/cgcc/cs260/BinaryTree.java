package edu.cgcc.cs260;

public class BinaryTree {
	
	//members
	private BSTNode root;
	
	//constructor
	BinaryTree(){
	}
	
	//private member functions
	/**
	 * print node key and person name to console
	 * @param rt node containing data
	 */
	private void printData(BSTNode rt) {
		System.out.print("(" + rt.getKey() + ")" + rt.getData().getName() + " ");
	}
	
	/**
	 * recursively print nodes to console in pre-order traversal
	 * @param rt
	 */
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
	
	/**
	 * recursively print nodes to console in in-order traversal
	 * @param rt
	 */
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
	
	/**
	 * recursively print nodes to console in post-order traversal
	 * @param rt
	 */
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
	
	/**
	 * get the number of nodes in the tree
	 * @param rt
	 * @return integer number of nodes in tree
	 */
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
	
	/**
	 * get the height of the tree
	 * @param rt
	 * @return integer height of tree
	 */
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
	
	/**
	 * insert a node into the tree
	 * @param rt
	 * @param key
	 * @return
	 */
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
	
	/**
	 * delete a node from the tree
	 * @param rt
	 * @param key
	 * @return
	 */
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
    
    /**
     * find the node with minimum key value
     * @param rt
     * @return
     */
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
	
    /**
     * find a node in the tree with a given key value
     * @param rt
     * @param key
     * @return
     */
    private BSTNode findNode(BSTNode rt, int key) {
		//base case: rt is the node to be found
    	if (rt.getKey() == key) 
            return root; 
      
        // key is less than root's key; go to left
        if (key < rt.getKey() && rt.left != null) 
            return findNode(rt.left, key); 
        else if(key > rt.getKey() && rt.right != null)
        // key is greater than root's key; go to right
        	return findNode(rt.right, key); 
        else
        // return null since node cannot be found
        	return null;
    }
    
	//public member functions
    /**
     * insert a node with a given key
     * @param key
     */
	public void insert(int key) {
		root = insert(root, key);
	}
	
	/**
	 * find and delete a node that matches a given key
	 * @param key
	 */
	public void delete(int key) {
		 
        deleteNode(root, key);
    }
	
	/**
	 * check if tree is empty
	 * @return
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * get the number of nodes in the tree
	 * @return
	 */
	public int size() {
		return getSize(root);
	}
	
	/**
	 * print the tree in pre-order traversal
	 */
	public void preOrder() {
		printPreOrder(root);
	}
	
	/**
	 * print the tree in in-order traversal
	 */
	public void inOrder() {
		printInOrder(root);
	}
	
	/**
	 * print the tree in post-order traversal
	 */
	public void postOrder() {
		printPostOrder(root);
	}
	
	/**
	 * find a node with a given key and return its data
	 * @param key
	 * @return a person from the tree
	 */
	public Person search(int key) {
		
		BSTNode rt = findNode(root,key);
		
		if( rt != null)
			return rt.getData();
		else
			return null;
	}

}
