package alg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringPermutations {

    private static final int ENG_LETTERS_NUMBER = 28;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a first string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        System.out.println("Enter a second string: ");
        String str2 = br.readLine();
        System.out.println("Both string contains the same letters: " + isPermutations(str1, str2));
    }

    private static boolean isPermutations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        byte[] symbols1 = getMassOfLettersCount(str1);
        byte[] symbols2 = getMassOfLettersCount(str2);
        return Arrays.equals(symbols1, symbols2);
    }

    private static byte[] getMassOfLettersCount(String str) {
        byte[] res = new byte[ENG_LETTERS_NUMBER];
        for (int i = 0; i < str.length(); ++i) {
           char ch = str.charAt(i);
            checkCharIsLetter(ch);
            ++res[ch - 'a'];
        }
        return res;
    }

    private static void checkCharIsLetter(char ch) {
        if (ch < 'a' || ch > 'z') {
            throw new IllegalArgumentException("String must not contains non letter chars: " + ch);
        }
    }
}
