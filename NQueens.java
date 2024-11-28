public class NQueens {
    void solve(int n) {
        int[] board = new int[n];
        placeQueens(board, 0, n);
    }

    boolean placeQueens(int[] board, int row, int n) {
        if (row == n) {
            printBoard(board, n);
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                if (placeQueens(board, row + 1, n)) return true;
                board[row] = -1; // Backtrack
            }
        }
        return false;
    }

    boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) 
            if (board[i] == col || Math.abs(board[i] - col) == row - i) return false;
        return true;
    }

    void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(board[i] == j ? "Q " : ". ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new NQueens().solve(8); // Change 8 to any N for N-Queens
    }
}
