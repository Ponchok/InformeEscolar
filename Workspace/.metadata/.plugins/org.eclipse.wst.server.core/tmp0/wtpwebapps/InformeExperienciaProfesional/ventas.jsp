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
<title>Ventas</title>

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

<style type="text/css">
tbody {
	display: block;
}

tbody {
	height: 500px; /*   Just for the demo          */
	overflow-y: auto; /* Trigger vertical scroll    */
	overflow-x: hidden; /* Hide the horizontal scroll */
	text-align: left;
	padding: 8px;
}

td {
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}

.selected {
	background-color: brown;
	color: #FFF;
}

#busqueda1, #busqueda2 {
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 450px;
	font-size: 16px;
	font-weight: bold;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}
</style>


<script type="text/javascript">
	function seleccionar() {
		var seleccionados = document.getElementsByName("seleccion");
		var seleccion = "";
		for (i = 0; i < seleccionados.length; i++) {
			if (seleccionados[i].checked == true) {
				seleccion += seleccionados[i].value + ",";
			}

		}
		document.getElementById("seleccionLista").value = seleccion;
	}; 

	function busqueda1() {
		var input, filter, table, tr, td, i;
		input = document.getElementById("busqueda1");
		filter = input.value.toUpperCase();
		table = document.getElementById("tbodyarticulos");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[2];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}

	function busqueda2() {
		var input, filter, table, tr, td, i;
		input = document.getElementById("busqueda2");
		filter = input.value.toUpperCase();
		table = document.getElementById("tbodyarticulos");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[4];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}

	function limpia() {
		document.getElementById("busqueda1").value = "";
		document.getElementById("busqueda2").value = "";
	}
</script>

</head>


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
							<li role="presentation"><a href="index.html" class="active">Soporte</a></li>
							<li role="presentation"><a href="index.html">Información</a></li>
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





	<!-- Ejemplo de muestra de Tabla articulos -->
	<div class="text-center" id="divarticulos">

		<input type="text" id="busqueda1" onkeyup="busqueda1()"
			placeholder="Busca Nombre de Articulo o Descripción..."
			title="Haz click y busca por nombre o descripción"> <br>
		<input type="text" id="busqueda2" onkeyup="busqueda2()"
			placeholder="Busca por Categoria de Articulo ..."
			title="Haz click y busca por categorias"> <br>
		<button onclick="limpia()">Limpia Busquedas</button>
		<form action="/superabarrotes/detalleVenta.jsp" method="post">
			<table cellpadding="5" cellspacing="5" border="1" id="tbodyarticulos"
				align="center">
				<tr bgcolor="#A52A2A">
					<th></th>
					<th><b>Nombre del Articulo</b></th>
					<th><b>Descripcion</b></th>
					<th><b>Precio</b></th>
					<th><b>Categoria</b></th>
				</tr>

				<%
					try {
						Connection conn = null;
						Statement stm = null;
						ResultSet rs = null;
						AccesoBaseDatos acceso = new AccesoBaseDatos();
						conn = acceso.obtenerConexion();
						stm = conn.createStatement();
						String query = Constantes.DAO_TABLA_ARTICULOS;
						rs = stm.executeQuery(query);
						while (rs.next()) {
				%>


				<tr bgcolor="#DEB887">
					<td id="tdarticulos"><input type="checkbox" name="seleccion"
						value="<%=rs.getString("idProducto")%>" onclick="seleccionar()"></input></td>
					<td id="tdarticulos"><%=rs.getString("Nombre")%></td>
					<td id="tdarticulos"><%=rs.getString("Descripcion")%></td>
					<td id="tdarticulos"><%=rs.getString("Precio")%></td>
					<td id="tdarticulos"><%=rs.getString("Categoria")%></td>
				</tr>

				<%
					

					}
						conn.close();
						stm.close();
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
			</table>
			<input type="hidden" id="seleccionLista" name="seleccionLista"
				value=""></input>
			<button type="submit" id="Seleccion" class="btn btn-primary btn-lg">Continuar</button>
		</form>
	</div>
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