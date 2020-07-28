/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraw;

//public abstract class libraw_imgother_t extends Structure<libraw_imgother_t, libraw_imgother_t.ByValue, libraw_imgother_t.ByReference > {
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

//public class libraw_imgother_t extends Structure<libraw_imgother_t, libraw_imgother_t.ByValue, libraw_imgother_t.ByReference > {
public class libraw_imgother_t extends Structure {

    public float iso_speed;
    public float shutter;
    public float aperture;
    public float focal_len;
    /**
     * Conversion Error : time_t (Primitive without known type for this runtime:
     * NativeTime)
     */
    public int shot_order;
    /**
     * C type : unsigned[32]
     */
    public int[] gpsdata = new int[32];
    /**
     * C type : libraw_gps_info_t
     */
    public libraw_gps_info_t parsed_gps;
    /**
     * C type : char[512]
     */
    public byte[] desc = new byte[512];
    /**
     * C type : char[64]
     */
    public byte[] artist = new byte[64];
    public float FlashEC;
    public float FlashGN;
    public float CameraTemperature;
    public float SensorTemperature;
    public float SensorTemperature2;
    public float LensTemperature;
    public float AmbientTemperature;
    public float BatteryTemperature;
    public float exifAmbientTemperature;
    public float exifHumidity;
    public float exifPressure;
    public float exifWaterDepth;
    public float exifAcceleration;
    public float exifCameraElevationAngle;
    public float real_ISO;

    public libraw_imgother_t() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("iso_speed", "shutter", "aperture", "focal_len", "shot_order", "gpsdata", "parsed_gps", "desc", "artist", "FlashEC", "FlashGN", "CameraTemperature", "SensorTemperature", "SensorTemperature2", "LensTemperature", "AmbientTemperature", "BatteryTemperature", "exifAmbientTemperature", "exifHumidity", "exifPressure", "exifWaterDepth", "exifAcceleration", "exifCameraElevationAngle", "real_ISO");
    }

    public libraw_imgother_t(Pointer peer) {
        super(peer);
    }

    public static abstract class ByReference extends libraw_imgother_t implements Structure.ByReference {

    };

    public static abstract class ByValue extends libraw_imgother_t implements Structure.ByValue {

    };

    public float getIsoSpeed() {
        return iso_speed;
    }

    public float getShutterSpeed() {
        return shutter;
    }

    public float getAperture() {
        return aperture;
    }

    public float getFocalLen() {
        return focal_len;
    }

    public int getShot_order() {
        return shot_order;
    }

    public int[] getGpsdata() {
        return gpsdata;
    }

    public libraw_gps_info_t getParsed_gps() {
        return parsed_gps;
    }

    public byte[] getDesc() {
        return desc;
    }

    public byte[] getArtist() {
        return artist;
    }

    public float getFlashEC() {
        return FlashEC;
    }

    public float getFlashGN() {
        return FlashGN;
    }

    public float getCameraTemperature() {
        return CameraTemperature;
    }

    public float getSensorTemperature() {
        return SensorTemperature;
    }

    public float getSensorTemperature2() {
        return SensorTemperature2;
    }

    public float getLensTemperature() {
        return LensTemperature;
    }

    public float getAmbientTemperature() {
        return AmbientTemperature;
    }

    public float getBatteryTemperature() {
        return BatteryTemperature;
    }

    public float getExifAmbientTemperature() {
        return exifAmbientTemperature;
    }

    public float getExifHumidity() {
        return exifHumidity;
    }

    public float getExifPressure() {
        return exifPressure;
    }

    public float getExifWaterDepth() {
        return exifWaterDepth;
    }

    public float getExifAcceleration() {
        return exifAcceleration;
    }

    public float getExifCameraElevationAngle() {
        return exifCameraElevationAngle;
    }

    public float getReal_ISO() {
        return real_ISO;
    }

}
