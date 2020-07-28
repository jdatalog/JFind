/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_fuji_info_t extends Structure<libraw_fuji_info_t, libraw_fuji_info_t.ByValue, libraw_fuji_info_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_fuji_info_t extends Structure {

    public float FujiExpoMidPointShift;
    /**
     * C type : ushort
     */
    public short FujiDynamicRange;
    /**
     * C type : ushort
     */
    public short FujiFilmMode;
    /**
     * C type : ushort
     */
    public short FujiDynamicRangeSetting;
    /**
     * C type : ushort
     */
    public short FujiDevelopmentDynamicRange;
    /**
     * C type : ushort
     */
    public short FujiAutoDynamicRange;
    /**
     * C type : ushort
     */
    public short FocusMode;
    /**
     * C type : ushort
     */
    public short AFMode;
    /**
     * C type : ushort[2]
     */
    public short[] FocusPixel = new short[2];
    /**
     * C type : ushort[3]
     */
    public short[] ImageStabilization = new short[3];
    /**
     * C type : ushort
     */
    public short FlashMode;
    /**
     * C type : ushort
     */
    public short WB_Preset;
    /**
     * C type : ushort
     */
    public short ShutterType;
    /**
     * C type : ushort
     */
    public short ExrMode;
    /**
     * C type : ushort
     */
    public short Macro;
    public int Rating;
    /**
     * C type : ushort
     */
    public short FrameRate;
    /**
     * C type : ushort
     */
    public short FrameWidth;
    /**
     * C type : ushort
     */
    public short FrameHeight;

    public libraw_fuji_info_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("FujiExpoMidPointShift", "FujiDynamicRange", "FujiFilmMode", "FujiDynamicRangeSetting", "FujiDevelopmentDynamicRange", "FujiAutoDynamicRange", "FocusMode", "AFMode", "FocusPixel", "ImageStabilization", "FlashMode", "WB_Preset", "ShutterType", "ExrMode", "Macro", "Rating", "FrameRate", "FrameWidth", "FrameHeight");
    }

    public libraw_fuji_info_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_fuji_info_t newInstance() {
        return new libraw_fuji_info_t();
    }
//	public static libraw_fuji_info_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_fuji_info_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_fuji_info_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_fuji_info_t implements Structure.ByValue {

    };
}
