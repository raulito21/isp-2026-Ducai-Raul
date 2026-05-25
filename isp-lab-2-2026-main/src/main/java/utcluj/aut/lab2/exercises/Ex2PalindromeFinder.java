package utcluj.aut.lab2.exercises;

/**
 * Class for finding palindromic numbers in a given range.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex2PalindromeFinder {

    /**
     * Checks if a number is palindromic (reads the same backward as forward).
     *
     * @param number the number to check
     * @return true if the number is palindromic, false otherwise
     */
    public boolean isPalindromic(int number) {
        // TODO: Implement this method
        int absNumber = Math.abs(number);
        // 1. Convert the number to a string
        String str = String.valueOf(absNumber);
        // 2. Check if the string reads the same forward and backward
        String reversed = new StringBuilder(str).reverse().toString();
        // 3. Return the result
        return str.equals(reversed);
        return false;
    }

    /**
     * Finds all palindromic numbers in the given range [a, b], inclusive.
     *
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return an array of all palindromic numbers in the range
     * @throws IllegalArgumentException if a > b
     */
    public int[] findPalindromes(int a, int b) {
        // TODO: Implement this method
        // 1. Validate that a <= b, throw IllegalArgumentException if not
        if (a > b) {
            throw new IllegalArgumentException("Valoarea lui 'a' trebuie să fie mai mică sau egală cu 'b'.");
        }
        // 2. Create an array to store palindromic numbers
        List<Integer> palindromeList = new ArrayList<>();
        // 3. Iterate through each number in the range [a, b]
        for (int i = a; i <= b; i++) {
        // 4. Check if each number is palindromic, add to array if true
            if (isPalindromic(i)) {
                palindromeList.add(i);
            }
            // 5. Return the array
            int[] result = new int[palindromeList.size()];
            for (int i = 0; i < palindromeList.size(); i++) {
                result[i] = palindromeList.get(i);
            }

            return result;
        return new int[0];
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
            Ex2PalindromeFinder finder = new Ex2PalindromeFinder();
            Scanner scanner = new Scanner(System.in);
        // 1. Create an instance of PalindromeFinder
        // 2. Define a range of numbers to check for palindromes
            System.out.println("=== Căutare Numere Palindrom ===");
            System.out.print("Introduceți limita inferioară (a): ");
            int a = scanner.nextInt();

            System.out.print("Introduceți limita superioară (b): ");
            int b = scanner.nextInt();

            try {
        // 3. Find palindromes in the defined range
                int[] palindromes = finder.findPalindromes(a, b);
        // 4. Print the array of palindromes
                for (int p : palindromes) {
                    System.out.print(p + " ");
                }
                System.out.println("\nNumăr total de palindroame: " + palindromes.length);

            } catch (IllegalArgumentException e) {
                System.out.println("Eroare: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }
}
