package jfind;


import datalog.coord.PointSimple;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.GregorianCalendar;

/**
 *
 * @author tophe
 */
public class PointGpsExif extends PointSimple {

    private String infos = null;

    public PointGpsExif(GregorianCalendar d, double la, double lo, String i) {
        super(d, la, lo);
        this.infos = i;
    }

    public String getInfos() {
        return infos;
    }
}
