package com.abarrotes.utilidades;
/**
 * Clase utilizada para declarar constantes usadas en el proyecto
 *
 */
public interface Constantes {

	public static final String CONEXION_BD = "jdbc:mysql://localhost/SandBoxAbarrote?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String USUARIO_MYSQL = "root";
	public static final String CONTRASENA_MYSQL = "";
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DAO_TABLA_ACCESO = "select * from acceso;";
	public static final String DAO_TABLA_EMPLEADOS = "select  * from empleado;";
	public static final String DAO_TABLA_ARTICULOS = "select * from SandBoxAbarrote.tabla_articulos;";
	public static final String DAO_TABLA_SELECCION_ARTICULOS_1 = "select nombre as Nombre, descripcion as Descripcion, precio as Precio from articulo where idProducto IN (";
	public static final String DAO_TABLA_SELECCION_ARTICULOS_2 = ");";
	public static final String DAO_OBTENER_ID_VENTA = "select count(idVenta)  from ventas;";
	public static final String DAO_INSERTAR_VENTA = "INSERT INTO SandBoxAbarrote.ventas (idVenta, fecha, totalVentas) VALUES (?,?,?);";
	public static final String DAO_INSERTAR_DETALLE_VENTA = "INSERT INTO SandBoxAbarrote.detalleventa (idVenta, idArticulo, cantidad, idEmpleado, idCliente, ventaTotalArticulo) VALUES (?,?,?,?,?,?);";
	public static final String DAO_SELECCION_PRECIOS_ARTICULOS_1 = "select articulo.precio from articulo where articulo.idProducto in (";
	public static final String DAO_SELECCION_PRECIOS_ARTICULOS_2 = ");";
	public static final String DAO_MUESTRA_VENTA_ARTICULOS = "select idVenta, articulo.nombre, ventaTotalArticulo from detalleventa  left join articulo on detalleventa.idArticulo = articulo.idProducto where idVenta = ? order by idVenta desc;";
	public static final String DAO_OBTENER_SUMA_TOTAL_VENTA = "select sum(ventaTotalArticulo) from detalleventa where idVenta = ?;";
}
