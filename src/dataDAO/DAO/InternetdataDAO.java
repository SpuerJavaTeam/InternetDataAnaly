package dataDAO.DAO;

import bean.Source.InternetdataInfo;

public interface InternetdataDAO {
	public abstract boolean saveOrUpdate(InternetdataInfo internetdataInfo);
}
