package org.denny.testgenerator;

import java.util.List;

import org.denny.bean.Generator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestSequence {

	/*configuration版*/
	@Test
	public void test() {
		Configuration config = new Configuration().configure() ;
//		ServiceRegistry registry = new StandardServiceRegistryBuilder().build();
		SessionFactory sessionFactory = config.buildSessionFactory() ;
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.getTransaction().begin();
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		Generator g = currentSession.get(Generator.class, 10) ;
		System.err.println("g1====>" + g);
		
		List<Generator> list = currentSession.createQuery("from Generator",Generator.class).list() ;
		for (Generator obj : list) {
			System.err.println(obj) ;	
		}
		currentSession.getTransaction().commit();
		sessionFactory.close();
		
	}
	/*properties版*/
	@Test
	public void test1() {
		Configuration config = new Configuration() ;
		SessionFactory sf = config.configure().buildSessionFactory() ;
		System.err.println(sf);
		Session currentSession = sf.getCurrentSession();
		currentSession.getTransaction().begin();
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		currentSession.persist(new Generator("TitleTest", "ContentTest"));
		Generator g = currentSession.get(Generator.class, 10) ;
		System.err.println("g1====>" + g);
		
		List<Generator> list = currentSession.createQuery("from Generator",Generator.class).list() ;
		for (Generator obj : list) {
			System.err.println(obj) ;	
		}
		currentSession.getTransaction().commit();
		
		sf.close();
	}
	public static void main(String[] args) {
//		test1() ;
	}

}
