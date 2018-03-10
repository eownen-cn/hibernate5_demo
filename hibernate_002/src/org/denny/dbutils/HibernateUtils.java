package org.denny.dbutils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate 4.2.0 CR2 HibernateSessionFactory
 * 
 * @author Administrator
 * 
 */
public class HibernateUtils {

	private static final String CONFIG_XML;
	private static Configuration CFG;
	private static ServiceRegistry SR;
	private static StandardServiceRegistryBuilder SSRB;
	private static Properties P;
	private static SessionFactory SF;
	private static ThreadLocal<Session> Threads;
	static {
		CONFIG_XML = "/hibernate.cfg.xml" ;
		CFG = CFG == null ? new Configuration().configure(CONFIG_XML) : CFG ;
		SSRB = SSRB == null ? new StandardServiceRegistryBuilder() : SSRB ;
		P = P == null ? CFG.getProperties() : P ;
		SR = SR == null ? SSRB.applySettings(P).build(): SR ;
		SF = SF == null ? CFG.buildSessionFactory(SR) : SF ;
		setUp() ;
	}

	/**
	 * Close session with the current process !
	 * 
	 * @param session
	 */
	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isConnected() || session.isOpen()) {
				session.close();
			}
//			Threads.set(null);
		}
	}
	/**
	 * Get the singleton factory of session !
	 * 
	 * @return SessionFactory
	 * @throws InterruptedException
	 */
	public static SessionFactory getSessionFactory(){
		return SF;
	}
	
	protected static void setUp(){
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			SF = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
}
