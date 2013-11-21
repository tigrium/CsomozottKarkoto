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
public class Szal {
    public String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
