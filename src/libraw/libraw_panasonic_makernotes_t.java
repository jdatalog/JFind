/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_panasonic_makernotes_t extends Structure<libraw_panasonic_makernotes_t, libraw_panasonic_makernotes_t.ByValue, libraw_panasonic_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_panasonic_makernotes_t extends Structure {

    /**
     * Compression:<br>
     * 34826 (Panasonic RAW 2): LEICA DIGILUX 2;<br>
     * 34828 (Panasonic RAW 3): LEICA D-LUX 3; LEICA V-LUX 1; Panasonic DMC-LX1;
     * Panasonic DMC-LX2; Panasonic DMC-FZ30; Panasonic DMC-FZ50;<br>
     * 34830 (not in exiftool): LEICA DIGILUX 3; Panasonic DMC-L1;<br>
     * 34316 (Panasonic RAW 1): others (LEICA, Panasonic, YUNEEC);<br>
     * C type : ushort
     */
    public short Compression;
    /**
     * C type : ushort
     */
    public short BlackLevelDim;
    /**
     * C type : float[8]
     */
    public float[] BlackLevel = new float[8];

    public libraw_panasonic_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("Compression", "BlackLevelDim", "BlackLevel");
    }

    /**
     * @param Compression Compression:<br>
     * 34826 (Panasonic RAW 2): LEICA DIGILUX 2;<br>
     * 34828 (Panasonic RAW 3): LEICA D-LUX 3; LEICA V-LUX 1; Panasonic DMC-LX1;
     * Panasonic DMC-LX2; Panasonic DMC-FZ30; Panasonic DMC-FZ50;<br>
     * 34830 (not in exiftool): LEICA DIGILUX 3; Panasonic DMC-L1;<br>
     * 34316 (Panasonic RAW 1): others (LEICA, Panasonic, YUNEEC);<br>
     * C type : ushort<br>
     * @param BlackLevelDim C type : ushort<br>
     * @param BlackLevel C type : float[8]
     */
    public libraw_panasonic_makernotes_t(short Compression, short BlackLevelDim, float BlackLevel[]) {
        super();
        this.Compression = Compression;
        this.BlackLevelDim = BlackLevelDim;
        if ((BlackLevel.length != this.BlackLevel.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.BlackLevel = BlackLevel;
    }

    public libraw_panasonic_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_panasonic_makernotes_t newInstance() {
        return new libraw_panasonic_makernotes_t();
    }
//	public static libraw_panasonic_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_panasonic_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_panasonic_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_panasonic_makernotes_t implements Structure.ByValue {

    };
}
