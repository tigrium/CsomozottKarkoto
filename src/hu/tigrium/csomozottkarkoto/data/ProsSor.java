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
        kimaradoSzal = 0;
    }

    @Override
    void init() {
        csomok = new Csomo[be.length / 2];
    }

//    @Override
//    public void general() {
//        super.general();
//        if (be.length % 2 == 1) {
//            ki[be.length-1] = be[be.length-1];
//        }
//    }
    
}
