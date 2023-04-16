package alg.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two
 * different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one
 * direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of
 * edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 *
 * Example 2:
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 *
 * Example 3:
 *
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     2 <= n <= 5 * 10^4
 *     connections.length == n - 1
 *     connections[i].length == 2
 *     0 <= ai, bi <= n - 1
 *     ai != bi
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public static void main(String[] args) {
        System.out.println(minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}})); // 3
        System.out.println(minReorder(5, new int[][]{{1,0},{1,2},{3,2},{3,4}})); // 2
        System.out.println(minReorder(3, new int[][]{{1,0},{2,0}})); // 0
    }

    private static int minReorder(int n, int[][] connections) {
        List<Integer>[] adj = new List[n];
        for (int i = 0;i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            adj[from].add(to);
            adj[to].add(-from);
        }

        return dfs(adj, new boolean[n], 0);
    }

    private static int dfs(List<Integer>[] adj, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int value: adj[from]) {
            if (visited[Math.abs(value)]) {
                continue;
            }
            change += dfs(adj, visited, Math.abs(value)) + (value > 0 ? 1 : 0);
        }
        return change;
    }
}
