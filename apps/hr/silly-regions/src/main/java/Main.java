/**
Consider a matrix with rows and columns, where each cell contains either a or a and any cell
containing a is called a filled cell. Two cells are said to be connected if they are adjacent to
each other horizontally, vertically, or diagonally; in other words, cell [i][j] is connected to
cells , , , , , , , and , provided that the location exists in the matrix for that .

If one or more filled cells are also connected, they form a region. Note that each cell in a region
is connected to at least one other cell in the region but is not necessarily directly connected to
all the other cells in the region.

Task

Given an matrix, find and print the number of cells in the largest region in the matrix. Note that
there may be more than one region in the matrix.

Input Format

The first line contains an integer, , denoting the number of rows in the matrix.

The second line contains an integer, , denoting the number of columns in the matrix.

Each line of the subsequent lines contains space-separated integers describing the respective values
filling each row in the matrix.

Constraints

* 0 <= n, m < 10

Output Format

Print the number of cells in the largest region in the given matrix.

Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

Sample Output

5

Explanation

The diagram below depicts two regions of the matrix; for each region, the component cells forming
the region are marked with an X:

X X 0 0     1 1 0 0
0 X X 0     0 1 1 0
0 0 X 0     0 0 1 0
1 0 0 0     X 0 0 0

The first region has five cells and the second region has one cell. Because we want to print the
number of cells in the largest region of the matrix, we print .
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static int max;
    static int count;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        findMax(grid);
        System.out.println(max);
    }

    static void findMax(int[][] grid) {
        final int N = grid.length;
        if (N == 0)
            return;
        final int M = grid[0].length;
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                if (grid[r][c] == 0) {
                    continue;
                } else {
                    count = 1;
                    recurse(grid, r, c + 1);
                    recurse(grid, r + 1, c);
                    recurse(grid, r + 1, c + 1);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
    }

    static void recurse(int[][] grid, int r, int c) {
        final int N = grid.length;
        final int M = grid[0].length;
        if (r >= N || c >= M || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (grid[r][c] == 1) {
            count++;
            recurse(grid, r, c + 1);
            recurse(grid, r + 1, c);
            recurse(grid, r + 1, c + 1);
        }
    }
}
