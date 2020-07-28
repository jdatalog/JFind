/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_shootinginfo_t extends Structure<libraw_shootinginfo_t, libraw_shootinginfo_t.ByValue, libraw_shootinginfo_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_shootinginfo_t extends Structure {

    public short DriveMode;
    public short FocusMode;
    public short MeteringMode;
    public short AFPoint;
    public short ExposureMode;
    public short ImageStabilization;
    /**
     * C type : char[64]
     */
    public byte[] BodySerial = new byte[64];
    /**
     * this may be PCB or sensor serial, depends on make/model<br>
     * C type : char[64]
     */
    public byte[] InternalBodySerial = new byte[64];

    public libraw_shootinginfo_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("DriveMode", "FocusMode", "MeteringMode", "AFPoint", "ExposureMode", "ImageStabilization", "BodySerial", "InternalBodySerial");
    }

    /**
     * @param BodySerial C type : char[64]<br>
     * @param InternalBodySerial this may be PCB or sensor serial, depends on
     * make/model<br>
     * C type : char[64]
     */
    public libraw_shootinginfo_t(short DriveMode, short FocusMode, short MeteringMode, short AFPoint, short ExposureMode, short ImageStabilization, byte BodySerial[], byte InternalBodySerial[]) {
        super();
        this.DriveMode = DriveMode;
        this.FocusMode = FocusMode;
        this.MeteringMode = MeteringMode;
        this.AFPoint = AFPoint;
        this.ExposureMode = ExposureMode;
        this.ImageStabilization = ImageStabilization;
        if ((BodySerial.length != this.BodySerial.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.BodySerial = BodySerial;
        if ((InternalBodySerial.length != this.InternalBodySerial.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.InternalBodySerial = InternalBodySerial;
    }

    public libraw_shootinginfo_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_shootinginfo_t newInstance() {
        return new libraw_shootinginfo_t();
    }
//	public static libraw_shootinginfo_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_shootinginfo_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_shootinginfo_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_shootinginfo_t implements Structure.ByValue {

    };
}
