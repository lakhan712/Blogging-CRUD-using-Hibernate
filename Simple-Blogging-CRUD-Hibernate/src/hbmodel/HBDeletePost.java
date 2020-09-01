package hbmodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hbController.HibernateUtil;

public class HBDeletePost {

	public static boolean deletePost(int userId) {
		try {
		SessionFactory sf = HibernateUtil.sessionFactory();
		Session session= sf.openSession();
		session.getTransaction().begin();
		Post post =  session.get(Post.class, userId);
		
		session.delete(post);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
