import java.util.*;

public class VertexCover {
    static void vertexCover(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<int[]> edgeList = new ArrayList<>();
        for (int[] edge : edges) edgeList.add(edge);
        
        List<Integer> cover = new ArrayList<>();
        
        for (int[] edge : edgeList) {
            if (!visited[edge[0]] && !visited[edge[1]]) {
                visited[edge[0]] = visited[edge[1]] = true;
                cover.add(edge[0]);
                cover.add(edge[1]);
            }
        }

        System.out.println("Vertex Cover: " + cover);
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        int[][] edges = { {0, 1}, {0, 2}, {1, 3}, {3, 4} };
        vertexCover(n, edges);
    }
}
