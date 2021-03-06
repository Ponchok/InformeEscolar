package com.abarrotes.utilidades;

import java.sql.SQLException;

/**
 * 
 * Esta clase generadora permite la manipulación de datos aritmeticamente para la venta
 * de ariculos.
 *
 */
public class VentaArticulosGenerador extends AccesoBaseDatos {

	
	/**
	 * Este metodo calcula la venta total en base al articulo y a la cantidad del mismo
	 * @param articulos
	 * @param cantidad
	 * @return Venta total de un articulo
	 */
	public String generarVentaArticulo(String articulos, String cantidad) {

		String ventasPorArticulo = "";
		String obtenerPrecios = "";

		try {
			conn = obtenerConexion();
			stm = conn.createStatement();
			String query = Constantes.DAO_SELECCION_PRECIOS_ARTICULOS_1 + articulos + Constantes.DAO_SELECCION_PRECIOS_ARTICULOS_2;
			rs = stm.executeQuery(query);

			while (rs.next()) {
				int precio = rs.getInt("precio");
				obtenerPrecios += precio + ",";

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		String[] articulosLista = articulos.split(",");
		String[] cantidadesLista = cantidad.split(",");
		String[] preciosLista = obtenerPrecios.split(",");

		for (int i = 0; i < articulosLista.length; i++) {
			ventasPorArticulo += (Integer.parseInt(cantidadesLista[i]) * Integer.parseInt(preciosLista[i])) + ",";
		}

		return ventasPorArticulo;

	}

	
	
	/**
	 * Este Metodo realiza la suma de la venta de cada articulo en la trasaccion y regresa este total
	 * @param idVenta
	 * @param articulos
	 * @param cantidades
	 * @return
	 */
	public String ventaTotal(String idVenta, String articulos, String cantidades) {
		int cuenta = 0;
		String ventaTotal = "";
		String grupoVentaPre = generarVentaArticulo(articulos, cantidades);
		String grupoVenta = grupoVentaPre.substring(0, (grupoVentaPre.length() - 1));
		String[] grupoVentaLista = grupoVenta.split(",");

		for (int i = 0; i < grupoVentaLista.length; i++) {
			cuenta += Integer.parseInt(grupoVentaLista[i]);
		}
		ventaTotal = String.valueOf(cuenta);
		return ventaTotal;
	}

}
