package com.sssm.strings;

public class Palindrome {

	public static void main(String[] args) {
		String input = "abcde";
		printStatus(input, isPalindrome(input));

		input = "abcba";
		printStatus(input, isPalindrome(input));
	}

	private static boolean isPalindrome(String inputString) {
		String s = "";
		char[] charArray = inputString.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			s = s + charArray[i];
		}
		return s.equalsIgnoreCase(inputString);
	}

	private static void printStatus(String input, boolean isPalindrome) {
		if (isPalindrome) {
			System.out.println(input + " is a Palindrome");
		} else {
			System.out.println(input + " is not a Palindrome");
		}
	}

}
