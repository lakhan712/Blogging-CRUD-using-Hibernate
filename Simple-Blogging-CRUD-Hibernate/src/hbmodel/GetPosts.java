package hbmodel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hbController.HibernateUtil;

public class GetPosts {
	
	
	public static List<Post> getPosts(int userId){
		try {
			List<Post> list = null;
			SessionFactory sf = HibernateUtil.sessionFactory();
			Session session= sf.openSession();
			System.out.println("We are in GetPosts method");
			Query query = session.createQuery("from Post where userId = :userId").setParameter("userId", userId);
					//.setParameter("userId", userId);
				list = query.list();
			session.close();
			System.out.println("returning the actual data list");
			return list;
		}catch(Exception e) {
			e.printStackTrace();

			return null;
		}
		
	}

}
