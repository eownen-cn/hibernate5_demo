package org.denny.bean.test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.denny.bean.Dept;
import org.denny.bean.Employee;
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

public class TestOneToManyOneWay {
	
	/**
	 * 生成DDL语句
	 */
	@Test
	public void test() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("oneway.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).buildMetadata();
		SchemaExport schema = new SchemaExport();
		schema.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	
	@Test
	public void test1(){
		Configuration config = new Configuration();
		SessionFactory sf = config.configure("oneway.cfg.xml").buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Dept d = new Dept("财务部");
		Dept d2 = new Dept("市场部");
		Employee scott = new Employee("SCOTT");
		Employee smith = new Employee("SMITH");
		Employee king = new Employee("KING");
		Set<Employee> empSet = new HashSet<>();
		empSet.addAll(Arrays.asList(scott,smith,king)) ;
		d.setEmpSet(empSet);
		
		saxin.persist(d);
		saxin.persist(d2);
		
		saxin.flush();
		saxin.close();
		sf.close() ;
		
	}
}
