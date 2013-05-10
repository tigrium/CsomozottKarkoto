/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.data;

import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author Kata
 */
public class Szal {
    public final String id;
    private Color szin;

    public Szal(String id, Color szin) {
        this.id = id;
        this.szin = szin;
    }

    public Color getSzin() {
        return szin;
    }

    public void setSzin(Color szin) {
        this.szin = szin;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
