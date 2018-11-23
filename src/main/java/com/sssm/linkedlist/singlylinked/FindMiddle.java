package com.sssm.linkedlist.singlylinked;

import java.util.LinkedList;

// find the middle of a linked list
public class FindMiddle {

	public static void main(String[] args) {
		// using regular old list
		LinkedList<String> jdkLinkedList = new LinkedList<>();
		jdkLinkedList.add("a");
		jdkLinkedList.add("b");
		jdkLinkedList.add("c");
		jdkLinkedList.add("d");
		jdkLinkedList.add("e");
		int size = jdkLinkedList.size();
		System.out.println("Middle Element = " + jdkLinkedList.get(size / 2));

		// refer to MyLinkedListImplementation class
		SinglyLinkedList<String> mll = new SinglyLinkedList<>();
		mll.addNodeAtTheEnd("1");
		mll.addNodeAtTheEnd("2");
		mll.addNodeAtTheEnd("3");
		mll.addNodeAtTheEnd("4");

		// should print 3
		System.out.println("Middle Element = " + mll.findMiddle());

		mll.addNodeAtTheEnd("5");

		// should print 3
		System.out.println("Middle Element = " + mll.findMiddle());

		mll.addNodeAtTheEnd("6");

		// should print 4
		System.out.println("Middle Element = " + mll.findMiddle());
	}

}