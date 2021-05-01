package alg.other;

import java.util.LinkedList;
import java.util.Objects;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 30
 *
 * The following are the terms from n=1 to n=10 of the count-and-say sequence:
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *  6.     312211
 *  7.     13112221
 *  8.     1113213211
 *  9.     31131211131221
 * 10.     13211311123113112211
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    private static String countAndSay(int n) {
        LinkedList<Integer> seq = new LinkedList<>();
        seq.add(1);
        LinkedList<Integer> result = nextSequence(seq, n - 1);
        StringBuilder sb = new StringBuilder();
        for(Integer val: result) {
            sb.append(val);
        }
        return sb.toString();
    }

    private static LinkedList<Integer> nextSequence(LinkedList<Integer> linkedList, int n) {
        if (n == 0) return linkedList;

        LinkedList<Integer> currentSeq = new LinkedList<>();
        int counter = 0;
        Integer curVal = null;
        for (Integer val: linkedList) {
            if (curVal == null) {
                curVal = val;
                ++counter;
            } else if (val.equals(curVal)) {
                ++counter;
            }
            else {
                currentSeq.add(counter);
                currentSeq.add(curVal);
                curVal = val;
                counter = 1;
            }
        }
        currentSeq.add(counter);
        currentSeq.add(curVal);
        // do (n - 1) steps
        return nextSequence(currentSeq, n - 1);
    }
}
