package utcluj.aut.lab2.exercises;

import java.util.*;

public class Ex5StringAnalyzer {

    public String[] parseInput(String i) {
        return i == null ? new String[0] : i.split(";");
    }

    public String[] findLongest(String[] s) {
        int m = 0;
        for (String x : s) m = Math.max(m, x.length());
        List<String> r = new ArrayList<>();
        for (String x : s) if (x.length() == m) r.add(x);
        return r.toArray(new String[0]);
    }

    public String[] findShortest(String[] s) {
        if (s.length == 0) return new String[0];
        int m = s[0].length();
        for (String x : s) m = Math.min(m, x.length());
        List<String> r = new ArrayList<>();
        for (String x : s) if (x.length() == m) r.add(x);
        return r.toArray(new String[0]);
    }

    public int[] countVowels(String[] s) {
        int[] c = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            for (char h : s[i].toCharArray()) if ("aeiouAEIOUYy".indexOf(h) != -1) c[i]++;
        }
        return c;
    }

    public int[] countConsonants(String[] s) {
        int[] c = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            for (char h : s[i].toCharArray()) {
                if (Character.isLetter(h) && "aeiouAEIOUYy".indexOf(h) == -1) c[i]++;
            }
        }
        return c;
    }

    public String[] findMostVowels(String[] s) {
        int[] v = countVowels(s);
        int m = 0;
        for (int x : v) m = Math.max(m, x);
        List<String> r = new ArrayList<>();
        for (int i = 0; i < s.length; i++) if (v[i] == m) r.add(s[i]);
        return r.toArray(new String[0]);
    }

    public String[] findMostConsonants(String[] s) {
        int[] c = countConsonants(s);
        int m = 0;
        for (int x : c) m = Math.max(m, x);
        List<String> r = new ArrayList<>();
        for (int i = 0; i < s.length; i++) if (c[i] == m) r.add(s[i]);
        return r.toArray(new String[0]);
    }
}