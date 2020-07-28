/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_olympus_makernotes_t extends Structure<libraw_olympus_makernotes_t, libraw_olympus_makernotes_t.ByValue, libraw_olympus_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_olympus_makernotes_t extends Structure {

    public int OlympusCropID;
    /**
     * upper left XY, lower right XY<br>
     * C type : ushort[4]
     */
    public short[] OlympusFrame = new short[4];
    /**
     * C type : int[2]
     */
    public int[] OlympusSensorCalibration = new int[2];
    /**
     * C type : ushort[2]
     */
    public short[] FocusMode = new short[2];
    /**
     * C type : ushort
     */
    public short AutoFocus;
    /**
     * C type : ushort
     */
    public short AFPoint;
    /**
     * C type : unsigned[64]
     */
    public int[] AFAreas = new int[64];
    /**
     * C type : double[5]
     */
    public double[] AFPointSelected = new double[5];
    /**
     * C type : ushort
     */
    public short AFResult;
    public int ImageStabilization;
    /**
     * C type : ushort
     */
    public short ColorSpace;
    /**
     * C type : uchar
     */
    public byte AFFineTune;
    /**
     * C type : short[3]
     */
    public short[] AFFineTuneAdj = new short[3];

    public libraw_olympus_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("OlympusCropID", "OlympusFrame", "OlympusSensorCalibration", "FocusMode", "AutoFocus", "AFPoint", "AFAreas", "AFPointSelected", "AFResult", "ImageStabilization", "ColorSpace", "AFFineTune", "AFFineTuneAdj");
    }

    public libraw_olympus_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_olympus_makernotes_t newInstance() {
        return new libraw_olympus_makernotes_t();
    }
//	public static libraw_olympus_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_olympus_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_olympus_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_olympus_makernotes_t implements Structure.ByValue {

    };
}
