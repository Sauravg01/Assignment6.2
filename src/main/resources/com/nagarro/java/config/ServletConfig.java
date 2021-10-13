package com.nagarro.java.config;
@configuration
@ComponentScan({ "com.nagarro.java.controller" })
public class ServletConfig {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		return vr;
	}
}
