/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_dng_color_t extends Structure<libraw_dng_color_t, libraw_dng_color_t.ByValue, libraw_dng_color_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_dng_color_t extends Structure {

    public int parsedfields;
    /**
     * C type : ushort
     */
    public short illuminant;
    /**
     * C type : float[4][4]
     */
    public float[] calibration = new float[((4) * (4))];
    /**
     * C type : float[4][3]
     */
    public float[] colormatrix = new float[((4) * (3))];
    /**
     * C type : float[3][4]
     */
    public float[] forwardmatrix = new float[((3) * (4))];

    public libraw_dng_color_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("parsedfields", "illuminant", "calibration", "colormatrix", "forwardmatrix");
    }

    /**
     * @param illuminant C type : ushort<br>
     * @param calibration C type : float[4][4]<br>
     * @param colormatrix C type : float[4][3]<br>
     * @param forwardmatrix C type : float[3][4]
     */
    public libraw_dng_color_t(int parsedfields, short illuminant, float calibration[], float colormatrix[], float forwardmatrix[]) {
        super();
        this.parsedfields = parsedfields;
        this.illuminant = illuminant;
        if ((calibration.length != this.calibration.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.calibration = calibration;
        if ((colormatrix.length != this.colormatrix.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.colormatrix = colormatrix;
        if ((forwardmatrix.length != this.forwardmatrix.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.forwardmatrix = forwardmatrix;
    }

    public libraw_dng_color_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_dng_color_t newInstance() {
        return new libraw_dng_color_t();
    }
//	public static libraw_dng_color_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_dng_color_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_dng_color_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_dng_color_t implements Structure.ByValue {

    };
}
