/**
 * Pramp practice interview question.
 *
 * Island Count
 *
 * Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns
 * the number of islands of 1s in binaryMatrix.
 *
 * An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is
 * considered adjacent to another cell if they are next to each either on the same row or
 * column. Note that two values of 1 are not part of the same island if they’re sharing only a
 * mutual “corner” (i.e. they are diagonally neighbors).
 *
 * Explain and code the most efficient solution possible and analyze its time and space
 * complexities.
 *
 * Example:
 *
 * input:  binaryMatrix = [ [0,    1,    0,    1,    0],
 *                          [0,    0,    1,    1,    1],
 *                          [1,    0,    0,    1,    0],
 *                          [0,    1,    1,    0,    0],
 *                          [1,    0,    1,    0,    1] ]
 *
 * output: 6 # since this is the number of islands in binaryMatrix.
 *
 * See all 6 islands color-coded on the Pramp site:
 * https://www.pramp.com/challenge/yZm60L6d5juM7K38KYZ6
 */
class Main {

    /** Return 0 or the number of islands (as described above) in the given binary matrix. */
    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        // Handle the special cases, null and empty input.
        if (binaryMatrix == null || binaryMatrix.length == 0)
            return 0;

        // Handle the normal case, a matrix of size > 0 by walking the matrix looking for cells
        // containing a 1.
        int islandCount = 0;
        for (int row = 0; row < binaryMatrix.length; row++)
            for (int col = 0; col < binaryMatrix[row].length; col++)
                if (binaryMatrix[row][col] == 1) {
                    islandCount++;
                    processNeighbors(binaryMatrix, row, col);
                }
        return islandCount;
    }

    public static void main(String[] args) {

    }

    /** Process all the neighbors of the given cell to see if they are part of the given island. */
    private static void processNeighbors(int[][] matrix, int row, int col) {
        // Mark the given cell as visited by changing the value to 2 and recursively process the
        // given cell's neighbors to the left, right, above and below (honoring boundaries).
        if (matrix[row][col] == 1) {
            matrix[row][col] = 2;
            if (row - 1 > 0)
                processNeighbors(matrix, row - 1, col);
            if (row + 1 < matrix.length)
                processNeighbors(matrix, row + 1, col);
            if (col - 1 > 0)
                processNeighbors(matrix, row, col - 1);
            if (col + 1 < matrix[row].length)
                processNeighbors(matrix, row, col + 1);
        }
    }
}
