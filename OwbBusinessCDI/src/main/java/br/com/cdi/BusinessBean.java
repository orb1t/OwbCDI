package br.com.cdi;

import java.io.Serializable;

@javax.inject.Named
@javax.enterprise.context.RequestScoped
public class BusinessBean implements Serializable {

	/**
	 *  Atributo '<code>serialVersionUID</code>' do tipo long
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	public void execute() {
		System.out.println(getClass().getSimpleName() +  " executed");
	}
}
