package br.com.cdi.mbean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.cdi.FacadeAdapter;

@Named("myBean")
@RequestScoped
public class MyBean {

	@Inject
//	@javax.enterprise.context.ApplicationScoped
//	@br.com.cdi.Facade
	private FacadeAdapter facade;
	
	public String execute() {
		facade.executarComando(getJsfSession(true), "mapa", "permissao");
		return "OK";
	}
	
	private static HttpSession getJsfSession(boolean bln) {
		if (FacesContext.getCurrentInstance() ==  null)
			return null;
		else
			return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(bln);
	}
	
	public String getTitle() {
		return "WebOwbCDI";
	}
}
