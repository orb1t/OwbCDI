package br.com.cdi.listener;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanFactory {
	
	static BeanManager getBeanManager() {
	    InitialContext context;
	    Object result;
	    try {
	        context = new InitialContext();
	        result = context.lookup("java:comp/env/BeanManager"); //lookup in Tomcat
	    } catch (NamingException e) {
	        try {
	            context = new InitialContext();
	            result = context.lookup("java:comp/BeanManager"); //lookup in JBossAS
	        } catch (NamingException ex) {
	            throw new RuntimeException("BeanManager could not be found in JNDI", e);
	        }
	    }
	    return (BeanManager) result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getContextualInstance(final Class<T> type) {
		BeanManager manager = getBeanManager();
	    
//	    @SuppressWarnings("serial")
//		Annotation[] annotations = { new AnnotationLiteral<BusinessBean>() {} };
        
		Set<Bean<?>> beans = manager.getBeans(type /*, annotations*/);
//		beans = manager.getBeans(type);
//		beans = manager.getBeans("teste");
		Bean<T> bean = (Bean<T>) manager.resolve(beans);
	    return getBeanReference(manager, bean);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getContextualInstance(final String beanName) {
		BeanManager manager = getBeanManager();
		
//	    @SuppressWarnings("serial")
//		Annotation[] annotations = { new AnnotationLiteral<BusinessBean>() {} };
		
		Set<Bean<?>> beans = manager.getBeans(beanName);
//		beans = manager.getBeans(type);
//		beans = manager.getBeans("teste");
		Bean<T> bean = (Bean<T>) manager.resolve(beans);
		return getBeanReference(manager, bean);
	}

	@SuppressWarnings("unchecked")
	private static <T> T getBeanReference(BeanManager manager, Bean<T> bean) {
		T result = null;
		if (bean != null) {
	        CreationalContext<T> context = manager.createCreationalContext(bean);
	        if (context != null) {
	            result = (T) manager.getReference(bean, bean.getBeanClass(), context);
	        }
	    }
	    return result;
	}
	
	
	public static void fireEvent(Object event, Annotation... qualifiers) {
		getBeanManager().fireEvent(event, qualifiers);
	}
	
}
