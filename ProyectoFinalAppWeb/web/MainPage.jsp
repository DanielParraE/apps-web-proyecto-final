<%-- 
    Document   : MainPage
    Created on : Nov 5, 2021, 11:50:47 AM
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Main Page</title>
        <link rel="stylesheet" href="./styles/main-style.css" />
    </head>
    <body>
        <section id="container-general">
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
                        <h3>Ian:</h3>
                        <p>
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                            Doloribus perspiciatis aperiam est sequi alias! Natus, dolorum qui
                            molestiae tenetur assumenda inventore sapiente esse, hic officiis,
                            voluptatum error cupiditate. Exercitationem, illum.
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
    </body>
</html>

