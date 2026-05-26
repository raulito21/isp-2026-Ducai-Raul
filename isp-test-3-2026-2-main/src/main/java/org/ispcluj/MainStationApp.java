package org.ispcluj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainStationApp {

    @FunctionalInterface
    interface MenuAction {
        void execute() throws Exception;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, MenuAction> menuActions = new HashMap<>();

        TerminalStation terminalStation = new TerminalStation();

        menuActions.put(1, () -> {
            System.out.println("\n[Action] Starting Live Train Platform Allocation Simulation...");

            List<Train> structuralSchedule = populateSampleSchedule();

            // REQ-2: Stream pipeline cu lambda
            List<Train> filteredSchedule = structuralSchedule.stream()
                    .filter(train -> !"Freight".equalsIgnoreCase(train.getType()))
                    .toList();

            TrafficController controller = new TrafficController(terminalStation, filteredSchedule);

            PlatformTrack platform1 = new PlatformTrack(1, terminalStation);
            PlatformTrack platform2 = new PlatformTrack(2, terminalStation);
            PlatformTrack platform3 = new PlatformTrack(3, terminalStation);

            platform1.start();
            platform2.start();
            platform3.start();

            controller.start();

            controller.join();
            platform1.join();
            platform2.join();
            platform3.join();

            System.out.println("[Main] Simulation finished.");
        });

        menuActions.put(2, () -> {
            System.out.println("\n[Action] Triggering Controlled Custom Exception Test...");

            Train invalidTrain = new Train("TEST-404", "InterCity", null);

            try {
                invalidTrain.validateSignals();
            } catch (SignalFailureException e) {
                System.out.println("[Handled Exception] " + e.getMessage());
            }

            try {
                throw new TerminalOverloadException("Manual overload test exception.");
            } catch (TerminalOverloadException e) {
                System.out.println("[Handled Runtime Exception] " + e.getMessage());
            }
        });

        menuActions.put(3, () -> {
            System.out.println("\n[Action] Displaying Processed Train Summary...");
            System.out.println("Processed trains: " + terminalStation.getProcessedTrains());
            System.out.println("Unique registered trains: " + terminalStation.getUniqueTrainCount());
        });

        while (true) {
            printMenu();
            System.out.print("Select an option (1-4): ");

            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a numerical choice.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                        menuActions.get(choice).execute();
                        break;

                    case 4:
                        System.out.println("Exiting terminal control system. Safe travels!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Error: Option out of bounds! Choose a valid menu entry.");
                        break;
                }
            } catch (Exception e) {
                System.err.println("[System Error Alert] " + e.getMessage());
            }

            System.out.println("\n========================================================");
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Central Station Platform Allocation Console ===");
        System.out.println("1. Run Real-time Allocation Engine");
        System.out.println("2. Simulate & Trigger Signal Exceptions Check");
        System.out.println("3. View Total Processed Trains / Unique Registry Stats");
        System.out.println("4. Shutdown & Terminate Station Program");
    }

    private static List<Train> populateSampleSchedule() {
        return List.of(
                new Train("IC-120", "InterCity", "Cluj-Napoca"),
                new Train("FR-441", "Freight", "Arad"),
                new Train("IR-33", "Regional", "Sibiu"),
                new Train("IC-120", "InterCity", "Cluj-Napoca"),
                new Train("S-88", "InterCity", null),
                new Train("RE-501", "Regional", "Oradea"),
                new Train("IC-777", "InterCity", "Brasov")
        );
    }
}