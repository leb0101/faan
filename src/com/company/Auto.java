package com.company;

import java.text.DecimalFormat;

/**
 * @author hoehn
 */

public class Auto {
    // Klassenvariable
    private static int counter = 1;
    // Instanzvariablen
    private final int autoId;
    private int ps;
    private String hersteller, farbe, kraftstoff, modell, typ, ausstattung, antrieb;
    private long hubraum;
    private double preis;
    DecimalFormat f = new DecimalFormat("#.##");

// Leeres Auto-Objekt mit einer Id macht wenig Sinn
/*
    Auto(){
        this.autoId = counter;
        counter++;
    }
*/

    Auto(int ps, String hersteller, String farbe, String kraftstoff,
         String typ, String modell, String ausstattung, String antrieb, long hubraum,
         double preis) {

        this.autoId = counter;
        counter++;
        this.ps = ps;
        this.hersteller = hersteller;
        this.farbe = farbe;
        this.kraftstoff = kraftstoff;
        this.modell = modell;
        this.typ = typ;
        this.ausstattung = ausstattung;
        this.antrieb = antrieb;
        this.hubraum = hubraum;
        this.preis = preis;

    }

    public int getAutoId() {
        return autoId;
    }

    /* AutoId soll nicht nachträglich verändert werden
      public void setAutoId(int autoId) {
          this.autoId = autoId;
      }
      */
    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    public String getAntrieb() {
        return antrieb;
    }

    public void setAntrieb(String antrieb) {
        this.antrieb = antrieb;
    }

    public long getHubraum() {
        return hubraum;
    }

    public void setHubraum(long hubraum) {
        this.hubraum = hubraum;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getAllAttributes() {
        return "ID: "
                + this.autoId + " , "
                + this.ps + " "
                + this.hersteller + " "
                + this.farbe + " "
                + this.kraftstoff + " "
                + this.modell + " "
                + this.typ + " "
                + this.ausstattung + " "
                + this.antrieb + " "
                + this.hubraum + " "
                + f.format(this.preis);
    }

}
