package com.zhenhua.homelake.randomgenerator;

import java.security.SecureRandom;
import java.util.Random;

public class StringGenerator {
	private static final String[] who = "Judy, Nicole, Lunar".split(", ");

	private static final String[] like = "Like".split(", ");

	private static final String[] what = "Cat, Dog, Penguin, Zebra, Tiger, Giraffe, Crocodile, Alligator".split(", ");

	private final Random random;

	public StringGenerator() {
		random = new SecureRandom();
	}

	public String generate() {
		return new StringBuilder().append(select(who)).append(select(like)).append(select(what)).toString();
	}

	private String select(String[] dictionary) {
		return dictionary[random.nextInt(dictionary.length)];
	}
}
