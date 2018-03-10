package org.denny.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.denny.vo.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.denny.dbutils.HibernateUtils ;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory() ;


		get(sf);
	}

	@SuppressWarnings("deprecation")
	private static void get(SessionFactory sf) {
		Session s = sf.openSession() ;
		Member find = s.find(Member.class, "");
		System.err.println(find);
		s.close();
		sf.close();
//		q.addEntity(Member.class) ;
//		List<Member> resultList = q.getResultList();
//		for (Member m : resultList) {
//			System.err.println(m);
//		}
	}

	private static void add(SessionFactory sf) {
		EntityManager entityManager = sf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( new Member( "Our very first event!", "Our very first event!") );
		entityManager.persist( new Member( "A follow up event", "A follow up event") );
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
