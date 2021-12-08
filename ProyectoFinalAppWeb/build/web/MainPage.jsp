<%-- 
    Document   : MainPage
    Created on : Nov 5, 2021, 11:50:47 AM
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Main Page</title>
        <link rel="shortcut icon" href="./imagenes/GuyuLogoBlue.png">
        <link rel="stylesheet" type="text/css" href="./styles/main-style.css" />
        <script type="module" src="./js/DisplayUserData.js"></script>
    </head>
    <body>

        <header class="main-header">
            <img class="imagen-logo" src="./imagenes/GuyuMiniLogoBlue.png" alt="" />
            <ul class="list-hdr">
                <li><h3 id="nombreuser"></h3><li>
                <li><img id="avatarUsuarioContenedor" class="imagen-perfil" src="#" alt="usuarioAvatar" /></li>
                <li><a id="logOutUser" href="#"><button>LogOut</button></a></li>
                <li><a id="linkMisPosts" href="./Home.jsp"><button>Mis Posts</button></a></li>
                <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
                <li><a id="linkLogIn" href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                <li><a id="linkRegister" href="Register.jsp"><button>Registrarse</button></a></li>
            </ul>
        </header>
        <main>

            <style>
                #containerPostsAnclados {
                    padding-bottom: 10px;
                }
                #containerGeneralDeAnclados {
                    padding-bottom: 30px;
                }
                #containerPostsComunes {
                    padding-bottom: 10px; 
                }
                .containerPostSingle {
                    display: flex;
                    flex-direction: column;
                }
            </style>

            <section id="containerGeneral" class="container-general">
                <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
                <!-- [SECTION PARA LOS POSTS ANCLADOS, NO CONFUNDIR CON EL DE COMUNES] -->
                <section id="containerGeneralDeAnclados">
                    <c:if test="${user != null}">
                        <c:if test="${postsAnclados != null}">
                            <c:forEach var="postAnclado" items="${postsAnclados}">
                                <section class="containerAncladoSingle">
                                    <section id="containerPostsAnclados" class="container-general">
                                        <div class="publication">
                                            <section class="publication-container">
                                                <div class="message-container">
                                                    <ul class="title-list">
                                                        <li><h3>${postAnclado.titulo}</h3></li>
                                                        <li><h4>${postAnclado.administrador.nombreCompleto}</h4></li>
                                                                <fmt:parseDate value="${postAnclado.fechaHoraCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                                                        <li><fmt:formatDate type="date" dateStyle="short" value="${parsedDate}" /></li>
                                                    </ul>
                                                    <p>
                                                        ${postAnclado.contenido}
                                                    </p>
                                                </div>
                                            </section>
                                        </div>
                                        <c:if test="${esAdmin}">
                                            <aside>
                                                <ul class="btnList">
                                                    <li><a href="EliminarPostServlet?idpost=${postComun.id}"><button class="btnRed">Eliminar</button></a></li>
                                                </ul>
                                            </aside>
                                        </c:if>
                                    </section>
                                </section>
                            </c:forEach>
                            <br>
                            <br>
                            <br>
                            <br>
                        </c:if>
                    </c:if>
                </section>
                <br>
                <br>
                <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
                <!-- [SECTION PARA LOS POSTS COMUNES, NO CONFUNDIR CON EL DE ANCLADOS] -->
                <section id="containerGeneralDeComunes">
                    <c:if test="${postsComunes != null}">
                        <c:forEach var="postComun" items="${postsComunes}">
                            <section class="containerPostSingle">
                                <div id="containerPostsComunes" class="publication">
                                    <section class="publication-container">
                                        <div class="message-container">
                                            <ul class="title-list">
                                                <li><h3>${postComun.titulo}</h3></li>
                                                <li><h4>${postComun.usuario.nombreCompleto}</h4></li>
                                                        <fmt:parseDate value="${postComun.fechaHoraCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                                                <li><fmt:formatDate type="date" dateStyle="short" value="${parsedDate}" /></li>
                                            </ul>
                                            <p>
                                                ${postComun.contenido}
                                            </p>
                                        </div>
                                        <c:if test="${user != null}">
                                            <c:if test="${!(esAdmin)}">
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
                                                        </div>
                                                        <input type="hidden" value="${postComun.id}" name="idpostcomentar" />
                                                        <button type="submit" class="btn-comentario">
                                                            <img src="./imagenes/flechablancaconnegro.png" alt="" />
                                                        </button>
                                                    </div>
                                                </form>
                                            </c:if>
                                        </c:if>
                                    </section>
                                </div>
                                <c:if test="${esAdmin}">
                                    <aside>
                                        <ul class="btnList">
                                            <li><a href="EliminarPostServlet?idpost=${postComun.id}"><button class="btnRed">Eliminar</button></a></li>
                                        </ul>
                                    </aside>
                                </c:if>
                                <c:forEach var="comment" items="${cmts}">
                                    <c:if test="${comment.postComun.id == postComun.id}">
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
                            </section>
                        </c:forEach>
                    </c:if>
                </section>
            </section>
            <br>
            <br>
            <a id="idBotonAgregarPost" href="./Agregar.jsp"><button class="btnGreen">Agregar Publicación</button></a>
        </main>
        <footer style="height: 800px"></footer>
    </body>
</html>

