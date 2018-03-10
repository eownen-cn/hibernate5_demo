package org.denny.bean.test;

import java.util.EnumSet;

import org.denny.bean.Account2;
import org.denny.bean.Address2;
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

public class TestOneToOneTwoWay {
	
	/**
	 * 生成DDL语句
	 */
	@Test
	public final void test() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).buildMetadata();
		SchemaExport schema = new SchemaExport();
		schema.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	
	/**
	 * 级联CRUD测试
	 */
	@Test
	public void test1(){
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Account2 c1 = new Account2("龙永凌");
		Address2 d1 = new Address2("地球");
		
		c1.setAddress(d1);
		d1.setAccount(c1);
		
		saxin.persist(c1);
		saxin.persist(d1);
		
		saxin.flush();
		saxin.close();
		sf.close() ;
		
	}
	public static void main(String[] args) {
		
	}
}
