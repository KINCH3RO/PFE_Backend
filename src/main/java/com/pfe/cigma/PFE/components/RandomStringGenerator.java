package com.pfe.cigma.PFE.components;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import org.springframework.stereotype.Component;


public class RandomStringGenerator {
	// create a string of all characters

	public static String generateString() {

		int length = 7;

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}
	// specify length of random string

}
