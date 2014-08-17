package br.com.cdi.listener;

import java.io.Serializable;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.deltaspike.core.api.provider.BeanManagerProvider;
import org.apache.log4j.Logger;


/**
 * @author Felipe
 *
 */
@WebListener
public class SessaoExpiradaListener implements HttpSessionListener {
    private static final Logger LOG = Logger.getLogger(SessaoExpiradaListener.class);


    @Override
    public void sessionCreated(HttpSessionEvent events) {
        LOG.info("sessionCreated");

        BeanManagerProvider.getInstance().getBeanManager().fireEvent(new SessaoExpiradaEvent(events.getSession()));
        LOG.info("beanManager fired SomeDummyEvent.");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        BeanManagerProvider.getInstance().getBeanManager().fireEvent(new SessaoExpiradaEvent(event.getSession()));

        LOG.info("beanManager fired SomeDummyEvent.");
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
