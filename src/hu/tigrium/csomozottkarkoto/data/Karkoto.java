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
    private boolean paros;  // Első sor páros, vagyis rajzolásnál az első négyzet üres

    public Karkoto(int n) {
//        if ( n % 2 == 0 ) {
            this.n = n;
            szalak = new Szal[n];
            kezdoSzalak = szalak;
//        } else {
//            throw new RuntimeException("Páros számú szálnak kell lenni.");
//        }
    }

    public Karkoto(Szal[] szalak) {
//        if ( szalak.length % 2 == 0 ) {
            this.szalak = szalak;
            kezdoSzalak = szalak;
            n = szalak.length;
//        } else {
//            throw new RuntimeException("Páros számú szálnak kell lenni.");
//        }
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
                szalak[i] = new Szal(i + "", new Color(0, 0, 0, 0));
            }
        }
        
        kezdoSzalak = szalak;
    }
    
    public void addSor(Sor sor) {
        sorok.add(sor);
        szalak = sor.getKi();
    }

    public void addUresSor() {
        Sor ures;
        if (paros) {
            ures = new ProsSor(szalak);
        } else {
            ures = new PtlanSor(szalak);
        }
        for (int i = ures.kimaradoSzal; i + 1 < n; i += 2) {
            ures.addCsomo(i/2, UresCsomo.class);
        }
        addSor(ures);
    }
    
    public Szal[] getSzalak() {
        return szalak;
    }

    public ArrayList<Sor> getSorok() {
        return sorok;
    }
    
    public Sor getSor(int index) {
        return getSorok().get(index);
    }

    public Szal[] getKezdoSzalak() {
        return kezdoSzalak;
    }
    
    public Csomo getCsomo(int sor, int csomo) {
        return getSor(sor).getCsomok()[csomo];
    }
    
    public void setCsomo(int sor, int csomo, Class<? extends Csomo> csomoClass) {
        getSor(sor).addCsomo(csomo, csomoClass);
        update(sor);
    }
    
//    public void setSzalak(int szalak) {
//        n = szalak;
//        kezdoSzalak = new Szal[szalak];
//        this.szalak = new Szal[szalak];
//        sorok = new ArrayList<>();
//    }
    
    public Szal getSzal(int index) {
        return getSzalak()[index];
    }

    public boolean isParos() {
        return paros;
    }

    public void setParos(boolean paros) {
        this.paros = paros;
    }
    
    public void setSzalSzin(int index, Color szin) {
        getSzal(index).setSzin(szin);
        kezdoSzalak[index].setSzin(szin);
        update(index);
    }
    
    public void update(int kezdoIndex) {
        if (kezdoIndex == 0) {
            getSor(0).update(kezdoSzalak);
        }
        for(int i = Math.max(1, kezdoIndex); i < getSorok().size(); i++) {
            getSor(i).update(getSor(i-1).getKi());
        }
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
