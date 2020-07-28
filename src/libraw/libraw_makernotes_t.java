/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_makernotes_t extends Structure<libraw_makernotes_t, libraw_makernotes_t.ByValue, libraw_makernotes_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_makernotes_t extends Structure {

    /**
     * C type : libraw_canon_makernotes_t
     */
    public libraw_canon_makernotes_t canon;
    /**
     * C type : libraw_nikon_makernotes_t
     */
    public libraw_nikon_makernotes_t nikon;
    /**
     * C type : libraw_hasselblad_makernotes_t
     */
    public libraw_hasselblad_makernotes_t hasselblad;
    /**
     * C type : libraw_fuji_info_t
     */
    public libraw_fuji_info_t fuji;
    /**
     * C type : libraw_olympus_makernotes_t
     */
    public libraw_olympus_makernotes_t olympus;
    /**
     * C type : libraw_sony_info_t
     */
    public libraw_sony_info_t sony;
    /**
     * C type : libraw_kodak_makernotes_t
     */
    public libraw_kodak_makernotes_t kodak;
    /**
     * C type : libraw_panasonic_makernotes_t
     */
    public libraw_panasonic_makernotes_t panasonic;
    /**
     * C type : libraw_pentax_makernotes_t
     */
    public libraw_pentax_makernotes_t pentax;

    public libraw_makernotes_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("canon", "nikon", "hasselblad", "fuji", "olympus", "sony", "kodak", "panasonic", "pentax");
    }

    /**
     * @param canon C type : libraw_canon_makernotes_t<br>
     * @param nikon C type : libraw_nikon_makernotes_t<br>
     * @param hasselblad C type : libraw_hasselblad_makernotes_t<br>
     * @param fuji C type : libraw_fuji_info_t<br>
     * @param olympus C type : libraw_olympus_makernotes_t<br>
     * @param sony C type : libraw_sony_info_t<br>
     * @param kodak C type : libraw_kodak_makernotes_t<br>
     * @param panasonic C type : libraw_panasonic_makernotes_t<br>
     * @param pentax C type : libraw_pentax_makernotes_t
     */
    public libraw_makernotes_t(libraw_canon_makernotes_t canon, libraw_nikon_makernotes_t nikon, libraw_hasselblad_makernotes_t hasselblad, libraw_fuji_info_t fuji, libraw_olympus_makernotes_t olympus, libraw_sony_info_t sony, libraw_kodak_makernotes_t kodak, libraw_panasonic_makernotes_t panasonic, libraw_pentax_makernotes_t pentax) {
        super();
        this.canon = canon;
        this.nikon = nikon;
        this.hasselblad = hasselblad;
        this.fuji = fuji;
        this.olympus = olympus;
        this.sony = sony;
        this.kodak = kodak;
        this.panasonic = panasonic;
        this.pentax = pentax;
    }

    public libraw_makernotes_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_makernotes_t newInstance() {
        return new libraw_makernotes_t();
    }
//	public static libraw_makernotes_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_makernotes_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_makernotes_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_makernotes_t implements Structure.ByValue {

    };
}
