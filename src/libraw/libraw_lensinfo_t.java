/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_lensinfo_t extends Structure<libraw_lensinfo_t, libraw_lensinfo_t.ByValue, libraw_lensinfo_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_lensinfo_t extends Structure {

    public float MinFocal;
    public float MaxFocal;
    public float MaxAp4MinFocal;
    public float MaxAp4MaxFocal;
    public float EXIF_MaxAp;
    /**
     * C type : char[128]
     */
    public byte[] LensMake = new byte[128];
    /**
     * C type : char[128]
     */
    public byte[] Lens = new byte[128];
    /**
     * C type : char[128]
     */
    public byte[] LensSerial = new byte[128];
    /**
     * C type : char[128]
     */
    public byte[] InternalLensSerial = new byte[128];
    /**
     * C type : ushort
     */
    public short FocalLengthIn35mmFormat;
    /**
     * C type : libraw_nikonlens_t
     */
    public libraw_nikonlens_t nikon;
    /**
     * C type : libraw_dnglens_t
     */
    public libraw_dnglens_t dng;
    /**
     * C type : libraw_makernotes_lens_t
     */
    public libraw_makernotes_lens_t makernotes;

    public libraw_lensinfo_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("MinFocal", "MaxFocal", "MaxAp4MinFocal", "MaxAp4MaxFocal", "EXIF_MaxAp", "LensMake", "Lens", "LensSerial", "InternalLensSerial", "FocalLengthIn35mmFormat", "nikon", "dng", "makernotes");
    }

    public libraw_lensinfo_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_lensinfo_t newInstance() {
        return new libraw_lensinfo_t();
    }

//    public static libraw_lensinfo_t[] newArray(int arrayLength) {
//        return Structure.newArray(libraw_lensinfo_t.class, arrayLength);
//    }
    public static class ByReference extends libraw_lensinfo_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_lensinfo_t implements Structure.ByValue {

    };
}
