package hbmodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hbController.HibernateUtil;

public class HBRegisterService {
	
	public static void registerUserHB(User user) throws Exception {
		SessionFactory sessionF = HibernateUtil.sessionFactory();
		
		//OPEN CONNECTION
		Session session = sessionF.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(user);
		txn.commit();
		session.close();
		//sessionF.close();
		
	}

}
