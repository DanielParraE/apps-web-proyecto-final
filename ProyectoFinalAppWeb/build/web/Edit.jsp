<%-- 
    Document   : Edit
    Created on : 17 nov 2021, 19:36:20
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Edit Publicación</title>
        <link rel="shortcut icon" href="./imagenes/GuyuLogoBlue.png" />
        <link rel="stylesheet" type="text/css" href="./styles/edit-style.css" />
        <script type="module" src="./js/DisplayUserData.js"></script>
    </head>
    <body>
        <header class="main-header">
            <img class="imagen-logo" src="./imagenes/GuyuMiniLogoBlue.png" alt="" />
            <ul class="list-hdr">
                <li><h3 id="nombreuser"></h3></li>
                <li><img id="avatarUsuarioContenedor" class="imagen-perfil" src="#" alt="usuarioAvatar" /></li>
                <li><a id="logOutUser" href="#"><button>LogOut</button></a></li>
                <li><a id="linkPrincipal" href="./MainPage.jsp"><button>Pagina Principal</button></a></li>
                <li><a id="linkMisPosts" href="./Home.jsp"><button>Mis Posts</button></a></li>
                <!-- SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION SEPARACION -->
                <li><a id="linkLogIn" href="LogIn.html"><button>Iniciar Sesión</button></a></li>
                <li><a id="linkRegister" href="Register.jsp"><button>Registrarse</button></a></li>
            </ul>
        </header>
        <form id="formEditar" action="#" method="POST">
            <div class="container">
                <div class="publication">
                    <section class="publication-container">
                        <div class="message-container">
                            <ul class="edits">
                                <li><input id="tituloPost" type="text" name="titulo" value="" placeholder="" required="required" /></li>
                                <li><h4 id="nombrePostUsuario" class="edit-nombre"></h4></li>
                                <li>
                                    <select id="tipoPost">
                                        <option value="false">Comun</option>
                                        <option value="true">Anclado</option>
                                    </select>
                                </li>
                            </ul>
                            <input id="contenidoPost" class="edit-cuerpo" type="text" name="contenido" placeholder="" value="" required="required" />
                        </div>
                    </section>
                </div>
            </div>
            <input id="postIDModify" type="hidden" name="idpost" />
            <button type="submit" class="btnBlue">Editar Publicación</button>
        </form>
        <footer style="height: 800px"></footer>
    </body>
</html>
