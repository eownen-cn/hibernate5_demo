package org.denny.bean.test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.denny.bean.Dept2;
import org.denny.bean.Employee2;
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

public class TestOneToManyTwoWay {
	
	/**
	 * 生成DDL语句
	 */
	@Test
	public final void test() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("twoway.cfg.xml").build();
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
		SessionFactory sf = config.configure("twoway.cfg.xml").buildSessionFactory() ;
		Session saxin = sf.getCurrentSession() ;
		saxin.getTransaction().begin();
		
		Dept2 d = new Dept2("策划部");
		Dept2 d2 = new Dept2("创意部");
		
		Employee2 blake = new Employee2("Blake");
		Employee2 jhon = new Employee2("Jhon");
		Employee2 alice = new Employee2("Alice");
		Set<Employee2> empSet = new HashSet<>() ;
		
		blake.setDept(d);
		jhon.setDept(d);
		alice.setDept(d);
		
		empSet.addAll(Arrays.asList(blake,jhon,alice)) ;
		d.setEmpSet(empSet);
		
		saxin.persist(d);
		
		jhon.setDept(d2); // 挖人
		Set<Employee2> empSet2 = new HashSet<>() ;
		empSet2.add(jhon) ;
		d2.setEmpSet(empSet2);
		
		saxin.persist(d2);
		
		System.out.println("\n\n创意部：" + Arrays.toString(d2.getEmpSet().toArray()) + "\n\n");
		System.out.println("\n\n策划部：" + Arrays.toString(d.getEmpSet().toArray()) + "\n\n");
		saxin.flush();
		saxin.close();
		sf.close() ;
		
	}
	public static void main(String[] args) {
		
	}
}
