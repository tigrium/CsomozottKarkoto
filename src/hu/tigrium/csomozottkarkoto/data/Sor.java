/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 *
 * @author Kata
 */
public abstract class Sor {
    Szal[] be;
    Szal[] ki;
    Csomo[] csomok;
    
    int kimaradoSzal;

    public Sor(Szal[] be) {
        this.be = be;
        ki = new Szal[be.length];
        init();
    }
    
    public void addCsomo(int i, Class<? extends Csomo> csomoClass) {
//        System.out.println("i " + i + "  kimarado " + kimaradoSzal);
        Csomo csomo = null;
        try {
            Class<?> clazz = Class.forName(csomoClass.getCanonicalName());
            Constructor<?> ctor = clazz.getConstructor(Szal.class, Szal.class);
            csomo = (Csomo) ctor.newInstance(new Object[] { be[2*i + kimaradoSzal], 
                be[2*i + 1 + kimaradoSzal] });
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException |
                InstantiationException | InvocationTargetException | NoSuchMethodException | 
                SecurityException ex) {
            ex.printStackTrace();
        }

        csomok[i] = csomo;
    }
    
    public void general() {
        ki = new Szal[be.length];
        for(int i = 0; i < csomok.length; i++) {
            csomok[i].csomoz();
        }
        for (int i = 0; i < csomok.length; i++) {
            if ( csomok[i] == null ) { 
                ki = null;
                throw new RuntimeException("Nincs minden csomó megkötve!");
            } else {
                ki[2*i + kimaradoSzal] = csomok[i].getKi()[0];
                ki[2*i + 1 + kimaradoSzal] = csomok[i].getKi()[1];
            }
        }
        for (int i = 0; i < be.length; i++) {
            if (ki[i] == null) ki[i] = be[i];
        }
    }
    
    public void update(Szal[] be) {
        if (this.be.length == be.length) {
            this.be = be;
            System.out.print(Arrays.toString(ki) + " ");
            general();
            System.out.println(Arrays.toString(ki));
        } else {
            throw new RuntimeException("Rossz szál darabszám!");
        }
    }

    public Szal[] getBe() {
        return be;
    }

    public Szal[] getKi() {
        general();
        return ki;
    }

    public Csomo[] getCsomok() {
        return csomok;
    }

    public int getKimaradoSzal() {
        return kimaradoSzal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (Csomo cs : csomok) {
            sb.append(cs.toString()).append("\t");
        }
        
        return sb.toString();
    }
    
    abstract void init();
    
}
