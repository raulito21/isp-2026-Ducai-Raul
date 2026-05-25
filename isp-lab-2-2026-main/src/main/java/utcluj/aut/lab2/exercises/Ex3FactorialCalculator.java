package utcluj.aut.lab2.exercises;
/**
 * Class for calculating factorials using recursive and non-recursive approaches.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex3FactorialCalculator {

    /**
     * Calculates the factorial of n using recursion.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long recursiveFactorial(int n) {
        public long recursiveFactorial(int n) {
            // 1. Validate that n is not negative
            if (n < 0) {
                throw new IllegalArgumentException("Numărul nu poate fi negativ.");
            }

            // 3. Base case (0! = 1)
            if (n == 0 || n == 1) {
                return 1;
            }

            // 2. Implement the recursive algorithm
            return n * recursiveFactorial(n - 1);
        }
        return 0;
    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {
        // 1. Validate that n is not negative
        if (n < 0) {
            throw new IllegalArgumentException("Numărul nu poate fi negativ.");
        }

        // 3. Base case (0! = 1) - acoperit logic și de bucla de mai jos dacă result = 1
        long result = 1;

        // 2. Implement a loop-based algorithm
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
        return 0;
    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {
        // 1. Measure the execution time of recursiveFactorial
        long startRecursive = System.nanoTime();
        recursiveFactorial(n);
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive - startRecursive;

        // 2. Measure the execution time of nonRecursiveFactorial
        long startNonRecursive = System.nanoTime();
        nonRecursiveFactorial(n);
        long endNonRecursive = System.nanoTime();
        long nonRecursiveTime = endNonRecursive - startNonRecursive;

        // 3. Return both times in an array
        return new long[]{recursiveTime, nonRecursiveTime};
        return null;
    }

     public static void main(String[] args) {
         // 1. Measure the execution time of recursiveFactorial
         long startRecursive = System.nanoTime();
         recursiveFactorial(n);
         long endRecursive = System.nanoTime();
         long recursiveTime = endRecursive - startRecursive;

         // 2. Measure the execution time of nonRecursiveFactorial
         long startNonRecursive = System.nanoTime();
         nonRecursiveFactorial(n);
         long endNonRecursive = System.nanoTime();
         long nonRecursiveTime = endNonRecursive - startNonRecursive;

         // 3. Return both times in an array
         return new long[]{recursiveTime, nonRecursiveTime};
    }
}
