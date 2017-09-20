import java.util.Scanner;

/**
 * This example is incomplete and disabled via removal from settings.gradle.
 */
public class Main {
    public static int numberNeeded(String first, String second) {
        // Build two arrays to hold the character counts of each possible character (a-z) in the
        // input strings.  Then compare the deltas at each array index to determine the number of
        // deletions needed to ensure an anagram result.
        int[] a = getCounts(first);
        int[] b = getCounts(second);
        int deleteCount = 0;
        for (int i = 0; i < 26; i++)
            deleteCount += Math.abs(a[i] - b[i]);
        return deleteCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    private static int[] getCounts(String s) {
        int[] result = new int[26]; // defaults to 0 values.
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (index >= 0)
                result[index]++;
        }
        return result;
    }
}
