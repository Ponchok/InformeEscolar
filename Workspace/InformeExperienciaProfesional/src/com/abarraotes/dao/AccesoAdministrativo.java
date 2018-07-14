package com.abarraotes.dao;


import java.sql.*;
import com.abarrotes.utilidades.ConexionBD;
import com.abarrotes.utilidades.Constantes;

public class AccesoAdministrativo  {


	/**
	 * Metodo Data Acces Object para obtener datos de la tabla "Acceso" y
	 * autenticar el acceso a usuarios administradores.
	 * 
	 * @param usuario
	 * @param contraseña
	 * @return boolean | Es usuario Administrador?
	 */
	public boolean esUsuarioAdmin(String usuario, String contraseña) {
		boolean esAdmin = false;

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = ConexionBD.conectarBD();
			stm = conn.createStatement();
			String query = Constantes.DAO_TABLA_ACCESO;
			rs = stm.executeQuery(query);

			while (rs.next()) {
				if (usuario.equals(rs.getString("empleado")) && contraseña.equals(rs.getString("contraseña"))) {
					esAdmin = true;
					System.out.println("Usuario es Administrador identificado...");
					break;
				} else
					System.out.println("Usuario NO es Administrador ...");
				break;
			}

			conn.close();
			stm.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esAdmin;
	}

	public static void main(String[] args) {
		AccesoAdministrativo ad = new AccesoAdministrativo();
		ad.esUsuarioAdmin("admin", "ual12345");
	}

}