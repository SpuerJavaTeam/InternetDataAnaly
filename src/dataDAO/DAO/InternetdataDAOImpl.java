package dataDAO.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Source.InternetdataInfo;

public class InternetdataDAOImpl implements InternetdataDAO{

	@Override
	public boolean saveOrUpdate(InternetdataInfo internetdataInfo) {
		
		boolean ret=false;
		Session session=null;
		Transaction transaction=null;
		try{
			session=SessionUtil.getFactory().openSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(internetdataInfo);
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
