package isp.lab3.exercise1;

public class Tree {

    private int height;

    public Tree() {
        this.height = 15;
    }

    public void grow(int meters) {
        if (meters >= 1) {
            this.height += meters;
        } else {
            System.out.println("Eroare: Arborele poate crește doar cu valori >= 1 metru.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.height);
    }
}