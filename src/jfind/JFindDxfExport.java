package jfind;

import datalog.coord.Convert;
import datalog.coord.PointCartesien;
import datalog.coord.PointGps;
import datalog.coord.PointSimple;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class JFindDxfExport {

    private static DecimalFormat coordF = new DecimalFormat();
    private static DecimalFormat altF = new DecimalFormat();
    private static String POINT_LAYER = "9510";
    private static String TRACK_LAYER = "9520";
    private static String TEXT_LAYER = "9530";

    private String fn = null;
    private JFindGpsLog log = null;
    
    public JFindDxfExport(String s, JFindGpsLog l) {
        this.fn = s;
        this.log = l;
    }
    
//	private static String TRACKLAYER
    public  void writeDxf() throws IOException {
        List l = log.getList();

        Collections.sort(l, ((Comparator) new ComparePointGPSByDate()));

        coordF.applyPattern("0.00");
        //	coordF.setMinimumFractionDigits(2);

        altF.applyPattern("0.0");
        //	altF.setMinimumFractionDigits(1);

//		try {
        FileOutputStream fw = new FileOutputStream(new File(fn));
        PrintWriter pw = new PrintWriter(fw);
        writeHeaderSection(pw, log);

        pw.println("  0\nSECTION\n  2\nENTITIES");

        writeTrack(pw, l);
        writePoint(pw, l);
        pw.println("  0\nENDSEC\n  2\nEOF");

        pw.close();

//		} catch ( IOException e) {
//			System.out.println("Impossible dde sauvegarder le fichier : "+fn);
//		}

    //writeHeaderSection();
    //write
    }

    private static void writeHeaderSection(PrintWriter pw, JFindGpsLog log) {
        double alt = 0;
//		0
//		SECTION
//		2
//		HEADER
//		9
//		$EXTMIN
//		10
//		848999.80
//		20
//		1829999.80
//		9
//		$EXTMAX
//		10
//		850000.20
//		20
//		1831000.20
//		0
//		ENDSEC
        PointCartesien pc = null;

        pw.println("  0\nSECTION\n  2\nHEADER");

        pc = Convert.LAMBERT3.convert(log.getMin());
        pw.println("  9\n$EXTMIN\n 10\n" + coordF.format(pc.getX()) + "\n 20\n" + coordF.format(pc.getY()));
        pc = Convert.LAMBERT3.convert(log.getMax());
        pw.println("  9\n$EXTMAX\n 10\n" + coordF.format(pc.getX()) + "\n 20\n" + coordF.format(pc.getY()));

        pw.println("  0\nENDSEC");

    }

    private static void writeTrack(PrintWriter pw, List l) {
//		0
//		SECTION	
//		0
//		POLYLINE
//		66
//		1
//		8
//		9520
        pw.println("  0\nPOLYLINE\n 66\n1\n  8\n" + JFindDxfExport.TRACK_LAYER);

//		0
//		VERTEX
//		8
//		9520
//		10
//		849699.20
//		20
//		1830709.50
        PointCartesien pc = null;
        PointGps pt = null;
        for (Iterator it = l.iterator(); it.hasNext();) {
            pt = (PointGps) it.next();
            pc = Convert.LAMBERT3.convert(pt.getPointGeographique());
            if (null != pc) {
                pw.println("  0\nVERTEX\n  8\n" + JFindDxfExport.TRACK_LAYER);
                pw.println(" 10\n" + coordF.format(pc.getX()));
                pw.println(" 20\n" + coordF.format(pc.getY()));
                pw.println(" 30\n" + altF.format(pt.getAlt() - pt.getGeoidCor()));
            }

        }
        pw.println("  0\nSEQEND");


    }

    private static void writePoint(PrintWriter pw, List l) {

        PointCartesien pc = null;
        PointGps pt = null;
        for (Iterator it = l.iterator(); it.hasNext();) {
            pt = (PointGps) it.next();
            pc = Convert.LAMBERT3.convert(pt.getPointGeographique());
            if (null != pc) {
                pw.println("  0\nPOINT\n  8\n" + JFindDxfExport.POINT_LAYER);
                pw.println(" 10\n" + coordF.format(pc.getX()));
                pw.println(" 20\n" + coordF.format(pc.getY()));
                pw.println(" 30\n" + altF.format(pt.getAlt() - pt.getGeoidCor()));
                pw.println("  0\nTEXT\n  8\n" + JFindDxfExport.TEXT_LAYER);
                pw.println(" 10\n" + coordF.format(pc.getX()) + 10);
                pw.println(" 20\n" + coordF.format(pc.getY()) + 10);
                pw.println(" 30\n" + altF.format(pt.getAlt() - pt.getGeoidCor()));
                pw.println(" 40\n  10");
                pw.println("  1\n  " + pt.getInfos());

            }
        }

//		0
//		POINT
//		8
//		9510
//		10
//		849759.50
//		20
//		1830671.40
//		50
//		0.0
//		  0
//		  TEXT
//		    8
//		  7030
//		   10
//		  842541.35
//		   20
//		  1838101.90
//		   40
//		  83.61
//		    1
//		  test
//		   50
//		  0.0
//		    0
    }

    private class ComparePointGPSByDate implements Comparator {

        public int compare(Object p1, Object p2) {
            return ((PointSimple) p2).getGCDate().after(((PointSimple) p1).getGCDate()) ? 0 : 1;
        }
    }
}

