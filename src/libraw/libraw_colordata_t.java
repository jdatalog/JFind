/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_colordata_t extends Structure<libraw_colordata_t, libraw_colordata_t.ByValue, libraw_colordata_t.ByReference > {
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_colordata_t extends Structure {

    /**
     * C type : ushort[0x10000]
     */
    public short[] curve = new short[0x10000];
    /**
     * C type : unsigned[4102]
     */
    public int[] cblack = new int[4102];
    public int black;
    public int data_maximum;
    public int maximum;
    /**
     * C type : long[4]
     */
    public NativeLong[] linear_max = new NativeLong[4];
    public float fmaximum;
    public float fnorm;
    /**
     * C type : ushort[8][8]
     */
    public short[] white = new short[((8) * (8))];
    /**
     * C type : float[4]
     */
    public float[] cam_mul = new float[4];
    /**
     * C type : float[4]
     */
    public float[] pre_mul = new float[4];
    /**
     * C type : float[3][4]
     */
    public float[] cmatrix = new float[((3) * (4))];
    /**
     * C type : float[3][4]
     */
    public float[] ccm = new float[((3) * (4))];
    /**
     * C type : float[3][4]
     */
    public float[] rgb_cam = new float[((3) * (4))];
    /**
     * C type : float[4][3]
     */
    public float[] cam_xyz = new float[((4) * (3))];
    /**
     * C type : ph1_t
     */
    public ph1_t phase_one_data;
    public float flash_used;
    public float canon_ev;
    /**
     * C type : char[64]
     */
    public byte[] model2 = new byte[64];
    /**
     * C type : char[64]
     */
    public byte[] UniqueCameraModel = new byte[64];
    /**
     * C type : char[64]
     */
    public byte[] LocalizedCameraModel = new byte[64];
    /**
     * C type : void*
     */
    public Pointer profile;
    public int profile_length;
    /**
     * C type : unsigned[8]
     */
    public int[] black_stat = new int[8];
    /**
     * C type : libraw_dng_color_t[2]
     */
    public libraw_dng_color_t[] dng_color = new libraw_dng_color_t[2];
    /**
     * C type : libraw_dng_levels_t
     */
    public libraw_dng_levels_t dng_levels;
    public float baseline_exposure;
    /**
     * R, G1, B, G2 coeffs<br>
     * C type : int[256][4]
     */
    public int[] WB_Coeffs = new int[((256) * (4))];
    /**
     * CCT, than R, G1, B, G2 coeffs<br>
     * C type : float[64][5]
     */
    public float[] WBCT_Coeffs = new float[((64) * (5))];
    /**
     * C type : libraw_P1_color_t[2]
     */
    public libraw_P1_color_t[] P1_color = new libraw_P1_color_t[2];

    public libraw_colordata_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("curve", "cblack", "black", "data_maximum", "maximum", "linear_max", "fmaximum", "fnorm", "white", "cam_mul", "pre_mul", "cmatrix", "ccm", "rgb_cam", "cam_xyz", "phase_one_data", "flash_used", "canon_ev", "model2", "UniqueCameraModel", "LocalizedCameraModel", "profile", "profile_length", "black_stat", "dng_color", "dng_levels", "baseline_exposure", "WB_Coeffs", "WBCT_Coeffs", "P1_color");
    }

    public libraw_colordata_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_colordata_t newInstance() {
        return new libraw_colordata_t();
    }
//	public static libraw_colordata_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_colordata_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_colordata_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_colordata_t implements Structure.ByValue {

    };
}
