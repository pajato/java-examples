import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            // Write Your Code Here
            if (n == 1) {
                System.out.println("Yes");
                continue;
            }
            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i+1]) {
                    continue;
                }
                if (a[i] == a[i+1] + 1) {
                    int tmp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = tmp;
                    continue;
                }
                if (a[i] > a[i+1]) {
                    isSorted = false;
                    break;
                }
            }
            System.out.println(isSorted ? "Yes" : "No");
        }
    }
}
