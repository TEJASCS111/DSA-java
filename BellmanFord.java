import java.util.Arrays;

public class BellmanFord {
    void bellmanFord(int[][] edges, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges)
                if (dist[edge[0]] != Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]])
                    dist[edge[1]] = dist[edge[0]] + edge[2];
        }

        for (int[] edge : edges)
            if (dist[edge[0]] != Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                System.out.println("Negative weight cycle detected");
                return;
            }

        System.out.println("Shortest distances: " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int[][] edges = { {0, 1, 4}, {0, 2, 5}, {1, 2, -3}, {2, 3, 2}, {3, 1, 1} };
        new BellmanFord().bellmanFord(edges, 4, 0);
    }
}
