/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Kata
 */
public class Karkoto {
    private int n;
    private Szal[] kezdoSzalak;
    private Szal[] szalak;
    private ArrayList<Sor> sorok;

    public Karkoto(int n) {
        if ( n % 2 == 0 ) {
            this.n = n;
            szalak = new Szal[n];
        } else {
            throw new RuntimeException("Páros számú szálnak kell lenni.");
        }
    }

    public Karkoto(Szal[] szalak) {
        if ( szalak.length % 2 == 0 ) {
            this.szalak = szalak;
            kezdoSzalak = szalak;
            n = szalak.length;
        } else {
            throw new RuntimeException("Páros számú szálnak kell lenni.");
        }
    }
    
    public void addSzal(Szal szal) {
        for (int i = 0; i < n; i++) {
            if ( szalak[i] == null ) {
                szalak[i] = szal;
                kezdoSzalak = szalak;
                return;
            }
        }
        throw new RuntimeException("Már megvan minden szál.");
    }
    
    public void addSzal(Szal szal, int i) {
        if (i < szalak.length) {
            szalak[i] = szal;
        }
    }
    
    public void init() {
        if (sorok == null) {
            sorok = new ArrayList<Sor>();
        }
        
        for (int i = 0; i < n; i++) {
            if ( szalak[i] == null ) {
                szalak[i] = new Szal("", new Color(0,0,0,0));
            }
        }
        
        kezdoSzalak = szalak;
//        Sor elso = new ProsSor(szalak);
//        for (int i = 0; i + 1 < n; i += 2) {
//            elso.addCsomo(i/2, UresCsomo.class);
//        }
//        addSor(elso);
    }
    
    public void addSor(Sor sor) {
        sorok.add(sor);
        szalak = sor.getKi();
    }

    public Szal[] getSzalak() {
        return szalak;
    }

    public ArrayList<Sor> getSorok() {
        return sorok;
    }

    public Szal[] getKezdoSzalak() {
        return kezdoSzalak;
    }
    
    public void setSzalak(int szalak) {
        n = szalak;
        kezdoSzalak = new Szal[szalak];
        this.szalak = new Szal[szalak];
        sorok = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (Sor s : sorok) {
            sb.append(s.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
