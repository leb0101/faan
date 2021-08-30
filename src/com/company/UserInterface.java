
package com.company;


import java.util.Scanner;

/**
 * @author hoehn
 */

public class UserInterface {
    private int attrib;
    private final Scanner sc = new Scanner(System.in);
    private int ps;
    private String hersteller, farbe, kraftstoff, modell, typ, ausstattung, antrieb;
    private long hubraum;
    private double preis;
    private Datenbank db;


    // Startmethode mit einem Datenbankobjekt als Parameter
    public void start(Datenbank db) {
        this.db = db;
        showMenue();
    }

    // Start Methode ohne Parameter
    public void start() {
        db = new Datenbank();
        showMenue();
    }

    // Hauptmethode zur Menü-Anzeige
    public void showMenue() {
        System.out.println("Auto-Verwaltungsprogramm");
        System.out.println("----------------------------------");
        System.out.println("1.)Alle Datensätze ausgeben");
        System.out.println("2.)Datensatz eingeben");
        System.out.println("3.)Datensatz löschen");
        System.out.println("4.)Datensatz suchen");
        System.out.println("5.)Datensätze Sortieren");
        System.out.println("9.)Programm verlassen");


        switch (sc.nextInt()) {
            case 1 -> showAllDataSets();
            case 2 -> insert();
            case 3 -> delete();
            case 4 -> search();
            case 5 -> sort();
            case 9 -> System.out.println("Bye Bye");
            default -> {
                System.out.println("Falsche eingabe!");
                showMenue();
            }
        }

    }

    public void insert() {

        try {
            System.out.println("Hersteller:");
            hersteller = sc.next();
            System.out.println("Farbe:");
            farbe = sc.next();
            System.out.println("Modell:");
            modell = sc.next();
            System.out.println("Typ:");
            typ = sc.next();
            System.out.println("Kraftstoff:");
            kraftstoff = sc.next();
            System.out.println("Autsstattung:");
            ausstattung = sc.next();
            System.out.println("Antrieb:");
            antrieb = sc.next();
            System.out.println("ps:");
            ps = sc.nextInt();
            System.out.println("Hubraum:");
            hubraum = sc.nextLong();
            System.out.println("Preis (xx,xx):");
            preis = sc.nextDouble();

        } catch (Exception e) {
            sc.next();
            System.out.println("Fehlerhafte Eingabe bitte geben Sie die Daten erneut ein !");
            sc.next();
            System.out.println("---------------------------------------------------------------------------");
            insert();
        }

        Auto temp = new Auto(ps, hersteller, farbe, kraftstoff, typ, modell, ausstattung, antrieb, hubraum, preis);
        db.insertAutoObj(temp);
        System.out.println("Systembenachrichtigung: Datensatz wurde hinzugefügt");
        showMenue();
    }

    // Methode zum Aufruf der Datenbank Methode showAllDataSets()
    public void showAllDataSets() {
        db.showAllDataSets();
        keyWait();
    }


    // Aufruf der Methode Löschen vom Datenbank-Objekt
    public void delete() {
        System.out.println("*************** Datensatz löschen *****************");
        System.out.println();
        System.out.println("Auto-ID des zu löschenden Auto-Datensatzes:");
        db.deleteDataSet(sc.nextInt());
        showMenue();
    }

    // Methode zum Suchen einer Eigenschaft, per Usereingabe
    public void search() {
        System.out.println("############## Datensatz suchen ####################");
        System.out.println();
        System.out.println("Suchen nach ....");
        System.out.println("0) AutoID");
        System.out.println("1) PS");
        System.out.println("2) Hersteller");
        System.out.println("3) Farbe");
        System.out.println("4) Kraftstoff");
        System.out.println("5) Typ");
        System.out.println("6) Modell");
        System.out.println("7) Ausstattung");
        System.out.println("8) Antrieb");
        System.out.println("9) Preis");
        System.out.println("10) Hubraum");
        System.out.println("1000) Zurück");

        attrib = sc.nextInt();
        switch (attrib) {

            case 0 -> searchID();
            case 1 -> searchPS();
            case 2 -> searchAssembler();
            case 3 -> searchColor();
            case 4 -> searchPatrol();
            case 5 -> searchType();
            case 6 -> searchModell();
            case 7 -> searchFurnishing();
            case 8 -> searchDrive();
            case 9 -> searchPrice();
            case 10 -> searchCubic();
            case 1000 -> showMenue();
            default -> {
                System.out.println("Ungültige Eingabe !");
                search();
            }
        }


    }

    private void searchID() {
        System.out.println("----------------- AutoID - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie die AutoID ein: ");
        try {
            db.searchID(sc.nextInt());
        } catch (Exception e) {
            sc.next();
            searchID();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchPrice() {
        System.out.println("----------------- Preis - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie einen Preis ein: ");
        try {
            db.searchPrice(sc.nextDouble());
        } catch (Exception e) {
            sc.next();
            searchPrice();
        }
        sc.nextLine();
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchDrive() {
        System.out.println("----------------- Antrieb -Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie den Antrieb ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchDrive();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchFurnishing() {
        System.out.println("----------------- Ausstattung - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie die Ausstattung ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchFurnishing();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchModell() {
        System.out.println("----------------- Modell - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie das Modell ein:");

        try {
            db.searchString(attrib, sc.nextLine());
        } catch (Exception e) {
            sc.next();
            searchModell();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchType() {
        System.out.println("----------------- Typen - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie den Typ ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchType();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchPatrol() {
        System.out.println("----------------- Kraftstoff - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie die Kraftstoffart ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchPatrol();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchColor() {
        System.out.println("----------------- Farben - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie die Farbe ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchColor();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchAssembler() {
        System.out.println("----------------- Hersteller - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie den Hersteller ein:");
        try {
            db.searchString(attrib, sc.next());
        } catch (Exception e) {
            sc.next();
            searchAssembler();
        }
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchPS() {
        System.out.println("----------------- PS - suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie die PS- Zahl ein:");
        try {
            db.searchPS(sc.nextInt());
        } catch (Exception e) {
            sc.next();
            searchPS();
        }
        sc.nextLine();
        keyWait(); // Warten und zurück zum Hauptmenue
    }

    private void searchCubic() {
        System.out.println("----------------- Hubraum - Suche -------------");
        System.out.println();
        System.out.println("Bitte Geben Sie den Hubraum ein:");
        try {
            db.searchCubic(sc.nextLong());
        } catch (Exception e) {
            sc.next();
            searchCubic();
        }

        keyWait(); // Warten und zurück zum Hauptmenue
    }

    // Methode um eine beliebige Tastatureingabe entgegenzunehmen und dann zum Hauptmenü zurückzukehren

    private void keyWait() {
        System.out.println("Weiter mit Buchstabe + Enter-Taste");
        try {
            sc.next();
            showMenue();
        } catch (Exception FormatException) {
            sc.next();
            showMenue();
        }
    }

    // Methode für den Aufruf der Datanbankmethode sort() um nach Hersteller zu Sortieren

    private void sort() {

        try {
            db.sort();
            showAllDataSets();
        } catch (Exception NullpointerException) {
            System.out.println("System: Leider ist ein Fehler aufgetreten !");
            showMenue();
        }


    }

}