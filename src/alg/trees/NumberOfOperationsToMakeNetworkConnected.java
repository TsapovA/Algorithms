package alg.trees;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
 * connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other
 * computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected
 * computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 *
 * Example 2:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 105
 *     1 <= connections.length <= min(n * (n - 1) / 2, 105)
 *     connections[i].length == 2
 *     0 <= ai, bi < n
 *     ai != bi
 *     There are no repeated connections.
 *     No two computers are connected by more than one cable.
 *
 * Solution logic:
 *
 *     Use Union-find algorithm.
 *     If the number of connections is less than n-1, it is not possible to connect all the computers, so return -1.
 *     Initialize the parent array for the Union-Find algorithm, where parent[i] is the parent of computer i.
 *     Union the connected computers by iterating over the connections array and finding their parent using the find
 *     operation in the Union-Find algorithm. Count the number of disjoint sets (connected components) by iterating
 *     over the parent array and counting the number of nodes where parent[i] is equal to i.
 *     The number of cables needed to connect all the computers is equal to the number of disjoint sets minus 1.
 */
public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        System.out.println(makeConnected(4, new int[][]{{0,1}, {0,2}, {1,2}})); // 1
        System.out.println(makeConnected(6, new int[][]{{0,1}, {0,2}, {0,3}, {1,2}, {1,3}})); // 2
        System.out.println(makeConnected(6, new int[][]{{0,1}, {0,2}, {0,3}, {1,2}})); // -1
    }

    private static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int[] parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }

        for (int[] pair: connections) {
            int parent1 = findParent(pair[0], parents);
            int parent2 = findParent(pair[1], parents);
            if (parent1 != parent2) {
                parents[parent1] = parent2;
            }
        }

        int numberOfDisjointSets = 0;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == i) {
                ++numberOfDisjointSets;
            }
        }

        return numberOfDisjointSets - 1;
    }

    private static int findParent(int node, int[] parents) {
        if (parents[node] != node) {
            parents[node] = findParent(parents[node], parents);
        }

        return parents[node];
    }
}
