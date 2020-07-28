/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class ph1_t extends Structure<ph1_t, ph1_t.ByValue, ph1_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class ph1_t extends Structure {

    public int format;
    public int key_off;
    public int tag_21a;
    public int t_black;
    public int split_col;
    public int black_col;
    public int split_row;
    public int black_row;
    public float tag_210;

    public ph1_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("format", "key_off", "tag_21a", "t_black", "split_col", "black_col", "split_row", "black_row", "tag_210");
    }

    public ph1_t(int format, int key_off, int tag_21a, int t_black, int split_col, int black_col, int split_row, int black_row, float tag_210) {
        super();
        this.format = format;
        this.key_off = key_off;
        this.tag_21a = tag_21a;
        this.t_black = t_black;
        this.split_col = split_col;
        this.black_col = black_col;
        this.split_row = split_row;
        this.black_row = black_row;
        this.tag_210 = tag_210;
    }

    public ph1_t(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected ph1_t newInstance() {
        return new ph1_t();
    }

//    public static ph1_t[] newArray(int arrayLength) {
//        return Structure.newArray(ph1_t.class, arrayLength);
//    }
    public static class ByReference extends ph1_t implements Structure.ByReference {

    };

    public static class ByValue extends ph1_t implements Structure.ByValue {

    };
}
