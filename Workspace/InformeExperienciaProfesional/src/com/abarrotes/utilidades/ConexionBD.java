package com.abarrotes.utilidades;

import java.sql.*;

/**
 * Esta clase entabla la conexion directa con la base de datos.
 * 
 *
 */
public class ConexionBD {

	/**
	 * Metodo para entablar la conexion con la base de datos.
	 * 
	 * @throws ClassNotFoundException,
	 *             SQLException
	 * 
	 */
	public static Connection conectarBD() {
		Connection conn = null;

		try {
			Class.forName(Constantes.MYSQL_DRIVER);
			System.out.println("Conectando a base de datos...");
			conn = DriverManager.getConnection(Constantes.CONEXION_BD, Constantes.USUARIO_MYSQL,
					Constantes.CONTRASENA_MYSQL);
		} catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());	
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Conexion establecida...");
		return conn;

	}

}
