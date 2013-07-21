/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

import java.awt.Color;

/**
 *
 * @author Kata
 */
public abstract class Csomo {
    Szal[] be;
    Szal[] ki;
    Color szin;
    
    public Csomo(Szal be1, Szal be2) {
        be = new Szal[]{be1, be2};
        csomoz();
    }

    public Szal[] getBe() {
        return be;
    }

    public Szal[] getKi() {
        return ki;
    }

    public Color getSzin() {
        return szin;
    }

    @Override
    public String toString() {
        if ( szin.equals(be[0].getSzin())) {
            return be[0].id;
        } else {
            return be[1].id;
        }
    }
    
    abstract void csomoz();
    
}
