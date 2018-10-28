package com.sssm.strings;

public class RemovePunctuations {

	public static void main(String[] args) {
		String str = "Welcome ???@@##$ to#$% Geeks%$^for$%^&Geeks";

		// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
		str = str.replaceAll("\\p{Punct}", "");

		System.out.println(str);
	}

}
