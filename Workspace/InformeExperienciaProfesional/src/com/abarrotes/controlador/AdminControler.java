package com.abarrotes.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abarraotes.dao.AccesoAdministrativo;

/**
 * Servlet implementation class AdminControler
 */
@WebServlet("/AdminControler")
public class AdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminControler() {
		super();
		System.out.println("SERVLET");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("accesID");
		String password = request.getParameter("passID");
		System.out.println("usuario: " + usuario + " *** " + "password: " + password);
		AccesoAdministrativo admin = new AccesoAdministrativo();

		if (admin.esUsuarioAdmin(usuario, password))
			response.sendRedirect("about.html");

		else
			response.sendRedirect("index.html");

	}

}
