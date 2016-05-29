// Simple class to create a linked list from integer array

public class MyLinkedList {
	
	public class Node {
		private Node next;
		private int data;
		
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
		
		public Node() {}
		
		public void setData(int d) { this.data = d; }
		public void setNext(Node n) { this.next = n; }
		public Node getNext() {return this.next; }
		public int getData() {return this.data; }
	}
	
	private Node head;
	
	public Node createListFromArray(int[] arr) {
		Node prev = null;
		for(int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (prev == null) {
				// First node
				head = prev = n;
			} else {
				prev.setNext(n);
				prev = n;
			}
		}
		return head;
	}
	
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		MyLinkedList l = new MyLinkedList();
		l.createListFromArray(arr);
		l.printList();

	}
}
