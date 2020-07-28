/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_output_params_t extends Structure<libraw_output_params_t, libraw_output_params_t.ByValue, libraw_output_params_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

public class libraw_output_params_t extends Structure {

    /**
     * -A x1 y1 x2 y2<br>
     * C type : unsigned[4]
     */
    public int[] greybox = new int[4];
    /**
     * -B x1 y1 x2 y2<br>
     * C type : unsigned[4]
     */
    public int[] cropbox = new int[4];
    /**
     * -C<br>
     * C type : double[4]
     */
    public double[] aber = new double[4];
    /**
     * -g<br>
     * C type : double[6]
     */
    public double[] gamm = new double[6];
    /**
     * -r mul0 mul1 mul2 mul3<br>
     * C type : float[4]
     */
    public float[] user_mul = new float[4];
    /**
     * -s
     */
    public int shot_select;
    /**
     * -b
     */
    public float bright;
    /**
     * -n
     */
    public float threshold;
    /**
     * -h
     */
    public int half_size;
    /**
     * -f
     */
    public int four_color_rgb;
    /**
     * -H
     */
    public int highlight;
    /**
     * -a
     */
    public int use_auto_wb;
    /**
     * -w
     */
    public int use_camera_wb;
    /**
     * +M/-M
     */
    public int use_camera_matrix;
    /**
     * -o
     */
    public int output_color;
    /**
     * -o<br>
     * C type : char*
     */
    public Pointer output_profile;
    /**
     * -p<br>
     * C type : char*
     */
    public Pointer camera_profile;
    /**
     * -P<br>
     * C type : char*
     */
    public Pointer bad_pixels;
    /**
     * -K<br>
     * C type : char*
     */
    public Pointer dark_frame;
    /**
     * -4
     */
    public int output_bps;
    /**
     * -T
     */
    public int output_tiff;
    /**
     * -t
     */
    public int user_flip;
    /**
     * -q
     */
    public int user_qual;
    /**
     * -k
     */
    public int user_black;
    /**
     * C type : int[4]
     */
    public int[] user_cblack = new int[4];
    /**
     * -S
     */
    public int user_sat;
    /**
     * -m
     */
    public int med_passes;
    public float auto_bright_thr;
    public float adjust_maximum_thr;
    /**
     * -W
     */
    public int no_auto_bright;
    /**
     * -j
     */
    public int use_fuji_rotate;
    public int green_matching;
    public int dcb_iterations;
    public int dcb_enhance_fl;
    public int fbdd_noiserd;
    public int exp_correc;
    public float exp_shift;
    public float exp_preser;
    public int use_rawspeed;
    public int use_dngsdk;
    public int no_auto_scale;
    public int no_interpolation;
    public int raw_processing_options;
    public int sony_arw2_posterization_thr;
    public float coolscan_nef_gamma;
    /**
     * C type : char[5]
     */
    public byte[] p4shot_order = new byte[5];
    /**
     * C type : char**
     */
    public PointerByReference custom_camera_strings;

    public libraw_output_params_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("greybox", "cropbox", "aber", "gamm", "user_mul", "shot_select", "bright", "threshold", "half_size", "four_color_rgb", "highlight", "use_auto_wb", "use_camera_wb", "use_camera_matrix", "output_color", "output_profile", "camera_profile", "bad_pixels", "dark_frame", "output_bps", "output_tiff", "user_flip", "user_qual", "user_black", "user_cblack", "user_sat", "med_passes", "auto_bright_thr", "adjust_maximum_thr", "no_auto_bright", "use_fuji_rotate", "green_matching", "dcb_iterations", "dcb_enhance_fl", "fbdd_noiserd", "exp_correc", "exp_shift", "exp_preser", "use_rawspeed", "use_dngsdk", "no_auto_scale", "no_interpolation", "raw_processing_options", "sony_arw2_posterization_thr", "coolscan_nef_gamma", "p4shot_order", "custom_camera_strings");
    }

    public libraw_output_params_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_output_params_t newInstance() {
        return new libraw_output_params_t();
    }
//	public static libraw_output_params_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_output_params_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_output_params_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_output_params_t implements Structure.ByValue {

    };
}
