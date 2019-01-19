package alg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MixedPalindrom {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Palindrom: " + isPalindrom(br.readLine()));
    }

    private static boolean isPalindrom(String str) {
        Map<Character, Integer> map = new HashMap<>();
        BiFunction<Integer, Integer, Integer> mergeFun = (oldVal, curVal) -> oldVal + curVal;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if (isLetter(ch)){

                map.merge(ch, 1, mergeFun);
            } else {
                map.merge(' ', 1,  mergeFun);
            }
        }

        boolean flagOneOddCounterPossible = str.length() % 2 == 0 ? false : true;
        for (Integer counter: map.values()) {
            if (counter % 2 == 1) {
                if (flagOneOddCounterPossible) {
                    flagOneOddCounterPossible = false;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }
}
