package com.abarraotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.tomcat.util.buf.UDecoder;

import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;
import com.abarrotes.utilidades.FechaGenerador;
import com.abarrotes.utilidades.GeneradorID;

public class AccesoVentas extends AccesoBaseDatos {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public AccesoVentas(){
		conn = obtenerConexion();
	}

	/**
	 * Metodo para insertar una nueva venta con fecha en la tabla "ventas"
	 * Ejemplo Quey Insert a tabla ventas INSERT INTO SandBoxAbarrote.ventas
	 * (idVenta, fecha) VALUES (31, 2018-07-17);
	 */
	public String insertarVenta() {

		GeneradorID id = new GeneradorID();
		String idVenta = id.generarIDVenta();
		String fechaVenta = FechaGenerador.fechaBD(new Date());

		try {
			stmt = conn.prepareStatement(Constantes.DAO_INSERTAR_VENTA);
			stmt.setString(1, idVenta);
			stmt.setString(2, fechaVenta);
			int i = stmt.executeUpdate();
			System.out.println("Insertado en la tabla ventas " + i + " registros");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Saliendo de metodo insertarVenta()");
		return idVenta;
	}

	
	
	
	
	
	
	/**
	 * Metodo para insertar una detalle de venta en la tabla "detalleventa"
	 * Ejemplo Query INSERT INTO `SandBoxAbarrote`.`detalleventa` (`idVenta`,
	 * `idArticulo`, `cantidad`, `idEmpleado`, `idCliente`) VALUES ('31', '1',
	 * '1', '1', '1');
	 * 
	 * @param idVenta
	 * @param idArticulo
	 * @param idEmpleado
	 * @param idCliente
	 */
	public void insertDetalleVenta(String idArticulo, String cantidades, String idEmpleado, String idCliente) {

		System.out.println("Entrando a Metodo insertarDetalleVenta");
		// Insertar Id de venta y a su vez insertando en tabla de ventas
		String idVenta = insertarVenta();
        System.out.println("Valor del ID en el metodo insertarDetalleVenta: " + idVenta);
		
		// Del string con todos los articulos, remover el ultimo caracter
		String articulos = idArticulo.substring(0, (idArticulo.length() - 1));
		String [] articulosLista = articulos.split(",");
		System.out.println("Tamano del array de articulos: " + articulosLista.length);
		System.out.println("Imprimiendo array ya separado de articulos: " + articulosLista.toString());
		

		// Del string con todos las cantidades, remover el ultimo caracter
		String cantidad = cantidades.substring(0, (cantidades.length() - 1));
		String [] cantidadLista = cantidad.split(",");
		System.out.println("Tamano del array de cantidades: " + cantidadLista.length);
		System.out.println("Imprimiendo array ya separado de cantidades: " + cantidadLista.toString());
		
		// El idEmpleado sacarlo despues del obejto Session
		idEmpleado = "1";
		// El idCliente sacarlo luego del request
		idCliente = "1";
		// Del String con los articulos, removemos el ultimo caracter

		int registrosInsertados = 0;
		
		try {
			stmt = conn.prepareStatement(Constantes.DAO_INSERTAR_DETALLE_VENTA);

			for (int i = 0; i < articulosLista.length; i++) {
				System.out.println("Iteracion: " + i);
				
				stmt.setString(1, idVenta);
				System.out.println("ID de venta: " + idVenta);
				
				stmt.setString(2, articulosLista[i]);
				System.out.println("articulo: " + articulosLista[i]);
				
				stmt.setString(3, cantidadLista[i]);
				System.out.println("cantidad: " + cantidadLista[i]);
				
				stmt.setString(4, idEmpleado);
				System.out.println("ID Empleado: " + idEmpleado);
				
				stmt.setString(5, idCliente);
				System.out.println("ID Cliente: " + idCliente);
				
				registrosInsertados += stmt.executeUpdate();
				
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
		

		System.out.println("Saliendo de Metodo insertarDetalle ventas");
		System.out.println("Registros insertados: " + registrosInsertados);
	}

}
