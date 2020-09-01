package hbmodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hbController.HibernateUtil;

public class HBUpdateService {
	
	public static boolean updatePost(String post, int userId) {
		try {
		SessionFactory sf = HibernateUtil.sessionFactory();
		Session session= sf.openSession();
		session.getTransaction().begin();
		Post postOb = session.get(Post.class, userId);
		postOb.setPost(post);
		session.save(postOb);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
