package com.abarrotes.utilidades;

import java.sql.SQLException;

public class VentaArticulosGenerador extends AccesoBaseDatos {
	
	
	public String generarVentaArticulo(String articulos, String cantidades){
		
		String ventasPorArticulo = "";
		String obtenerPrecios = "";
		String articulo = articulos.substring(0, (articulos.length() - 1));
		String cantidad = cantidades.substring(0, (cantidades.length() - 1));
		
		try {
			conn = obtenerConexion();
			stm = conn.createStatement();
			System.out.println("ARTICULOS: " + articulo);
			String query = Constantes.DAO_SELECCION_PRECIOS_ARTICULOS_1 + articulo + Constantes.DAO_SELECCION_PRECIOS_ARTICULOS_2;
			rs = stm.executeQuery(query);
			

			while(rs.next()){
				int precio = rs.getInt("precio");
				System.out.println("Checando precio: " + precio);
				obtenerPrecios += precio +",";
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		String[] articulosLista = articulo.split(",");
		String [] cantidadesLista = cantidad.split(",");
		String [] preciosLista = obtenerPrecios.split(",");
		
		for (int i = 0; i < articulosLista.length; i++ ){
			System.out.println("Iteracion: " + i);
			ventasPorArticulo +=  (Integer.parseInt(cantidadesLista[i]) * Integer.parseInt(preciosLista[i])) + ",";
			 System.out.println("Venta de este articulo: " + ventasPorArticulo);
			
		}
		
		return ventasPorArticulo;
		
	}
	

}
