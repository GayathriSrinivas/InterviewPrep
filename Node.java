import java.util.*;

public class Node {
	
	private int data;
	private Node next = null;
	private Boolean isVisited = false;

	public Node(int d) {
		data = d;
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this ;

		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public Node deleteNode(int d) {
		Node head = this;
		Node n = this;

		if( n.data == d) {
			return head.next; /* Head Moved*/
		}

		while(n.next != null){
			if(n.next.data == d) {
				n.next = n.next.next;
				return head; /* Head Didn't Change */
			}
			n = n.next;
		}

		// Element not found
		return head;
	}

	public void printList() {
		Node n = this;

		while(n != null) {
			System.out.println("Data ::" + n.data);
			n = n.next;
		}
	}

	public void searchList(int d) {
		Node n = this;

		while(n != null) {
			if( n.data == d) {
				System.out.println("Data ::" + n.data);
				return;
			}
			n = n.next;
		}

		System.out.println("Data not found ");
	}


	public Node removeDuplicates() {
		Node head = this;
		Node n = this;
		Node previous = null;

		Hashtable<Integer,Boolean> table = new Hashtable<>();

		while(n != null) {
			if(table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
		return head;
	}

	public  Node runnerTechniqueRemoveDuplicates() {
		Node head = this;
		Node current = this;

		while( current != null) {
			Node runner = current;

			while(runner.next != null) {
				if( runner.next.data == current.data ) {
					runner.next = runner.next.next;
					System.out.println("Runner ::" + runner.data);
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}

		return head;
	}

	public Node reverseList() {
		Node head = this;

		//Head is null
		if( head == null) {
			return null;
		} 

		Node n1 = head;
		Node n2 = head.next;

		//Set the Head nodes next to null to avoid loops
		//n1.next = null;

		while( n2 != null) {
			Node temp = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = temp;
		}

		return n1;
	}

	public Node reverse(Node n1,Node n2) {

		if(n2 == null) return n1;

		Node temp = n2.next;
		n2.next = n1;		
		return reverse(n2,temp);
	}

	public Node reverseWrapper() {
		Node n1 = this;
		Node n2 = n1.next;
		if (n1 == null) return null;
		n1.next = null;

		return reverse(n1, n2);
	}

	public Boolean isPalindrome() {
		Node head = this;

		Stack<Integer> stack = new Stack<>();

		Node slow = head;
		Node fast = head;

		/*Push the first half into the Stack*/
		while( fast!=null && fast.next!=null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		/*If the List is odd push one more element*/
		if(fast != null) {
			slow = slow.next;
		}

		while(slow != null) {
			if(slow.data != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}

		return true;

	}

	public Boolean checkLoops() {
		Node head  = this;
		Node current = head;
		Node previous = head;

		while(current != null) {

			if(current.isVisited == true) {
				System.out.println("Loops are present :( @ Start node" + previous.data);
				return false;
			}
			current.isVisited = true;
			previous = current;
			current = current.next;
		}
		return true;
	}

	public Node foldListWrapper() {
		Node head = this;

		Node slow = head;
		Node fast = head;

		Node previous = null;

		while(fast != null && fast.next!= null) {
			previous = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		previous.next = null;
		return slow;
	}
	
	public Node foldList(Node list2) {

		Node head = this;
		Node list1 = head;
		Node temp1 = null;
		Node temp2 = null;
		
		while(list1 != null && list2 !=null) {
			temp1 = list1.next;
			temp2 = list2.next;

			list1.next = list2;
			list2.next = temp1;

			//Prep for next iter
			list1 = temp1;
			list2 = temp2;
		}

		list1 = head;

		while(list1.next !=null) {
			list1 = list1.next;
		}

		list1.next = list2;

		return head;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.appendToTail(2);
		root.appendToTail(3);
		root.appendToTail(4);
		root.appendToTail(5);
		root.appendToTail(6);
		root.appendToTail(7);

		root.printList();

		System.out.println("::::::::::::::::::");

		//root = root.removeDuplicates();

		//root.printList();

		//root = root.runnerTechniqueRemoveDuplicates();

		//root.printList();

		//root = root.reverseList();
		//root.checkLoops();
		//root.printList();	

		/*root = root.reverseWrapper();
		root.printList();

		if( root.isPalindrome() == true){
			System.out.println("It is a palindrome");
		} else {
			System.out.println("It is not a palindrome");
		} */

		Node mid = root.foldListWrapper();		
		System.out.println("Mid Element" + mid.data);

		Node revMid= mid.reverseWrapper();
		System.out.println("Rev Mid Element" + revMid.data);		

		root = root.foldList(revMid);
		root.printList();

	}	
}
