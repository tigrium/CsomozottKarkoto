/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto;

import hu.tigrium.csomozottkarkoto.data.Karkoto;
import hu.tigrium.csomozottkarkoto.data.MinusMinus;
import hu.tigrium.csomozottkarkoto.data.MinusPlus;
import hu.tigrium.csomozottkarkoto.data.PlusMinus;
import hu.tigrium.csomozottkarkoto.data.PlusPlus;
import hu.tigrium.csomozottkarkoto.data.PtlanSor;
import hu.tigrium.csomozottkarkoto.data.ProsSor;
import hu.tigrium.csomozottkarkoto.data.Sor;
import hu.tigrium.csomozottkarkoto.data.Szal;
import hu.tigrium.csomozottkarkoto.gui.Keret;
import hu.tigrium.csomozottkarkoto.gui.SettingsPanel;
import java.awt.Color;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kata
 */
public class CsomozottKarkoto {
    private static Karkoto karkoto;
    private static Keret keret;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CsomozottKarkoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CsomozottKarkoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CsomozottKarkoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CsomozottKarkoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        init();
        displayKeret();
        test();
    }
    
    private static void init() {
        setKarkoto(new Karkoto(11));
    }
    
    private static void displayKeret() {
        keret = new Keret();
        keret.setVisible(true);
    }
    
    private static void test() {
        karkoto = new Karkoto(6);
        
        karkoto.addSzal(new Szal("B", Color.red));
        karkoto.addSzal(new Szal("B", Color.red));
        karkoto.addSzal(new Szal("F", Color.white));
        karkoto.addSzal(new Szal("S", Color.yellow));
        karkoto.addSzal(new Szal("S", Color.yellow));
        karkoto.addSzal(new Szal("F", Color.white));
        
//        System.out.println(szalakToString(karkoto.getSzalak()));
//        System.out.println("init:");
        karkoto.init();
//        System.out.println(szalakToString(karkoto.getSzalak()));
////        System.out.println(karkoto);
//        System.out.println();
        
//        System.out.println("add sor");
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusMinus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusMinus.class, PlusMinus.class, PlusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));
        
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, MinusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusMinus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, PlusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));

//        System.out.println("\nKarkötő: ");
//        System.out.println(karkoto);
//        System.out.println(szalakToString(karkoto.getSzalak()));
        
    }
    
    private static String szalakToString(Szal[] szalak) {
        StringBuilder sb = new StringBuilder();
        
        for (Szal sz : szalak) {
            if ( sz == null) {
                sb.append("_").append(" ");
            } else {
                sb.append(sz.id).append(" ");
            }
        }
        
        return sb.toString();
    }
    
    private static Sor getSor(Karkoto karkoto, Class... c) {
        Sor s;
        if ( c.length % 2 != 0 ) {
            s = new ProsSor(karkoto.getSzalak());
        } else {
            s = new PtlanSor(karkoto.getSzalak());
        }
        
        for (int i = 0; i < c.length; i++) {
            s.addCsomo(i, c[i]);
        }
        
        return s;
    }

    public static Karkoto getKarkoto() {
        if (karkoto == null) {
            karkoto = new Karkoto(6);
            karkoto.init();
        }
        return karkoto;
    }

    public static void setKarkoto(Karkoto karkoto) {
        karkoto.init();
        CsomozottKarkoto.karkoto = karkoto;
        if (keret != null) {
            repaintKarkoto();
            keret.updateSettings();
        }
    }
    
    public static void repaintKarkoto() {
        keret.repaintKarkoto();
    }
    
//    public static void repaintKeret() {
//        if (keret != null) {
//            keret.repaint();
//        }
//    }

    public static Keret getKeret() {
        return keret;
    }

    public static void setKeret(Keret keret) {
        CsomozottKarkoto.keret = keret;
    }
}
