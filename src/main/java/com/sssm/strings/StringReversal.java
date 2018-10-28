package com.sssm.strings;

public class StringReversal {

	public static void main(String[] args) {
		String input = "abcde";

		// reverse using char array approach
		char[] charArray = input.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			System.out.print(charArray[i]);
		}
		System.out.println();

		// reverse using StringBuilder
		StringBuilder builder = new StringBuilder(input);
		System.out.println(builder.reverse());
	}

}
