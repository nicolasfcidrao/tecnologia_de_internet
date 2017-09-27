package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataUtil {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date stringToDate(String data) throws ParseException {
		return sdf.parse(data);
	}

	public static String dateToString(Date data) {
		return sdf.format(data);
	}

	public static int getQtdeDias(Date d1, Date d2) {
		long tempo = d2.getTime() - d1.getTime();

		return (int) Math.ceil(tempo / (24 * 60 * 60 * 1000));
	}
}
