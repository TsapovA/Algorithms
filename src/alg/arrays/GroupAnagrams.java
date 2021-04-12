package alg.arrays;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})); // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[]{""})); // [[""]]
        System.out.println(groupAnagrams(new String[]{"a"})); // [[a]]
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] charCounter = new int[26];
            for (char ch: str.toCharArray()) {
                charCounter[ch - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < 26; ++i) {
                stringBuilder.append('_').append(charCounter[i]);
            }

            if (!map.containsKey(stringBuilder.toString())) {
                map.put(stringBuilder.toString(), new ArrayList<String>());
            }

            map.get(stringBuilder.toString()).add(str);
        }

        // additional sorting. Not needed at the original task
        for (List<String> list: map.values()) {
            Collections.sort(list);
        }

        return new ArrayList<>(map.values());
    }
}
