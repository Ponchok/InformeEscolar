<!DOCTYPE html>
<%@page import="com.abarrotes.utilidades.Constantes"%>
<%@page import="com.abarrotes.utilidades.AccesoBaseDatos"%>
<%@page import="com.abarraotes.dao.AccesoSistema"%>
<%@page import="java.sql.*"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Detalle Venta</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<body>
	<header id="header">
		<nav class="navbar navbar-default navbar-static-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">
						<a href="index.html"><h1>Super Abarrotes Admin Software</h1></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="soporte.html">Soporte</a></li>
							<li role="presentation"><a href="informacion.html">Información</a></li>	
							<li role="presentation"><a href="index.html">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>
	<!--/header-->

	<div>
		<table cellpadding="5" cellspacing="5" border="1" id="tbodyarticulos"
			align="center">
			<tr bgcolor="#A52A2A">
				<th><b>Articulo</b></th>
				<th><b>Venta Total Articulo</b></th>
			</tr>

			<%
				try {
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					String idVenta = (String) request.getAttribute("IdVenta");
					AccesoBaseDatos acceso = new AccesoBaseDatos();
					conn = acceso.obtenerConexion();
					String query = Constantes.DAO_MUESTRA_VENTA_ARTICULOS;
					pstm = conn.prepareStatement(query);
					pstm.setString(1, idVenta);
					rs = pstm.executeQuery();

					while (rs.next()) {   
			%>


			<tr bgcolor="#DEB887">
				<td id="tdarticulos" align="center"><%=rs.getString("nombre")%></td>
				<td id="tdarticulos" align="center">$ <%=rs.getString("ventaTotalArticulo")%></td>
			</tr>

			<%
				}
					conn.close();
					pstm.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
			
			<% String idVenta = (String) request.getAttribute("IdVenta"); %>
			<% String ventaTotal = (String) request.getAttribute("VentaTotal"); %>
			
			<tfoot style="color: olive;">
				<td><b>Numero de Venta: <%=idVenta %></b></td>
				<td align="center"> $ <%=ventaTotal %> </td>
			</tfoot>
		</table>
	</div>
	
	<div align="center">
	<br>
	<button>
	 <a style="color: blue; font-weight: bold;" href="http://localhost:8080/superabarrotes/ventas.jsp">Nueva Venta</a>
	</button>
	<button>
		<a style="color: red; font-weight: bold;" href="index.html">Terminar y Salir</a>
	</button>
	</div>
	
	
	<br>
	<!-- Ejemplo de muestra de Tabla articulos -->










	<footer>
		<div class="container">
			<div class="col-md-4 wow fadeInDown" data-wow-duration="1000ms"
				data-wow-delay="300ms">
				<h4>Proyecto para Informe de experiencia Profesional</h4>
				<p>Trabajo realizado para obtener el titulo en Lic. en
					Informatica Administrativa</p>
				<div class="contact-info">
					<ul>
						<li><i></i>Alfonso Pedro Pablo Angulo Torres</li>
						<li><i></i>UNIVERSIDAD AMERICA LATINA</li>
					</ul>
				</div>
			</div>

		</div>
	</footer>

	<div class="sub-footer">
		<div class="container">
			<div class="col-md-4 col-md-offset-4">
				<div class="copyright">
					&copy; Day 2015 by <a target="_blank"
						href="http://bootstraptaste.com/"
						title="Free Twitter Bootstrap WordPress Themes and HTML templates">Bootstrap
						Themes</a>.All Rights Reserved. <a
						href="https://www.flaticon.com/authors/srip">Iconos utlizados:
						"designed by srip from Flaticon"</a>
				</div>
				<!-- 
                    All links in the footer should remain intact. 
                    Licenseing information is available at: http://bootstraptaste.com/license/
                    You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Day
                -->
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script>
		wow = new WOW({}).init();
	</script>
</body>
</html>
