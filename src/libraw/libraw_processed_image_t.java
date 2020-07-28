/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public class libraw_processed_image_t extends Structure<libraw_processed_image_t, libraw_processed_image_t.ByValue, libraw_processed_image_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class libraw_processed_image_t extends Structure {

    /**
     * @see LibRaw_image_formats<br>
     * C type : LibRaw_image_formats
     */
    public int type;
    /**
     * C type : ushort
     */
    public short height;
    /**
     * C type : ushort
     */
    public short width;
    /**
     * C type : ushort
     */
    public short colors;
    /**
     * C type : ushort
     */
    public short bits;
    public int data_size;
    /**
     * C type : unsigned char[1]
     */
    public byte[] data = new byte[1];

    public libraw_processed_image_t(Pointer peer) {
        super(peer);
        int s = peer.getInt(12);
        this.data = Arrays.copyOf(peer.getByteArray(16, s), s);
        //this.data = new byte[s];
        //this.data.
        allocateMemory();
    }

    public libraw_processed_image_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("type", "height", "width", "colors", "bits", "data_size", "data");
    }

    /**
     * @param type @see LibRaw_image_formats<br>
     * C type : LibRaw_image_formats<br>
     * @param height C type : ushort<br>
     * @param width C type : ushort<br>
     * @param colors C type : ushort<br>
     * @param bits C type : ushort<br>
     * @param data C type : unsigned char[1]
     */
    public libraw_processed_image_t(int type, short height, short width, short colors, short bits, int data_size, byte data) {
        super();
        this.type = type;
        this.height = height;
        this.width = width;
        this.colors = colors;
        this.bits = bits;
        this.data_size = data_size;
//		if ((data.length != this.data.length)) 
//			throw new IllegalArgumentException("Wrong array size !");
        this.data[0] = data;
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected libraw_processed_image_t newInstance() {
        return new libraw_processed_image_t();
    }
//	public static libraw_processed_image_t[] newArray(int arrayLength) {
//		return Structure.newArray(libraw_processed_image_t.class, arrayLength);
//	}

    public static class ByReference extends libraw_processed_image_t implements Structure.ByReference {

    };

    public static class ByValue extends libraw_processed_image_t implements Structure.ByValue {

    };

    public int getType() {
        return type;
    }

    public short getHeight() {
        return height;
    }

    public short getWidth() {
        return width;
    }

    public short getColors() {
        return colors;
    }

    public short getBits() {
        return bits;
    }

    public int getData_size() {
        return data_size;
    }

       public byte[] getDatas() {
        return this.data;
       }
       
}
