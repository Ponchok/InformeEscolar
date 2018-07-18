package com.abarrotes.controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abarraotes.dao.AccesoVentas;
import com.abarraotes.dao.GeneradorID;
import com.abarrotes.utilidades.FechaGenerador;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articulos = request.getParameter("seleccionLista");
		System.out.println("\nDetalle Venta en Servlet: " + articulos);
		//Resultado = Detalle Venta en Servlet: 31,48,82,91,
		
		String cantidades = request.getParameter("cantidadesLista");
		System.out.println("Detalle Cantidades: " + cantidades);
		//Resultado = Detalle Venta en Servlet: Detalle Cantidades: 3-2-2-6-
		
		System.out.println("Empezando prueba insert en tabla ventas y detalle ventas");
		AccesoVentas ac = new AccesoVentas();
		ac.insertDetalleVenta( articulos, cantidades, "1", "1");
		
		
		/*
		 * Ya hemos podido obtener los id's de los articulos y las cantidades 
		 * Ahora hay que insertarlos en la base d edatos
		 * 
		 * Ejemplo Quey para el insert en la tabla detalle venta
		 * INSERT INTO `SandBoxAbarrote`.`detalleventa` (`idVenta`, `idArticulo`, `cantidad`, `idEmpleado`, `idCliente`) VALUES ('31', '1', '1', '1', '1');
		 * 
		 * Ejemplo Quey Insert a tabla ventas
		 * INSERT INTO `SandBoxAbarrote`.`ventas` (`idVenta`, `fecha`) VALUES ('31', '2018-07-17');
		 * 
		 */
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		//EXITOSO INSERTAR EN TABLA VENTAS
//		System.out.println("Empezando prueba insert en tabla ventas");
//		AccesoVentas ac = new AccesoVentas();
//		String idVenta = ac.insertarVenta();
//		System.out.println("Terminado Prueba, obtuvimos registro nuevo: " + idVenta);
		//EXITOSO INSERTAR EN TABLA VENTAS
		
		
		//EXITOSO INSERTAR EN TABLA DETALLE VENTAS
//		System.out.println("Empezando prueba insert en tabla ventas y detalle ventas");
//		AccesoVentas ac = new AccesoVentas();
//		ac.insertDetalleVenta( "50,2,", "10,30,", "1", "1");
		//EXITOSO INSERTAR EN TABLA DETALLE VENTAS
		
		
		
		
	}

}
