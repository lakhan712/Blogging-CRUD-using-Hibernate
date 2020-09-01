package hbmodel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hbController.HibernateUtil;

public class GetData {
	
	public static List<User> data() {

		  List<User> list;

		SessionFactory sessionF = HibernateUtil.sessionFactory();

		Session session = sessionF.openSession();
		Transaction txn = session.beginTransaction();
		Query query = session.createQuery("from User");
		list= (List<User>) query.list();
		txn.commit();
		session.close();
		
		System.out.println(list);

		return list;
	}

}
