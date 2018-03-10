package org.denny.bean.test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.denny.bean.Course;
import org.denny.bean.Student;
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
		
		Course c1 = new Course("Java",89) ;
		Course c2 = new Course("Java",89) ;
		Course c3 = new Course("Java",89) ;
		Set<Course> courseSet = new HashSet<>() ;
		courseSet.addAll(Arrays.asList(c1,c2,c3)) ;
		
		Student stu = new Student("龙永凌") ;
		
		stu.setCourseSet(courseSet);
		
		saxin.persist(stu);
		saxin.persist(c1);
		saxin.persist(c2);
		saxin.persist(c3);
		
		saxin.flush();
		saxin.close();
		sf.close() ;
		
	}
}
