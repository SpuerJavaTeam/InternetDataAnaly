package bean.Source;

import java.util.HashSet;
import java.util.Set;

public class UserInfo {
	int uid;
	String sno;
	String name;
	String gender;
	private Set<InternetdataInfo> internetdataInfos=new HashSet<InternetdataInfo>();
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<InternetdataInfo> getInternetdataInfos() {
		return internetdataInfos;
	}
	public void setInternetdataInfos(Set<InternetdataInfo> internetdataInfos) {
		this.internetdataInfos = internetdataInfos;
	}
	
	
}
