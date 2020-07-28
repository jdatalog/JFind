/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_gps_info_t extends Structure<libraw_gps_info_t, libraw_gps_info_t.ByValue, libraw_gps_info_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_gps_info_t extends Structure {

    /**
     * Deg,min,sec<br>
     * C type : float[3]
     */
    public float[] latitude = new float[3];
    /**
     * Deg,min,sec<br>
     * C type : float[3]
     */
    public float[] longtitude = new float[3];
    /**
     * Deg,min,sec<br>
     * C type : float[3]
     */
    public float[] gpstimestamp = new float[3];
    public float altitude;
    public byte altref;
    public byte latref;
    public byte longref;
    public byte gpsstatus;
    public byte gpsparsed;

    public libraw_gps_info_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("latitude", "longtitude", "gpstimestamp", "altitude", "altref", "latref", "longref", "gpsstatus", "gpsparsed");
    }

    /**
     * @param latitude Deg,min,sec<br>
     * C type : float[3]<br>
     * @param longtitude Deg,min,sec<br>
     * C type : float[3]<br>
     * @param gpstimestamp Deg,min,sec<br>
     * C type : float[3]
     */
    public libraw_gps_info_t(float latitude[], float longtitude[], float gpstimestamp[], float altitude, byte altref, byte latref, byte longref, byte gpsstatus, byte gpsparsed) {
        super();
        if ((latitude.length != this.latitude.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.latitude = latitude;
        if ((longtitude.length != this.longtitude.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.longtitude = longtitude;
        if ((gpstimestamp.length != this.gpstimestamp.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.gpstimestamp = gpstimestamp;
        this.altitude = altitude;
        this.altref = altref;
        this.latref = latref;
        this.longref = longref;
        this.gpsstatus = gpsstatus;
        this.gpsparsed = gpsparsed;
    }

    public libraw_gps_info_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_gps_info_t newInstance() {
        return new libraw_gps_info_t();
    }
//	public static libraw_gps_info_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_gps_info_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_gps_info_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_gps_info_t implements Structure.ByValue {

    };
}
