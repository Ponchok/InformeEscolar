package com.abarrotes.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abarraotes.dao.AccesoSistema;

/**
 * Servlet implementation class AdminControler
 * Este Servlet es el Controlador el cual determina los accesos a la aplicación.
 */
@WebServlet("/AdminControler")
public class AdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminControler() {
		super();
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
		
		String usuario = ((request.getParameter("accesID") != null) && (!request.getParameter("accesID").isEmpty())) ? request.getParameter("accesID") : "USUARIO INVALIDO";
		String password = ((request.getParameter("passID") != null) && (!request.getParameter("passID").isEmpty())) ? request.getParameter("passID") : "CONTRASEÑA INVALIDO";

		AccesoSistema acceso = new AccesoSistema(usuario, password);
		if (acceso.esUsuarioRegistrado() && acceso.esUsuarioAdmin())
			response.sendRedirect("administracion.html");

		else if (acceso.esUsuarioRegistrado())
			response.sendRedirect("ventas.jsp");

		else
			response.sendRedirect("noAcceso.html");

	}

}
