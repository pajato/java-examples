import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        if (k == n) {
            printArray(a);
            System.exit(0);
        }

        // The copy will take two steps:
        // 1) copy a[d] .. a[n-1] into result[0] .. result[d-n-1]
        // 2) copy a[0] .. a[d] into result[d-n] .. result[n-1]
        int[] result = new int[a.length];
        System.arraycopy(a, k, result, 0, n - k);
        System.arraycopy(a, 0, result, n - k, k);
        printArray(result);
        System.exit(0);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1)
                System.out.print(" ");
        }
    }
}
