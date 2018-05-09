package dataDAO.DAO;

import bean.Source.UserInfo;

public interface UserDAO {
	public abstract boolean saveOrUpdate(UserInfo userInfo);
//	public abstract UserInfo queryByusername (String username);
//	public abstract void delete(UserInfo userInfo);
}
