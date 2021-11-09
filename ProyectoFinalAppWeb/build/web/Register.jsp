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
                height: 450px;
                background-color: gray;
                border: solid;
                border-color: honeydew;
            }
            button {
                margin-top: 15px;
            }
        </style>
    </head>
    <body>
        <section id="form-container">
            <form action="ServletUsuario" method="POST" enctype="multipart/form-data">
                <h3 class="tags">Username:</h3>
                <input type="text" placeholder="Username here" name="username" />
                <h3 class="tags">Email:</h3>
                <input type="text" placeholder="Email here" name="email" />
                <h3 class="tags">Password:</h3>
                <input type="text" placeholder="Password here" name="password" />
                <h5 class="tags">Confirm Password:</h5>
                <input type="text" name="confirmPassword" />
                <h3 class="tags">Birthday:</h3>
                <input type="date" value="2021-01-01" name="birthday"/>
                <h3 class="tags">Gender:</h3>
                <select name="gender">
                    <option value="F">Femenine</option>
                    <option value="M">Masculine</option>
                    <option value="O">Other</option>
                </select>
                <h3 class="tags">Avatar:</h3>
                <input type="file" name="avatar" accept="image/*" />
                <p></p>
                <button type="submit">Enter</button>
            </form>
        </section>
    </body>
</html>
