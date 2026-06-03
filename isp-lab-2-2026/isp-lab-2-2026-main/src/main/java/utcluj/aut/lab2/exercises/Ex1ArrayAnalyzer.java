package utcluj.aut.lab2.exercises;

import java.util.Arrays;
import java.util.Random; // Importăm clasa pentru numere aleatoare

/**
 * Class for generating and analyzing arrays of random integers.
 */
public class Ex1ArrayAnalyzer {

    public int[] generateArray() {
        Random random = new Random();

        // 1. Generate a random size between 25 and 150
        // Formula: random.nextInt(max - min + 1) + min
        int size = random.nextInt(150 - 25 + 1) + 25;

        // 2. Create an array of that size
        int[] array = new int[size];

        // 3. Fill the array with random integers between -100 and 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100 - (-100) + 1) + (-100);
        }

        // 4. Return the array
        return array;
    }

    public double calculateAverage(int[] array) {
        // 3. Handle edge case of empty array (facem asta prima dată)
        if (array == null || array.length == 0) {
            return 0.0;
        }

        // 1. Calculate the sum of all elements in the array
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        // 2. Return the average
        // Convertim (cast) 'sum' la double pentru a nu pierde zecimalele la împărțire
        return (double) sum / array.length;
    }

    public int[] countAboveBelowAverage(int[] array, double average) {
        int above = 0;
        int below = 0;

        for(int i = 0; i < array.length; ++i) {
            if(array[i] > average) {
                above++;
            }
            // Folosim else if pentru că un număr nu poate fi și peste și sub medie în același timp
            else if(array[i] < average) {
                below++;
            }
        }

        return new int[]{above, below};
    }

    public static void main(String[] args) {
        // 1. Create an instance of ArrayAnalyzer
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();

        // 2. Generate a random array
        int[] array = analyzer.generateArray();

        // 3. Calculate the average of the array
        double average = analyzer.calculateAverage(array);

        // 4. Count elements above and below the average
        int[] aboveBelowAverage = analyzer.countAboveBelowAverage(array, average);

        // 5. Print the results
        System.out.println("Array generated with size: " + array.length);
        System.out.println("Array is: " + Arrays.toString(array));
        System.out.println("Average is: " + average);
        System.out.println("Numbers above average: " + aboveBelowAverage[0]);
        System.out.println("Numbers below average: " + aboveBelowAverage[1]);
    }
}
