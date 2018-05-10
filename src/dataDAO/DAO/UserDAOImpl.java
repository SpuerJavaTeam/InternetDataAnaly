package dataDAO.DAO;

<<<<<<< HEAD
import java.util.List;

import org.hibernate.Criteria;
=======
import dataDAO.SessionUtil.SessionUtil;
>>>>>>> bafc26ddd3ebdd7066063e2ba4349527831f7db8
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
			session= SessionUtil.getFactory().openSession();
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

	@Override
	public List<UserInfo> showall() {
		List<UserInfo> ret=null;
		Session session=null;
		try {
			session=SessionUtil.getFactory().openSession();
			Criteria criteria=session.createCriteria(UserInfo.class);
			ret=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			ret=null;
		} finally {
			if (session!=null) {
				session.close();
			}
		}
		return ret ;
	}
}
