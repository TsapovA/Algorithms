package alg.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 *
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 *
 *
 * Example 1:
 *
 * Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * Output: [[1,2,10],[4,5,7,8]]
 * Explanation:
 * Players 1, 2, and 10 have not lost any matches.
 * Players 4, 5, 7, and 8 each have lost one match.
 * Players 3, 6, and 9 each have lost two matches.
 * Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
 * Example 2:
 *
 * Input: matches = [[2,3],[1,3],[5,4],[6,4]]
 * Output: [[1,2,5,6],[]]
 * Explanation:
 * Players 1, 2, 5, and 6 have not lost any matches.
 * Players 3 and 4 each have lost two matches.
 * Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * All matches[i] are unique.
 */
public class FindPlayerWithZeroOrOneLosses {

    private static final byte LOSE_BYTE = (byte) (1 << 1);
    private static final byte WIN_BYTE = (byte) 1;

    public static void main(String[] args) {
        System.out.println(findWinners(new int[][]{
                {1,3}, {2,3}, {3,6}, {5,6}, {5,7}, {4,5}, {4,8}, {4,9}, {10,4}, {10,9} // [[1,2,10],[4,5,7,8]]
        }));
        System.out.println(findWinners(new int[][]{
                {2,3}, {1,3}, {5,4}, {6,4} // [[1,2,5,6],[]]
        }));
    }

    private static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> winners = new ArrayList<>(matches.length);
        List<Integer> oneTimeLosers = new ArrayList<>(matches.length);

        byte[] summary = new byte[100_001];
        for (int[] matchRes : matches) {
            int winner = matchRes[0];
            int loser = matchRes[1];

            summary[winner] |= WIN_BYTE;
            boolean hasPrevLose = (summary[loser] & LOSE_BYTE) == LOSE_BYTE;
            if (hasPrevLose) {
                summary[loser] = Byte.MAX_VALUE;
            } else {
                summary[loser] |= LOSE_BYTE;
            }
        }

        for (int i = 0; i < summary.length; ++i) {
            byte res = summary[i];
            if (res == Byte.MAX_VALUE) {
                continue;
            } else if ((byte) (res & LOSE_BYTE) == LOSE_BYTE) {
                oneTimeLosers.add(i);
            } else if ((byte) (res & WIN_BYTE) == WIN_BYTE) {
                winners.add(i);
            }
        }
        return Arrays.asList(winners, oneTimeLosers);
    }
}
