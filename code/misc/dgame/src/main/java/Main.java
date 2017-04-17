import java.util.Arrays;
import java.util.Locale;

/**
 * Write a method to process a swipe in a game that takes as input a 4x4 grid of integer values.
 * Each row contains four integers.  The values can be -1 or a positive non-zero value.  The
 * processing of a "swipe" will combine values in a row such that two consecutive occurrences of the
 * same integer will produce as output a doubled value.  An entry of -1 is ignored except to act as
 * a placeholder value.
 *
 * The input to the program is provided on the command line as four space separated arrays, e. g:
 *
 * [4 - 4 -] [2 2 1 1] [1 2 - 2] [- - 3 -] => [8 - - -] [4 1 1 -] [1 4 - -] [3 - - -]
 */
public class Main {

    static class Grid {

        // The elements are initialized to -1.
        int[][] data = new int[4][4];

        Grid() {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    data[row][col] = -1;
                }
            }
        }

        Grid(int[][] data) {
            this.data = data;
        }

        public int[] getRow(int row) {
            return data[row];
        }

        public void put(int row, int col, int value) {
            data[row][col] = value;
        }
    }

    public static void main(String[] args) throws Exception {
        Grid g = getGrid();
        Grid result = swipe(g);
        print(g, result);
    }

    private static Grid swipe(Grid g) {
        Grid result = new Grid();
        for (int row = 0; row < 4; row++) {
            processRow(g, result, row);
        }
        return result;
    }

    private static void processRow(Grid input, Grid result, int index) {
        int[] row = input.getRow(index);
        int i, j, k;
        i = j = k = 0;
        boolean doubled = false;
        while (i < 4 && j < 4) {
            // Get the first non empty value in the row.
            while (j < 4 && row[j] == -1)
                j++;
            if (j == 4)
                return;
            int value = row[j];

            // See if the next non empty value is a dup.
            k = j + 1;
            while (k < 4 && row[k] == -1)
                k++;
            if (k < 4 && row[k] == value && !doubled) {
                // The next non empty value is a dup.  Do a doubling, but only do it once.
                result.put(index, i++, 2 * value);
                doubled = true;
                j = k + 1;
            } else if (row[j] != -1) {
                // Not a dup.  Copy the value.
                result.put(index, i++, value);
                j++;
            } else {
                // Not a dup and is an empty value.  Continue.
                j++;
            }
        }
    }

    private static void print(Grid input, Grid output) {
        System.out.println("  input   =>   output");
        for (int i = 0; i < 4; i++) {
            String inputRow = getRow(input, i);
            String outputRow = getRow(output, i);
            String line = String.format(Locale.US, "%s    %s", inputRow, outputRow);
            System.out.println(line);
        }
    }

    private static String getRow(Grid g, int r) {
        int[] row = g.getRow(r);
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int c = 0; c < 4; c++) {
            int value = row[c];
            result.append(value == -1 ? "-" : value);
            if (c < 3)
                result.append(" ");
        }
        result.append("]");
        return result.toString();
    }

    private static Grid getGrid() {
        int[][] g = {{-1, -1, 1, 1}, {4, 4, -1, 8}, {-1, 1, 2, 3}, {1, 2, 1, 2}};
        Grid result = new Grid(g);
        return result;
    }
}
