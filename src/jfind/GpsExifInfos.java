package jfind;

import java.util.HashMap;

import com.drew.metadata.exif.GpsDirectory;

public class GpsExifInfos extends GpsDirectory {

//	[GPS] GPS Version ID - 2 2 0 0
//	[GPS] GPS Latitude Ref - N
//	[GPS] GPS Latitude - 43"24'53.03311
//	[GPS] GPS Longitude Ref - E
//	[GPS] GPS Longitude - 5"37'50.923992
//	[GPS] GPS Altitude Ref - Sea level
//	[GPS] GPS Altitude - 4937/10 metres
//	[GPS] GPS Time-Stamp - 13:43:48 UTC
//	[GPS] GPS Satellites - 0
//	[GPS] GPS Map Datum - WGS-84
//	[GPS] Unknown tag (0x001d) - 2008:09:29
	
	public void infos () {
		HashMap map = this.getTagNameMap();
	}
	
}
