/**
 * Problem 8.12 Eight Queens
 *
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none
 * of them share the same row, column or diagonal. In this case "diagonal" means all diagonals, not
 * just the two that bisect the board.
 *
 * Algorithm:
 * 1)
 */
public class Main {

    /** Return a list of all solutions to the eight queens problem, generalized to an nxn board. */
    static List<String> getSolutions(final int n) {
        // Handle the special case, n < 4.
        if (n < 4)
            return new ArrayList<String>();

        // Handle the normal cases, n >= 4 using recursion to detect all possible solutions.
        List<String> result = new ArrayList<>();
        checkSolutions(new int[n][n], 0, 0, result);
        return result;
    }

    private static void checkSolutions(final int[][] board, final int r, final int c,
                                       final List<String> result) {
        // Handle the base case of a successful board.
        final int n = board.length;
        if (r > n - 1) {
            // This board is a solution.  Add it to the result.
            result.add("got one");
            return;
        }

        // Handle the base case of an unsuccessful board.
        if (c > n - 1)
            return;

        // Deal with the normal case, place a queen at (r,c) and test it.
        board[r][c] = 1;
        if (threatened(board, r, c)) {
            // This position will not work.  Try the next column in this row.
            board[r][c] = 0;
            checkSolutions(board, r, c + 1);
        } else {
            // This position does work, try the next row.
            checkSolutions(board, r + 1, 0)
        }

        // Backtrack and test for completion.
        // tbc
        if (c > n - 1)
            // Backtrack the row.
    }

    /** Return TRUE iff the piece at the given cell is threatened by another queen. */
    private static boolean threatened(final int[][] board, int r, int c) {
        // tbc.
        return false;
    }
}
