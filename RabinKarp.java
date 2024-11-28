public class RabinKarp {
    static final int d = 256, q = 101; // d: character set size, q: prime number for modulo

    static void search(String text, String pattern) {
        int m = pattern.length(), n = text.length();
        int pHash = 0, tHash = 0, h = 1;

        for (int i = 0; i < m - 1; i++) h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (pHash == tHash && text.substring(i, i + m).equals(pattern)) 
                System.out.println("Pattern found at index " + i);

            if (i < n - m)
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
            if (tHash < 0) tHash += q;
        }
    }

    public static void main(String[] args) {
        String text = "ABCCDABCDABCD", pattern = "ABCD";
        search(text, pattern);
    }
}
