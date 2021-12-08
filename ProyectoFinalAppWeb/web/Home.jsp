<%-- 
    Document   : Home
    Created on : 11 nov 2021, 11:57:35
    Author     : Daniel Parra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Home Page</title>
        <link rel="shortcut icon" href="./imagenes/GuyuLogoBlue.png">
        <link rel="stylesheet" type="text/css" href="./styles/home-style.css" />
        <script type="module" src="./js/DisplayUserData.js"></script>
    </head>
    <body>

        <header class="main-header">
            <img class="imagen-logo" src="./imagenes/GuyuMiniLogoBlue.png" alt="" />
            <ul class="list-hdr">
                <li><h3 id="nombreuser"></h3><li>
                <li><img id="avatarUsuarioContenedor" class="imagen-nav" src="#" alt="usuarioAvatar" /></li>
                <li><a id="logOutUser" href="#"><button>LogOut</button></a></li>
                <li><a id="linkMisPosts" href="./MainPage.jsp"><button>Pagina Principal</button></a></li>
                <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
                <li><a id="linkLogIn" href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                <li><a id="linkRegister" href="Register.jsp"><button>Registrarse</button></a></li>
            </ul>
        </header>
        <div id="containerGeneral" class="container-general">
            <div class="presentation-profile">
                <h3 id="nombrePresentacion"></h3>
            </div>

            <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
            <!-- [SECTION PARA LOS POSTS ANCLADOS, NO CONFUNDIR CON EL DE COMUNES] -->
            <section id="containerGeneralDeAnclados">
                <c:if test="${esAdmin}">
                    <c:if test="${misPostsAnclados != null}">
                        <section id="containerPostsAnclados" class="publication">
                            <c:forEach var="miPostAnclado" items="${misPostsAnclados}">
                                <section class="publication-container">
                                    <div class="message-container">
                                        <ul class="title-list">
                                            <li><h3>${miPostAnclado.titulo}</h3></li>
                                            <li><h4>${miPostAnclado.administrador.nombreCompleto}</h4></li>
                                                    <fmt:parseDate value="${miPostAnclado.fechaHoraCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                                            <li><fmt:formatDate type="date" dateStyle="short" value="${parsedDate}" /></li>
                                        </ul>
                                        <p>
                                            ${miPostAnclado.contenido}
                                        </p>
                                    </div>
                                </section>
                            </section>
                            <aside>
                                <ul class="btnList">
                                    <li><a href="EliminarPostServlet?idpost=${miPostAnclado.id}"><button class="btnRed">Eliminar</button></a></li>
                                    <li><a href="MostrarPostModificarServlet?idpost=${miPostAnclado.id}"><button class="btnBlue">Editar</button></a></li>
                                </ul>
                            </aside>
                        </c:forEach>
                        <br>
                        <br>
                        <br>
                        <br>
                    </c:if>
                </c:if>
            </section>
            <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
            <!-- [SECTION PARA LOS POSTS COMUNES, NO CONFUNDIR CON EL DE ANCLADOS] -->

            <c:if test="${misPostsComunes != null}">
                <c:forEach var="miPostComun" items="${misPostsComunes}">
                    <section class="publication">
                        <section class="publication-container">
                            <div class="message-container">
                                <ul class="title-list">
                                    <li><h3>${miPostComun.titulo}</h3></li>
                                    <li><h4>${miPostComun.usuario.nombreCompleto}</h4></li>
                                            <fmt:parseDate value="${miPostComun.fechaHoraCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                                    <li><fmt:formatDate type="date" dateStyle="short" value="${parsedDate}" /></li>
                                </ul>
                                <p>
                                    ${miPostComun.contenido}
                                </p>
                            </div>
                            <form action="ComentarServlet" method="POST">
                                <div class="input-container">
                                    <div class="escribe-comentario">
                                        <input
                                            class="input-comentario"
                                            type="text"
                                            placeholder="Comentario..."
                                            name="comentarioContenido"
                                            required="required"
                                            />
                                        <input type="hidden" value="${miPostComun.id}" name="idpostcomentar" />
                                        <button type="submit" class="btn-comentario">
                                            <img src="./imagenes/flechablancaconnegro.png" alt="" />
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </section>
                    <aside>
                        <ul class="btnList">
                            <li><a href="EliminarPostServlet?idpost=${miPostComun.id}"><button class="btnRed">Eliminar</button></a></li>
                            <li><a href="MostrarPostModificarServlet?idpost=${miPostComun.id}"><button class="btnBlue">Editar</button></a></li>
                        </ul>
                    </aside>

                    <c:forEach var="comment" items="${cmts}">
                        <c:if test="${comment.postComun.id == miPostComun.id}">
                            <section class="container-comentarios">
                                <div class="comentario">
                                    <h3><b>${comment.usuarioNormal.nombreCompleto}</b></h3>
                                    <p>
                                        ${comment.contenido}
                                    </p>
                                </div>
                            </section>
                        </c:if>
                    </c:forEach>

                </c:forEach>

            </c:if>
        </div>
        <a id="idBotonAgregarPost" href="./Agregar.jsp"><button class="btnGreen">Agregar</button></a>
        <footer style="height: 800px"></footer>
    </body>
</html>