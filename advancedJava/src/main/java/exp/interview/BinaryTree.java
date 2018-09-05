package com.chandler.exp.interview;

import java.util.Random;

public class BinaryTree {
	//all sub nodes linked from here
	private Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node find(Node root, Node node) {
		// nothing found
		if (null == root) {
			return null;
		}

		// compare once to improve performance
		int compareResult = node.compareTo(root);
		// found
		if (compareResult == 0) {
			return node;
		} else if (compareResult > 0) {// go to right child
			return find(root.right, node);
		} else {// go to left child
			return find(root.left, node);
		}
	}

	//better performance than recursive
	public Node findNonRec(Node root, Node node) {
		// declare once to improve performace
		@SuppressWarnings("unused")
		int compareResult;

		while (true) {
			if (null == root) {
				return null;
			}

			// compare once to improve performance
			compareResult = node.compareTo(root);

			if (node.compareTo(root) == 0) {
				return node;
			} else if (node.compareTo(root) > 0) {// go to right child
				root = root.right;
			} else {// go to left child
				root = root.left;
			}
		}
	}

	public Node insert(Node root, Node node) {
		// convergence point
		//if the node passed in already has child, then the whole subTree is attached
		if (null == root) {
			//we assume the node has already had the right height
			//if the node has no child, this will be 0
			//refer to the height method
			node.height = Math.max(height(node.left), height(node.right))+1;
			return node;
		}
		// compare once to improve performance
		int compareResult = node.compareTo(root);

		// duplicate found, do nothing
		if (compareResult == 0) {
			;
		} else if (compareResult > 0) {// go to right child
			// the root here is the end of tree before inserting the new node
			root.right = insert(root.right, node);
		} else {// go to left child
			// the root here is the end of tree before inserting the new node
			root.left = insert(root.left, node);
		}

		
		root.height = Math.max(height(root.left), height(root.right))+1;
		// need to return root but not node
		// all node along the way back of recursive is RESET
		// try debug to know better of the process
		return root;
	}

	//dramatically better than recursive
	//do not need to reset all nodes along the way back
	public void insertNonRec(Node root, Node node) {
		//insert node as root
		if (null == root) {
			this.root = node;
		}

		// declare once to improve performace
		@SuppressWarnings("unused")
		int compareResult;
		
		while (true) {			
			// compare once to improve performance
			compareResult = node.compareTo(root);

			//duplicate, do nothing
			if (node.compareTo(root) == 0) {
				break;
			} else if (node.compareTo(root) > 0) {// go to right child
				//right child is empty
				if(null == root.right){
					root.right = node;
					break;
				}else
					root = root.right;
			} else {// go to left child
				if(null == root.left){
					root.left = node;
					break;
				}else
					root = root.left;
			}
		}
	}

	public Node remove(Node root, Node node){
		//do nothing
		if(null == node)
			return null;		
		if(null == root){
			return null;
		}
		
		// compare once to improve performance
		int compareResult = node.compareTo(root);
		
		//go right
		if(compareResult > 0 ){
			root.right = remove(root.right, node);//similar to insert
		}else if(compareResult <0){
			root.left = remove(root.left, node);
			
		//node found and both left and right are not null - complicated case
		}else if(null != root.left && null != root.right){
			//find min in right subtree and remove it, then replace the current node with the min
			Node min = this.findMin(root.right);
			//remove min first to maintain binary tree structure
			root.right = remove(root.right, min);
			root.value = min.value; // replace the value ONLY
		}else{//at least one of the child is null, node == root at convergence point
			if(null != root.left){
				root = root.left; //does not change the actual node but as a return value
			}else if(null != root.right){
				root = root.right;
			}else{// node is a leaf
				root = null;
			}
		}
		
		return root;
	}
	
	public Node findMin(Node root){
		if(null == root)
			return root;
		else if(null == root.left)
			return root;
		else
			return findMin(root.left);
	}
	
	public Node finMinNonRec(Node root){
		while(true){
			if(null == root)
				return null;
			else if(null == root.left)
				return root;
			else
				root = root.left;
		}
	}
	
	//the most complicated method
	public void removeNonRec(Node root, Node node){
		if(null == node)
			return;
		if(null == root){
			return;
		}		
		
		int compareResult;
		//MUST have, refer to comment for codes below
		Node parent = null;
		
		
		while(true){			
			compareResult = node.compareTo(root);
			
			//go right
			if(compareResult > 0 ){
				parent = root;
				root = root.right;
			}else if(compareResult <0){
				parent = root;
				root = root.left;				
			//node found and both left and right are not null - complicated case
			}else if(null != root.left && null != root.right){
				//find min in right subtree and remove it, then replace the current node with the min
				Node min = this.finMinNonRec(root.right);
				//the min point has no left child, so we can do recursive call
				//there are 3 cases for this operation(if non-recursive) so we do a one-time recursive call(calling non recursive method)
				//to reduce the coding complexity without sacrificing performance
				this.removeNonRec(root, min);//remove min node first to maintain tree stucture
				root.value = min.value; // replace the value ONLY				
				break;
			}else{//at least one of the child is null, node == root at convergence point
				
				//delete root
				if(null == parent){
					this.root = null;
				}else if(null != root.left){
					//Java restriction here
					//if we do not use parent but directly change the root itself
					//the code will not work since the root is like an alias of the original obj
					//we can only change the "link" from parent obj to actually modify the tree
					if(parent.left == root){
						parent.left = root.left;
					}else{
						parent.right = root.left;
					}
				}else if(null != root.right){
					if(parent.left == root){
						parent.left = root.right;
					}else{
						parent.right = root.right;
					}
				}else{// node is a leaf		
					if(parent.left == root){
						parent.left = null;
					}else{
						parent.right = null;
					}					
				}
				break;
			}			
		}
		
	}
	
	public void printNode(Node node) {
		if (null == node)
			System.out.println("node is null.");
		else {
			System.out.print("Node value: " + node.value);
			if (null != node.left) {
				System.out.print(" Left: " + node.left.value);
			}
			if (null != node.right) {
				System.out.print(" Right: " + node.right.value);
			}
		}
		System.out.println("");
	}

	public void scanTree(Node root) {
		if (null == root)
			return;
		else
			this.printNode(root);

		scanTree(root.left);
		scanTree(root.right);
	}

	private int height(Node node){
		//will see why in insert method
		//non-recursive method has difficulty to be an AVL tree
		return node == null ? -1 : node.height;
	}
	
	//this method cannot be used in non-recursive
	//because all nodes' height along the way BACK needs to be ajusted
	private Node rotateWithLeftChild(Node node){
		Node leftChild = node.left;
		node.left = leftChild.right;
		leftChild.right = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		//node height already calculated, the new height need to be based on the new structure
		leftChild.height = Math.max(height(leftChild.left), node.height)+1;
		
		return leftChild;
	}
	
	public static void main(String[] args) {
		int size = 20;
		int bound = size*1;
		long from; 
		Random r = new Random();
		Node temp;
		Node root = new Node(20, null, null);
		BinaryTree bt = new BinaryTree(root);
		
//		from = System.currentTimeMillis();		
//		for (int i = 0; i < size; i++) {
//			//int value = i;
//			int value = r.nextInt(bound);
//			bt.insert(bt.root, new Node(value, null, null));
//			System.out.print(value+",");
//		}
//		System.out.println("Tree: ");
//		bt.scanTree(root);
//		
//		System.out.println("Node found: ");
//		temp = bt.find(root, new Node(6, null, null));
//		bt.printNode(temp);
//		System.out.println("Remove node: ");
//		bt.remove(root, temp);
//		bt.scanTree(root);
//		System.out.println("Time spent:"+(System.currentTimeMillis()-from));

		//non-recursive
		root = new Node(20, null, null);
		bt = new BinaryTree(root);
		
		from = System.currentTimeMillis();		
		for (int i = 0; i < size; i++) {
//			int value = i;
			int value = r.nextInt(bound);
			bt.insertNonRec(bt.root, new Node(value, null, null));
			System.out.print(value+",");
		}
		System.out.println("Tree: ");
		bt.scanTree(root);
		
		System.out.println("Node found Non-Rec: ");
		temp = bt.findNonRec(bt.root, new Node(6, null, null));
		bt.printNode(temp);
		System.out.println("Remove node: ");
		bt.removeNonRec(bt.root, temp);
		bt.scanTree(bt.root);
		System.out.println("Time spent:"+(System.currentTimeMillis()-from));
	}
}

// this can never be accessed from main if declared as inner class(no matter
// public or not)
class Node implements Comparable<Node> {
	int id; // not in use for this example
	int value;
	Node left;
	Node right;
	
	int height;//only used in AVL

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;		
	}

	@Override
	public int compareTo(Node arg0) {
		return Integer.compare(this.value, arg0.value);
	}
}