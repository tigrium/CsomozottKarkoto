/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

/**
 *
 * @author Kata
 */
public class ProsSor extends Sor {

    public ProsSor(Szal[] be) {
        super(be);
    }

    @Override
    void init() {
        csomok = new Csomo[be.length / 2];
    }
    
}
