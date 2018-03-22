package com.zhenhua.homelake.randomgenerator;

public class GeneratorTest {

	public static void main(String[] args) {
		String name = getRandomName('-');
		System.out.println(name);
		
		for(int i=0;i<100;i++) {
			String name2 = getRandomName();
			System.out.println(name2);	
		}
	}
	
	public static String  getRandomName(char separator) {
		return new ThreePhraseGenerator().generate(separator);
	}
	public static String  getRandomName() {
		return new StringGenerator().generate();
	}

}
