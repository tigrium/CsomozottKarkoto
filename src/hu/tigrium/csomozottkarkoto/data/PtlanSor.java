/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

/**
 *
 * @author Kata
 */
public class PtlanSor extends Sor {

    public PtlanSor(Szal[] be) {
        super(be);
        kimaradoSzal = 1;
    }

    @Override
    void init() {
        csomok = new Csomo[(be.length - 1) / 2];
        ki[0] = be[0];
        if (be.length % 2 == 0) {
            ki[be.length-1] = be[be.length-1];
        }
    }
    
}
