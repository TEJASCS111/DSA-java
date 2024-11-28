public class BipartiteMatching {
    static boolean bpm(int[][] graph, int u, boolean[] seen, int[] matchR) {
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] == 1 && !seen[v]) {
                seen[v] = true;
                if (matchR[v] == -1 || bpm(graph, matchR[v], seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    static int maxBPM(int[][] graph) {
        int[] matchR = new int[graph[0].length];
        java.util.Arrays.fill(matchR, -1);
        int result = 0;
        for (int u = 0; u < graph.length; u++) {
            boolean[] seen = new boolean[graph[0].length];
            if (bpm(graph, u, seen, matchR)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 0, 1, 0}, 
            {0, 1, 0, 1}, 
            {1, 0, 1, 0}, 
            {0, 0, 0, 1}
        };
        System.out.println("Maximum Bipartite Matching: " + maxBPM(graph));
    }
}
