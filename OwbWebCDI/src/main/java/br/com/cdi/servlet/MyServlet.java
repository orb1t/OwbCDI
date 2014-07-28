package br.com.cdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cdi.FacadeAdapter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/svlt")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private FacadeAdapter facade;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method "+ facade.executarComando(request.getSession(), "mapaSvlt", "permissaoSvlt") );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost method " + facade.toString());
	}

}
