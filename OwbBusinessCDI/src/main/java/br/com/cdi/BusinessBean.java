package br.com.cdi;


@javax.inject.Named
@javax.enterprise.context.RequestScoped
public class BusinessBean {

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
