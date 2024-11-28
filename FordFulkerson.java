

public class FordFulkerson {
    boolean dfs(int[][] residual, int[] parent, int src, int sink, boolean[] visited) {
        visited[src] = true;
        if (src == sink) return true;
        for (int v = 0; v < residual.length; v++) {
            if (!visited[v] && residual[src][v] > 0) {
                parent[v] = src;
                if (dfs(residual, parent, v, sink, visited)) return true;
            }
        }
        return false;
    }

    int maxFlow(int[][] graph, int src, int sink) {
        int n = graph.length, maxFlow = 0;
        int[][] residual = new int[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(graph[i], 0, residual[i], 0, n);

        int[] parent = new int[n];
        while (dfs(residual, parent, src, sink, new boolean[n])) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != src; v = parent[v])
                pathFlow = Math.min(pathFlow, residual[parent[v]][v]);
            for (int v = sink; v != src; v = parent[v]) {
                residual[parent[v]][v] -= pathFlow;
                residual[v][parent[v]] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        System.out.println("Maximum Flow: " + new FordFulkerson().maxFlow(graph, 0, 5));
    }
}
