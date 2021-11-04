<%-- 
    Document   : Register
    Created on : 3 nov. 2021, 15:42:37
    Author     : Daniel Parra
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
                height: 340px;
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
            <form action="ServletUsuario" method="POST">
                <h3 class="tags">Username:</h3>
                <input type="text" placeholder="Username here" />
                <h3 class="tags">Email:</h3>
                <input type="text" placeholder="Email here" />
                <h3 class="tags">Password:</h3>
                <input type="text" placeholder="Password here" />
                <h5 class="tags">Confirm Password:</h5>
                <input type="text" />
                <h3 class="tags">Birthday:</h3>
                <input type="date" value="2021-01-01" />
                <p></p>
                <button type="submit">Enter</button>
            </form>
        </section>
    </body>
</html>
