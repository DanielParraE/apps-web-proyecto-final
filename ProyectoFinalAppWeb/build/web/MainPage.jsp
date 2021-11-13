<%-- 
    Document   : MainPage
    Created on : Nov 5, 2021, 11:50:47 AM
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Main Page</title>
        <link rel="stylesheet" href="./styles/main-style.css" />
    </head>
    <body>

        <header class="main-header">
            <ul class="list-hdr">
                <c:if test="${user != null}">
                    <li><a href="LogoutServlet"><button>LogOut</button></a></li>
                    <li><a href="MisPostsServlet"><button>Mis Posts</button></a></li>
                    <li><img id="usuarioAvatar" src="${pageContext.request.contextPath}/images/foo.png" alt="usarioAvatar" /></li>
                    <li><p>${user.nombreCompleto}</p><li>
                </c:if>
                <c:if test="${user == null}">
                    <li><a href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                    <li><a href="Register.jsp"><button>Registrarse</button></a></li>
                </c:if>
            </ul>
        </header>
        <main>
            <c:if test="${postsComunes != null}">
                <c:forEach var="postComun" items="${postsComunes}">
                    <section class="container-general">
                        <div class="publication">
                            <aside>
                                <ul class="btnList">
                                    <li><button class="btnGreen">Agregar</button></li>
                                    <li><button class="btnRed">Eliminar</button></li>
                                    <li><button class="btnBlue">Editar</button></li>
                                </ul>
                            </aside>
                            <section class="publication-container">
                                <div class="message-container">
                                    <h3>${postComun.usuario.nombreCompleto}</h3>
                                    <p>
                                        ${postComun.contenido}
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
                        </div>
                    </section>
                </c:forEach>
            </c:if>
        </main>
    </body>
</html>

