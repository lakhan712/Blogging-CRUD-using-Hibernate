package hbmodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hbController.HibernateUtil;

public class PostService {
	
	public static boolean createPost(String post, int userId) {
		try {
		SessionFactory sf = HibernateUtil.sessionFactory();
		Session session= sf.openSession();
		session.getTransaction().begin();
		Post postOb = new Post();
		postOb.setPost(post);
		postOb.setLikeCount(50);
		postOb.setDislikeCount(15);
		postOb.setUserId(userId);
		
		session.save(postOb);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
