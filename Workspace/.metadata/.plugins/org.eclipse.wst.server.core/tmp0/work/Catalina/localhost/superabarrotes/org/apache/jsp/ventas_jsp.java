/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.53
 * Generated at: 2018-07-16 03:25:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.abarrotes.utilidades.Constantes;
import com.abarrotes.utilidades.AccesoBaseDatos;
import com.abarraotes.dao.AccesoSistema;
import java.sql.*;

public final class ventas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.abarrotes.utilidades.Constantes");
    _jspx_imports_classes.add("com.abarraotes.dao.AccesoSistema");
    _jspx_imports_classes.add("com.abarrotes.utilidades.AccesoBaseDatos");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("<title>Ventas</title>\n");
      out.write("\n");
      out.write("<!-- Bootstrap -->\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("<link href=\"css/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" />\n");
      out.write("<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("tbody {\n");
      out.write("\tdisplay: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write("tbody {\n");
      out.write("\theight: 400px; /*   Just for the demo          */\n");
      out.write("\toverflow-y: auto; /* Trigger vertical scroll    */\n");
      out.write("\toverflow-x: hidden; /* Hide the horizontal scroll */\n");
      out.write("\ttext-align: left;\n");
      out.write("\tpadding: 8px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("td {\n");
      out.write("\tborder: 1px #DDD solid;\n");
      out.write("\tpadding: 5px;\n");
      out.write("\tcursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".selected {\n");
      out.write("\tbackground-color: brown;\n");
      out.write("\tcolor: #FFF;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#categoria {\n");
      out.write("\theight: 10px; /* Just for the demo          */\n");
      out.write("\toverflow-y: auto; /* Trigger vertical scroll    */\n");
      out.write("\toverflow-x: hidden; /* Hide the horizontal scroll */\n");
      out.write("\ttext-align: left;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction seleccionar() {\n");
      out.write("\t\tvar seleccionados = document.getElementsByName(\"seleccion\");\n");
      out.write("\t\tvar seleccion = \"\";\n");
      out.write("\t\tfor (i = 0; i < 50; i++) {\n");
      out.write("\t\t\tif (seleccionados[i].checked == true) {\n");
      out.write("\t\t\t\tseleccion += seleccionados[i].value + \"-\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\talert(seleccion);\n");
      out.write("\t\tdocument.getElementById(\"seleccionLista\").value = seleccion;\n");
      out.write("\n");
      out.write("\t};\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<nav class=\"navbar navbar-default navbar-static-top\" role=\"banner\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\n");
      out.write("\t\t\t\t\t\tdata-target=\".navbar-collapse\">\n");
      out.write("\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\n");
      out.write("\t\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\n");
      out.write("\t\t\t\t\t\t\tclass=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t<div class=\"navbar-brand\">\n");
      out.write("\t\t\t\t\t\t<a href=\"index.html\"><h1>Super Abarrotes Admin Software</h1></a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"navbar-collapse collapse\">\n");
      out.write("\t\t\t\t\t<div class=\"menu\">\n");
      out.write("\t\t\t\t\t\t<ul class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\"><a href=\"index.html\" class=\"active\">Soporte</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\"><a href=\"index.html\">Información</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\"><a href=\"index.html\">Salir</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!--/.container-->\n");
      out.write("\t\t</nav>\n");
      out.write("\t\t<!--/nav-->\n");
      out.write("\t</header>\n");
      out.write("\t<!--/header-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t<!-- Ejemplo de muestra de Tabla articulos -->\n");
      out.write("\t<div class=\"text-center\" id=\"divarticulos\">\n");
      out.write("\t\t<form action=\"/superabarrotes/TestVentas\" method=\"post\">\n");
      out.write("\t\t\t<table cellpadding=\"5\" cellspacing=\"5\" border=\"1\" id=\"tbodyarticulos\"\n");
      out.write("\t\t\t\talign=\"center\">\n");
      out.write("\t\t\t\t<tr bgcolor=\"#A52A2A\">\n");
      out.write("\t\t\t\t\t<th></th>\n");
      out.write("\t\t\t\t\t<th><b>Articulo</b></th>\n");
      out.write("\t\t\t\t\t<th><b>Descripcion</b></th>\n");
      out.write("\t\t\t\t\t<th><b>Precio</b></th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t");
	
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
				
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<tr bgcolor=\"#DEB887\">\n");
      out.write("\t\t\t\t\t<td id=\"tdarticulos\"><input type=\"checkbox\" name=\"seleccion\"\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(rs.getString("idProducto"));
      out.write("\" onclick=\"seleccionar()\"></input></td>\n");
      out.write("\t\t\t\t\t<td id=\"tdarticulos\">");
      out.print(rs.getString("nombre"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td id=\"tdarticulos\">");
      out.print(rs.getString("descripcion"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td id=\"tdarticulos\">");
      out.print(rs.getString("costo"));
      out.write("</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t");

					}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"seleccionLista\" name=\"seleccionLista\"\n");
      out.write("\t\t\t\tvalue=\"\"></input>\n");
      out.write("\t\t\t<button type=\"submit\" id=\"Seleccion\" class=\"btn btn-primary btn-lg\">Continuar</button>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- Ejemplo de muestra de Tabla articulos -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<footer>\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"col-md-4 wow fadeInDown\" data-wow-duration=\"1000ms\"\n");
      out.write("\t\t\t\tdata-wow-delay=\"300ms\">\n");
      out.write("\t\t\t\t<h4>Proyecto para Informe de experiencia Profesional</h4>\n");
      out.write("\t\t\t\t<p>Trabajo realizado para obtener el titulo en Lic. en\n");
      out.write("\t\t\t\t\tInformatica Administrativa</p>\n");
      out.write("\t\t\t\t<div class=\"contact-info\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><i></i>Alfonso Pedro Pablo Angulo Torres</li>\n");
      out.write("\t\t\t\t\t\t<li><i></i>UNIVERSIDAD AMERICA LATINA</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</footer>\n");
      out.write("\n");
      out.write("\t<div class=\"sub-footer\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("\t\t\t\t<div class=\"copyright\">\n");
      out.write("\t\t\t\t\t&copy; Day 2015 by <a target=\"_blank\"\n");
      out.write("\t\t\t\t\t\thref=\"http://bootstraptaste.com/\"\n");
      out.write("\t\t\t\t\t\ttitle=\"Free Twitter Bootstrap WordPress Themes and HTML templates\">Bootstrap\n");
      out.write("\t\t\t\t\t\tThemes</a>.All Rights Reserved. <a\n");
      out.write("\t\t\t\t\t\thref=\"https://www.flaticon.com/authors/srip\">Iconos utlizados:\n");
      out.write("\t\t\t\t\t\t\"designed by srip from Flaticon\"</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<!-- \n");
      out.write("                    All links in the footer should remain intact. \n");
      out.write("                    Licenseing information is available at: http://bootstraptaste.com/license/\n");
      out.write("                    You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Day\n");
      out.write("                -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("\t<script src=\"js/jquery.js\"></script>\n");
      out.write("\t<!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"js/wow.min.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("\t\twow = new WOW({}).init();\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
