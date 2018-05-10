package dataCreator.Random;

import java.util.Random;

public class RandomSno {
	public static String getsnorandom() { 

		int sys=180000000;
		while ( sys > 179999999) {
			int flag = new Random().nextInt(179999999);  
		    if (flag < 140000000)  
		    {  
		        flag += 140000000;  
		    } 
		    sys=flag;
		}
		String s = String.valueOf(sys);
		return s;
		
	}
}
