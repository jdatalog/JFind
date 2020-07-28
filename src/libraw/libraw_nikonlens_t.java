/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_nikonlens_t extends Structure<libraw_nikonlens_t, libraw_nikonlens_t.ByValue, libraw_nikonlens_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_nikonlens_t extends Structure {

    public float NikonEffectiveMaxAp;
    /**
     * C type : uchar
     */
    public byte NikonLensIDNumber;
    /**
     * C type : uchar
     */
    public byte NikonLensFStops;
    /**
     * C type : uchar
     */
    public byte NikonMCUVersion;
    /**
     * C type : uchar
     */
    public byte NikonLensType;

    public libraw_nikonlens_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("NikonEffectiveMaxAp", "NikonLensIDNumber", "NikonLensFStops", "NikonMCUVersion", "NikonLensType");
    }

    /**
     * @param NikonLensIDNumber C type : uchar<br>
     * @param NikonLensFStops C type : uchar<br>
     * @param NikonMCUVersion C type : uchar<br>
     * @param NikonLensType C type : uchar
     */
    public libraw_nikonlens_t(float NikonEffectiveMaxAp, byte NikonLensIDNumber, byte NikonLensFStops, byte NikonMCUVersion, byte NikonLensType) {
        super();
        this.NikonEffectiveMaxAp = NikonEffectiveMaxAp;
        this.NikonLensIDNumber = NikonLensIDNumber;
        this.NikonLensFStops = NikonLensFStops;
        this.NikonMCUVersion = NikonMCUVersion;
        this.NikonLensType = NikonLensType;
    }

    public libraw_nikonlens_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_nikonlens_t newInstance() {
        return new libraw_nikonlens_t();
    }
//	public static libraw_nikonlens_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_nikonlens_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_nikonlens_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_nikonlens_t implements Structure.ByValue {

    };
}
