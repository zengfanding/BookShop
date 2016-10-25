package zfd.utils;

import java.util.UUID;

public class StringUtils {

	
	public static String getDir(String filename){
		
		int hashCodeValue = filename.hashCode();
		int dir1 = hashCodeValue & 15;
		int dir2 = hashCodeValue >>> 4 & 15;
		return "/"+dir1+"/"+dir2;
	}

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static String getUnique32BitNum(){
		
		int i = 0;
		String uuidStr;
		Integer num = 0;
		while(i < 3){
			uuidStr = StringUtils.getUUID();
			num = uuidStr.hashCode();
			
			if(num > 0){
				break;
			}
			i++;
		}
		
		if(num < 0){
			num *= -1;
		}
		
		System.out.println(i);
		
		return num.toString();
		
	}

	
	
}
