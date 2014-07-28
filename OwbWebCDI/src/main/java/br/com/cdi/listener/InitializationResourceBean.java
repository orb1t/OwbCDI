package br.com.cdi.listener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;

import br.com.cdi.FacadeAdapter;

/**
 * @author Felipe
 *
 */
@javax.enterprise.context.ApplicationScoped
//@javax.inject.Named
public class InitializationResourceBean {

    private static final Logger LOG = Logger.getLogger(InitializationResourceBean.class);

    @javax.inject.Inject
//    @javax.enterprise.context.ApplicationScoped
//    @javax.enterprise.inject.Default
    private FacadeAdapter facade;

    public void listen(@Observes SessaoExpiradaListener.SessaoExpiradaEvent event) {
//    	LOG.info(getClass().getSimpleName() + facade.toString());
    	facade.executarComando(event.getSession(), "mapa","permissao");
    }

    @PostConstruct
    public void init() {
    	LOG.info(getClass().getSimpleName() + " init");
    	
    	LOG.info("facade created" + facade);
    }

    @PreDestroy
    public void destroy() {
    	LOG.info(getClass().getSimpleName() + " destroy");
    }
    
}