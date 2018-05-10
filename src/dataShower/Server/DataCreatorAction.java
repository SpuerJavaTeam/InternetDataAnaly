package dataShower.Server;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.Action;

import bean.Source.InternetdataInfo;
import bean.Source.UserInfo;
import dataCreator.Random.RandomDate;
import dataCreator.Random.RandomGender;
import dataCreator.Random.RandomName;
import dataCreator.Random.RandomSno;
import dataCreator.Random.RandomUrl;
import dataCreator.Random.RandomUserInfo;
import dataDAO.DAO.InternetdataDAOImpl;
import dataDAO.DAO.UserDAOImpl;

public class DataCreatorAction implements Action{

	private String datacount;
	private String datestart;
	private String dateend;
	
	public String execute() throws Exception {
		
		if (Integer.parseInt(datestart) > Integer.parseInt(dateend)) {
			return Action.ERROR;
		}
		int count=new Integer(datacount);
		
		for(int i=0;i<count;i++) {
			int flag=RandomGender.getNum(0, 1);
			
			if (flag==0) {//生成新人
				UserInfo userInfo=new UserInfo();
				InternetdataInfo internetdataInfo=new InternetdataInfo();
				userInfo.setGender(RandomGender.getgenderrandom());
				userInfo.setName(RandomName.getallnamerandom());
				userInfo.setSno(RandomSno.getsnorandom());
				
				UserDAOImpl daoImpl=new UserDAOImpl();
				daoImpl.saveOrUpdate(userInfo);			
				
				//生成时间
				Date randomDate =RandomDate.getdaterandom(datestart, dateend);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String nowTime = sdf.format(randomDate);//将时间格式转换成符合Timestamp要求的格式.
		        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
		        
		        System.out.println(dates);
		        
		        //随机提取userinfo
		 
				internetdataInfo.setDate(dates.toString());
				internetdataInfo.setUrl(RandomUrl.geturlrandom());
				internetdataInfo.setUserInfo(userInfo);

				InternetdataDAOImpl internetdataDAOImpl=new InternetdataDAOImpl();
				internetdataDAOImpl.saveOrUpdate(internetdataInfo);
			} 
			
			
			else 
			
			
			{//==1生成老人
				UserInfo userInfo=new UserInfo();
				InternetdataInfo internetdataInfo=new InternetdataInfo();
				UserDAOImpl daoImpl=new UserDAOImpl();
			
				//生成时间
				Date randomDate =RandomDate.getdaterandom(datestart, dateend);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String nowTime = sdf.format(randomDate);//将时间格式转换成符合Timestamp要求的格式.
		        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
		        
		        //随机提取userinfo
		        userInfo=RandomUserInfo.getuserinforandom(daoImpl.showall());
		 
				internetdataInfo.setDate(dates.toString());
				internetdataInfo.setUrl(RandomUrl.geturlrandom());
				internetdataInfo.setUserInfo(userInfo);

				InternetdataDAOImpl internetdataDAOImpl=new InternetdataDAOImpl();
				internetdataDAOImpl.saveOrUpdate(internetdataInfo);
			}
		}
		return Action.SUCCESS;
	}
	
	public String getDatacount() {
		return datacount;
	}

	public void setDatacount(String datacount) {
		this.datacount = datacount;
	}

	public String getDatestart() {
		return datestart;
	}

	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}

	public String getDateend() {
		return dateend;
	}

	public void setDateend(String dateend) {
		this.dateend = dateend;
	}

}
