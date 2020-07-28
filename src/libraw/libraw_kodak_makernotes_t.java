/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_kodak_makernotes_t extends Structure<libraw_kodak_makernotes_t, libraw_kodak_makernotes_t.ByValue, libraw_kodak_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_kodak_makernotes_t extends Structure {

    /**
     * C type : ushort
     */
    public short BlackLevelTop;
    /**
     * C type : ushort
     */
    public short BlackLevelBottom;
    /**
     * KDC files, negative values or zeros
     */
    public short offset_left;
    /**
     * KDC files, negative values or zeros
     */
    public short offset_top;
    /**
     * valid for P712, P850, P880<br>
     * C type : ushort
     */
    public short clipBlack;
    /**
     * valid for P712, P850, P880<br>
     * C type : ushort
     */
    public short clipWhite;
    /**
     * C type : float[3][3]
     */
    public float[] romm_camDaylight = new float[((3) * (3))];
    /**
     * C type : float[3][3]
     */
    public float[] romm_camTungsten = new float[((3) * (3))];
    /**
     * C type : float[3][3]
     */
    public float[] romm_camFluorescent = new float[((3) * (3))];
    /**
     * C type : float[3][3]
     */
    public float[] romm_camFlash = new float[((3) * (3))];
    /**
     * C type : float[3][3]
     */
    public float[] romm_camCustom = new float[((3) * (3))];
    /**
     * C type : float[3][3]
     */
    public float[] romm_camAuto = new float[((3) * (3))];

    public libraw_kodak_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("BlackLevelTop", "BlackLevelBottom", "offset_left", "offset_top", "clipBlack", "clipWhite", "romm_camDaylight", "romm_camTungsten", "romm_camFluorescent", "romm_camFlash", "romm_camCustom", "romm_camAuto");
    }

    public libraw_kodak_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_kodak_makernotes_t newInstance() {
        return new libraw_kodak_makernotes_t();
    }
//	public static libraw_kodak_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_kodak_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_kodak_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_kodak_makernotes_t implements Structure.ByValue {

    };
}
