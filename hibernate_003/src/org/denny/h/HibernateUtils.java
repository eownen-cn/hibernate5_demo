package org.denny.h;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.boot.registry.*;


public class HibernateUtils {
	private static String confXml = "hibernate-context.xml" ;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>() ;
	public static SessionFactory getSessionFactory;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		getSessionFactory = new Configuration().buildSessionFactory(new StandardServiceRegistryBuilder().configure(confXml).build());
	}
	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isConnected() || session.isOpen()) {
				session.close();
			}
			threadLocal.set(null);
		}
	}
}
