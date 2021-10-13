package com.nagarro.java.config;


@configuration
public class LibConfig {
	@Bean
	public HibernateDao getHibernateDao() {
		return new HibernateDaoImplementation();
	}


	@Bean
	public LoginService getLoginService() {
		return new LoginService();
	}

	@Bean
	public BookManagementService getLibraryManagementService() {
		return new BookManagementService();
	}

}
