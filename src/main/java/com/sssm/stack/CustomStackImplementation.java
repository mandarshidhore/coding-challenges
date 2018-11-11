package com.sssm.stack;

public class CustomStackImplementation {

	public static void main(String[] args) {
		Stack<Card> cardsStack = new Stack<>();
		Card card1 = new Card("Ace", "Spades");
		Card card2 = new Card("Jack", "Clubs");
		Card card3 = new Card("King", "Diamonds");
		Card card4 = new Card("Queen", "Hearts");

		try {
			cardsStack.pop();
		} catch (IllegalStateException e) {
			// should print "There are no items on the stack"
			System.out.println(e.getMessage());
		}

		cardsStack.push(card1);
		cardsStack.push(card2);
		cardsStack.push(card3);
		cardsStack.push(card4);

		// should print 4
		System.out.println(cardsStack.size());

		Card card = cardsStack.pop();

		// should print Queen of Hearts
		System.out.println(card.getRank() + " of " + card.getSuit());

		// should print 3
		System.out.println(cardsStack.size());
	}

}

class Stack<X> {
	private X[] elements;
	private int stackPointer;

	public Stack() {
		elements = (X[]) new Object[100];
		stackPointer = 0;
	}

	public void push(X element) {
		elements[stackPointer++] = element;
	}

	public X pop() {
		if (stackPointer == 0) {
			throw new IllegalStateException("There are no items on the stack");
			// we could also return null
		}
		return elements[--stackPointer];
	}

	public int size() {
		return stackPointer;
	}

	public X access(X element) {
		while (stackPointer > 0) {
			X item = pop();
			if (item.equals(element)) {
				return item;
			}
		}
		throw new IllegalStateException("Could not find item on the stack");
		// we could also return null
	}

	public boolean contains(X element) {
		for (X x : elements) {
			if (x.equals(element)) {
				return true;
			}
		}
		return false;
	}
}

class Card {
	private String rank;
	private String suit;

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}
}
