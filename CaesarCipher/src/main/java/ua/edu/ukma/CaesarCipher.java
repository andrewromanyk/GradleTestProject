package ua.edu.ukma;

public class CaesarCipher {

    public static String encrypt(String plainText, int shift) {
        plainText = plainText.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            result.append(encrypt(c, shift));
        }
        return result.toString();
    }

    public static char encrypt(char a, int shift){
        if (a == ' ') return ' ';
        int shifted = a + shift;
        if (shifted > 122) return (char) (96 + shifted % 122);
        return (char) shifted;
    }

    public static String decrypt(String plainText, int shift) {
        plainText = plainText.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            result.append(decrypt(c, shift));
        }
        return result.toString();
    }

    public static char decrypt(char a, int shift) {
        if (a == ' ') return ' ';
        int shifted = a - shift;
        if (shifted < 97) return (char) (123 - 97 % shifted);
        return (char) shifted;
    }
}
