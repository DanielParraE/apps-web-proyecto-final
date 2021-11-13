<%-- 
    Document   : Home
    Created on : 11 nov 2021, 11:57:35
    Author     : Daniel Parra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Main Page</title>
        <link rel="stylesheet" href="./styles/home-style.css" />
    </head>
    <body>

        <header class="main-header">
            <ul class="list-hdr">
                <c:if test="${user != null}">
                    <li><a href="LogoutServlet"><button>LogOut</button></a></li>
                    <li><a href="ObtenerPostsServlet"><button>Pagina Principal</button></a></li>
                    <li><img src="" alt="" /></li>
                    <li><p>${user.nombreCompleto}</p><li>
                        </c:if>
                        <c:if test="${user == null}">
                    <li><a href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                    <li><a href="Register.jsp"><button>Registrarse</button></a></li>
                    </c:if>
            </ul>
        </header>
        <div class="container-general">
            <div class="presentation-profile">
                <h3>${user.nombreCompleto}</h3>
            </div>
            <c:if test="${misPosts != null}">
                <c:forEach var="miPost" items="${misPosts}">
                    <section class="publication">
                        <aside>
                            <ul class="btnList">
                                <li><button class="btnGreen">Agregar</button></li>
                                <li><button class="btnRed">Eliminar</button></li>
                                <li><button class="btnBlue">Editar</button></li>
                            </ul>
                        </aside>
                        <section class="publication-container">
                            <div class="message-container">
                                <h3>${miPost.titulo}</h3>
                                <p>
                                    ${miPost.contenido}
                                </p>
                            </div>
                            <div class="input-container">
                                <input
                                    class="input-comentario"
                                    type="text"
                                    placeholder="Comentario..."
                                    />
                            </div>
                        </section>
                    </section>
                </c:forEach>
            </c:if>
        </div>
        <footer style="height: 800px"></footer>
    </body>
</html>