package com.sssm.linkedlist.singlylinked;

public class CustomLinkedListImplementation {

	public static void main(String[] args) {
		SinglyLinkedList<String> sll = new SinglyLinkedList<>();

		sll.remove(0);

		sll.addItem("A");
		System.out.print("After adding A, ");
		sll.print(); // should print A

		sll.remove(0);
		System.out.print("After removing A, ");
		sll.print(); // empty

		sll.addItem("A");
		sll.addItem("B");
		sll.addItem("C");
		sll.addItem("D");
		System.out.print("After adding A B C D, ");
		sll.print(); // should print A, B, C, D

		sll.remove(0);
		System.out.print("After removing A, ");
		sll.print(); // should print B, C, D

		sll.addItem("A");
		System.out.print("After adding A, ");
		sll.print(); // should print B, C, D, A

		sll.remove(1);
		System.out.print("After removing C, ");
		sll.print(); // should print B, D, A

		sll.addItem("C");
		System.out.print("After adding C, ");
		sll.print(); // should print B, D, A, C

		sll.remove(2);
		System.out.print("After removing A, ");
		sll.print(); // should print B, D, C

		sll.addItem("A");
		System.out.print("After adding A, ");
		sll.print(); // should print B, D, C, A

		sll.remove(3);
		System.out.print("After removing A, ");
		sll.print(); // should print B, D, C

		sll.addItem("E");
		sll.addItem("A");
		sll.addItem("F");
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

	public void addItem(X data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			Node newNode = new Node(data);
			tail.setNext(newNode);
			tail = newNode;
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

	public void print() {
		System.out.println("Linked List contains - ");
		Node node = head;
		while (node != null) {
			System.out.println("item -> " + node.getData());
			node = node.getNext();
		}
		System.out.println();
	}

	public X findMiddle() {
		Node p = head;
		Node q = head;

		while (q != null && q.getNext() != null) {
			p = p.getNext();
			q = q.getNext().getNext();
		}

		return p.getData();
	}

}
