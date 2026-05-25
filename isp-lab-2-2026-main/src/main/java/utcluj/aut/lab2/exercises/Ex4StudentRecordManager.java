package utcluj.aut.lab2.exercises;

import java.util.Scanner;

/**
 * Application that manages student records using only Strings and arrays.
 * The program allows users to input student records, filter them by grade,
 * and sort them by different criteria.
 */
public class Ex4StudentRecordManager {

    /**
     * Main method that runs the application.
     * Observație: Adăugat cuvântul cheie 'static' necesar pentru rularea aplicației.
     */
    public static void main(String[] args) {
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        String[][] allRecords = new String[100][3]; // Păstrăm un număr maxim arbitrar de 100 pentru simplitate
        int recordCount = 0;

        // 2. Prompt the user to enter student records
        System.out.println("Introduceți datele studentului (nume,varsta,nota). Tastați 'done' când doriți să finalizați:");

        // 3. Read and store the records until the user indicates they're done
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] parsed = parseStudentRecord(input);
            if (parsed != null) {
                if (recordCount < allRecords.length) {
                    allRecords[recordCount++] = parsed;
                } else {
                    System.out.println("S-a atins limita maximă de studenți!");
                    break;
                }
            } else {
                System.out.println("Format invalid. Folosiți exact formatul: nume,varsta,nota");
            }
        }

        // Tăiem array-ul la dimensiunea exactă a înregistrărilor salvate
        String[][] exactRecords = new String[recordCount][3];
        System.arraycopy(allRecords, 0, exactRecords, 0, recordCount);

        if (recordCount > 0) {
            // Citim opțiunile (metoda deschide un scanner local care citește de la tastatură)
            String[] options = getFilterAndSortOptions();

            // 4. Allow the user to filter records by minimum grade
            String[][] filteredRecords = filterByGrade(exactRecords, options[0]);

            // 5. Allow the user to sort the filtered records
            boolean ascending = Boolean.parseBoolean(options[2]);
            String[][] sortedRecords = sortRecords(filteredRecords, options[1], ascending);

            // 6. Display the filtered and sorted records
            System.out.println("\n=== Rezultate Studenți ===");
            displayRecords(sortedRecords);
        } else {
            System.out.println("Nu a fost introdus niciun student.");
        }
    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     */
    public static String[] parseStudentRecord(String record) {
        if (record == null || record.isEmpty()) return null;

        // 1. Split the record by commas
        String[] parts = record.split(",");

        // 2. Validate that there are exactly 3 parts
        if (parts.length == 3) {
            // 3. Return a string array with [name, age, grade], eliminând și posibilele spații goale
            return new String[]{parts[0].trim(), parts[1].trim(), parts[2].trim()};
        }

        // 4. Return null or handle invalid formats appropriately
        return null;
    }

    /**
     * Filters student records by a minimum grade threshold.
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        if (records == null || minGrade == null || !isInteger(minGrade)) {
            return new String[0][0]; // Evităm crash-ul returnând un array gol
        }

        // 1. Parse the minimum grade threshold to an integer
        int threshold = Integer.parseInt(minGrade);

        // 2. Count how many records meet the criteria
        int count = 0;
        for (String[] student : records) {
            if (student != null && isInteger(student[2]) && Integer.parseInt(student[2]) >= threshold) {
                count++;
            }
        }

        // 3. Create a new array of arrays to hold the filtered records
        String[][] filtered = new String[count][3];

        // 4. Add records with grade >= minGrade to the new array
        int index = 0;
        for (String[] student : records) {
            if (student != null && isInteger(student[2]) && Integer.parseInt(student[2]) >= threshold) {
                filtered[index++] = student;
            }
        }

        // 5. Return the filtered records
        return filtered;
    }

    /**
     * Sorts student records by the given criteria.
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        if (records == null || records.length == 0) return records;

        // 1. Create a copy of the records array to avoid modifying the original
        String[][] sorted = new String[records.length][3];
        for (int i = 0; i < records.length; i++) {
            System.arraycopy(records[i], 0, sorted[i], 0, 3);
        }

        // 2. Determine which index to sort by based on sortBy
        int colIndex = 0; // Default (name)
        if (sortBy.equalsIgnoreCase("age")) {
            colIndex = 1;
        } else if (sortBy.equalsIgnoreCase("grade")) {
            colIndex = 2;
        }

        // 3. Implement a sorting algorithm (Bubble Sort)
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                boolean needSwap = false;

                // Criteriu logic dacă comparăm Text (Nume) sau Numere (Vârstă/Notă)
                if (colIndex == 0) { // Comparam String-uri (Nume)
                    int comparison = sorted[j][0].compareToIgnoreCase(sorted[j + 1][0]);
                    if (ascending ? comparison > 0 : comparison < 0) {
                        needSwap = true;
                    }
                } else { // Comparam Numere Intregi
                    int val1 = isInteger(sorted[j][colIndex]) ? Integer.parseInt(sorted[j][colIndex]) : 0;
                    int val2 = isInteger(sorted[j + 1][colIndex]) ? Integer.parseInt(sorted[j + 1][colIndex]) : 0;

                    // 4. If ascending is false, reverse the sorting logic
                    if (ascending ? val1 > val2 : val1 < val2) {
                        needSwap = true;
                    }
                }

                // Interschimbăm rândurile
                if (needSwap) {
                    String[] temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        // 5. Return the sorted array
        return sorted;
    }

    /**
     * Displays student records in a formatted way.
     */
    public static void displayRecords(String[][] records) {
        // 1. Check if there are any records to display
        if (records == null || records.length == 0) {
            System.out.println("Nu există nicio înregistrare de afișat conform filtrelor.");
            return;
        }

        // 2. Display a header for the output
        System.out.println(String.format("%-20s | %-6s | %-5s", "Nume Student", "Vârsta", "Notă"));
        System.out.println("----------------------------------------");

        // 3. Iterate through each record and format it for display
        for (String[] record : records) {
            // 4. Display each record on a separate line
            System.out.println(String.format("%-20s | %-6s | %-5s", record[0], record[1], record[2]));
        }
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     */
    public static String[] getFilterAndSortOptions() {
        // 1. Create a scanner to read user input (fără a-l închide ulterior, ca să nu blocăm System.in)
        Scanner scanner = new Scanner(System.in);

        // 2. Prompt the user for minimum grade threshold
        System.out.print("\nIntroduceți nota minimă dorită: ");
        String minGrade = scanner.nextLine().trim();

        // 3. Prompt the user for sorting criteria
        System.out.print("Criteriu de sortare (name, age, grade): ");
        String sortBy = scanner.nextLine().trim();

        // 4. Prompt the user for sorting order
        System.out.print("Sortează crescător? (true/false): ");
        String ascending = scanner.nextLine().trim();

        // 5. Return the options as a string array
        return new String[]{minGrade, sortBy, ascending};
    }

    /**
     * Checks if a string can be parsed as an integer.
     */
    public static boolean isInteger(String str) {
        // 1. Try to parse the string as an integer
        try {
            Integer.parseInt(str.trim());
            // 2. Return true if successful
            return true;
        } catch (NumberFormatException e) {
            // 2. Return false if it causes an exception
            return false;
        }
    }
}