package com.abarrotes.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase utilitaria para obtener fechas usables en la base de datos.
 * @author ponchoadmin
 *
 */
public class FechaGenerador {

	/**
	 * Este metodo genera fechas en base a la hora de sistema
	 * Estas fechas se usan para ser insertadas en la base de datos.
	 * @param fecha
	 * @return Fecha para base de datos.
	 */
	public static String fechaBD(Date fecha){
		String venta = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		venta = sdf.format(fecha);
		return venta;
	}
	
}
