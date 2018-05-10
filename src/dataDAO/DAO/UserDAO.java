package dataDAO.DAO;

import java.util.List;

import bean.Source.UserInfo;

public interface UserDAO {
	public abstract boolean saveOrUpdate(UserInfo userInfo);
	public abstract List<UserInfo> showall();
//	public abstract UserInfo queryByusername (String username);
//	public abstract void delete(UserInfo userInfo);
}
