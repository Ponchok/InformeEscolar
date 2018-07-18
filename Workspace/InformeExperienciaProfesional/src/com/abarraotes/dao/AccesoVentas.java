package com.abarraotes.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;
import com.abarrotes.utilidades.FechaGenerador;

public class AccesoVentas extends AccesoBaseDatos {

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
			conn = obtenerConexion();
			PreparedStatement stmt = conn.prepareStatement(Constantes.DAO_INSERTAR_VENTA);
			stmt.setString(1, idVenta);
			stmt.setString(2, fechaVenta);
			int i = stmt.executeUpdate();
			System.out.println("Insertado en la tabla ventas " + i + " registros");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idVenta;
	}

}
