package com.abarrotes.utilidades;

import java.sql.SQLException;
import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;

public class GeneradorID extends AccesoBaseDatos {

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