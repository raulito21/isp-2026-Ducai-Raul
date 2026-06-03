package utcluj.aut.lab2.exercises;

import java.util.Scanner;

public class Ex3FactorialCalculator {

    public long recursiveFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        return (n < 2) ? 1 : n * recursiveFactorial(n - 1);
    }

    public long nonRecursiveFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        long r = 1;
        for (int i = 2; i <= n; i++) r *= i;
        return r;
    }

    public long[] compareExecutionTime(int n) {
        long t1 = System.nanoTime();
        recursiveFactorial(n);
        long d1 = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        nonRecursiveFactorial(n);
        long d2 = System.nanoTime() - t2;

        return new long[]{d1, d2};
    }

    public static void main(String[] args) {
        Ex3FactorialCalculator c = new Ex3FactorialCalculator();
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int n = s.nextInt();
            long[] t = c.compareExecutionTime(n);
            System.out.println("R: " + t[0] + " ns, NR: " + t[1] + " ns");
        }
    }
}