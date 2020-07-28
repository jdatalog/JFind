/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_raw_crop_t extends Structure<libraw_raw_crop_t, libraw_raw_crop_t.ByValue, libraw_raw_crop_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_raw_crop_t extends Structure {

    /**
     * C type : ushort
     */
    public short cleft;
    /**
     * C type : ushort
     */
    public short ctop;
    /**
     * C type : ushort
     */
    public short cwidth;
    /**
     * C type : ushort
     */
    public short cheight;

    public libraw_raw_crop_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("cleft", "ctop", "cwidth", "cheight");
    }

    /**
     * @param cleft C type : ushort<br>
     * @param ctop C type : ushort<br>
     * @param cwidth C type : ushort<br>
     * @param cheight C type : ushort
     */
    public libraw_raw_crop_t(short cleft, short ctop, short cwidth, short cheight) {
        super();
        this.cleft = cleft;
        this.ctop = ctop;
        this.cwidth = cwidth;
        this.cheight = cheight;
    }

    public libraw_raw_crop_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_raw_crop_t newInstance() {
        return new libraw_raw_crop_t();
    }
//	public static libraw_raw_crop_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_raw_crop_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_raw_crop_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_raw_crop_t implements Structure.ByValue {

    };
}
