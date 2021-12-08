/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class LogInUser {

    constructor() {
        this.frmLogear = document.getElementById("frmLogIn");
        this.frmLogear.onsubmit = this.logearUsuario;
    }

    logearUsuario(evt) {
        evt.preventDefault();

        let nombreCompleto = document.getElementById("nombreCompletoLog").value;
        let contrasenia = document.getElementById("contraseniaLog").value;

        let url = '/ProyectoFinalAppWeb/LoginServlet?username-login=' + nombreCompleto + '&password-login=' + contrasenia;

        fetch(url)
                .then(response => response.json())
                .then(usuarioObtenido => {
                    sessionStorage.setItem('usr', JSON.stringify(usuarioObtenido));
                }).then(() => {
                    window.location.replace("./MainPage.jsp");
                }) 
                .catch(exception => console.log(exception));
    }
}

window.onload = () => new LogInUser();
