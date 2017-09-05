/**
 * Pramp practice interview question.
 *
 * Nth root
 *
 * Given a non-negative value and a positive integer, compute the principal nth root of the value.
 *
 */
class Main {

    // Public constants.

    /** The accuracy desired for the approximate solutions. */
    final static double EPSILON = 0.001;

    // Private instance variables.

    private static int iterationCount;

    // Public class methods.

    /** Return the number of iterations performed to arrive at the solution. */
    static int getIterations() {
        return iterationCount;
    }

    /** Return the nth root of the given value using logarithms. */
    static double rootByAntilog(final double A, final int n) {
        iterationCount = 1;

        // Deal with invalid input and the special (valid) case of A and n.
        if (A < 0.0 || n <= 0)
            throw new IllegalArgumentException();
        if (A == 0.0)
            return 0.0;
        if (A == 1.0)
            return 0.0;
        if (n == 1)
            return A;

        return Math.exp(Math.log(A)/n);
    }

    /** Return the nth root of the given value using a binary interval method. */
    static double rootByBinarySearch(final double A, final int n) {
        iterationCount = 0;

        // Deal with invalid input and the special (valid) case of A and n.
        if (A < 0.0 || n <= 0)
            throw new IllegalArgumentException();
        if (A == 0.0)
            return 0.0;
        if (A == 1.0)
            return 0.0;
        if (n == 1)
            return A;

        double [] bounds = new double[]{0.0, A};
        double guess, exp;
        while (true) {
            iterationCount++;
            guess = (bounds[1] + bounds[0]) / 2;
            exp = Math.pow(guess, n);
            if (Math.abs(exp - A) > EPSILON) {
                if (exp > A)
                    bounds[1] = guess;
                if (exp < A)
                    bounds[0] = guess;
            } else
                return guess;
        }
    }

    /** Return 0 or the number of islands (as described above) in the given binary matrix. */
    static double rootByNewtonRaphson(final double A, final int n) {
        iterationCount = 0;

        // your code goes here
        // Use Newton-Raphson method starting with a wild ass guess.
        // Deal with invalid input and the special (valid) case of A and n.
        if (A < 0.0 || n <= 0)
            throw new IllegalArgumentException();
        if (A == 0.0)
            return 0.0;
        if (A == 1.0)
            return 0.0;
        if (n == 1)
            return A;

        // Handle the normal cases.
        double guess = A / n;
        do {
            iterationCount++;
            guess = 1.0/n * (((n - 1) * guess) + (A / product(guess, n - 1)));
        } while (Math.abs(product(guess, n) - A) > EPSILON);

        return guess;
    }

    private static double product(final double value, int count) {
        // count must be greater than 0.
        double product = value;
        for (int i = 0; i < count - 1; i++)
            product *= value;
        return product;
    }
}
