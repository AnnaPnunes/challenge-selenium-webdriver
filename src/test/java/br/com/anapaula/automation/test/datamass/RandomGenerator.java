package br.com.anapaula.automation.test.datamass;

import java.util.Random;

public class RandomGenerator {
    public static String generateRandomString(int min, int max) {
        String signsSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprqstuvwxyz";
        char[] chars = signsSet.toCharArray();
        StringBuilder randString = new StringBuilder();
        Random rand = new Random();
        int length = rand.nextInt((max - min) + 1) + min;
        while (length > 0) {
            randString.append(chars[rand.nextInt(chars.length)]);
            length--;
        }
        return randString.toString();
    }

    public static String generateRandomStringWithoutNumbers(int min, int max) {
        String signsSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprqstuvwxyz";
        char[] chars = signsSet.toCharArray();
        StringBuilder randString = new StringBuilder();
        Random rand = new Random();
        int length = rand.nextInt((max - min) + 1) + min;
        while (length > 0) {
            randString.append(chars[rand.nextInt(chars.length)]);
            length--;
        }
        return randString.toString();
    }
}
