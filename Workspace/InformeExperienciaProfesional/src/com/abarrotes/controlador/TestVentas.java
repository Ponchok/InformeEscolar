package com.abarrotes.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abarraotes.dao.AccesoVentas;
import com.abarrotes.utilidades.VentaArticulosGenerador;

/**
 * Servlet implementation class TestVentas
 */
@WebServlet("/TestVentas")
public class TestVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//	PREPARANDO INFORMACION OBTENIDA DEL FORMULARIO
		
		String articulosRAW = request.getParameter("seleccionLista");
		String articulos = articulosRAW.substring(0, (articulosRAW.length() - 1));

		
		String cantidadesRAW = request.getParameter("cantidadesLista");
		String cantidades = cantidadesRAW.substring(0, (cantidadesRAW.length() - 1));
		
		
		//Faltaria obtener empleado y cliente
		
		
		AccesoVentas ac = new AccesoVentas();
		ac.insertDetalleVenta(articulos, cantidades, "1", "1");
		
		
		
		
		

	}

}
