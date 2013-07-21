/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.gui;

import hu.tigrium.csomozottkarkoto.CsomozottKarkoto;
import hu.tigrium.csomozottkarkoto.data.Csomo;
import hu.tigrium.csomozottkarkoto.data.Karkoto;
import hu.tigrium.csomozottkarkoto.data.MinusMinus;
import hu.tigrium.csomozottkarkoto.data.MinusPlus;
import hu.tigrium.csomozottkarkoto.data.PlusMinus;
import hu.tigrium.csomozottkarkoto.data.PlusPlus;
import hu.tigrium.csomozottkarkoto.data.Sor;
import hu.tigrium.csomozottkarkoto.data.Szal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Kata
 */
public class HaloPanel extends JPanel {
    private static final int keret = 40;
    private static final int tav = 14;

    public HaloPanel() {
        setSize(getW() * tav + 2 * keret, getH() * tav + 2 * keret);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Karkoto karkoto = CsomozottKarkoto.getKarkoto();
        Szal[] szalak = karkoto.getSzalak();
        
        if (karkoto != null && karkoto.getSorok() != null && karkoto.getSzalak() != null) {
            int hossz = karkoto.getSorok().size();
            int szelesseg = karkoto.getSzalak().length;
            setSize(2 * keret + tav * szelesseg, 2 * keret + tav * hossz);
            setPreferredSize(new Dimension(2 * keret + tav * szelesseg, 2 * keret + tav * hossz));
        }
        
        Color c = g.getColor();
        
        for (int i = 0; i < getW(); i++) {
            g.setColor(szalak[i].getSzin());
            g.drawLine(keret + i * tav, keret - 2 * tav, keret + i * tav, keret - tav);
            g.setColor(c);
            g.drawLine(keret + i * tav, keret, keret + i * tav, keret + (getH() + 1 ) * tav);
        }
        for (int i = 0; i <= getH(); i++) {
            g.drawLine(keret, keret + i * tav, keret + (getW()-1) * tav, keret + i * tav);
        }
        
        if ( karkoto.getSorok() != null ) {
            for (int i = 0; i < karkoto.getSorok().size(); i++) {
                Sor sor = karkoto.getSorok().get(i);
                Csomo[] csomok = sor.getCsomok();
                int a = (csomok.length + 1) % 2;
                
                for (int j = 0; j < csomok.length; j++) {
                    g.setColor(csomok[j].getSzin());
                    int x = keret + 1 + (a + j * 2) * tav;
                    int y = keret + 1 + i * tav;
                    g.fillRect(x, y, tav-1, tav-1);
                    g.drawImage(getCsomoRajz(csomok[j]), x-1, y-1, this);
                }
            }
        }
    }
    
    private static BufferedImage getCsomoRajz(Csomo csomo) {
        BufferedImage img = new BufferedImage(tav, tav, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.black);
        
        if ( csomo.getClass() == PlusPlus.class ) {
            int x = (int)(tav/2);
            g.drawLine(x, 2, x, tav-2);
            g.drawLine(2, x, tav-2, x);
        } else if ( csomo.getClass() == MinusMinus.class ) {
            int x = (int)(tav/2);
            g.drawLine(x, 2, x, tav-2);
        } else if ( csomo.getClass() == PlusMinus.class ) {
            int x = (int)(tav*0.4);
            x -= x % 2;
            int y = (tav - x) / 2;
            g.fillRect(y, y, x+1, x+1);
        } else if ( csomo.getClass() == MinusPlus.class ) {
            int x = (int)(tav*0.6);
            x -= x % 2;
            int y = (tav - x) / 2;
            g.drawRect(y, y, x, x);
        }
        
        return img;
    }
    
    private int getH() {
        Karkoto karkoto = CsomozottKarkoto.getKarkoto();
        if (karkoto != null && karkoto.getSorok() != null) {
            return karkoto.getSorok().size();
        } else {
            return 0;
        }
    }
    
    private int getW() {
        return CsomozottKarkoto.getKarkoto().getSzalak().length;
    }
}
