package dataCreator.Random;

public class RandomGender {
	public static String getgenderrandom() { 
			int sex=getNum(0,1);   
			String gender;
		    if(sex==0){       
		        gender = "女";    
		    }else {    
		    	gender = "男";    
		    } 
		    return gender;
	}
	
	public static int getNum(int start,int end)
	{    
		return (int)(Math.random()*(end-start+1)+start);    
    }   
}
