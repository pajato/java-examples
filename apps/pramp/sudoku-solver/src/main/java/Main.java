import java.util.Map;
import java.util.HashMap;

/**
 * Pramp practice interview question.
 *
 * Sudoku Solver
 *
 * Write the function sudokuSolve that checks whether a given sudoku board (i.e. sudoku puzzle) is
 * solvable. If so, the function will returns true. Otherwise (i.e. there is no valid solution to
 * the given sudoku board), returns false.
 *
 * In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and
 * each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to
 * 9. The board setter provides a partially completed board, which for a well-posed board has a
 * unique solution. As explained above, for this problem, it suffices to calculate whether a given
 * sudoku board has a solution. No need to return the actual numbers that make up a solution.
 *
 * A sudoku board is represented as a two-dimensional 9x9 array of the characters ‘1’,‘2’,…,‘9’ and
 * the '.' character, which represents a blank space. The function should fill the blank spaces with
 * characters such that the following rules apply:
 *
 * In every row of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
 *
 * In every column of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
 *
 * In every 3x3 sub-board that is illustrated below, all characters ‘1’,‘2’,…,‘9’ appear exactly
 * once.
 *
 * A solved sudoku is a board with no blank spaces, i.e. all blank spaces are filled with characters
 * that abide to the constraints above. If the function succeeds in solving the sudoku board, it’ll
 * return true (false, otherwise).
 *
 * Example (more examples can be found here):
 *
 * A typical Sudoku board
 *
 *  0 1 2 3 4 5 6 7 8
 * [5 3 . . 7 0 . . .]
 * [6 . . 1 9 5 . . .]
 * [. 0 9 8 . . . 6 .]
 * [8 . . . 6 . . . 3]
 * [4 . . 8 . 3 . . 1]
 * [7 . . . 2 . . . 6]
 * [. 6 . . . . 2 8 .]
 * [. . . 4 1 9 . . 5]
 * [. . . . 8 . . 7 9]
 *
 * The same board with solutions
 *
 * Write a readable an efficient code, explain how it is built and why you chose to build it that
 * way.
 */
class Main {

    private static final Map<Character, Boolean> map = new HashMap<>();

    /** A blank character. */
    private static final char BLANK = '.';

    // Public class methods.

    // Return true iff there are no dups in the rows, columns or sub-arrays of the given matrix. */
    static boolean sudokuSolve(char[][] board) {
        // your code goes here

        // Handle special cases.
        if (board == null || isInvalid(board))
            return false;

        // Algorithm:
        //
        // 1) Ensure that the rows do not have any dups.
        // Assume that the board is square and of length 9.
        final int length = 9;
        for (int r = 0; r < length; r++) {
            // Assume a square board!
            map.clear();
            for (int c = 0; c < length; c++) {
                // Check for a row violation.
                char ch = board[r][c];
                if (ch != BLANK && map.containsKey(ch))
                    return false;
                map.put(ch, true);
            }
        }

        // 2) Ensure that the columns do not have any dups.
        for (int c = 0; c < length; c++) {
            map.clear();
            for (int r = 0; r < length; r++) {
                char ch = board[r][c];
                if (ch != BLANK && map.containsKey(ch))
                    return false;
                map.put(ch, true);
            }
        }

        // 3) Ensure that the sub-arrays do have any dups.  There are nine of them.
        for (int i = 0; i < length; i++) {
            map.clear();
            if (invalidSubArray(board, i / 3, 3 * (i % 3)))
                return false;
        }

        return true;
    }

    /** Return TRUE iff the sub-array at the given cell has a duplicate value. */
    private static boolean invalidSubArray(final char[][] board, final int row, final int col) {
        map.clear();
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                char ch = board[r][c];
                if (ch != BLANK && map.containsKey(ch))
                    return true;
            }
        }
        return false;
    }

    /** Return true iff the board is not a valid Sudoku board. */
    private static boolean isInvalid(final char[][] board) {
        if (board == null || board.length != 9)
            return true;
        for (char[] row : board)
            if (row.length != 9)
                return true;
        return false;
    }
}
