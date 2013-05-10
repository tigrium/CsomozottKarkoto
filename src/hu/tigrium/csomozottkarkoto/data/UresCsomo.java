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
public class UresCsomo extends Csomo {

    public UresCsomo(Szal be1, Szal be2) {
        super(be1, be2);
    }

    @Override
    void csomoz() {
        ki = new Szal[]{be[0], be[1]};
        szin = new Color(0, 0, 0, 0);
    }

    @Override
    public String toString() {
        return be[0].id + " " + be[1].id;
    }
    
}
