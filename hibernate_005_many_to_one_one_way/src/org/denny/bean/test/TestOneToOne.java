package org.denny.bean.test;

import java.util.EnumSet;

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
	public static void test1(){
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Employee emp1 = new Employee("龙永凌");
		Employee emp2 = new Employee("利用率");
		Employee emp3 = new Employee("利用了");
		Dept dept = new Dept("财务部");
		emp1.setDept(dept);
		emp2.setDept(dept);
		emp3.setDept(dept);
		saxin.persist(dept);
		saxin.persist(emp1);
		saxin.persist(emp2);
		saxin.persist(emp3);
		
		saxin.flush();
		sf.close() ;
	}
	public static void main(String[] args) {
		test1() ;
	}
}
