/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_iparams_t extends Structure<libraw_iparams_t, libraw_iparams_t.ByValue, libraw_iparams_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_iparams_t extends Structure {

    /**
     * C type : char[4]
     */
    public byte[] guard = new byte[4];
    /**
     * C type : char[64]
     */
    public byte[] make = new byte[64];
    /**
     * C type : char[64]
     */
    public byte[] model = new byte[64];
    /**
     * C type : char[64]
     */
    public byte[] software = new byte[64];
    public int raw_count;
    public int dng_version;
    public int is_foveon;
    public int colors;
    public int filters;
    /**
     * C type : char[6][6]
     */
    public byte[] xtrans = new byte[((6) * (6))];
    /**
     * C type : char[6][6]
     */
    public byte[] xtrans_abs = new byte[((6) * (6))];
    /**
     * C type : char[5]
     */
    public byte[] cdesc = new byte[5];
    public int xmplen;
    /**
     * C type : char*
     */
    public Pointer xmpdata;

    public libraw_iparams_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("guard", "make", "model", "software", "raw_count", "dng_version", "is_foveon", "colors", "filters", "xtrans", "xtrans_abs", "cdesc", "xmplen", "xmpdata");
    }

    public libraw_iparams_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_iparams_t newInstance() {
        return new libraw_iparams_t();
    }
//	public static libraw_iparams_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_iparams_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_iparams_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_iparams_t implements Structure.ByValue {

    };

    /**
     * @return the make
     */
    @SuppressWarnings("empty-statement")
    public String getMake() {
        int len = 0;
        for (len = 0; len < make.length && make[len] != 0; len++);
        return new String(make, 0, len);
    }

    /**
     * @return the model
     */
    @SuppressWarnings("empty-statement")
    public String getModel() {
        int len = 0;
        for (len = 0; len < model.length && model[len] != 0; len++);
        return new String(model, 0, len);
    }

    /**
     * @return the raw_count
     */
    public int getRawCount() {
        return raw_count;
    }

    /**
     * @return the dng_version
     */
    public int getDngVersion() {
        return dng_version;
    }

    /**
     * @return the is_foveon
     */
    public boolean getIsFoveon() {
        return is_foveon != 0;
    }

    /**
     * @return the colors
     */
    public int getColors() {
        return colors;
    }

    /**
     * @return the filters
     */
    public int getFilters() {
        return filters;
    }

    /**
     * @return the cdesc
     */
    public byte[] getCdesc() {
        return cdesc;
    }
}
