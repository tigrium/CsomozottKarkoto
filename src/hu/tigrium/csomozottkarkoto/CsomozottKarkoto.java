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
import hu.tigrium.csomozottkarkoto.data.ProsSor;
import hu.tigrium.csomozottkarkoto.data.PtlanSor;
import hu.tigrium.csomozottkarkoto.data.Sor;
import hu.tigrium.csomozottkarkoto.data.Szal;
import java.awt.Color;

/**
 *
 * @author Kata
 */
public class CsomozottKarkoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Karkoto karkoto = new Karkoto(6);
        
        karkoto.addSzal(new Szal("B", Color.red));
        karkoto.addSzal(new Szal("B", Color.red));
        karkoto.addSzal(new Szal("F", Color.black));
        karkoto.addSzal(new Szal("S", Color.yellow));
        karkoto.addSzal(new Szal("S", Color.yellow));
        karkoto.addSzal(new Szal("F", Color.black));
        
        System.out.println(szalakToString(karkoto.getSzalak()));
        System.out.println("init:");
        karkoto.init();
        System.out.println(szalakToString(karkoto.getSzalak()));
//        System.out.println(karkoto);
        System.out.println();
        
        System.out.println("add sor");
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusMinus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class, MinusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusPlus.class, PlusPlus.class));
        karkoto.addSor(getSor(karkoto, PlusMinus.class, PlusMinus.class, PlusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusMinus.class, MinusMinus.class));
        karkoto.addSor(getSor(karkoto, MinusPlus.class, MinusPlus.class, MinusPlus.class));

        System.out.println("\nKarkötő: ");
        System.out.println(karkoto);
        System.out.println(szalakToString(karkoto.getSzalak()));
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
}
