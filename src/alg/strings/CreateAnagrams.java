package alg.strings;

import java.util.HashSet;
import java.util.Set;

public class CreateAnagrams {

    public static void main(String[] args) {
        Set<String> set = doAnagrams("1234");
        System.out.println(set);
        System.out.println(set.size());
    }

    private static Set<String> doAnagrams(String word) {
        Set<String> anagrams = new HashSet<>();
        anagrams.add(word);
        perform(word.toCharArray(), 0, anagrams);
        return anagrams;
    }

    private static void perform(char[] chars, int idx, Set<String> anagrams) {
        for (int i = idx; i < chars.length; ++i) {
            perform(chars, idx + 1, anagrams);
            rotate(chars, idx);
            anagrams.add(String.valueOf(chars));
        }
    }

    private static void rotate(char[] chars, int idx) {
        char temp = chars[idx];
        for (int i = idx; i < chars.length - 1; ++i) {
            chars[i] = chars[i + 1];
        }
        chars[chars.length - 1] = temp;
    }
}
