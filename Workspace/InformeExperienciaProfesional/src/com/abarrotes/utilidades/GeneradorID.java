package com.abarrotes.utilidades;

import java.sql.SQLException;
import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;

/**
 * Esta clase generadora permite obtener ID's unicas de la base de datos para nuevas transacciones
 * 
 *
 */
public class GeneradorID extends AccesoBaseDatos {

	/**
	 * Este Metodo regresa un ID de la base de datos y que se puede
	 * usar en una nueva transaccion de venta.
	 * @return ID de base de datos como Venta.
	 */
	public String generarIDVenta() {
		String id = null;
		try {
			conn = obtenerConexion();
			stm = conn.createStatement();
			String query = Constantes.DAO_OBTENER_ID_VENTA;
			rs = stm.executeQuery(query);

			while (rs.next()) {
				id = rs.getString("count(idVenta)");
			}

			conn.close();
			stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int valor = (Integer.parseInt(id) + 1);
		return id = String.valueOf(valor);

	}

}