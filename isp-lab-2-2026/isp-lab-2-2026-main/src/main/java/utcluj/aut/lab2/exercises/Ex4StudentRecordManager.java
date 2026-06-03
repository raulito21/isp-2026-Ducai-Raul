package utcluj.aut.lab2.exercises;

import java.util.*;

public class Ex4StudentRecordManager {

    public static String[] parseStudentRecord(String r) {
        String[] p = r.split(",");
        if (p.length != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) p[i] = p[i].trim();
        return p;
    }

    public static String[][] filterByGrade(String[][] r, String g) {
        int m = Integer.parseInt(g);
        List<String[]> l = new ArrayList<>();
        for (String[] s : r) {
            if (Integer.parseInt(s[2]) >= m) l.add(s);
        }
        return l.toArray(new String[0][0]);
    }

    public static String[][] sortRecords(String[][] r, String b, boolean a) {
        String[][] s = Arrays.copyOf(r, r.length);
        int k = b.equals("name") ? 0 : (b.equals("age") ? 1 : 2);
        Arrays.sort(s, (x, y) -> {
            int v = (k == 0) ? x[0].compareTo(y[0]) : Integer.compare(Integer.parseInt(x[k]), Integer.parseInt(y[k]));
            return a ? v : -v;
        });
        return s;
    }

    public static void displayRecords(String[][] r) {
        for (String[] x : r) System.out.println(String.join(" | ", x));
    }

    public static boolean isInteger(String s) {
        try { Integer.parseInt(s); return true; } catch (Exception e) { return false; }
    }
}