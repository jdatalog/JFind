/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

//public class libraw_image_sizes_t extends Structure<libraw_image_sizes_t, libraw_image_sizes_t.ByValue, libraw_image_sizes_t.ByReference > {
public class libraw_image_sizes_t extends Structure {

    /**
     * C type : ushort
     */
    public short raw_height;
    /**
     * C type : ushort
     */
    public short raw_width;
    /**
     * C type : ushort
     */
    public short height;
    /**
     * C type : ushort
     */
    public short width;
    /**
     * C type : ushort
     */
    public short top_margin;
    /**
     * C type : ushort
     */
    public short left_margin;
    /**
     * C type : ushort
     */
    public short iheight;
    /**
     * C type : ushort
     */
    public short iwidth;
    public int raw_pitch;
    public double pixel_aspect;
    public int flip;
    /**
     * C type : int[8][4]
     */
    public int[] mask = new int[((8) * (4))];
    /**
     * C type : libraw_raw_crop_t
     */
    public libraw_raw_crop_t raw_crop;

    public libraw_image_sizes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("raw_height", "raw_width", "height", "width", "top_margin", "left_margin", "iheight", "iwidth", "raw_pitch", "pixel_aspect", "flip", "mask", "raw_crop");
    }

    public libraw_image_sizes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_image_sizes_t newInstance() {
        return new libraw_image_sizes_t();
    }
//	public static libraw_image_sizes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_image_sizes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_image_sizes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_image_sizes_t implements Structure.ByValue {

    };
}
