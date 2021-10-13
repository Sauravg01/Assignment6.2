package com.nagarro.java.DAO;

import org.hibernate.Session;

public class Hibernate {
	public Session getSession();

	public void begin();

	public void commit();

	public void close();

	public void rollback();
}
