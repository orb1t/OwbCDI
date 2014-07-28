package br.com.cdi.listener;

import java.io.Serializable;

import javax.enterprise.inject.spi.BeanManager;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;


/**
 * @author Felipe
 *
 */
@WebListener
public class SessaoExpiradaListener implements HttpSessionListener {
	 private static final Logger LOG = Logger.getLogger(SessaoExpiradaListener.class);

//	@javax.inject.Inject
//	@javax.enterprise.inject.Default
//	@javax.enterprise.context.ApplicationScoped
//	@Facade
//	private FacadeAdapter facade;
	
	@Override
	public void sessionCreated(HttpSessionEvent events) {
		LOG.info("sessionCreated");
//		LOG.info("facade " + facade);
		
		BeanManager beanManager = BeanFactory.getBeanManager();
		if (beanManager != null) {
			beanManager.fireEvent(new SessaoExpiradaEvent(events.getSession()));
			LOG.info("beanManager fired SomeDummyEvent.");
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		// I need use the FacadeAdapter here !!!
//		facade.executarComando(event.getSession(), "mapa","permissao");
		
		BeanManager beanManager = BeanFactory.getBeanManager();
		if (beanManager != null) {
			beanManager.fireEvent(new SessaoExpiradaEvent(event.getSession()));
/*			final FacadeAdapter facade = BeanFactory.getContextualInstance("facade");
			
			LOG.info( facade );
			if ( facade.getBusiness() == null)
				LOG.info("facade.getBusiness() should not be null !");*/
				
			LOG.info("beanManager fired SomeDummyEvent.");
		} else {
			LOG.error("beanManager is null.  Cannot fire startup event.");
		}

	}

	static class SessaoExpiradaEvent implements Serializable {

		private HttpSession session;

		public SessaoExpiradaEvent(HttpSession session) {
			this.session = session;
		}
		
		private static final long serialVersionUID = 1L;

		public HttpSession getSession() {
			return session;
		}
    }


}
