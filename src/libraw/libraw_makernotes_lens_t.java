/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_makernotes_lens_t extends Structure<libraw_makernotes_lens_t, libraw_makernotes_lens_t.ByValue, libraw_makernotes_lens_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_makernotes_lens_t extends Structure {

    public long LensID;
    /**
     * C type : char[128]
     */
    public byte[] Lens = new byte[128];
    /**
     * to characterize the image circle the lens covers<br>
     * C type : ushort
     */
    public short LensFormat;
    /**
     * 'male', lens itself<br>
     * C type : ushort
     */
    public short LensMount;
    public long CamID;
    /**
     * some of the sensor formats<br>
     * C type : ushort
     */
    public short CameraFormat;
    /**
     * 'female', body throat<br>
     * C type : ushort
     */
    public short CameraMount;
    /**
     * C type : char[64]
     */
    public byte[] body = new byte[64];
    /**
     * -1/0 is unknown; 1 is fixed focal; 2 is zoom
     */
    public short FocalType;
    /**
     * C type : char[16]
     */
    public byte[] LensFeatures_pre = new byte[16];
    /**
     * C type : char[16]
     */
    public byte[] LensFeatures_suf = new byte[16];
    public float MinFocal;
    public float MaxFocal;
    public float MaxAp4MinFocal;
    public float MaxAp4MaxFocal;
    public float MinAp4MinFocal;
    public float MinAp4MaxFocal;
    public float MaxAp;
    public float MinAp;
    public float CurFocal;
    public float CurAp;
    public float MaxAp4CurFocal;
    public float MinAp4CurFocal;
    public float MinFocusDistance;
    public float FocusRangeIndex;
    public float LensFStops;
    public long TeleconverterID;
    /**
     * C type : char[128]
     */
    public byte[] Teleconverter = new byte[128];
    public long AdapterID;
    /**
     * C type : char[128]
     */
    public byte[] Adapter = new byte[128];
    public long AttachmentID;
    /**
     * C type : char[128]
     */
    public byte[] Attachment = new byte[128];
    /**
     * C type : ushort
     */
    public short CanonFocalUnits;
    public float FocalLengthIn35mmFormat;

    public libraw_makernotes_lens_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("LensID", "Lens", "LensFormat", "LensMount", "CamID", "CameraFormat", "CameraMount", "body", "FocalType", "LensFeatures_pre", "LensFeatures_suf", "MinFocal", "MaxFocal", "MaxAp4MinFocal", "MaxAp4MaxFocal", "MinAp4MinFocal", "MinAp4MaxFocal", "MaxAp", "MinAp", "CurFocal", "CurAp", "MaxAp4CurFocal", "MinAp4CurFocal", "MinFocusDistance", "FocusRangeIndex", "LensFStops", "TeleconverterID", "Teleconverter", "AdapterID", "Adapter", "AttachmentID", "Attachment", "CanonFocalUnits", "FocalLengthIn35mmFormat");
    }

    public libraw_makernotes_lens_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_makernotes_lens_t newInstance() {
        return new libraw_makernotes_lens_t();
    }
//	public static libraw_makernotes_lens_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_makernotes_lens_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_makernotes_lens_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_makernotes_lens_t implements Structure.ByValue {

    };
}
