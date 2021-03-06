package com.abarraotes.dao;

import java.sql.*;
import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarrotes.utilidades.Constantes;

/**
 * Esta clase es utilizada permitir el acceso a usuarions Administradores y
 * Empleados en base a los registros dados de alta en la base de datos. BD
 * Tablas; "acceso" TAREAS: 1.- Autenticacion de Usuarios. 2.- Determinar si son
 * Usuarios empleados o administrativos.
 * 
 *
 */

public class AccesoSistema extends AccesoBaseDatos {

	public AccesoSistema(String usuario, String contraseña) {
		try {
			conn = obtenerConexion();
			stm = conn.createStatement();
			String query = Constantes.DAO_TABLA_ACCESO;
			rs = stm.executeQuery(query);

			while (rs.next()) {
				if (usuario.equals(rs.getString("usuario")) && contraseña.equals(rs.getString("contraseña"))) {
					esUsuarioRegistrado = true;
					if ("SI".equals(rs.getString("esAdmin"))) {
						esUsuarioAdmin = true;
					}
				}
			}

			conn.close();
			stm.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean esUsuarioRegistrado() {
		return esUsuarioRegistrado;
	}

	public boolean esUsuarioAdmin() {
		return esUsuarioAdmin;
	}

}
