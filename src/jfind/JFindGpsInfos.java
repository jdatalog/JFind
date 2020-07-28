package jfind;

import com.drew.lang.Rational;
import com.drew.metadata.Directory;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.GpsDirectory;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class JFindGpsInfos {

    static public PointGpsExif getPointGps(GpsDirectory gpsDirectory, ExifDirectoryBase exifDirectory) {
        PointGpsExif pt = null;
        GregorianCalendar date = new GregorianCalendar();
        String infos = "";

        double alti = 0;
        double lon = 0;
        double lat = 0;
        // Get Altitude
        if (gpsDirectory.containsTag(GpsDirectory.TAG_ALTITUDE)) {
            try {
                alti = gpsDirectory.getRational(GpsDirectory.TAG_ALTITUDE).doubleValue();
            } catch (Exception e) {
            }
        }

        if (gpsDirectory.containsTag(GpsDirectory.TAG_LONGITUDE)) {
            try {
                Rational[] components = gpsDirectory.getRationalArray(GpsDirectory.TAG_LONGITUDE);
                // TODO create an HoursMinutesSecods class ??
                double deg = components[0].doubleValue();
                double min = components[1].doubleValue();
                double sec = components[2].doubleValue();
                lon = (deg * 3600. + min * 60. + sec) / 3600.;
            } catch (Exception e) {
            }
        }

        if (gpsDirectory.containsTag(GpsDirectory.TAG_LATITUDE)) {
            try {
                Rational[] components = gpsDirectory.getRationalArray(GpsDirectory.TAG_LATITUDE);
                // TODO create an HoursMinutesSecods class ??
                double deg = components[0].doubleValue();
                double min = components[1].doubleValue();
                double sec = components[2].doubleValue();
                lat = (deg * 3600. + min * 60. + sec) / 3600.;
            } catch (Exception e) {
            }
        }

        if (gpsDirectory.containsTag(GpsDirectory.TAG_DATE_STAMP)) {
            try {
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy:MM:dd", Locale.US);

                date.setTime(sdfDate.parse(gpsDirectory.getString(GpsDirectory.TAG_DATE_STAMP)));


            } catch (Exception e) {
            }
        }

        if (gpsDirectory.containsTag(GpsDirectory.TAG_TIME_STAMP)) {
            try {
                int[] timeComponents = gpsDirectory.getIntArray(GpsDirectory.TAG_TIME_STAMP);
                date.add(Calendar.HOUR_OF_DAY, timeComponents[0]);
                date.add(Calendar.MINUTE, timeComponents[1]);
                date.add(Calendar.SECOND, timeComponents[2]);
            } catch (Exception e) {
            }
        }

        if (exifDirectory.containsTag(ExifDirectoryBase.TAG_DATETIME)) {
            try {
                infos = exifDirectory.getString(ExifDirectoryBase.TAG_DATETIME);
            } catch (Exception e) {
            }
        }

        return new PointGpsExif(date, lat, lon, infos);
    }
}
