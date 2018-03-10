package org.denny.bean.test;

import java.util.EnumSet;

import org.denny.bean.Account;
import org.denny.bean.Address;
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

public class TestOneToOneOneWay {
	
	/**
	 * 生成DDL语句
	 */
	@Test
	public void test() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).buildMetadata();
		SchemaExport schema = new SchemaExport();
		schema.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	
	@Test
	public void test1(){
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Address d = new Address("月亮");
		Account a = new Account("龙永凌");
		a.setAddress(d);
		
		saxin.persist(a);
		
		saxin.flush();
		saxin.close();
		sf.close() ;
		
	}
}
