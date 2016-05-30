// Please rename this file to MyLinkedList.java. Else it will not work.
// Simple class to create a linked list from integer array
// Also has method to remove duplicates from linked list
import java.util.HashSet;

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
	
	public void removeDuplicate(Node head) {
		if(head == null || head.next == null) {
			System.out.println("List is 0 or 1 element");
			return;
		}
		
		HashSet<Integer> h = new HashSet<Integer>();
		Node prev = null;
		Node cur = head;
		
		while(cur != null) {
			if(h.contains(cur.getData())) {
				prev.setNext(cur.getNext());
			} else {
				h.add(cur.getData());
				prev = cur;
			}
			cur = cur.getNext();
		}
		
	}

	public static void main(String[] args) {
		int[] arr = {1,2,1,2,3,2,1,4,4,5,6,7,6,5};
		MyLinkedList l = new MyLinkedList();
		Node head = l.createListFromArray(arr);
		l.printList();
		l.removeDuplicate(head);
		l.printList();
		
	}
}
