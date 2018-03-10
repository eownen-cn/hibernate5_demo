package org.denny.bean.test;

import java.util.EnumSet;

import org.denny.bean.IDCard;
import org.denny.bean.Person;
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
		
		Person p = new Person() ;
		p.setPname("龙永凌");
		
		IDCard c = new IDCard() ;
		c.setContent("654321657431284315");
		c.setPerson(p);
		
		saxin.persist(c);
		saxin.flush();
		saxin.close() ;
		sf.close() ;
	}
}
