/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_thumbnail_t extends Structure<libraw_thumbnail_t, libraw_thumbnail_t.ByValue, libraw_thumbnail_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_thumbnail_t extends Structure {

    /**
     * @see LibRaw_thumbnail_formats<br>
     * C type : LibRaw_thumbnail_formats
     */
    public int tformat;
    /**
     * C type : ushort
     */
    public short twidth;
    /**
     * C type : ushort
     */
    public short theight;
    public int tlength;
    public int tcolors;
    /**
     * C type : char*
     */
    public Pointer thumb;

    public libraw_thumbnail_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("tformat", "twidth", "theight", "tlength", "tcolors", "thumb");
    }

    /**
     * @param tformat @see LibRaw_thumbnail_formats<br>
     * C type : LibRaw_thumbnail_formats<br>
     * @param twidth C type : ushort<br>
     * @param theight C type : ushort<br>
     * @param thumb C type : char*
     */
    public libraw_thumbnail_t(int tformat, short twidth, short theight, int tlength, int tcolors, Pointer thumb) {
        super();
        this.tformat = tformat;
        this.twidth = twidth;
        this.theight = theight;
        this.tlength = tlength;
        this.tcolors = tcolors;
        this.thumb = thumb;
    }

    public libraw_thumbnail_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_thumbnail_t newInstance() {
        return new libraw_thumbnail_t();
    }
//	public static libraw_thumbnail_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_thumbnail_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_thumbnail_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_thumbnail_t implements Structure.ByValue {

    };
}
