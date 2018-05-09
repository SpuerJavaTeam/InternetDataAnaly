package dataDAO.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Source.UserInfo;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean saveOrUpdate(UserInfo userInfo) {
		
		boolean ret=false;
		Session session=null;
		Transaction transaction=null;
		try{
			session=SessionUtil.getFactory().openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(userInfo);
			transaction.commit();
			ret=true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			if (session!=null) {
				session.close();
			}
		}
		return ret;

	}
}
