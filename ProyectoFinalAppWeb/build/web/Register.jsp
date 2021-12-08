<%-- 
    Document   : Register
    Created on : 3 nov. 2021, 15:42:37
    Author     : Equipo 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Register</title>
        <style>
            .tags {
                margin: 5px 0px 5px 0px;
                font-family: Verdana, Geneva, Tahoma, sans-serif;
            }
            input {
                text-align: center;
            }
            body {
                background-color: #333333;
            }
            section {
                text-align: center;
                margin: 60px 42%;
                width: 300px;
                height: 600px;
                background-color: gray;
                border: solid;
                border-color: honeydew;
            }
            button {
                margin-top: 15px;
            }
        </style>
        <script src="./js/RegisterJS.js"></script>
    </head>
    <body>
        <section id="form-container">
            <form id="formRegister" action="#" method="POST" enctype="multipart/form-data">
                <h3 class="tags">Username:</h3>
                <input id="nombreUsr" type="text" placeholder="Username here" name="username" required="required" />
                <h3 class="tags">Email:</h3>
                <input id="emailUsr" type="text" placeholder="Email here" name="email" required="required" />
                <h3 class="tags">Password:</h3>
                <input id="passwordUsr" type="text" placeholder="Password here" name="password" required="required" />
                <h5 class="tags">Confirm Password:</h5>
                <input id="confPassUsr" type="text" name="confirmPassword" required="required" />
                <h5 class="tags">Telefono:</h5>
                <input id="telephoneUsr" type="text" name="telephone" required="required" />
                <h3 class="tags">Birthday:</h3>
                <input id="bithdayUsr" type="date" value="2021-01-01" name="birthday" required="required" />
                <h3 class="tags">Gender:</h3>
                <select id="genderUsr" name="gender">
                    <option value="F">Femenine</option>
                    <option value="M">Masculine</option>
                    <option value="O">Other</option>
                </select>
                <h3 class="tags">Estado:</h3>                            
                <select id="cmbEstado" name="estado"></select><br />
                <h3 class="tags">Municipio</h3>                            
                <select id="cmbMunicipio" name="municipio"></select><br />
                <h3 class="tags">Avatar:</h3>
                <input id="profilePicUsr" type="file" name="avatar" accept="image/*" required="required" />
                <p></p>
                <button id="btnSubir" type="submit">Enter</button>
            </form>
        </section>
    </body>
</html>
