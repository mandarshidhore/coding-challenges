package com.sssm.strings;

public class Palindrome {

	public static void main(String[] args) {
		String input = "abcde";
		String reversed = reverseString(input);
		print(input, reversed);

		input = "abcba";
		reversed = reverseString(input);
		print(input, reversed);
	}

	private static String reverseString(String inputString) {
		String s = "";
		char[] charArray = inputString.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			s = s + charArray[i];
		}
		return s;
	}

	private static void print(String a, String b) {
		if (a.equals(b)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
	}

}
