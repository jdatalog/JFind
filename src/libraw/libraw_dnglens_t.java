/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_dnglens_t extends Structure<libraw_dnglens_t, libraw_dnglens_t.ByValue, libraw_dnglens_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_dnglens_t extends Structure {

    public float MinFocal;
    public float MaxFocal;
    public float MaxAp4MinFocal;
    public float MaxAp4MaxFocal;

    public libraw_dnglens_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("MinFocal", "MaxFocal", "MaxAp4MinFocal", "MaxAp4MaxFocal");
    }

    public libraw_dnglens_t(float MinFocal, float MaxFocal, float MaxAp4MinFocal, float MaxAp4MaxFocal) {
        super();
        this.MinFocal = MinFocal;
        this.MaxFocal = MaxFocal;
        this.MaxAp4MinFocal = MaxAp4MinFocal;
        this.MaxAp4MaxFocal = MaxAp4MaxFocal;
    }

    public libraw_dnglens_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_dnglens_t newInstance() {
        return new libraw_dnglens_t();
    }
//	public static libraw_dnglens_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_dnglens_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_dnglens_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_dnglens_t implements Structure.ByValue {

    };
}
