package dataDAO.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtil {
	private static SessionFactory factory;
	private SessionUtil() {

	}
	public static SessionFactory getFactory() {
		if (factory==null) {
			Configuration configuration=new Configuration().configure();
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
			.applySettings(configuration.getProperties())
			.buildServiceRegistry();    
		factory=configuration.buildSessionFactory(serviceRegistry);
		}
		return factory;
	}
}
