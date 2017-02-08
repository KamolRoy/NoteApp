package com.comolroy.webfm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//Enable the transactional capability. Used in service level.  
@EnableTransactionManagement
public class WebFmApplication {
	private static final Log log = LogFactory.getLog(WebFmApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx=	SpringApplication.run(WebFmApplication.class, args);
		
		log.info("Beans in application context:");
		
		String beanNames[] = ctx.getBeanDefinitionNames();
		for(String beanName: beanNames){
			log.info("[Created bean: "+ beanName + " ]");
		}
	}
}
