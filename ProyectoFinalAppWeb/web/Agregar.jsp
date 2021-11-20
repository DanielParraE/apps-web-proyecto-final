<%-- 
    Document   : Agregar
    Created on : 17 nov 2021, 19:40:18
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Agregar Publicacion</title>
        <link rel="shortcut icon" href="./imagenes/GuyuLogoBlue.png" />
        <link rel="stylesheet" type="text/css" href="./styles/agregar-style.css" />
    </head>
    <body>
        <header class="main-header">
            <img class="imagen-logo" src="./imagenes/GuyuMiniLogoBlue.png" alt="" />
            <ul class="list-hdr">
                <c:if test="${user != null}">
                    <li><h3>${user.nombreCompleto}</h3></li>
                    <li><img class="imagen-perfil" src="${pageContext.request.contextPath}/images/foo.png" alt="usuarioAvatar" /></li>
                    <li><a href="LogoutServlet"><button>LogOut</button></a></li>
                    <li><a href="ObtenerPostsServlet"><button>Pagina Principal</button></a></li>
                    <li><a href="MisPostsServlet"><button>Mis Posts</button></a></li>
                </c:if>
                <c:if test="${user == null}">
                    <li><a href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                    <li><a href="Register.jsp"><button>Registrarse</button></a></li>
                </c:if>
            </ul>
        </header>
        <form action="AgregarPostServlet" method="POST">
            <div class="container">
                <div class="publication">
                    <section class="publication-container">
                        <div class="message-container">
                            <ul class="edits">
                                <li><input type="text" placeholder="Título" name="titulo" required="required" /></li>
                                <li><h4 class="edit-nombre">${user.nombreCompleto}</h4></li>
                            </ul>
                            <input class="edit-cuerpo" type="text" placeholder="Cuerpo" name="contenido" required="required" />
                        </div>
                    </section>
                </div>
            </div>
            <button type="submit" class="btnGreen">Agregar Publicación</button>
        </form>
        <footer style="height: 800px"></footer>
    </body>
</html>

