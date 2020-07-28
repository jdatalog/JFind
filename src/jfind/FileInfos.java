package jfind;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileInfos {
	private String absolutePath;
	private String newPath = null;
	private long size;
	private boolean isJPEG = false;
	private boolean hasExifInfos = false;
	private String dateTime;
    int annee;   
    int mois;   
    int jour;   
    int heure;    
    int minute;  
    int seconde;   

//	private String time;
	

	public FileInfos( String path) {
		absolutePath = path;
		
	}

	public FileInfos( String path, long s, boolean is, boolean exif, String dt) {
		absolutePath = path;
		isJPEG       = is;
		size         = s;
		if (isJPEG) {
			hasExifInfos = exif;
			dateTime = dt;
			
			if (dateTime != null) {
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
            try {
		    Date d = sf.parse(dateTime);
	        Calendar c = Calendar.getInstance();
	        c.setTime(d);

		    annee   = c.get(Calendar.YEAR);   
		    mois    = c.get(Calendar.MONTH)+1;   
		    jour    = c.get(Calendar.DAY_OF_MONTH);   
		    heure   = c.get(Calendar.HOUR_OF_DAY);    
		    minute  = c.get(Calendar.MINUTE);  
		    seconde = c.get(Calendar.SECOND);   
		     }
           catch (Exception e){
            e.printStackTrace();
	        }
			}

		}
		
	}

	public String toString() {
		if ( ! isJPEG) {
			return absolutePath + "// not a jpeg file // ";
		} else {
			if (hasExifInfos) {
				return absolutePath + " /" + dateTime+ "/ ";
			} else {
				return absolutePath;
			}
		}
	}
	
	public String getAbsolutePath() {
		return absolutePath;
	}
	
	public int getYear() {
		return annee;
	}
	
	public int getMonth() {
		return mois;
	}
	
	public int getDay() {
		return jour;
	}

	public long getSize() {
		return size;
	}
	
	public long getSizeKb() {
		return size/1024;
	}

	public String getNewName() {
		String y  = String.valueOf(annee);
		String m  = (mois<10) ? "0"+String.valueOf(mois): String.valueOf(mois);
		String d  = (jour<10) ? "0"+String.valueOf(jour): String.valueOf(jour);
		String h  = (heure<10) ? "0"+String.valueOf(heure): String.valueOf(heure);
		String mn = (minute<10) ? "0"+String.valueOf(minute): String.valueOf(minute);
		String s  = (seconde<10) ? "0"+String.valueOf(seconde): String.valueOf(seconde);
		
		return y + m + d + "_" + h + mn + s;
		
	}
	
	public String getNewNameWithExtension() {
		String y  = String.valueOf(annee);
		String m  = (mois<10) ? "0"+String.valueOf(mois): String.valueOf(mois);
		String d  = (jour<10) ? "0"+String.valueOf(jour): String.valueOf(jour);
		String h  = (heure<10) ? "0"+String.valueOf(heure): String.valueOf(heure);
		String mn = (minute<10) ? "0"+String.valueOf(minute): String.valueOf(minute);
		String s  = (seconde<10) ? "0"+String.valueOf(seconde): String.valueOf(seconde);
		
		return y + m + d + "_" + h + mn + s + ".jpg" ;
		
	}
}
