/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_rawdata_t extends Structure<libraw_rawdata_t, libraw_rawdata_t.ByValue, libraw_rawdata_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.ShortByReference;
import java.util.Arrays;
import java.util.List;

public class libraw_rawdata_t extends Structure {

    /**
     * C type : void*
     */
    public Pointer raw_alloc;
    /**
     * C type : ushort*
     */
    public ShortByReference raw_image;
    /**
     * C type : ushort[4]*
     */
    public Pointer color4_image;
    /**
     * C type : ushort[3]*
     */
    public Pointer color3_image;
    /**
     * C type : float*
     */
    public FloatByReference float_image;
    /**
     * C type : float[3]*
     */
    public Pointer float3_image;
    /**
     * C type : float[4]*
     */
    public Pointer float4_image;
    /**
     * C type : short[2]*
     */
    public Pointer ph1_cblack;
    /**
     * C type : short[2]*
     */
    public Pointer ph1_rblack;
    /**
     * C type : libraw_iparams_t
     */
    public libraw_iparams_t iparams;
    /**
     * C type : libraw_image_sizes_t
     */
    public libraw_image_sizes_t sizes;
    /**
     * C type : libraw_internal_output_params_t
     */
    public libraw_internal_output_params_t ioparams;
    /**
     * C type : libraw_colordata_t
     */
    public libraw_colordata_t color;

    public libraw_rawdata_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("raw_alloc", "raw_image", "color4_image", "color3_image", "float_image", "float3_image", "float4_image", "ph1_cblack", "ph1_rblack", "iparams", "sizes", "ioparams", "color");
    }

    public libraw_rawdata_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_rawdata_t newInstance() {
        return new libraw_rawdata_t();
    }
//	public static libraw_rawdata_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_rawdata_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_rawdata_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_rawdata_t implements Structure.ByValue {

    };
}
