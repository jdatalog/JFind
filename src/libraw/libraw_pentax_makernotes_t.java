/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_pentax_makernotes_t extends Structure<libraw_pentax_makernotes_t, libraw_pentax_makernotes_t.ByValue, libraw_pentax_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_pentax_makernotes_t extends Structure {

    /**
     * C type : ushort
     */
    public short FocusMode;
    /**
     * C type : ushort
     */
    public short AFPointSelected;
    public int AFPointsInFocus;
    /**
     * C type : ushort
     */
    public short FocusPosition;
    /**
     * C type : uchar[4]
     */
    public byte[] DriveMode = new byte[4];
    public short AFAdjustment;

    public libraw_pentax_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("FocusMode", "AFPointSelected", "AFPointsInFocus", "FocusPosition", "DriveMode", "AFAdjustment");
    }

    /**
     * @param FocusMode C type : ushort<br>
     * @param AFPointSelected C type : ushort<br>
     * @param FocusPosition C type : ushort<br>
     * @param DriveMode C type : uchar[4]
     */
    public libraw_pentax_makernotes_t(short FocusMode, short AFPointSelected, int AFPointsInFocus, short FocusPosition, byte DriveMode[], short AFAdjustment) {
        super();
        this.FocusMode = FocusMode;
        this.AFPointSelected = AFPointSelected;
        this.AFPointsInFocus = AFPointsInFocus;
        this.FocusPosition = FocusPosition;
        if ((DriveMode.length != this.DriveMode.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.DriveMode = DriveMode;
        this.AFAdjustment = AFAdjustment;
    }

    public libraw_pentax_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_pentax_makernotes_t newInstance() {
        return new libraw_pentax_makernotes_t();
    }
//	public static libraw_pentax_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_pentax_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_pentax_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_pentax_makernotes_t implements Structure.ByValue {

    };
}
