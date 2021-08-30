package com.company;

/**
 * @author hoehn
 */

public class Main {

    public static void main(String[] args) {
        // eigenes Auto-Objekt erstellen und Programm ausführen
        Auto[] autoArray = new Auto[50];

        // 20 Datsätze erstellen
        for (int i = 0; i < 20; i++) {
            autoArray[i] = new Auto(i, "BMW", "rot", "Atom",
                    "Motorrad", "Spezial-Delux", "Umweltfreundlich", "Front-Antrieb", 12 + i,
                    23.23 + i);
        }

        // Test Datensatz fürs Sortieren an der (pos.) 21 Stelle mit Index 20 "einfügen"
        autoArray[20] = new Auto(20, "Affe", "rot", "Atom",
                "Motorrad", "Spezial-Delux", "Umweltfreundlich", "Front-Antrieb", 120,
                23.23);
        Datenbank db = new Datenbank(autoArray);


        // Objekt UserInterface für die User-Anzeige und Programmssteuerung
        UserInterface uiView = new UserInterface();
        uiView.start(db);

        //  Start-Methode die Eine Leere-Datenbank erstellt
        //  uiView.start();

    }

}
