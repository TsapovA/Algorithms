package alg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymbolsOnlyOnce {

    private static final int ENG_LETTERS_NUMBER = 28;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println("String contains dublicate letters: " + isContainsRepeatedLetters(str));
    }

    private static boolean isContainsRepeatedLetters(String str) {
        boolean[] flags = new boolean[ENG_LETTERS_NUMBER];
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            checkCharIsLetter(ch);
            if (flags[ch - 'a']) {
                return true;
            }
            flags[ch - 'a']= true;
        }
        return false;
    }

    private static void checkCharIsLetter(char ch) {
        if (ch < 'a' || ch > 'z') {
            throw new IllegalArgumentException("String must not contains non letter chars: " + ch);
        }
    }
}
