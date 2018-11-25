package com.sssm.linkedlist.singlylinked;

import com.sssm.linkedlist.singlylinked.SinglyLinkedList.Node;

public class CustomLinkedListImplementation {

	public static void main(String[] args) {
		SinglyLinkedList<String> sll = new SinglyLinkedList<>();

		sll.remove(0);

		sll.addNodeAtTheEnd("A");
		System.out.print("After adding A, ");
		sll.print(); // should print A

		sll.remove(0);
		System.out.print("After removing A, ");
		sll.print(); // empty

		sll.addNodeAtTheEnd("A");
		sll.addNodeAtTheEnd("B");
		sll.addNodeAtTheEnd("C");
		sll.addNodeAtTheEnd("D");
		System.out.print("After adding A B C D, ");
		sll.print(); // should print A, B, C, D

		sll.remove(0);
		System.out.print("After removing A, ");
		sll.print(); // should print B, C, D

		sll.addNodeAtTheEnd("A");
		System.out.print("After adding A, ");
		sll.print(); // should print B, C, D, A

		sll.remove(1);
		System.out.print("After removing C, ");
		sll.print(); // should print B, D, A

		sll.addNodeAtTheEnd("C");
		System.out.print("After adding C, ");
		sll.print(); // should print B, D, A, C

		sll.remove(2);
		System.out.print("After removing A, ");
		sll.print(); // should print B, D, C

		sll.addNodeAtTheEnd("A");
		System.out.print("After adding A, ");
		sll.print(); // should print B, D, C, A

		sll.remove(3);
		System.out.print("After removing A, ");
		sll.print(); // should print B, D, C

		sll.addNodeAtTheEnd("E");
		sll.addNodeAtTheEnd("A");
		sll.addNodeAtTheEnd("F");
		System.out.print("After adding E A F, ");
		sll.print(); // should print B, D, C, E, A, F

		sll.remove(3);
		System.out.print("After removing E, ");
		sll.print(); // should print B, D, C, A, F

		sll.remove(3);
		System.out.print("After removing E, ");
		sll.print(); // should print B, D, C, F

		sll.remove(2);
		System.out.print("After removing C, ");
		sll.print(); // should print B, D, F

		sll.remove(0);
		System.out.print("After removing B, ");
		sll.print(); // should print D, F

		sll.remove(1);
		System.out.print("After removing F, ");
		sll.print(); // should print D
		
		sll.addNodeAsNewHead("5");
		sll.addNodeAsNewHead("4");
		sll.addNodeAsNewHead("3");
		sll.addNodeAsNewHead("2");
		sll.addNodeAsNewHead("1");
		sll.print(); // should print 1, 2, 3, 4, 5, D
		
		sll.deleteAllNodes();
		System.out.print("After deleting all nodes, ");
		sll.print(); // should print Linked List contains - no elements 
		
		Node current = sll.addNodeAsNewHead("5");
		System.out.print("After adding a new head as 5, ");
		sll.print(); // should print 5
		
		sll.addNodeAfterAGivenNode(current, "6");
		System.out.print("After adding a node after 5, ");
		sll.print(); // should print 5, 6
		
		sll.addNodeAfterAGivenNode(current, "7");
		System.out.print("After adding a node after 5, ");
		sll.print(); // should print 5, 7, 6
		
		current = sll.addNodeAsNewHead("8");
		System.out.print("After adding a new head as 8, ");
		sll.print(); // should print 8, 5, 7, 6
		
		sll.addNodeAfterAGivenNode(current, "9");
		System.out.print("After adding a node after 8, ");
		sll.print(); // should print 8, 9, 5, 7, 6
	}

}

class SinglyLinkedList<X> {

	class Node {
		private Node next;
		private X data;

		Node(X data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public X getData() {
			return data;
		}

		public void setData(X data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	// adds a node at the end
	public void addNodeAtTheEnd(X data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			Node newNode = new Node(data);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	// adds a node at the front and make it a head
	public Node addNodeAsNewHead(X data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
			return head;
		} else {
			Node temp = head;
			Node newNode = new Node(data);
			newNode.setNext(temp);
			head = newNode;
			return head;
		}
	}
	
	// adds a node after a given node
	public Node addNodeAfterAGivenNode(Node prev, X data) {
		if (prev == null) {
			// can either return or create a new node and make it as head
			return null;
		} else {
			Node newNode = new Node(data);
			Node currentNextNode = prev.getNext();
			if (currentNextNode == null) {
				prev.setNext(newNode);
				tail = newNode;
			} else {
				newNode.setNext(currentNextNode);
				prev.setNext(newNode);
			}
			return newNode;
		}
	}

	public void remove(int position) {
		if (head == null) {
			System.out.println("List is empty...\n");
			return;
		}

		Node temp = head;

		if (position == 0) {
			head = temp.getNext();
			return;
		}

		Node prev = head;
		Node next = head.getNext();
		for (int i = 1; next != null; i++) {
			Node furtherNode = next.getNext();
			if (position == i) {
				prev.setNext(furtherNode);
				next = furtherNode;
				if (furtherNode == null) {
					tail = prev;
				}
				return;
			} else {
				prev = next;
				next = furtherNode;
			}
		}
	}
	
	public void deleteAllNodes() {
		head = null;
		tail = null;
	}

	public void print() {
		System.out.println("Linked List contains - ");
		Node node = head;
		if (node == null) {
			System.out.println("no elements");
		}
		while (node != null) {
			System.out.println("item -> " + node.getData());
			node = node.getNext();
		}
		System.out.println();
	}

	public X findMiddle() {
		Node slowMover = head;
		Node fastMover = head;

		while (fastMover != null && fastMover.getNext() != null) {
			slowMover = slowMover.getNext();
			fastMover = fastMover.getNext().getNext();
		}

		return slowMover.getData();
	}

}
