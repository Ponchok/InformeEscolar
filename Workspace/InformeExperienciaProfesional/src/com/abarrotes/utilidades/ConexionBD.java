package com.abarrotes.utilidades;

import java.sql.*;

public class ConexionBD {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	
	public static void main(String[] args) {

		
		ConexionBD.conectarBD();
		ConexionBD.muestraTablaAcceso();
		ConexionBD.desconectarBD();
	}

	
	
	
	/**
	 * Metodo para entablar la conexion con la base de datos.
	 * 
	 */
	public static void conectarBD() {
		try {
			Class.forName(Constantes.MYSQL_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(Constantes.CONEXION_BD, Constantes.USUARIO_MYSQL, Constantes.CONTRASENA_MYSQL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para terminar y cerrar la conexiona la base de datos
	 */
	public static void desconectarBD() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TESTEO
	public static void muestraTablaAcceso() {
		
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select * from acceso;";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("idEmpleado");
				String nombre = rs.getString("empleado");
				String contraseña = rs.getString("contraseña");

				// Display values
				System.out.print("idEmpleado: " + id);
				System.out.print(", nombre: " + nombre);
				System.out.print(", contraseña: " + contraseña + "\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
