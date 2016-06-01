// Must change the file name to MyTree.java otherwise it will not work
// Program to traverse the tree. Preorder, inorder and postorder

import java.util.Stack;

public class MyTree {
	
	public class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
		
		public Node getLeft() { return left; }
		public Node getRight() { return right; }
		public int getData() { return data; }
		
		public void setData(int d) { data = d; }
		public void setLeft(Node n) { left = n; }
		public void setRight(Node n) { right = n; }
	}
	
	Node root = null;
	
	public void create_tree() {
		Node n1 = new Node(50);
		Node n2 = new Node(25);
		Node n3 = new Node(75);
		Node n4 = new Node(12);
		Node n5 = new Node(40);
		Node n6 = new Node(60);
		Node n7 = new Node(90);
		Node n8 = new Node(8);
		Node n9 = new Node(20);
		Node n10 = new Node(35);
		Node n11 = new Node(70);
		
		root = n1;
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n4.setLeft(n8);
		n4.setRight(n9);
		n5.setLeft(n10);
		n3.setLeft(n6);
		n3.setRight(n7);
		n6.setRight(n11);
	}
	
	public Node getRoot() { return root; }
	
	public void preOrderIter() {
		if(root == null) return;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node n;
		
		while(s.isEmpty() == false) {
		
			n = s.pop();
			while(n != null) {
				System.out.print(n.data + " ");
				if(n.getRight() != null) {
					s.push(n.getRight());
				}
				n = n.getLeft();
			}
		}
		
		System.out.println();
	}
	
	public void preOrderIter2() {
		if(root == null) return;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node n;
		
		while(s.size() > 0) {
			n = s.pop();
			System.out.print(n.data + " ");
			if(n.getRight() != null) s.push(n.getRight());
			if(n.getLeft() != null) s.push(n.getLeft());
		}
		
		System.out.println();
	}
	
	public void preOrder() 
	{ 
		preOrderWrap(root);
		System.out.println();
	}
	public void preOrderWrap(Node n) {
		if( n == null ) return;
		System.out.print(n.data + " ");
		preOrderWrap(n.getLeft());
		preOrderWrap(n.getRight());
	}
	
	public void inOrder() { 
		inOrderWrap(root);
		System.out.println();
	}
	
	public void inOrderWrap(Node n) {
		if( n == null ) return;
		inOrderWrap(n.getLeft());
		System.out.print(n.data + " ");
		inOrderWrap(n.getRight());
	}
	
	public void postOrder() { 
		postOrderWrap(root);
		System.out.println();
	}
	
	public void postOrderWrap(Node n) {
		if( n == null ) return;
		postOrderWrap(n.getLeft());
		postOrderWrap(n.getRight());
		System.out.print(n.data + " ");
	}
	
	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.create_tree();
		tree.preOrderIter();
		tree.preOrderIter2();
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
	}

}
