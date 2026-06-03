package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.List;

public class Ex2PalindromeFinder {

    public boolean isPalindromic(int n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public int[] findPalindromes(int a, int b) {
        if (a > b) throw new IllegalArgumentException();
        List<Integer> l = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (isPalindromic(i)) l.add(i);
        }
        int[] r = new int[l.size()];
        for (int i = 0; i < l.size(); i++) r[i] = l.get(i);
        return r;
    }

    public static void main(String[] args) {
        Ex2PalindromeFinder f = new Ex2PalindromeFinder();
        int[] res = f.findPalindromes(10, 100);
        for (int x : res) System.out.print(x + " ");
    }
}