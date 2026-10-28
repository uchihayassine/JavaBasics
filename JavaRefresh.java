/**
 * Java-Auffrischung fuer "Einfuehrung in die Programmierung".
 * Genau die Bausteine, die in den Projektwochen-Pruefungen vorkommen.
 *
 * Kompilieren und starten (PowerShell), aus diesem Ordner:
 *   & "C:\Users\yassine\Downloads\openjdk-24.0.1_windows-x64_bin\jdk-24.0.1\bin\javac.exe" JavaRefresh.java
 *   & "C:\Users\yassine\Downloads\openjdk-24.0.1_windows-x64_bin\jdk-24.0.1\bin\java.exe" JavaRefresh
 *
 * Lies jede Methode, dann aendere eine Zahl und starte neu.
 * So bleibt der Stoff haengen.
 */
public class JavaRefresh { //hed el dossier 

    public static void main(String[] args) { //heda el programme principal
        variablenUndRechnung();
        ifUndSchleifen();
        methoden();
        zeichenUndStrings();
        felder();
        klassen();
        scannerMuster();
    }

    //In der JavaRefresh.java werden Methoden definiert, um Logik auszulagern und den Code wiederverwendbar zu machen

    static void variablenUndRechnung() {     //el Method loula 
        System.out.println("=== 1. Variablen ===");
        int jahr = 2026;
        double betrag = 1000.0;
        double zinsProzent = 5.0;
        boolean bezahlt = false;
        char buchstabe = 'A';
        String name = "Alex";

        double zinsen = betrag * zinsProzent / 100.0;
        System.out.println(name + " zahlt im Jahr " + jahr + " Zinsen: " + zinsen);
        System.out.println("bezahlt? " + bezahlt + ", Buchstabe " + buchstabe);

        // printf: %d ganzzahlig, %.2f zwei Nachkommastellen, %n Zeilenumbruch
        System.out.printf("formatiert: %.2f Euro%n", zinsen);
    }

    static void ifUndSchleifen() { // El method el thenya 
        System.out.println("=== 2. if und Schleifen ===");
        int rest = 100;
        int rate = 30;
        int runde = 0;

        // while: solange die Bedingung wahr ist
        while (rest > 0) {
            runde = runde + 1;
            if (rest < rate) {
                System.out.println("letzte Rate: " + rest);
                rest = 0;
            } else {
                rest = rest - rate;
                System.out.println("nach Rate " + runde + " bleibt " + rest);
            }
        }

        // for: zaehler von 0 bis 4
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void methoden() { // El method el thaletha
        System.out.println("=== 3. Methoden ===");
        int summe = addiere(4, 7);
        System.out.println("4 + 7 = " + summe);
        System.out.println("ggt(48, 18) = " + ggt(48, 18));
    }

    static int addiere(int a, int b) {  
        return a + b;
    }

    // Euklid: der groesste gemeinsame Teiler. Brauchst du bei Bruchrechnung.
    static int ggt(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    static void zeichenUndStrings() {
        System.out.println("=== 4. char und String (nur charAt, length, equals) ===");
        char c = 'H';
        char verschoben = (char) (c + 3);
        System.out.println(c + " + 3 = " + verschoben);

        // Buchstaben kreisen lassen: nach z kommt wieder a
        char z = 'x';
        char rotiert = (char) ('a' + (z - 'a' + 3) % 26);
        System.out.println(z + " um 3 = " + rotiert);

        String wort = "halle";
        String neu = "";
        for (int i = 0; i < wort.length(); i++) {
            char ch = wort.charAt(i);
            neu = neu + (char) (ch + 1);
        }
        System.out.println(wort + " -> " + neu);
        System.out.println("gleich? " + neu.equals("ibmmf"));
    }

    static void felder() {
        System.out.println("=== 5. Arrays, auch zweidimensional ===");
        int[] punkte = new int[3];
        punkte[0] = 10;
        punkte[1] = 20;
        punkte[2] = 5;

        // Spielfeld: Zeile zuerst, dann Spalte. Index beginnt bei 0.
        char[][] brett = new char[3][3];
        for (int z = 0; z < brett.length; z++) {
            for (int s = 0; s < brett[z].length; s++) {
                brett[z][s] = '.';
            }
        }
        brett[1][1] = 'X';
        for (int z = 0; z < brett.length; z++) {
            for (int s = 0; s < brett[z].length; s++) {
                System.out.print(brett[z][s] + " ");
            }
            System.out.println();
        }
    }

    static void klassen() {
        System.out.println("=== 6. Klasse, Konstruktor, this ===");
        Spieler alex = new Spieler("Alex");
        alex.addPunkte(15);
        alex.addPunkte(2);
        System.out.println(alex.getName() + " hat " + alex.getPunkte() + " Punkte");
    }

    static void scannerMuster() {
        System.out.println("=== 7. Scanner (Muster, hier nicht ausgefuehrt) ===");
        System.out.println("import java.util.Scanner;");
        System.out.println("Scanner eingabe = new Scanner(System.in);");
        System.out.println("int n = eingabe.nextInt();      // ganze Zahl");
        System.out.println("String zeile = eingabe.next();  // ein Wort");
        System.out.println("Falsche Eingaben: while-Schleife, bis der Wert gueltig ist.");
    }
}

class Spieler {
    private String name;
    private int punkte;

    public Spieler(String name) {
        this.name = name;
        this.punkte = 0;
    }

    public String getName() {
        return name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void addPunkte(int wert) {
        this.punkte = this.punkte + wert;
    }
}
