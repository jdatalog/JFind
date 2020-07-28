/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_canon_makernotes_t extends Structure<libraw_canon_makernotes_t, libraw_canon_makernotes_t.ByValue, libraw_canon_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_canon_makernotes_t extends Structure {

    public int CanonColorDataVer;
    public int CanonColorDataSubVer;
    public int SpecularWhiteLevel;
    public int NormalWhiteLevel;
    /**
     * C type : int[4]
     */
    public int[] ChannelBlackLevel = new int[4];
    public int AverageBlackLevel;
    /**
     * C type : unsigned int[4]
     */
    public int[] multishot = new int[4];
    public short MeteringMode;
    public short SpotMeteringMode;
    /**
     * C type : uchar
     */
    public byte FlashMeteringMode;
    public short FlashExposureLock;
    public short ExposureMode;
    public short AESetting;
    /**
     * C type : uchar
     */
    public byte HighlightTonePriority;
    public short ImageStabilization;
    public short FocusMode;
    public short AFPoint;
    public short FocusContinuous;
    public short AFPointsInFocus30D;
    /**
     * C type : uchar[8]
     */
    public byte[] AFPointsInFocus1D = new byte[8];
    /**
     * bytes in reverse<br>
     * C type : ushort
     */
    public short AFPointsInFocus5D;
    /**
     * C type : ushort
     */
    public short AFAreaMode;
    /**
     * C type : ushort
     */
    public short NumAFPoints;
    /**
     * C type : ushort
     */
    public short ValidAFPoints;
    /**
     * C type : ushort
     */
    public short AFImageWidth;
    /**
     * C type : ushort
     */
    public short AFImageHeight;
    /**
     * cycle to NumAFPoints<br>
     * C type : short[61]
     */
    public short[] AFAreaWidths = new short[61];
    /**
     * --''--<br>
     * C type : short[61]
     */
    public short[] AFAreaHeights = new short[61];
    /**
     * --''--<br>
     * C type : short[61]
     */
    public short[] AFAreaXPositions = new short[61];
    /**
     * --''--<br>
     * C type : short[61]
     */
    public short[] AFAreaYPositions = new short[61];
    /**
     * cycle to floor((NumAFPoints+15)/16)<br>
     * C type : short[4]
     */
    public short[] AFPointsInFocus = new short[4];
    /**
     * --''--<br>
     * C type : short[4]
     */
    public short[] AFPointsSelected = new short[4];
    /**
     * C type : ushort
     */
    public short PrimaryAFPoint;
    public short FlashMode;
    public short FlashActivity;
    public short FlashBits;
    public short ManualFlashOutput;
    public short FlashOutput;
    public short FlashGuideNumber;
    public short ContinuousDrive;
    public short SensorWidth;
    public short SensorHeight;
    public short SensorLeftBorder;
    public short SensorTopBorder;
    public short SensorRightBorder;
    public short SensorBottomBorder;
    public short BlackMaskLeftBorder;
    public short BlackMaskTopBorder;
    public short BlackMaskRightBorder;
    public short BlackMaskBottomBorder;
    public int AFMicroAdjMode;
    public float AFMicroAdjValue;

    public libraw_canon_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("CanonColorDataVer", "CanonColorDataSubVer", "SpecularWhiteLevel", "NormalWhiteLevel", "ChannelBlackLevel", "AverageBlackLevel", "multishot", "MeteringMode", "SpotMeteringMode", "FlashMeteringMode", "FlashExposureLock", "ExposureMode", "AESetting", "HighlightTonePriority", "ImageStabilization", "FocusMode", "AFPoint", "FocusContinuous", "AFPointsInFocus30D", "AFPointsInFocus1D", "AFPointsInFocus5D", "AFAreaMode", "NumAFPoints", "ValidAFPoints", "AFImageWidth", "AFImageHeight", "AFAreaWidths", "AFAreaHeights", "AFAreaXPositions", "AFAreaYPositions", "AFPointsInFocus", "AFPointsSelected", "PrimaryAFPoint", "FlashMode", "FlashActivity", "FlashBits", "ManualFlashOutput", "FlashOutput", "FlashGuideNumber", "ContinuousDrive", "SensorWidth", "SensorHeight", "SensorLeftBorder", "SensorTopBorder", "SensorRightBorder", "SensorBottomBorder", "BlackMaskLeftBorder", "BlackMaskTopBorder", "BlackMaskRightBorder", "BlackMaskBottomBorder", "AFMicroAdjMode", "AFMicroAdjValue");
    }

    public libraw_canon_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_canon_makernotes_t newInstance() {
        return new libraw_canon_makernotes_t();
    }
//	public static libraw_canon_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_canon_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_canon_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_canon_makernotes_t implements Structure.ByValue {

    };
}
