package org.denny.bean.test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
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
		
		Orders o1 = new Orders("第一个订单") ;
		Orders o2 = new Orders("第二个订单") ;
		Orders o3 = new Orders("第三个订单") ;
		Account act = new Account("龙永凌");
		
		Set<Orders> orderSet = new HashSet<>();
		
		orderSet.addAll(Arrays.asList(o1,o2,o3)) ;
		
		act.setOrderSet(orderSet);
		
		saxin.persist(o1);
		saxin.persist(o2);
		saxin.persist(o3);
		saxin.persist(act);
		
		List<Account> countList = saxin.createQuery("from Account", Account.class).list();
		Account c = countList.get(0);
		System.err.println("账户ID\t\t账户名");
		System.err.println(c.getCountId() + "\t\t" + c.getCountName());
		System.err.println("我的订单");
		for( Orders o : c.getOrderSet() ) {
			System.err.println(o.getOrderId() + "\t" + o.getOrderNO() + "\t" + o.getOrderTime());
		}
		
		saxin.flush();
		saxin.close() ;
		sf.close() ;
	}
}
