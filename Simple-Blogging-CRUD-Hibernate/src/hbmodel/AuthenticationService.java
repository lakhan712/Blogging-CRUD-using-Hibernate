package hbmodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hbController.HibernateUtil;

public class AuthenticationService {
	private static User user=null;
	public static boolean valideateUserHB(String username, String password) {
		SessionFactory sessionF = HibernateUtil.sessionFactory();
		
		//OPEN CONNECTION
		Session session = sessionF.openSession();
		//Transaction txn = session.beginTransaction();
		
		try {
		Query query = session.createQuery("from User where username = :username and password = :password")
				.setParameter("username", username)
				.setParameter("password", password);

		System.out.println("AUTH checking in database");
		 user = (User) query.uniqueResult();
		// System.out.println("query result:  "+query.uniqueResult());
		session.close();
		}catch(Exception e) {
			
		}
		if(user==null) {
			//System.out.println("if null:  "+user);
			return false;
		}else {
			System.out.println("Auth is correct...");
			//System.out.println("if having value:  "+user);
			return true;
		}
	}
	
	public static User getUser() {
		return user;
	}
	
	
	
}
