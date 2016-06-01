// Must change the class name to MyTree Else program will not work
// Program to find the lowest common ancestor in a BST

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
	
	public Node find_LCA(Node n, int v1, int v2) {
		while(n != null) {
			if(n.getData() > v1 && n.getData() > v2) {
				n = n.getLeft();
			} else if(n.getData() < v1 && n.getData() < v2) {
				n = n.getRight();
			} else {
				return n;
			}
		}
		return null;
	}
	
	public Node findLCA(Node root, Node n1, Node n2) {
		if(root == null || n1 == null || n2 == null) {
			return null;
		}
		
		return find_LCA(root, n1.getData(), n2.getData());
	}
	

	
	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.create_tree();
		Node n = tree.find_LCA(tree.getRoot(), 8, 20);
		System.out.print(n.getData());
		
	}

}
