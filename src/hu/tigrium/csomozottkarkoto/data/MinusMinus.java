/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

/**
 *
 * @author Kata
 */
public class MinusMinus extends Csomo {

    public MinusMinus(Szal be1, Szal be2) {
        super(be1, be2);
    }
    
    @Override
    public void csomoz() {
        ki = new Szal[]{be[1], be[0]};
        szin = be[1].getSzin();
    }
    
}
