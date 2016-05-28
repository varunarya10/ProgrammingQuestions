// Implement Stack data structure using Linked List 

public class MyStack {
	
	public class Elem {
		private Elem next;
		private int data;
		
		public Elem(int data) {
			this.data = data;
			this.next = null;
		}
		
		public void setNext(Elem next) { this.next = next; }
		public void setData(int data) {this.data = data; }
		public Elem getNext() {return this.next; }
		public int getData() {return this.data; }
	}
	
	private Elem head;
	public MyStack() {this.head = null; }
	public boolean createStack() {
		this.head = null; 
		return true;
	}
	
	public boolean deleteStack() {
		Elem item = head;
		while(head != null) {
			head = item.getNext();
			item = null;
			item = head;
		}	
		return true;
	}
	
	public boolean push(int data) {
		// Following statement will throw exception on its own
		Elem item = new Elem(data);
		item.setNext(head);
		head = item;
		return true;
	}
	
	public int pop() throws Exception {
		if(head == null) {
			throw new Exception("Stack is empty"); 
		}
		
		int value = head.getData();
		Elem item = head;
		
		head = item.getNext();
		item = null;
		
		return value;
	}
	

	public static void main(String[] args) {
		MyStack mystack = new MyStack();
		mystack.createStack();
		System.out.println(mystack.push(1));
		System.out.println(mystack.push(2));
		System.out.println(mystack.push(3));
		System.out.println(mystack.push(4));
		
		try {
			System.out.println(mystack.pop());
			System.out.println(mystack.pop());
			System.out.println(mystack.pop());
			System.out.println(mystack.pop());
			System.out.println("aaa" + mystack.pop());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		mystack.deleteStack();
		

	}

}
