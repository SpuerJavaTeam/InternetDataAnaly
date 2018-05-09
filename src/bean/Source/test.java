package bean.Source;

import dataDAO.DAO.InternetdataDAOImpl;
import dataDAO.DAO.UserDAOImpl;

public class test {
	public static void main(String[] args) {
		UserInfo userInfo=new UserInfo();
		InternetdataInfo internetdataInfo=new InternetdataInfo();
		userInfo.setGender("男");
		userInfo.setName("李嘉成");
		userInfo.setSno("153020068");
		
		
		UserDAOImpl daoImpl=new UserDAOImpl();
		daoImpl.saveOrUpdate(userInfo);
		
		internetdataInfo.setDate("2018-11-12 23:23:23");
		internetdataInfo.setUrl("www.baidu.com");
		internetdataInfo.setUserInfo(userInfo);

		InternetdataDAOImpl internetdataDAOImpl=new InternetdataDAOImpl();
		internetdataDAOImpl.saveOrUpdate(internetdataInfo);
	}
}
