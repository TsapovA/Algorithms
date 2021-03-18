package alg.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        for (int i = 1; i < 2; ++i) {
            System.out.println(generateParenthesisVar1(i));
            System.out.println(generateParenthesisVar2(i));
            System.out.println();
        }
    }

    private static List<String> generateParenthesisVar1(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    //----------------------------------------------------------------

    private static List<String> generateParenthesisVar2(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesisVar2(c))
                    for (String right: generateParenthesisVar2(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
