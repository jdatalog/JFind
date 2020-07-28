/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_nikon_makernotes_t extends Structure<libraw_nikon_makernotes_t, libraw_nikon_makernotes_t.ByValue, libraw_nikon_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_nikon_makernotes_t extends Structure {

    public double ExposureBracketValue;
    /**
     * C type : ushort
     */
    public short ActiveDLighting;
    /**
     * C type : ushort
     */
    public short ShootingMode;
    /**
     * C type : uchar[7]
     */
    public byte[] ImageStabilization = new byte[7];
    /**
     * C type : uchar
     */
    public byte VibrationReduction;
    /**
     * C type : uchar
     */
    public byte VRMode;
    /**
     * C type : char[7]
     */
    public byte[] FocusMode = new byte[7];
    /**
     * C type : uchar
     */
    public byte AFPoint;
    /**
     * C type : ushort
     */
    public short AFPointsInFocus;
    /**
     * C type : uchar
     */
    public byte ContrastDetectAF;
    /**
     * C type : uchar
     */
    public byte AFAreaMode;
    /**
     * C type : uchar
     */
    public byte PhaseDetectAF;
    /**
     * C type : uchar
     */
    public byte PrimaryAFPoint;
    /**
     * C type : uchar[29]
     */
    public byte[] AFPointsUsed = new byte[29];
    /**
     * C type : ushort
     */
    public short AFImageWidth;
    /**
     * C type : ushort
     */
    public short AFImageHeight;
    /**
     * C type : ushort
     */
    public short AFAreaXPposition;
    /**
     * C type : ushort
     */
    public short AFAreaYPosition;
    /**
     * C type : ushort
     */
    public short AFAreaWidth;
    /**
     * C type : ushort
     */
    public short AFAreaHeight;
    /**
     * C type : uchar
     */
    public byte ContrastDetectAFInFocus;
    /**
     * C type : char[13]
     */
    public byte[] FlashSetting = new byte[13];
    /**
     * C type : char[20]
     */
    public byte[] FlashType = new byte[20];
    /**
     * C type : uchar[4]
     */
    public byte[] FlashExposureCompensation = new byte[4];
    /**
     * C type : uchar[4]
     */
    public byte[] ExternalFlashExposureComp = new byte[4];
    /**
     * C type : uchar[4]
     */
    public byte[] FlashExposureBracketValue = new byte[4];
    /**
     * C type : uchar
     */
    public byte FlashMode;
    public byte FlashExposureCompensation2;
    public byte FlashExposureCompensation3;
    public byte FlashExposureCompensation4;
    /**
     * C type : uchar
     */
    public byte FlashSource;
    /**
     * C type : uchar[2]
     */
    public byte[] FlashFirmware = new byte[2];
    /**
     * C type : uchar
     */
    public byte ExternalFlashFlags;
    /**
     * C type : uchar
     */
    public byte FlashControlCommanderMode;
    /**
     * C type : uchar
     */
    public byte FlashOutputAndCompensation;
    /**
     * C type : uchar
     */
    public byte FlashFocalLength;
    /**
     * C type : uchar
     */
    public byte FlashGNDistance;
    /**
     * C type : uchar[4]
     */
    public byte[] FlashGroupControlMode = new byte[4];
    /**
     * C type : uchar[4]
     */
    public byte[] FlashGroupOutputAndCompensation = new byte[4];
    /**
     * C type : uchar
     */
    public byte FlashColorFilter;
    /**
     * C type : ushort
     */
    public short NEFCompression;
    public int ExposureMode;
    public int nMEshots;
    public int MEgainOn;
    /**
     * C type : double[4]
     */
    public double[] ME_WB = new double[4];
    /**
     * C type : uchar
     */
    public byte AFFineTune;
    /**
     * C type : uchar
     */
    public byte AFFineTuneIndex;
    public byte AFFineTuneAdj;

    public libraw_nikon_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("ExposureBracketValue", "ActiveDLighting", "ShootingMode", "ImageStabilization", "VibrationReduction", "VRMode", "FocusMode", "AFPoint", "AFPointsInFocus", "ContrastDetectAF", "AFAreaMode", "PhaseDetectAF", "PrimaryAFPoint", "AFPointsUsed", "AFImageWidth", "AFImageHeight", "AFAreaXPposition", "AFAreaYPosition", "AFAreaWidth", "AFAreaHeight", "ContrastDetectAFInFocus", "FlashSetting", "FlashType", "FlashExposureCompensation", "ExternalFlashExposureComp", "FlashExposureBracketValue", "FlashMode", "FlashExposureCompensation2", "FlashExposureCompensation3", "FlashExposureCompensation4", "FlashSource", "FlashFirmware", "ExternalFlashFlags", "FlashControlCommanderMode", "FlashOutputAndCompensation", "FlashFocalLength", "FlashGNDistance", "FlashGroupControlMode", "FlashGroupOutputAndCompensation", "FlashColorFilter", "NEFCompression", "ExposureMode", "nMEshots", "MEgainOn", "ME_WB", "AFFineTune", "AFFineTuneIndex", "AFFineTuneAdj");
    }

    public libraw_nikon_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_nikon_makernotes_t newInstance() {
        return new libraw_nikon_makernotes_t();
    }
//	public static libraw_nikon_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_nikon_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_nikon_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_nikon_makernotes_t implements Structure.ByValue {

    };
}
