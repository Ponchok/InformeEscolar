package com.abarrotes.utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public  class AccesoBaseDatos {

	protected Connection conn = null;
	protected Statement stm = null;
	protected ResultSet rs = null;
	protected boolean esUsuarioRegistrado = false;
	protected boolean esUsuarioAdmin = false;
	
	public  Connection obtenerConexion(){
		Connection conn = ConexionBD.conectarBD();
		return conn;
	}
	
	
}