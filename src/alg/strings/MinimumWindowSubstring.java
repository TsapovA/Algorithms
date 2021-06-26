package alg.strings;

import java.util.*;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow2("aa", "aa")); // aa
        System.out.println(minWindow2("bba", "ab")); // ba
        System.out.println(minWindow2("ab", "b")); // b
        System.out.println(minWindow2("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow2("a", "a")); //a
        System.out.println(minWindow2("a", "aa")); // nothing = emptyString
    }

    private static String minWindow(String s, String t) {
        Map<Character, Integer> templateCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer count = templateCount.getOrDefault(ch, 0);
            templateCount.put(ch, count + 1);
            windowCount.putIfAbsent(ch, 0);
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int numberOfEqualChars = 0;
        // + '1' to check the case when the s doesn't include t letters
        String res = s + '1';
        char[] sChars = s.toCharArray();
        while (rightIdx < sChars.length) {
            if (windowCount.containsKey(sChars[rightIdx])) {
                windowCount.put(sChars[rightIdx], windowCount.get(sChars[rightIdx]) + 1);
                if (windowCount.get(sChars[rightIdx]) <= templateCount.get(sChars[rightIdx])) {
                    ++numberOfEqualChars;
                }

                if (numberOfEqualChars == t.length()) {
                    // try to minimize an overall length by increasing the leftIdx
                    while (leftIdx < rightIdx) {
                        if (windowCount.containsKey(sChars[leftIdx])) {
                            int windowCharCounter = windowCount.get(sChars[leftIdx]);
                            if (windowCharCounter == templateCount.get(sChars[leftIdx])) {
                                break;
                            }
                            windowCount.put(sChars[leftIdx], windowCharCounter - 1);
                        }
                        ++leftIdx;
                    }
                    res = res.length() < rightIdx - leftIdx + 1 ?
                            res :
                            s.substring(leftIdx, rightIdx + 1);
                }
            }
            ++rightIdx;
        }
        return res.length() > s.length() ? "" : res;
    }

    // with small optimization
    private static String minWindow2(String s, String t) {
        Map<Character, Integer> templateCounter = new HashMap<>(t.length());
        Map<Character, Integer> windowCounter = new HashMap<>();
        for (char ch: t.toCharArray()) {
            int chCounter = templateCounter.getOrDefault(ch, 0);
            templateCounter.put(ch, chCounter + 1);
            windowCounter.putIfAbsent(ch, 0);
        }

        List<Map.Entry<Integer, Character>> sIdxToChar = new ArrayList<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (templateCounter.containsKey(sChars[i])) {
                sIdxToChar.add(new AbstractMap.SimpleEntry<>(i, sChars[i]));
            }
        }
        if (sIdxToChar.isEmpty()) return "";

        int leftPos = 0;
        int rightPos = 0;
        int equalCounter = 0;
        String res = s + "1";

        while (leftPos <= rightPos && rightPos < sIdxToChar.size()) {
            char ch = sIdxToChar.get(rightPos).getValue();
            windowCounter.put(ch, windowCounter.get(ch) + 1);
            if (windowCounter.get(ch) <= (templateCounter.get(ch))) {
                ++equalCounter;

                if (equalCounter == t.length()) {
                    // try to minimize the left edge
                    while (leftPos <= rightPos) {
                        char leftPosChar = sIdxToChar.get(leftPos).getValue();
                        if (windowCounter.get(leftPosChar).equals(templateCounter.get(leftPosChar))) break;
                        windowCounter.put(leftPosChar, windowCounter.get(leftPosChar) - 1);
                        ++leftPos;
                    }
                    String checkedStr = s.substring(sIdxToChar.get(leftPos).getKey(), sIdxToChar.get(rightPos).getKey() + 1);
                    res = res.length() < checkedStr.length() ?
                            res :
                            checkedStr;

                    // move leftPos at one step right to decrease equal counter and continue the whole process
                    Map.Entry<Integer, Character> leftPosEntry = sIdxToChar.get(leftPos);
                    windowCounter.put(leftPosEntry.getValue(), windowCounter.get(leftPosEntry.getValue()) - 1);
                    --equalCounter;
                    ++leftPos;
                }
            }
            ++rightPos;
        }
        return res.length() > s.length() ? "" : res;
    }
}
