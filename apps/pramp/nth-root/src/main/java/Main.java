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

    static double ERROR_TOLERANCE = 0.00015;

    // Public class methods.

    /** Return 0 or the number of islands (as described above) in the given binary matrix. */
    static double root(final double A, final int n) {
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
        do
            guess = 1.0/n * (((n - 1) * guess) + (A / product(guess, n - 1)));
        while (Math.abs(product(guess, n) - A) > ERROR_TOLERANCE);

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
