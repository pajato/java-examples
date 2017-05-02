import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            if (isPrime(value))
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }

    private static boolean isPrime(int value) {
        if (value == 2)
            return true;
        if (value == 1 || value % 2 == 0)
            return false;
        int sqrt = (int) Math.sqrt(value);
        for (int i = 3; i <= sqrt; i += 2)
            if (value % i == 0)
                return false;
        return true;
    }
}
