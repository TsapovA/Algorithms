package alg.other;

import java.util.Arrays;

/**
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 * Example 1:
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 *
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 *
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 *
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 *
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 *
 *
 * Note:
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        System.out.println(equationsPossible(new String[]{"a==b", "b!=a"})); // false
        System.out.println(equationsPossible(new String[]{"b==a", "a==b"})); // true
        System.out.println(equationsPossible(new String[]{"a==b","b==c","a==c"})); // true
        System.out.println(equationsPossible(new String[]{"a==b", "b!=c", "c==a"})); // false
        System.out.println(equationsPossible(new String[]{"c==c", "b==d", "x!=z"})); // true
        System.out.println(equationsPossible(new String[]{"a==b", "b==c", "c==a", "c==a"})); // true
    }

    private static boolean equationsPossible(String[] equations) {
        if (equations == null) return true;

        int[] parents = new int[26];
        for (int i = 0; i < parents.length; ++i) parents[i] = i;

        for (String equation: equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                parents[findParent(parents, a)] = findParent(parents, b);
            }
        }

        for (String equation: equations) {
            if (equation.charAt(1) == '!') {
                int a = findParent(parents, equation.charAt(0) - 'a');
                int b = findParent(parents, equation.charAt(3) - 'a');
                if (a == b) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int findParent(int[] parents, int num) {
        while(num != parents[num]) {
            num = findParent(parents, parents[num]);
        }
        return num;
    }
}
