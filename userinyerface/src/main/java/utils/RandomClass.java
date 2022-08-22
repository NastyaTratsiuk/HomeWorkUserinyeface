package utils;

import java.util.Random;

public class RandomClass {

    public static String generateString(int size) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXZ0123456789";
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(text.length());
            char randomChar = text.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public String randomEmail(int size) {
        return RandomClass.generateString(size);
    }

    public String randomPassword(int size, int sizeEmail) {
        return RandomClass.generateString(size) + randomEmail(sizeEmail);
    }

    public String randomDomain(int size) {
        return RandomClass.generateString(size);
    }

}
