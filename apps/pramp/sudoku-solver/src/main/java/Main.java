import java.util.HashSet;
import java.util.Set;

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

    /** A blank character. */
    private static final char BLANK = '.';

    // Public class methods.

    /** Return true iff there is a valid solution to the given board. */
    static boolean sudokuSolve(char[][] board) {
        // your code goes here

        // Handle special cases.
        if (board == null || board.length != 9)
            return false;

        // Determine the position (r,c) which has the least number of candidate characters.
        int row = -1;
        int col = -1;
        char[] candidates = null;
        final int n = board.length;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) {
                if (board[r][c] == BLANK) {
                    char[] possibleCandidates = getCandidates(board, r, c);
                    if (candidates == null || possibleCandidates.length < candidates.length) {
                        candidates = possibleCandidates;
                        row = r;
                        col = c;
                    }
                }
            }

        // Test for the availability of a candidate.  If there are none, the puzzle has been solved.
        if (candidates == null)
            return true;

        // Apply a character from the candidate and solve for that board.
        for (char c : candidates) {
            board[row][col] = c;
            if (sudokuSolve(board))
                return true;
            board[row][col] = BLANK;
        }

        return false;
    }

    /** Return the set of candidate characters for the given board position (row, col). */
    private static char[] getCandidates(final char[][] board, final int row, final int col) {
        // Build a map of characters in the row, col and sub-array.
        final int n = board.length;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = board[row][i];
            if (c != BLANK)
                set.add(c);
        }
        for (int i = 0; i < n; i++) {
            char c = board[i][col];
            if (c != BLANK)
                set.add(c);
        }
        for (int i = row - row % 3; i < 3; i++)
            for (int j = col - col % 3; j < 3; j++) {
                char c = board[i][j];
                if (c != BLANK)
                    set.add(c);
            }

        // Return the set of characters between '0'..'8' (inclusive) that are actual candidates.
        char[] result = new char[9 - set.size()];
        int index = 0;
        for (char c : new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'})
            if (!set.contains(c))
                result[index++] = c;
        return result;
    }
}
