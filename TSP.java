import java.util.*;

public class TSP {
    private static final int INF = Integer.MAX_VALUE;

    int tsp(int[][] graph, int pos, int visited, int[][] dp) {
        if (visited == (1 << graph.length) - 1) return graph[pos][0] == 0 ? INF : graph[pos][0];
        if (dp[pos][visited] != -1) return dp[pos][visited];

        int cost = INF;
        for (int city = 0; city < graph.length; city++) {
            if ((visited & (1 << city)) == 0 && graph[pos][city] != 0)
                cost = Math.min(cost, graph[pos][city] + tsp(graph, city, visited | (1 << city), dp));
        }
        return dp[pos][visited] = cost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) Arrays.fill(row, -1);

        TSP solver = new TSP();
        System.out.println("Minimum cost: " + solver.tsp(graph, 0, 1, dp));
    }
}
