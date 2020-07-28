/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_internal_output_params_t extends Structure<libraw_internal_output_params_t, libraw_internal_output_params_t.ByValue, libraw_internal_output_params_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_internal_output_params_t extends Structure {

    public int mix_green;
    public int raw_color;
    public int zero_is_bad;
    /**
     * C type : ushort
     */
    public short shrink;
    /**
     * C type : ushort
     */
    public short fuji_width;

    public libraw_internal_output_params_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("mix_green", "raw_color", "zero_is_bad", "shrink", "fuji_width");
    }

    /**
     * @param shrink C type : ushort<br>
     * @param fuji_width C type : ushort
     */
    public libraw_internal_output_params_t(int mix_green, int raw_color, int zero_is_bad, short shrink, short fuji_width) {
        super();
        this.mix_green = mix_green;
        this.raw_color = raw_color;
        this.zero_is_bad = zero_is_bad;
        this.shrink = shrink;
        this.fuji_width = fuji_width;
    }

    public libraw_internal_output_params_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_internal_output_params_t newInstance() {
        return new libraw_internal_output_params_t();
    }
//	public static libraw_internal_output_params_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_internal_output_params_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_internal_output_params_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_internal_output_params_t implements Structure.ByValue {

    };
}
