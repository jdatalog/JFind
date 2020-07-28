/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_hasselblad_makernotes_t extends Structure<libraw_hasselblad_makernotes_t, libraw_hasselblad_makernotes_t.ByValue, libraw_hasselblad_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_hasselblad_makernotes_t extends Structure {

    public int BaseISO;
    public double Gain;

    public libraw_hasselblad_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("BaseISO", "Gain");
    }

    public libraw_hasselblad_makernotes_t(int BaseISO, double Gain) {
        super();
        this.BaseISO = BaseISO;
        this.Gain = Gain;
    }

    public libraw_hasselblad_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_hasselblad_makernotes_t newInstance() {
        return new libraw_hasselblad_makernotes_t();
    }
//	public static libraw_hasselblad_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_hasselblad_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_hasselblad_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_hasselblad_makernotes_t implements Structure.ByValue {

    };
}
