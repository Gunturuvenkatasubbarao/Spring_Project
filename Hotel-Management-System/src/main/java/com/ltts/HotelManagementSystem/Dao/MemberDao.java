package com.ltts.HotelManagementSystem.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.HotelManagementSystem.model.Member;



@Repository
public class MemberDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertMember(Member m) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(m);
			//System.out.println(st);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}
//		finally {
//			sf.close();
//		}
		
		return b;
	}
	
	
	/*
	 * public List<Member> getMembers(){ List }
	 */
	
	public Member getMemberByEmail(String email) {

		
		Member m = (Member)sf.openSession().get(Member.class,email);
		return m;
	}
	public List<Member> getAllMembers(){
		 Session session=sf.openSession();
	        session.beginTransaction();
	        
	        List<Member> li=sf.openSession().createCriteria(Member.class).list();
	        //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
	        
	        session.getTransaction().commit();
	        return li;
	}
}

