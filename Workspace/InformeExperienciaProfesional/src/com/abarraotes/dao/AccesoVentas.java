package com.abarraotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;
import com.abarrotes.utilidades.FechaGenerador;
import com.abarrotes.utilidades.GeneradorID;
import com.abarrotes.utilidades.VentaArticulosGenerador;

/**
 * Esta clase realiza las operaciones referentes a Ventas en la base de datos
 */
public class AccesoVentas extends AccesoBaseDatos {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private String idVenta = "";
	private String ventatotal = "";
	
	public AccesoVentas(){
		conn = obtenerConexion();
		idVenta = new GeneradorID().generarIDVenta();
	}

	
	
	/**
	 * Metodo para insertar una nueva venta con fecha en la tabla "ventas"
	 * Ejemplo Quey Insert a tabla ventas INSERT INTO SandBoxAbarrote.ventas
	 * (idVenta, fecha) VALUES (31, 2018-07-17,495);
	 */
	private  void insertarVenta(String idVenta, String articulos, String cantidades ) {

		VentaArticulosGenerador vag = new VentaArticulosGenerador();
		String fechaVenta = FechaGenerador.fechaBD(new Date());
		String ventaTotal = vag.ventaTotal(idVenta, articulos, cantidades);
		
		
		try {
			stmt = conn.prepareStatement(Constantes.DAO_INSERTAR_VENTA);
			stmt.setString(1, idVenta);
			stmt.setString(2, fechaVenta);
			stmt.setString(3, ventaTotal);
		    stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	/**
	 * Metodo para insertar una detalle de venta en la tabla "detalleventa"
	 * Ejemplo Query INSERT INTO `SandBoxAbarrote`.`detalleventa` (`idVenta`,
	 * `idArticulo`, `cantidad`, `idEmpleado`, `idCliente`, `ventaTotalArticulo` ) VALUES ('31', '1',
	 * '1', '1', '1', '1');
	 * 
	 * @param idVenta
	 * @param idArticulos
	 * @param idEmpleado
	 * @param idCliente
	 */
	public void insertDetalleVenta(String articulos, String cantidades, String idEmpleado, String idCliente) {
		
		String [] articulosLista = articulos.split(",");
		String [] cantidadLista = cantidades.split(",");
		
		// El idEmpleado sacarlo despues del obejto Session
		idEmpleado = "1";
		// El idCliente sacarlo luego del request
		idCliente = "1";
	
		VentaArticulosGenerador vag = new VentaArticulosGenerador();
		String ventaArticulosRAW = vag.generarVentaArticulo(articulos, cantidades);
		String ventaArticulos = ventaArticulosRAW.substring(0, (ventaArticulosRAW.length() - 1));
		
		
		String [] ventasLista = ventaArticulos.split(",");
		

		int registrosInsertados = 0;
		insertarVenta(idVenta, articulos, cantidades);
		
		
		try {
			stmt = conn.prepareStatement(Constantes.DAO_INSERTAR_DETALLE_VENTA);

			for (int i = 0; i < articulosLista.length; i++) {
				
				stmt.setString(1, idVenta);
				stmt.setString(2, articulosLista[i]);
				stmt.setString(3, cantidadLista[i]);
				stmt.setString(4, idEmpleado);
				stmt.setString(5, idCliente);
				stmt.setString(6, ventasLista[i]);
				registrosInsertados += stmt.executeUpdate();
			}
			
			stmt = conn.prepareStatement(Constantes.DAO_OBTENER_SUMA_TOTAL_VENTA);
			stmt.setString(1, idVenta);
			ResultSet rs2 = stmt.executeQuery();
			while (rs2.next()) {
				ventatotal = rs2.getString("sum(ventaTotalArticulo)");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		System.out.println("Registros insertados: " + registrosInsertados);
	}
	
	
	
	
	/**
	 * Este Metodo nos regresa el ID de venta que se utilizara en el detalle de las ventas.
	 * @return
	 */
	public String getIdVenta(){
		return idVenta;
	}
	
	
	
	public String obtenerVentaTotal(){
		return ventatotal;
	}
	
	

}
