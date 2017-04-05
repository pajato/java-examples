import java.util.Arrays;
import java.util.Scanner;
import util.Util;

/**
 * Jim's Orders from HackerRank:
 *
 * Jim's Burgers has hungry burger fans waiting in line. Each unique order is placed by a
 * customer at time and the order takes units of time to process.
 *
 * Given the information for all orders, can you find and print the order in which all customers
 * will receive their burgers? If two or more orders are fulfilled at the exact same time, sort
 * them by ascending order number.
 *
 * Input Format
 *
 * The first line contains a single integer denoting the number of orders.
 *
 * Each of the subsequent lines contains two space-separated integers describing the respective
 * values of order time (ti) and order duration (di) for order n.
 *
 * Constraints
 *
 * Output Format
 *
 * Print a single line of space-separated order numbers (recall that orders are numbered from 1 to
 * n) describing the sequence in which the customers receive their burgers. If two or more customers
 * receive their burgers at the same time, print the smallest order number first.
 *
 * Sample Input 0
 *
 * 3
 * 1 3
 * 2 3
 * 3 3
 *
 * Sample Output 0
 *
 * 1 2 3
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("There are no orders!");
            System.exit(0);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }
        processOrders(builder.toString());
    }

    /** Process a given collection of orders. */
    private static void processOrders(String orders) {
        // Use a scanner to pick off the input.
        Scanner scanner = new Scanner(orders);
        final int n = getNumberOfOrders(scanner);
        int[] completion = getCompletionTimes(n, scanner);
        int uniqueCount = Util.getUniqueCount(completion);
        int[] unique = Util.getUnique(completion);
        System.out.println("Completion array: " + Arrays.toString(completion));
        System.out.println("Unique array: " + Arrays.toString(unique));
        printOrders(unique, completion);
        scanner.close();
    }

    /** Return an array of completions times.  Exit in input error. */
    private static int[] getCompletionTimes(int n, Scanner scanner) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int orderTime = getOrderTime(scanner);
            int orderDuration = getOrderDuration(scanner);
            result[i] = orderTime + orderDuration;
        }
        return result;
    }

    /** Return the number of orders.  Exit on input error. */
    private static int getNumberOfOrders(Scanner scanner) {
        int result;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
            return result;
        }
        System.out.println("Invalid input detected in reading order count.");
        System.exit(1);
        return -1;
    }

    /** Return the order time.  Exit on input error. */
    private static int getOrderTime(Scanner scanner) {
        int result;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
            return result;
        }
        System.out.println("Invalid input detected in reading order time.");
        System.exit(1);
        return -1;
    }

    /** Return the order duration.  Exit on input error. */
    private static int getOrderDuration(Scanner scanner) {
        int result;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
            return result;
        }
        System.out.println("Invalid input detected in reading order duration.");
        System.exit(1);
        return -1;
    }

    /** Print the sequence in which the given orders will be completed. */
    private static void printOrders(int[] uniqueOrderTimes, int[] completionTimesByOrder) {
        for (int i = 0; i < uniqueOrderTimes.length; i++) {
            printOrders(uniqueOrderTimes[i], completionTimesByOrder);
        }
        System.out.println("");
    }

    /** Print the order numbers which will be ready at the given time. */
    private static void printOrders(int completionTime, int[] completionTimesByOrder) {
        final int N = completionTimesByOrder.length;
        for (int i = 0; i < N; i++) {
            if (completionTimesByOrder[i] == completionTime) {
                String entry = String.format("%d ", i + 1);
                System.out.print(entry);
            }
        }
    }
}
