/*
  Copyright (c) 2009 Harri Kaimio

  This file is part of Photovault.

  Photovault is free software; you can redistribute it and/or modify it
  under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.

  Photovault is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with Photovault; if not, write to the Free Software Foundation,
  Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 */
package libraw;

import com.sun.jna.Structure;

import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

/**
 * <i>native declaration : /usr/include/stdint.h</i><br>
 * This file was autogenerated by
 * <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit
 * <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> ,
 * <a href="http://rococoa.dev.java.net/">Rococoa</a>, or
 * <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class LibRawData extends Structure {

    /**
     * C type : ushort[4]*
     */
    public Pointer image;
    /**
     * C type : libraw_image_sizes_t
     */
    public libraw_image_sizes_t sizes;
    /**
     * C type : libraw_iparams_t
     */
    public libraw_iparams_t idata;
    /**
     * C type : libraw_lensinfo_t
     */
    public libraw_lensinfo_t lens;
    /**
     * C type : libraw_makernotes_t
     */
    public libraw_makernotes_t makernotes;
    /**
     * C type : libraw_shootinginfo_t
     */
    public libraw_shootinginfo_t shootinginfo;
    /**
     * C type : libraw_output_params_t
     */
    public libraw_output_params_t params;
    public int progress_flags;
    public int process_warnings;
    /**
     * C type : libraw_colordata_t
     */
    public libraw_colordata_t color;
    /**
     * C type : libraw_imgother_t
     */
    public libraw_imgother_t other;
    /**
     * C type : libraw_thumbnail_t
     */
    public libraw_thumbnail_t thumbnail;
    /**
     * C type : libraw_rawdata_t
     */
    public libraw_rawdata_t rawdata;
    /**
     * C type : void*
     */
    public Pointer parent_class;

    public LibRawData() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("image", "sizes", "idata", "lens", "makernotes", "shootinginfo", "params", "progress_flags", "process_warnings", "color", "other", "thumbnail", "rawdata", "parent_class");
    }

    public LibRawData(Pointer peer) {
        super(peer);
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected LibRawData newInstance() {
        return new LibRawData();
    }
//	public static LibRawData[] newArray(int arrayLength) {
//		return Structure.newArray(LibRawData.class, arrayLength);
//	}

    public static class ByReference extends LibRawData implements Structure.ByReference {

    };

    public static class ByValue extends LibRawData implements Structure.ByValue {

    };
}
