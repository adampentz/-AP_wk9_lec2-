package edu.cgcc.cs260;
import java.util.NoSuchElementException;

/**
 * A Self-Balancing Binary Search Tree
 * The heights of the two child subtrees of any node differ by at most one
 * Insertions and deletions may require the tree to be re-balanced by one or more rotations
 */
public class AVLTree {
	//members
	private AVLNode root;
	
	//
	//private member functions
	//
	/**
	 * private insert node into AVL tree
	 * @param key integer representing key value for data in AVL Node
	 * @return true on insertion success, false on insertion failure
	 * @throws Exception
	 */
	private void insertNode(AVLNode rt, int key) throws Exception {
		//if root is null, add node to root
		if(rt == null) {
			root = new AVLNode(key, null);
			return;
		}
		
		//otherwise, insert node in appropriate position
		//infinite loop to keep going until 
		//correct position is found and returned
		while(true) {
			//don't insert duplicate key
			//demonstration of exception handling
			if(rt.key == key)
				throw new Exception("Person " + key + " already exists.");
			
			//set the parent to current rt
			AVLNode parent = rt;
			
			//check the key. left if it's less, right if it's not
			//short form if statement
			boolean goLeft = rt.key > key;
			rt = goLeft ? rt.left : rt.right;
			
			//insert at null leaf
			if(rt == null) {
				//if the key is left, insert on left
				//otherwise, insert on right
				if(goLeft)
					parent.left = new AVLNode(key, parent);
				else
					parent.right = new AVLNode(key, parent);
				
				//rebalance the tree
				rebalance(parent);
				
				//quit the loop
				break;
			}
		}
		
		//return success of node creation and insertion
		return;
	}
	
	/**
	 * 
	 * @param rt
	 * @throws NoSuchElementException
	 */
	private void deleteNode(AVLNode rt) {
		//if it's a leaf node
		if(rt.left == null && rt.right == null) {
			
			//if parent is null, root should be deleted
			if(rt.parent == null)
				root = null; // set root to null
			else {
				AVLNode parent = rt.parent;
				if(parent.left == rt)
					parent.left = null;
				else
					parent.right = null;
				
				rebalance(parent);
			}
			
			return;
		}
		
		//delete left
		if(rt.left != null) {
			AVLNode child = rt.left;
			while(child.right != null)
				child = child.right;
			rt.key = child.key;
			deleteNode(child);
		}
		
		//delete right
		else {
			AVLNode child = rt.right;
			while(child.left != null)
				child = child.left;
			rt.key = child.key;
			deleteNode(child);
		}
	}
	
	/**
	 * re-balance the AVL tree after insertion and deletion
	 * @param rt
	 */
	private void rebalance(AVLNode rt) {
		//set the balance of the node
		setBalance(rt, null);

		
		if(rt.balance <= -2) {
			if(height(rt.left.left) >= height(rt.right.right))
				rt = rotateRight(rt);
			else
				rt = rotateLeftThenRight(rt);
		}
		
		else if(rt.balance >= 2) {
			if (height(rt.right.right) >= height(rt.right.left))
                rt = rotateLeft(rt);
            else
                rt = rotateRightThenLeft(rt);
		}
		
		//re-balance on parent if it exists
		if(rt.parent != null)
			rebalance(rt.parent);
		//otherwise, use current node
		else
			root = rt;
	}
	
	/**
	 * rotate tree to the left for balance
	 * @param a
	 * @return
	 */
	private AVLNode rotateLeft(AVLNode a) {
		 
        AVLNode b = a.right;
        b.parent = a.parent;
 
        a.right = b.left;
 
        if (a.right != null)
            a.right.parent = a;
 
        b.left = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
	/**
	 * rotate tree to the right for balance
	 * @param a
	 * @return
	 */
    private AVLNode rotateRight(AVLNode a) {
 
        AVLNode b = a.left;
        b.parent = a.parent;
 
        a.left = b.right;
 
        if (a.left != null)
            a.left.parent = a;
 
        b.right = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    /**
     * perform two rotations, left then right
     * @param n
     * @return
     */
    private AVLNode rotateLeftThenRight(AVLNode n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }
 
    /**
     * perform two rotations, right then left
     * @param n
     * @return
     */
    private AVLNode rotateRightThenLeft(AVLNode n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }
    
    /**
     * set the balance for both nodes passed
     * @param a
     * @param b
     */
    private void setBalance(AVLNode a, AVLNode b) {    	
    	for (AVLNode n : new AVLNode[] {a, b}) {
            reHeight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }
    
    /**
     * set the height for a node
     * @param n
     * @return
     */
    private int height(AVLNode n) {
        if (n == null)
            return -1;
        return n.height;
    }
    
    /**
     * re-height the tree to reflect correct heights for nodes
     * @param n
     */
    private void reHeight(AVLNode n) {
        if (n != null) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }
    }
	
	/**
	 * print node key and person name to console
	 * @param rt node containing data
	 */
	private void printData(AVLNode rt) {
		System.out.print("(" + rt.key + ")" + rt.getData().getName() + " ");
	}
	
	/**
	 * recursively print nodes to console in pre-order traversal
	 * @param rt
	 */
	private void printPreOrder(AVLNode rt) {
		
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
	private void printInOrder(AVLNode rt) {
		
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
	private void printPostOrder(AVLNode rt) {
		
		//base case: if node is null, return
		if(rt == null) {
			return;
		}
		
		//print post order
		printPostOrder(rt.left);
		printPostOrder(rt.right);
		printData(rt);
	}
	
	private void printNodeBalance(AVLNode n) {
        if (n != null) {
            printNodeBalance(n.left);
            System.out.printf("%s ", n.balance);
            printNodeBalance(n.right);
        }
    }
	
	//
	//public member functions
	//
	
	/**
	 * abstraction for insertNode method
	 * @param key
	 */
	public void insert(int key) {
		//attempt insertion
		try {
			insertNode(root, key);
			
			//on success, print message
			System.out.println("Person " + key + " inserted succesfully.");
		}
		//catch failures
		catch(Exception e) {
			System.err.println((e.getMessage() != null) ? e.getMessage() : "");
		}
	}
	
	/**
	 * abstraction for deleteNode method
	 * @param key
	 */
	public void delete(int key) {
		try {
			
			//make sure root isn't null
			if(root == null)
				throw new NullPointerException("The tree root is unassigned.");
			
			//set the child node to root
			AVLNode child = root;
			
			//while children exist, find node to delete
			while(child != null) {
				//set the child to current node to check
				AVLNode rt = child;
				
				//determine whether to traverse right or left from rt
				child = key >= rt.key ? rt.right : rt.left;
				
				//if the node is found, delete it
				if(key == rt.key) {
					deleteNode(rt);
					System.out.println("Person " + key + " has been deleted.");
					return;
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
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
	
	public void printBalance() {
		printNodeBalances(root);
	}
}
