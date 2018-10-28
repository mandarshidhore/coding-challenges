package com.sssm.linkedlist;

public class MyLinkedListImplementation {

	public static void main(String[] args) {
		MyLinkedList<String> mll = new MyLinkedList<>();
		mll.addItem("A");
		mll.addItem("B");
		mll.addItem("C");
		mll.addItem("D");

		// should print A, B, C, D
		mll.print();
	}

}

class MyLinkedList<X> {

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

	public MyLinkedList() {
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
			System.out.println("List is empty...");
			return;
		}

		Node temp = head;

		if (position == 0) {
			head = temp.getNext();
		}

		for (int i = 0; i < position; i++) {

		}

	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.println("item -> " + node.getData());
			node = node.getNext();
		}
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
