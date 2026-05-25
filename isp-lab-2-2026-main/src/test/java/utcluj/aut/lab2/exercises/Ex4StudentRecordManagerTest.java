package utcluj.aut.lab2.exercises;

public class MyPointTest {
    public static void main(String[] args) {
        // 3. Create two point objects
        MyPoint p1 = new MyPoint(); // Va folosi constructorul fără argumente: (0, 0, 0)
        MyPoint p2 = new MyPoint(3, 4, 5); // Va folosi constructorul cu parametrii

        // Afișarea punctelor folosind metoda toString() apelată implicit
        System.out.println("Punctul 1: " + p1);
        System.out.println("Punctul 2: " + p2);

        // Calcularea și afișarea distanței între ele
        double distantaIntrePuncte = p1.distance(p2);
        System.out.println("Distanța dintre p1 și p2: " + distantaIntrePuncte);

        // Testăm și metoda distance() cu argumente de tip int
        System.out.println("Distanța de la p2 la coordonatele (1, 1, 1): " + p2.distance(1, 1, 1));
    }
}