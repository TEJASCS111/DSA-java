public class KMP {
    static void search(String text, String pattern) {
        int[] lps = new int[pattern.length()];
        computeLPSArray(pattern, lps);

        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++; j++;
            }
            if (j == pattern.length()) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    static void computeLPSArray(String pattern, int[] lps) {
        int length = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) length = lps[length - 1];
                else { lps[i] = 0; i++; }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB", pattern = "ABABCABAB";
        search(text, pattern);
    }
}
