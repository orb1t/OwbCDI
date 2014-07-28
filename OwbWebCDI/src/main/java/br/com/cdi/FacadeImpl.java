package br.com.cdi;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

//@javax.inject.Named("facade")
@javax.enterprise.context.SessionScoped
@javax.enterprise.inject.Default
//@javax.enterprise.context.ApplicationScoped
//@Facade// Declare the Qualifier
public class FacadeImpl implements FacadeAdapter {

	private static final long serialVersionUID = 1L;

	@Inject
	private br.com.cdi.BusinessBean business;
	
	/**
	 * Construtor para esta classe usado pelo Flex.
	 * 
	 */
	public FacadeImpl() {
	}

	@Override
	public Object executarComando(HttpSession httpSession, String mapa,
			String permissao, Object... params) {
		
		System.out.println("Command executed " + mapa + " permissão " + permissao);
		
		business.execute();
		
		return "OK";
	}
	
	public String toString() {
		return "FacadeImpl";
	}

}