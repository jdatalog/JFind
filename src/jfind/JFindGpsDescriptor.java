package jfind;

import com.drew.lang.Rational;
import com.drew.metadata.Directory;
import com.drew.metadata.exif.GpsDescriptor;
import com.drew.metadata.exif.GpsDirectory;
import datalog.coord.PointSimple;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class JFindGpsDescriptor {


    public static JFindPointGps getPointGps( GpsDirectory _directory) {
        PointSimple pt = null;
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        GregorianCalendar date = new GregorianCalendar();

        double alti = 0;
        double lon = 0;
        double lat = 0;
        // Get Altitude
        if (_directory.containsTag(GpsDirectory.TAG_ALTITUDE)) {
            try {
                alti = _directory.getRational(GpsDirectory.TAG_ALTITUDE).doubleValue();
            } catch (Exception e) {
            }
        }

        if (_directory.containsTag(GpsDirectory.TAG_LONGITUDE)) {
            try {
                Rational[] components = _directory.getRationalArray(GpsDirectory.TAG_LONGITUDE);
                // TODO create an HoursMinutesSecods class ??
                double deg = components[0].doubleValue();
                double min = components[1].doubleValue();
                double sec = components[2].doubleValue();
                
                lon = (deg*3600.0+min*60.0+sec)/3600.0;
            } catch (Exception e) {
            }
        }

        if (_directory.containsTag(GpsDirectory.TAG_LATITUDE)) {
            try {
                Rational[] components = _directory.getRationalArray(GpsDirectory.TAG_LATITUDE);
                // TODO create an HoursMinutesSecods class ??
                double deg = components[0].doubleValue();
                double min = components[1].doubleValue();
                double sec = components[2].doubleValue();
                lat = (deg*3600.0+min*60.0+sec)/3600.0;
            } catch (Exception e) {
            }
        }

        if (_directory.containsTag(GpsDirectory.TAG_DATE_STAMP)) {
            try {
                date.setTime(sdfDate.parse(_directory.getString(GpsDirectory.TAG_DATE_STAMP)));
            } catch (Exception e) {
            }
        }

        if (_directory.containsTag(GpsDirectory.TAG_TIME_STAMP)) {
            try {
                int[] timeComponents = _directory.getIntArray(GpsDirectory.TAG_TIME_STAMP);
                date.add(Calendar.HOUR_OF_DAY, timeComponents[0]);
                date.add(Calendar.MINUTE, timeComponents[1]);
                date.add(Calendar.SECOND, timeComponents[2]);
            } catch (Exception e) {
            }
        }

        return new JFindPointGps( date, lat, lon);

    }
}
