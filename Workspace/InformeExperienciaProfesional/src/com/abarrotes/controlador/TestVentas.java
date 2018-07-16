package com.abarrotes.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("Venta en Servlet: " + articulos);
		
		articulos = articulos.substring(0, articulos.length()-1);
		System.out.println(articulos);
		
		String query = "select articulo.nombre as Nombre, articulo.descripcion as Descripcion, articulo.costo as Precio from articulo where articulo.idProducto in (";
        query += articulos;
        query += ");";
        
        System.out.println(query);
		
		
		/*
		 * Mejor hacer un JSP, ya estoy pasando los valores de la seleccion en ventas.jsp
		 * tomarlos y mostrar para realizar la cantidad
		 * En esta pagina hay un ejemplo
		 * http://www.myutilsjava.net/tutoriales/index.php/jsp/9-enviar-y-recibir-parametros-en-jsp
		 */
		
		
		/*
		 * Ya estoy pasando los ids de los articulos, preparar un query con estos
		 * 
		 * Ya esta saliendo copiar el jsp de ventas
		 */
		
		
		
		
	}
	
	

}
