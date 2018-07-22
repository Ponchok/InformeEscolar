package com.abarrotes.utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Esta clase facilita la conexión a la base d edatos.
 * @author ponchoadmin
 *
 */
public  class AccesoBaseDatos {

	protected Connection conn = null;
	protected Statement stm = null;
	protected ResultSet rs = null;
	protected boolean esUsuarioRegistrado = false;
	protected boolean esUsuarioAdmin = false;
	
	
	/**
	 * Este Metodo permite la conexxion con la base de datos
	 * @return
	 */
	public  Connection obtenerConexion(){
		Connection conn = ConexionBD.conectarBD();
		return conn;
	}
	
	
}
