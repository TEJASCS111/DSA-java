import java.util.*;

public class ShortestPathDAG {
    static void shortestPath(int n, int[][] edges, int src) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) graph[edge[0]].add(new int[]{edge[1], edge[2]});

        int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Stack<Integer> topo = topologicalSort(graph, n);
        while (!topo.isEmpty()) {
            int u = topo.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] v : graph[u]) 
                    dist[v[0]] = Math.min(dist[v[0]], dist[u] + v[1]);
            }
        }
        System.out.println("Shortest distances: " + Arrays.toString(dist));
    }

    static Stack<Integer> topologicalSort(List<int[]>[] graph, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) if (!visited[i]) dfs(i, graph, visited, stack);
        return stack;
    }

    static void dfs(int u, List<int[]>[] graph, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int[] v : graph[u]) if (!visited[v[0]]) dfs(v[0], graph, visited, stack);
        stack.push(u);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { {0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {4, 2, 2}, {4, 5, 4}, {2, 3, 6}, {5, 3, 1} };
        shortestPath(n, edges, 0);
    }
}
