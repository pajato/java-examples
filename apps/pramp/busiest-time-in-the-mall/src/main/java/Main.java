import java.util.Map;
import java.util.HashMap;

/**
 * Pramp practice interview question.
 *
 * Busiest Time in The Mall
 *
 * The Westfield Mall management is trying to figure out what the busiest moment at the mall was
 * last year. You’re given data extracted from the mall’s door detectors. Each data point is
 * represented as an integer array whose size is 3. The values at indices 0, 1 and 2 are the
 * timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit
 * and 1 for entrance), respectively. Here’s an example of a data point: [ 1440084737, 4, 0 ].
 *
 * Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the
 * number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
 *
 * Given an array, data, of data points, write a function findBusiestPeriod that returns the time at
 * which the mall reached its busiest moment last year. The return value is the timestamp,
 * e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return
 * the earliest one.
 *
 * Assume that the array data is sorted in an ascending order by the timestamp. Explain your
 * solution and analyze its time and space complexities.
 *
 * Example:
 *
 *input:  data = [ [1487799425, 14, 1],
 *                 [1487799425, 4,  0],
 *                 [1487799425, 2,  0],
 *                 [1487800378, 10, 1],
 *                 [1487801478, 18, 0],
 *                 [1487801478, 18, 1],
 *                 [1487901013, 1,  0],
 *                 [1487901211, 7,  1],
 *                 [1487901211, 7,  0] ]
 *
 * output: 1487800378 # since the increase in the number of people
 *                    # in the mall is the highest at that point
 */
class Main {

    // Public class methods.

    static int findBusiestPeriod(int[][] data) {
        // your code goes here

        // Deal with special cases.
        if (data == null || data.length == 0)
            return -1;

        // Deal with normal cases, at least one data entry.  Start by processing each valid data
        // entry.
        Map.Entry<Integer, Integer> mapEntry = null;
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] entry : data) {
            if (entry.length != 3)
                continue;
            count += entry[2] == 1 ? entry[1] : -1 * entry[1];
            map.put(entry[0], count);
        }

        // Finish by finding the timestamp with the highest count, which would mark the busiest time
        // in the mall.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mapEntry = entry;
            }
        }

        // Deal with the result, if any.
        if (mapEntry == null)
            return -1;
        return mapEntry.getKey();
    }
}
