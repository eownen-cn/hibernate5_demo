package org.denny.t;

import java.util.Collections;
import java.util.List;

import org.denny.bean.Member;
import org.denny.h.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 * Hibernate CRUD Basic Testing 
 * @author Ewonen-PC
 *
 */
//@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory.getCurrentSession();
		try {
			// 整个过程只开启一个事物
			session.getTransaction().begin();
//			save(session);
			Member m = persist1(session);
//			persist2(session);
//			saveOrUpdate1(session);
//			saveOrUpdate2(session);
			update(session,m); 
			update2(session,m); 
			update3(session,m); 
			update4(session,m); 
//			delete(session);
//			remove(session);
			list(session);
//			load(session);
//			get(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println( "\n\n错误信息：" + e.getMessage() + "\n\n错误原因：" + e.getCause());
			session.getTransaction().rollback();
		} finally {
			session.close();
			HibernateUtils.getSessionFactory.close();
		}
	}

	@SuppressWarnings("deprecation")
	private static void update2(Session session, Member m) {
		Query<?> query = session.createQuery("update Member set title=? where id=?");
		query.setString(0, "Updatting 2 new title 哈哈哈！") ;
		query.setInteger(1,m.getMid()) ;
		query.executeUpdate() ;
	}
	
	private static void update3(Session session, Member m) {
		Query<?> query = session.createQuery("update Member set content=? where id=?");
		query.setParameter(0, "Updatting 2 new title 哈哈哈！") ;
		query.setParameter(1,m.getMid()) ;
		query.executeUpdate() ;
	}
	
	private static void update4(Session session, Member m) {
		m.setContent("The four update function in the single Object");
		session.update(m);
	}

	private static void update(Session session, Member m) {
		m.setTitle("哈哈哈哈哈按不出哈哈 啧啧~");
		session.update(m);
	}

	private static void remove(Session session) {
		Member m = new Member() ;
		m.setMid(4) ;
		session.remove(m);
	}

	private static Member persist1(Session session) {
		Member m = new Member("Hello","world");
		session.persist(m); 
		return m ;
	}

	private static void persist2(Session session) {
		Member m = new Member("Hello","world");
//		m.setMid(6);// detached entity passed to persist 使用persist保存对象时不能指定ID哦
		session.persist(m);
	}

	private static void saveOrUpdate1(Session session) throws Exception { // 执行save
		Member m = new Member("saveOrUpdate1","saveOrUpdate1") ;
		session.saveOrUpdate(m);
	}
	
	private static void saveOrUpdate2(Session session) throws Exception { // 执行update修改ID为13的行记录
		Member m = new Member("saveOrUpdate2","saveOrUpdate2") ;
		m.setMid(6);
		session.saveOrUpdate(m);
	}

	private static void delete(Session session) throws Exception{
		Member m = new Member() ;
		m.setMid(5);
		session.delete(m);
	}

	private static void get(Session session) throws Exception{
		Member m = session.get(Member.class, 10) ; // 直接从数据库查询
		System.err.println("使用get读取：" + m);
	}

	private static void load(Session session)  throws Exception{
		
		// m 为准备查询的代理，但实际上，在这一步完成后并未进行查询
		// 代理对象保存了预查询的状态
		Member m = session.load(Member.class, 25) ; 
		
		// 当这个 m(代理对象)被访问或使用的时候，hibernate将执行真实的数据检索操作
		System.err.println("使用load加载数据：" + m); 
	}

	private static void list(Session session) throws Exception {
		System.err.println("编号\t\t标题\t\t内容");
		List<Member> list = session.createQuery("from Member", Member.class).list() ;
		Collections.sort(list,(a,b)->a.getMid()>b.getMid() ? 1 : -1);
		for (Member m : list){
			System.err.println(m.getMid() + "\t\t" + m.getTitle() + "\t\t" + m.getContent());
		}
	}

	private static void save(Session session) throws Exception{
		session.save(new Member("测标题","测内容")) ;
	}
}
