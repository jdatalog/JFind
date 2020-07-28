/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_P1_color_t extends Structure<libraw_P1_color_t, libraw_P1_color_t.ByValue, libraw_P1_color_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_P1_color_t extends Structure {

    /**
     * C type : float[9]
     */
    public float[] romm_cam = new float[9];

    public libraw_P1_color_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("romm_cam");
    }

    /**
     * @param romm_cam C type : float[9]
     */
    public libraw_P1_color_t(float romm_cam[]) {
        super();
        if ((romm_cam.length != this.romm_cam.length)) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.romm_cam = romm_cam;
    }

    public libraw_P1_color_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_P1_color_t newInstance() {
        return new libraw_P1_color_t();
    }
//	public static libraw_P1_color_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_P1_color_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_P1_color_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_P1_color_t implements Structure.ByValue {

    };
}
