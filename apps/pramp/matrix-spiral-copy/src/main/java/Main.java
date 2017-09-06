/**
 * Pramp: Smallest Substring of All Characters.
 */
class Main {

    // Set up an enum to handle direction switching and a boolean matrix of the same dimensions as
    // the input matrix to handle completion checking.
    enum Dir {
        right, down, left, up
    }

    /** An array used to track movement through the input matrix. */
    private static boolean[][] visited;

    /** The current direction. */
    private static Dir dir;

    /** The method under test. */
    static int[] spiralCopy(int[][] inputMatrix) {
        // your code goes here
        // Initialize the visited matrix.
        visited = new boolean[inputMatrix.length][];
        for (int r = 0; r < visited.length; r++)
            visited[r] = new boolean[inputMatrix[r].length];

        // Set up the output array (compute the size).
        int size = 0;
        for (int[] arr : inputMatrix) {
            size += arr.length;
        }
        int[] result = new int[size];

        // Iterate through the elements starting at top left, heading right.
        int r = 0;
        int c = 0;
        dir = Dir.right;
        int index = 0;
        while (!visited(inputMatrix, r, c)) {
            // Visit the current cell.
            result[index++] = inputMatrix[r][c];
            Dir nextDir = getNextDir(inputMatrix, r, c);
            int nextR = getNextRow(inputMatrix, r, c);
            int nextC = getNextCol(inputMatrix, r, c);
            visited[r][c] = true;
            r = nextR;
            c = nextC;
            dir = nextDir;
        }

        return result;
    }

    /** Return the direction for visiting the cell after r and c. */
    private static Dir getNextDir(final int[][] m, final int r, final int c) {
        switch (dir) {
            default:
            case right: return c == m[r].length - 1 || visited(m, r, c + 1) ? Dir.down : Dir.right;
            case down: return r == m.length - 1 || visited(m, r + 1, c) ? Dir.left : Dir.down;
            case left: return c == 0 || visited(m, r,c - 1) ? Dir.up : Dir.left;
            case up: return visited(m, r - 1, c) ? Dir.right : Dir.up;
        }
    }
    /** Visit an element in the given 2D matrix m at row r and col c. */
    private static int getNextRow(final int[][] m, final int r, final int c) {
        switch (dir) {
            default:
            case right: return (c == m[r].length - 1 && m.length > r + 1) || visited(m, r, c + 1) ? r + 1 : r;
            case down: return r == m.length - 1 || visited(m, r + 1, c) ? r : r + 1;
            case left: return c == 0 || visited(m, r, c - 1) ? r - 1 : r;
            case up: return visited(m, r - 1, c) ? r : r - 1;
        }
    }

    private static int getNextCol(final int[][] m, final int r, final int c) {
        switch (dir) {
            default:
            case right: return c == m[r].length - 1 || visited(m, r, c + 1) ? c : c + 1;
            case down: return (r == m.length - 1 && c > 0) || visited(m,r + 1, c) ? c - 1 : c;
            case left: return c == 0 || visited(m, r, c - 1) ? c : c - 1;
            case up: return visited(m, r - 1, c) ? c + 1 : c;
        }
    }

    /** Return TRUE iff the given cell has been visited. */
    private static boolean visited(int[][] m, int r, int c) {
        return (r < m.length && c < m[r].length) && visited[r][c];
    }
}
