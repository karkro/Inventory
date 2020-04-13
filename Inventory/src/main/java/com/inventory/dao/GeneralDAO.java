package com.inventory.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GeneralDAO {

	private Session session;
	private SessionFactory sessionFactory;
	
	public void connect() {
		StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();
		
		try {
			sessionFactory = 
					new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			session = sessionFactory.openSession();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			ex.printStackTrace();
		}
	}

	public void close() {
		if (session != null) {
			session.close();
			sessionFactory.close();
		}
	}

	public void save(Object obj) {
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
	public void delete(Object obj) {
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction();
	}
	
	public <T> Collection<T> list(Class<T> type) {
		List<T> result = 
				session.createCriteria(type)
				.setResultTransformer(
						Criteria.DISTINCT_ROOT_ENTITY).list();
		return result;
	}
	
	public <T> T get(Class<T> type, Serializable id) {
		return session.get(type, id);
	}
	
	
	
	
	
	
	
	
	
	
}
