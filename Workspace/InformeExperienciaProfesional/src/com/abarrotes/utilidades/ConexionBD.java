package com.abarrotes.utilidades;

import java.sql.*;

public class ConexionBD {

	//static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String BASE_DE_DATOS = Constantes.CONEXION_BD;


	static final String USUARIO_BD = Constantes.USUARIO_MYSQL;
	static final String CONTRASEÑA_BD = Constantes.CONTRASENA_MYSQL;

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 
			 System.out.println("Connecting to database...");
			 conn = DriverManager.getConnection(BASE_DE_DATOS,USUARIO_BD,CONTRASEÑA_BD);
			 
			 System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "select * from acceso;";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		          //Retrieve by column name
		          int id  = rs.getInt("idEmpleado");
		          String nombre = rs.getString("empleado");
		          String contraseña = rs.getString("contraseña");

		          //Display values
		          System.out.print("idEmpleado: " + id);
		          System.out.print(", nombre: " + nombre);
		          System.out.print(", contraseña: " + contraseña + "\n");
		         
		       }
		       //STEP 6: Clean-up environment
		       rs.close();
		       stmt.close();
		       conn.close();
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

}
