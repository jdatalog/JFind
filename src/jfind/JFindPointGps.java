/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jfind;

import datalog.coord.PointSimple;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author christophe gaillard
 */
public class JFindPointGps extends PointSimple {
    
    public  JFindPointGps( GregorianCalendar d, double la, double lo) {
         super( d, la, lo);
     }
     
     public String getInfos() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat shf = new SimpleDateFormat("HH:mm:ss");

         return sdf.format(this.getGCDate().getTime()) +"-" +shf.format(this.getGCDate().getTime());
     }

}
