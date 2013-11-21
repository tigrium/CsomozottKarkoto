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
import hu.tigrium.csomozottkarkoto.data.UresCsomo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        addMouseListener(new MouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Karkoto karkoto = CsomozottKarkoto.getKarkoto();
        
        // méret beállítása
        if (karkoto != null && karkoto.getSorok() != null && karkoto.getSzalak() != null) {
            int hossz = karkoto.getSorok().size();
            int szelesseg = karkoto.getSzalak().length;
            setSize(2 * keret + tav * szelesseg, 2 * keret + tav * hossz);
            setPreferredSize(new Dimension(2 * keret + tav * szelesseg, 2 * keret + tav * hossz));
        }
        
        Color c = g.getColor();
        
        // függőleges vonalak (színes és fekete egyaránt)
        for (int i = 0; i < getW(); i++) {
            g.setColor(karkoto.getKezdoSzalak()[i].getSzin());
            g.drawLine(keret + i * tav, keret - 2 * tav, keret + i * tav, keret - tav);
            g.setColor(c);
            g.drawLine(keret + i * tav, keret, keret + i * tav, keret + (getH() + 1 ) * tav);
        }
        // vízszintes vonalak
        for (int i = 0; i <= getH(); i++) {
            g.drawLine(keret, keret + i * tav, keret + (getW()-1) * tav, keret + i * tav);
        }
        
        // négyzetek
        if ( karkoto.getSorok() != null ) {
            for (int i = 0; i < karkoto.getSorok().size(); i++) {
                Sor sor = karkoto.getSorok().get(i);
                Csomo[] csomok = sor.getCsomok();
                int a = (csomok.length + 1) % 2;
                
                for (int j = 0; j < csomok.length; j++) {
                    Color color = csomok[j].getSzin();
                    g.setColor(color);
                    int x = keret + 1 + (a + j * 2) * tav;
                    int y = keret + 1 + i * tav;
                    g.fillRect(x, y, tav-1, tav-1);
                    g.drawImage(getCsomoRajz(csomok[j], color), x-1, y-1, this);
                }
            }
        }
    }
    
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        
//    }
    
    private static BufferedImage getCsomoRajz(Csomo csomo, Color hatter) {
        BufferedImage img = new BufferedImage(tav, tav, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        if ((hatter.getRed() * 0.25 + hatter.getGreen() * 0.65 + hatter.getBlue() * 0.1) / 255 > 0.25) {
            g.setColor(Color.black);
        } else {
            g.setColor(Color.white);
        }
        
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
    
    
    
    private class MouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            CsomoPozicio csp = getPozicio(e.getPoint());
            if (csp.csomo > -1 && csp.sor > -1) {
                CsomozottKarkoto.getKarkoto().setCsomo(csp.sor, csp.csomo, 
                        getNextCsomo(CsomozottKarkoto.getKarkoto().getCsomo(csp.sor, csp.csomo).getClass()));
            }
        }
        
    }
    
    private Class<? extends Csomo> getNextCsomo(Class<? extends Csomo> csomo) {
        if (csomo == UresCsomo.class) {
            return PlusPlus.class;
        } else if (csomo == PlusPlus.class) {
            return PlusMinus.class;
        } else if (csomo == PlusMinus.class) {
            return MinusMinus.class;
        } else if (csomo == MinusMinus.class) {
            return MinusPlus.class;
        } else if (csomo == MinusPlus.class) {
            return UresCsomo.class;
        } else {
            return null;
        }
    }
    
    private CsomoPozicio getPozicio(Point p) {
        return new CsomoPozicio(p.x, p.y);
    }
    
    private class CsomoPozicio {
        int sor;
        int csomo;
        
        public CsomoPozicio(int x, int y) {
            sor = (y - keret - 1) / tav;
            if (sor < 0 || sor >= CsomozottKarkoto.getKarkoto().getSorok().size()) {
                sor = -1;
            }
            
            int negyzet = (x - keret - 1) / tav;
            int kimarado = CsomozottKarkoto.getKarkoto().getSor(sor).getKimaradoSzal();
            
            if ((negyzet + kimarado) % 2 == 0) {
                csomo = (negyzet - kimarado + 1) / 2;
            } else {
                csomo = -1;
            }
            if (sor < 0 || csomo < 0 || csomo >= CsomozottKarkoto.getKarkoto().getSor(sor).getCsomok().length) {
                csomo = -1;
            }
        }
    }
}
