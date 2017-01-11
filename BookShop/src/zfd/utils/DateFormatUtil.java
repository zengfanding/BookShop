package zfd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	public static String formatDate(Long date){
		if(date != null){
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(new Date(date));
		}
		return null;
	}
	public static String formatTime(Long date){
		if(date != null){
			
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			return df.format(new Date(date));
		}
		return null;
	}
	public static String formatDateTime(Long date){
		if(date != null){
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(new Date(date));
		}
		return null;
	}
	public static String formatDateTime(Date date){
		if(date != null){
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(date);
		}
		return null;
	}

}
