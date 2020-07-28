/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfind;

import datalog.coord.GeoidCorrection;
import datalog.coord.Log;
import mnt.Altitude;

/**
 *
 * @author christophe gaillard
 */
public class JFindGpsLog extends Log {

    public JFindGpsLog(GeoidCorrection r, Altitude a) {
        super(r, false, a);
    }
}
