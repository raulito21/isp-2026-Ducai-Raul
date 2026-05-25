package utcluj.aut.lab2.exercises;
/**
 * Class for generating and analyzing arrays of random integers.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex1ArrayAnalyzer {

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {
        Random random = new random();
        // TODO: Implement this method
        // 1. Generate a random size between 25 and 150
        int size=random.nextInt(150-25+1)+25;
        // 2. Create an array of that size
        int[] array = new int[size];
        // 3. Fill the array with random integers between -100 and 100
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100 - (-100) + 1) - 100;
        }
        // 4. Return the array
        return array;
        return null;
    }

    /**
     * Calculates the average value of all elements in the given array.
     *
     * @param array the array to analyze
     * @return the average value of all elements
     */
    public double calculateAverage(int[] array) {
        // TODO: Implement this method
        // 1. Calculate the sum of all elements in the array
        double sum = 0;
        //        for (int value : array) {
        //            sum += value;
        //        }
        // 2. Return the average (sum divided by length)
        return sum / array.length;}
        // 3. Handle edge case of empty array
        if (array == null || array.length == 0) {
            return 0.0;
        return 0.0;
    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        // TODO: Implement this method
        if (array == null) {
            return new int[]{0, 0};
        }
        int countAbove = 0;
        int countBelow = 0;

        for (int value : array) {
        // 1. Count elements above the average
            if (value > average) {
                countAbove++;
            }
        // 2. Count elements below the average
            else if (value < average) {
                countBelow++;
            }}
        // 3. Return both counts as an array [countAbove, countBelow]
        return null;
        return new int[]{countAbove, countBelow};
    }
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of ArrayAnalyzer
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();
        // 2. Generate a random array
        int[] array = analyzer.generateArray();
        // 3. Calculate the average of the array
        double average = analyzer.calculateAverage(array);
        // 4. Count elements above and below the average
        int[] counts = analyzer.countAboveBelowAverage(array, average);
        // 5. Print the results
        System.out.println("=== Analiza Array ===");
        System.out.println("Dimensiunea array-ului generat: " + array.length);
        System.out.printf("Media elementelor: %.2f%n", average);
        System.out.println("Număr de elemente strict peste medie: " + counts[0]);
        System.out.println("Număr de elemente strict sub medie: " + counts[1]);
    }
    }
}
