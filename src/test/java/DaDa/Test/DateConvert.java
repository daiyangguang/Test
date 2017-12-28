package DaDa.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class DateConvert {

	public static String stampToDate (String stamp) {
		String result = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); 
		long lstamp = new Long(stamp);
		Date date = new Date(lstamp);
		result = format1.format(date);
		return result;
	}
}
