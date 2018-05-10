package dataCreator.Random;

import java.util.List;
import java.util.Random;

import bean.Source.UserInfo;

public class RandomUserInfo {
	public static UserInfo getuserinforandom(List<UserInfo> userInfos) {
		Random random=new Random(System.currentTimeMillis());  
       
        int index=random.nextInt(userInfos.size()-1);
        UserInfo userInfo=userInfos.get(index);  
        return userInfo;
	}
}
