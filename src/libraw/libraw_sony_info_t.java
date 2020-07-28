/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_sony_info_t extends Structure<libraw_sony_info_t, libraw_sony_info_t.ByValue, libraw_sony_info_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_sony_info_t extends Structure {

    /**
     * C type : ushort
     */
    public short SonyCameraType;
    /**
     * 0 if not found/deciphered, 0xa, 0xb, 0xc following exiftool
     * convention<br>
     * C type : uchar
     */
    public byte Sony0x9400_version;
    /**
     * C type : uchar
     */
    public byte Sony0x9400_ReleaseMode2;
    public int Sony0x9400_SequenceImageNumber;
    /**
     * C type : uchar
     */
    public byte Sony0x9400_SequenceLength1;
    public int Sony0x9400_SequenceFileNumber;
    /**
     * C type : uchar
     */
    public byte Sony0x9400_SequenceLength2;
    /**
     * C type : libraw_raw_crop_t
     */
    public libraw_raw_crop_t raw_crop;
    public byte AFMicroAdjValue;
    public byte AFMicroAdjOn;
    /**
     * C type : uchar
     */
    public byte AFMicroAdjRegisteredLenses;
    /**
     * C type : ushort
     */
    public short group2010;
    /**
     * C type : ushort
     */
    public short real_iso_offset;
    public float firmware;
    /**
     * C type : ushort
     */
    public short ImageCount3_offset;
    public int ImageCount3;
    public int ElectronicFrontCurtainShutter;
    /**
     * C type : ushort
     */
    public short MeteringMode2;
    /**
     * C type : char[20]
     */
    public byte[] SonyDateTime = new byte[20];
    /**
     * C type : uchar[6]
     */
    public byte[] TimeStamp = new byte[6];
    public int ShotNumberSincePowerUp;

    public libraw_sony_info_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("SonyCameraType", "Sony0x9400_version", "Sony0x9400_ReleaseMode2", "Sony0x9400_SequenceImageNumber", "Sony0x9400_SequenceLength1", "Sony0x9400_SequenceFileNumber", "Sony0x9400_SequenceLength2", "raw_crop", "AFMicroAdjValue", "AFMicroAdjOn", "AFMicroAdjRegisteredLenses", "group2010", "real_iso_offset", "firmware", "ImageCount3_offset", "ImageCount3", "ElectronicFrontCurtainShutter", "MeteringMode2", "SonyDateTime", "TimeStamp", "ShotNumberSincePowerUp");
    }

    public libraw_sony_info_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_sony_info_t newInstance() {
        return new libraw_sony_info_t();
    }
//	public static libraw_sony_info_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_sony_info_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_sony_info_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_sony_info_t implements Structure.ByValue {

    };
}
