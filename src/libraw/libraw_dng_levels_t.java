/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_dng_levels_t extends Structure<libraw_dng_levels_t, libraw_dng_levels_t.ByValue, libraw_dng_levels_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_dng_levels_t extends Structure {

    public int parsedfields;
    /**
     * C type : unsigned[4102]
     */
    public int[] dng_cblack = new int[4102];
    public int dng_black;
    /**
     * C type : unsigned[4]
     */
    public int[] dng_whitelevel = new int[4];
    /**
     * Origin and size<br>
     * C type : unsigned[4]
     */
    public int[] default_crop = new int[4];
    public int preview_colorspace;
    /**
     * C type : float[4]
     */
    public float[] analogbalance = new float[4];

    public libraw_dng_levels_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("parsedfields", "dng_cblack", "dng_black", "dng_whitelevel", "default_crop", "preview_colorspace", "analogbalance");
    }

    /**
     * @param dng_cblack C type : unsigned[4102]<br>
     * @param dng_whitelevel C type : unsigned[4]<br>
     * @param default_crop Origin and size<br>
     * C type : unsigned[4]<br>
     * @param analogbalance C type : float[4]
     */
    public libraw_dng_levels_t(int parsedfields, int dng_cblack[], int dng_black, int dng_whitelevel[], int default_crop[], int preview_colorspace, float analogbalance[]) {
        super();
        this.parsedfields = parsedfields;
        if ((dng_cblack.length != this.dng_cblack.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.dng_cblack = dng_cblack;
        this.dng_black = dng_black;
        if ((dng_whitelevel.length != this.dng_whitelevel.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.dng_whitelevel = dng_whitelevel;
        if ((default_crop.length != this.default_crop.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.default_crop = default_crop;
        this.preview_colorspace = preview_colorspace;
        if ((analogbalance.length != this.analogbalance.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.analogbalance = analogbalance;
    }

    public libraw_dng_levels_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_dng_levels_t newInstance() {
        return new libraw_dng_levels_t();
    }

//    public static libraw_dng_levels_t[] newArray(int arrayLength) {
//        return Structure.newArray(libraw_dng_levels_t.class, arrayLength);
//    }
    public static class ByReference extends libraw_dng_levels_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_dng_levels_t implements Structure.ByValue {

    };
}
