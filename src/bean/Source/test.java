package bean.Source;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataCreator.Random.RandomDate;
import dataCreator.Random.RandomGender;
import dataCreator.Random.RandomName;
import dataCreator.Random.RandomSno;
import dataCreator.Random.RandomUrl;
import dataCreator.Random.RandomUserInfo;
import dataDAO.DAO.InternetdataDAOImpl;
import dataDAO.DAO.UserDAOImpl;

public class test {
	public static void main(String[] args) {
		UserInfo userInfo=new UserInfo();
		InternetdataInfo internetdataInfo=new InternetdataInfo();
		userInfo.setGender(RandomGender.getgenderrandom());
		userInfo.setName(RandomName.getallnamerandom());
		userInfo.setSno(RandomSno.getsnorandom());
		
		UserDAOImpl daoImpl=new UserDAOImpl();
		daoImpl.saveOrUpdate(userInfo);
		
		
		//生成时间
		Date randomDate =RandomDate.getdaterandom("2018", "2020");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(randomDate);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
        
        System.out.println(dates);
        
        //随机提取userinfo
//        userInfo=RandomUserInfo.getuserinforandom(daoImpl.showall());
 
		internetdataInfo.setDate(dates.toString());
		internetdataInfo.setUrl(RandomUrl.geturlrandom());
		internetdataInfo.setUserInfo(userInfo);

		InternetdataDAOImpl internetdataDAOImpl=new InternetdataDAOImpl();
		internetdataDAOImpl.saveOrUpdate(internetdataInfo);
	}
}
