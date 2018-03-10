package org.denny.bean.test;

import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.denny.bean.Account;
import org.denny.bean.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class TestOneToOne {
	
	/**
	 * 生成DDL语句
	 */
	@Test
	public static void test() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).buildMetadata();
		SchemaExport schema = new SchemaExport();
		schema.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	
	@Test
	public static void test1(){
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Orders order1 = new Orders("订单1",new Date()) ;
		Orders order2 = new Orders("订单2",new Date()) ;
		Orders order3 = new Orders("订单3",new Date()) ;
		Orders order4 = new Orders("订单4",new Date()) ;
		Account account = new Account("龙永凌") ;
		
		order1.setAccount(account);
		order2.setAccount(account);
		order3.setAccount(account);
		order4.setAccount(account);
		Set<Orders> orderSet = new HashSet<>() ;
		orderSet.add(order1) ;
		orderSet.add(order2) ;
		orderSet.add(order3) ;
		orderSet.add(order4) ;
		account.setOrderSet(orderSet);
		
		saxin.persist(account);
		saxin.persist(order1);
		saxin.persist(order2);
		saxin.persist(order3);
		saxin.persist(order4);
		saxin.flush();
		saxin.getTransaction().commit();
		saxin.close();
		sf.close() ;
		
	}
	
	public static void main(String[] args) {
		test1() ;
	}
}
