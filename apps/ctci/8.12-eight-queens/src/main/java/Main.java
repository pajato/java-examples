import java.util.List;
import java.util.ArrayList;

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
        if (n <= 0 || n == 2 || n == 3)
            return new ArrayList<String>();

        // Handle the normal case, n > 4
        List<String> result = new ArrayList<>();
        checkSolutions(0, new int[n], result);
        return result;
    }

    private static void checkSolutions(final int row, final int[] columns, final List<String> result) {
        final int n = columns.length;
        if (row == n)
            result.add("Got one!");
        else
            for (int col = 0; col < n; col++)
                if (isValid(columns, row, col)) {
                    columns[row] = col;
                    checkSolutions(row + 1, columns, result);
                }
    }

    /** Return TRUE iff the piece at the given cell is a valid position for a queen to be places. */
    private static boolean isValid(final int[] columns, int row, int col) {
        // The queen at position (r, c) is threatened if there is another queen on the board with
        // the same row or column or is on the same diagonal.
        // Check for another queen on the same row.
        int n = columns.length;
        for (int r = 0; r < row; r++) {
            // Determine if (r, c) invalidates (row, col)
            int c = columns[r];
            if (col == c)
                return false;

            // Check for another queen on the same diagonal.
            int colDistance = Math.abs(c - col);
            int rowDistance = row - r;
            if (colDistance == rowDistance)
                return false;
        }

        // A queen can be placed at (row, col)
        return true;
    }
}
