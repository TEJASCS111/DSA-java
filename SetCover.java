import java.util.*;

public class SetCover {
    static void setCover(int[][] sets, int n) {
        boolean[] covered = new boolean[n];
        List<Integer> cover = new ArrayList<>();

        while (true) {
            int maxSet = -1, maxCount = 0;
            for (int i = 0; i < sets.length; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (sets[i][j] == 1 && !covered[j]) count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxSet = i;
                }
            }
            if (maxSet == -1) break;

            cover.add(maxSet);
            for (int j = 0; j < n; j++) {
                if (sets[maxSet][j] == 1) covered[j] = true;
            }
        }

        System.out.println("Set Cover: " + cover);
    }

    public static void main(String[] args) {
        int[][] sets = { 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 0, 0}, 
            {1, 0, 1, 1, 0}, 
            {0, 0, 0, 1, 1} 
        };
        int n = 5; // Number of elements to cover
        setCover(sets, n);
    }
}
