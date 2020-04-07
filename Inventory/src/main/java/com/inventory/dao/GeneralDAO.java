package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GeneralDAO {

	private Session session;
	
	public void connect() {
		StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();
		
		try {
			SessionFactory sessionFactory = 
					new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			session = sessionFactory.openSession();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}
	}
}
