package br.com.cdi;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

/**
 * @author Felipe
 *
 */
public interface FacadeAdapter extends Serializable {
	
//	public br.com.cdi.BusinessBean getBusiness() ;
	
	/**
	 * Executa o comando e retorna um objecto
	 * @param httpSession
	 * @param mapa
	 * @param permissao
	 * @param params
	 * @return
	 * @throws GrowUpException
	 */
	public Object executarComando(final HttpSession httpSession, 
			final String mapa, String permissao,
			final Object... params) ;


}