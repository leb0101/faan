package com.company;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hoehn
 */
//blubb o
public class Datenbank {
    private Auto[] dbArray;
    private Auto[] dummy; // Ein Auto-Array "Dummy"

    // Standard-Konsturktor mit 50 leeren Feldern vom Typ Auto
    public Datenbank() {
        dbArray = new Auto[50];
    }

    // überladener Kontruktor wenn man ein Feld mit Auto-Objekt übergeben möchte
    public Datenbank(Auto[] dbArray) {
        this.dbArray = dbArray;
    }

    // Methode zum einfügen eines Datensatzes an der Stelle die noch unbelegt ist
    public void insertAutoObj(Auto auto) {
        int i = 0;
        while (dbArray[i] != null) {
            i++;
        }

        dbArray[i] = auto;
    }


    public void deleteDataSet(int id) {
        boolean status = false;
        for (int i = 0; i < dbArray.length; i++) {
            if (dbArray[i] != null && dbArray[i].getAutoId() == id) {
                dbArray[i] = null;
                moveUp(i);
                status = true;
            }


        }

        // Abfrage ob Datensatz "gelöscht" wurde oder nicht
        if (status) {
            System.gc(); // dem Garbage-Collector mitteilen das er mal aktiv werden kann
            System.out.println("Systembenachrichtigung: Datensatz erfolgreich gelöscht !");
        } else {
            System.out.println("Der Datensatz mit der Auto-Id: " + id + " konnte NICHT gelöscht werden.");
        }

    }

    // Methode zum Aufrücken der Datensätze
    public void moveUp(int i) {
        for (int j = i + 1; j < dbArray.length -1; j++) {
               dbArray[i] = dbArray[j];
               i++;
        }

    }


    /************************* MEHTODEN FÜR DIE JEWEILIGE(N) SUCHEN *********************************************/
// Suche nach der AutoID
    public void searchID(int value) {
        int counter = 0;
        dummy = new Auto[dbArray.length];
        for (Auto x : dbArray) {
            if (x != null && x.getAutoId() == value) {
                dummy[counter] = x;
                counter++;
            }
        }
        showAllDataSets(dummy);
    }

    // Suche nach Preis
    public void searchPrice(double value) {
        int counter = 0;
        dummy = new Auto[dbArray.length];
        for (Auto x : dbArray) {
            if (x != null && x.getPreis() == value) {
                dummy[counter] = x;
                counter++;
            }
        }
        showAllDataSets(dummy);
    }

    // Suche nach Hubraum
    public void searchCubic(long value) {
        int counter = 0;
        dummy = new Auto[dbArray.length];
        for (Auto x : dbArray) {
            if (x != null && x.getHubraum() == value) {
                dummy[counter] = x;
                counter++;
            }
        }
        showAllDataSets(dummy);
    }

    // Suche nach PS-Zahl
    public void searchPS(int value) {
        int counter = 0;
        dummy = new Auto[dbArray.length];
        for (Auto x : dbArray) {
            if (x != null && x.getPs() == value) {
                dummy[counter] = x;
                counter++;
            }
        }
        showAllDataSets(dummy);
    }

    // Suchen eines Datesatzes nach Speziellem Kriterium mit STRING als Parameterübergabe
    public void searchString(int attribute, String value) {
        dummy = new Auto[dbArray.length];
        int i = 0;
        for (Auto x : dbArray) {
            if (x != null) {
                switch (attribute) {

                    case 2:
                        if (x.getHersteller().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 3:
                        if (x.getFarbe().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 4:
                        if (x.getKraftstoff().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 5:
                        if (x.getTyp().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 6:
                        if (x.getModell().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 7:
                        if (x.getAusstattung().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    case 8:
                        if (x.getAntrieb().equals(value)) {
                            dummy[i] = x;
                            i++;
                        }
                        break;
                    default:
                        System.out.println("Ups, da ist etwas Schief gegangen !");
                }

            }

        }


        showAllDataSets(dummy);
    }

    /**
     * Sortieren-Methode mit der Comparator Klasse
     */

    // Sortieren der Datensätze
    public void sort() {
        int endIndex = 0;
        for (int i = endIndex; i < dbArray.length; i++) {
            if (dbArray[0] == null){
               break;
            }
            else if (dbArray[i] != null){
                endIndex = i;
            }
        }

        Arrays.sort(dbArray,0,endIndex+1, Comparator.comparing(Auto::getHersteller));
        System.out.println("System: Datensätze Sortiert !");
    }


    // Mehode zur Ausgabe aller Datensätze
    public void showAllDataSets() {
        boolean ds = false;
        for (Auto x : dbArray) {
            if (x != null) {
                System.out.println(x.getAllAttributes());
                ds = true;
            }
        }

        if (!ds) {
            System.out.println("Keine Datensätze vorhanden !");
        }
    }

    // Überladene Methode zur Ausgabe aller Datensätze, Parameter ist ein Array mit Auto-Objekten
    public void showAllDataSets(Auto[] dbArray) {
        boolean ds = false;
        for (Auto x : dbArray) {
            if (x != null) {
                System.out.println(x.getAllAttributes());
                ds = true;
            }
        }

        if (!ds) {
            System.out.println("Keine Datensätze vorhanden !");
        }

    }
}
