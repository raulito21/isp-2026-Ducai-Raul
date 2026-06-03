package utcluj.aut.lab2.exercises;

import java.util.Random;
import java.util.Scanner;

public class Ex6BullsAndCowsGame {
    private String s;

    public Ex6BullsAndCowsGame() {
        this.s = generateSecretNumber();
    }

    public Ex6BullsAndCowsGame(String s) {
        this.s = s;
    }

    public static String generateSecretNumber() {
        Random r = new Random();
        StringBuilder b = new StringBuilder();
        while (b.length() < 4) {
            int d = r.nextInt(10);
            String v = String.valueOf(d);
            if (b.indexOf(v) == -1) {
                b.append(v);
            }
        }
        return b.toString();
    }

    public int[] evaluateGuess(String g) {
        if (g == null || g.length() != 4 || !g.matches("\\d+") || hasR(g)) {
            throw new IllegalArgumentException("Invalid guess");
        }

        int b = 0, c = 0;
        for (int i = 0; i < 4; i++) {
            char ch = g.charAt(i);
            if (ch == s.charAt(i)) {
                b++;
            } else if (s.indexOf(ch) != -1) {
                c++;
            }
        }
        return new int[]{b, c};
    }

    private boolean hasR(String g) {
        for (int i = 0; i < g.length(); i++) {
            for (int j = i + 1; j < g.length(); j++) {
                if (g.charAt(i) == g.charAt(j)) return true;
            }
        }
        return false;
    }

    public int playTestGame(String[] gs) {
        int a = 0;
        for (String g : gs) {
            a++;
            int[] r = evaluateGuess(g);
            if (r[0] == 4) return a;
        }
        return a;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        System.out.println("Start game!");
        while (true) {
            System.out.print("Guess: ");
            String g = sc.nextLine();
            try {
                a++;
                int[] r = evaluateGuess(g);
                System.out.println("Bulls: " + r[0] + ", Cows: " + r[1]);
                if (r[0] == 4) {
                    System.out.println("Success! Attempts: " + a);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                a--; // Nu numărăm încercările invalide
            }
        }
    }
}
