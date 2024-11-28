public class FiniteAutomata {
    static void search(String text, String pattern) {
        int m = pattern.length(), n = text.length();
        int[][] automata = new int[m][256]; // 256 for all ASCII characters
        
        buildAutomata(pattern, automata);

        int state = 0;
        for (int i = 0; i < n; i++) {
            state = automata[state][text.charAt(i)];
            if (state == m) {
                System.out.println("Pattern found at index " + (i - m + 1));
            }
        }
    }

    static void buildAutomata(String pattern, int[][] automata) {
        int m = pattern.length();
        for (int state = 0; state <= m; state++) {
            for (int c = 0; c < 256; c++) {
                if (state < m && c == pattern.charAt(state)) 
                    automata[state][c] = state + 1;
                else if (state > 0) 
                    automata[state][c] = automata[automata[state - 1][c]][c];
                else 
                    automata[state][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB", pattern = "ABABCABAB";
        search(text, pattern);
    }
}
