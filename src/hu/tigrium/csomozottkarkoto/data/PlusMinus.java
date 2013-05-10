/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

/**
 *
 * @author Kata
 */
public class PlusMinus extends Csomo {
    
    public PlusMinus(Szal be1, Szal be2) {
        super(be1, be2);
    }
    
    @Override
    public void csomoz() {
        ki = new Szal[]{be[0], be[1]};
        szin = be[0].getSzin();
    }
    
}
