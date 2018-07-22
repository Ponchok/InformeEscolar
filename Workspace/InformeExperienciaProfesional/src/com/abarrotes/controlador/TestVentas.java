package com.abarrotes.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.FechaGenerador;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articulos = request.getParameter("seleccionLista");
		System.out.println("\nDetalle Venta en Servlet: " + articulos);
		// Resultado = Detalle Venta en Servlet: 1,2,3,

		String cantidades = request.getParameter("cantidadesLista");
		System.out.println("Detalle Cantidades: " + cantidades);
		// Resultado = Detalle Venta en Servlet: Detalle Cantidades: 1,1,1,

		VentaArticulosGenerador vag = new VentaArticulosGenerador();
		String ventaArticulos = vag.generarVentaArticulo(articulos, cantidades);
		System.out.println("Detalle de Venta por Articulo: " + ventaArticulos);
		// Resultado = Detalle de Venta por Articulo: 40,70,60,12,
		
		
		
		
		
		
		

	}

}
