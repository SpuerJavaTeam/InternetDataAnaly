package dataCreator.Random;

import java.util.Random;

public class RandomUrl {
	public static String geturlrandom() {
		Random random=new Random(System.currentTimeMillis());  
        /* 598 百家姓 */  
        String[] urls= {"www.baidu.com","www.taobao.com",
        		"www.sina.com","www.tencent.com","www.google.com","www.iqiyi.com","www.yahoo.com"};  
          
        int index=random.nextInt(urls.length-1);
        String url = urls[index]; //获得一个随机的姓氏 
        return url;
	}
}
