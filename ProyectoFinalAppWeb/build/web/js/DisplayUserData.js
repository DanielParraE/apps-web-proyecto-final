/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import { LogOutUser } from './LogOutJS.js';

class DisplayUserData {

    constructor() {
        new LogOutUser();
        this.desplegarInformacionUsuario();
    }

    desplegarInformacionUsuario() {

        var path = window.location.pathname;
        var page = path.split("/").pop();

        if (sessionStorage.getItem('usr')) {
            document.getElementById("nombreuser").innerHTML = JSON.parse(sessionStorage.getItem('usr')).nombreCompleto;
            document.getElementById("avatarUsuarioContenedor")
                    .setAttribute(
                            'src', ('data:image/png;base64, ' + JSON.parse(sessionStorage.getItem('usr')).avatar)
                            );
            document.getElementById("linkLogIn").style.display = 'none';
            document.getElementById("linkRegister").style.display = 'none';
        } else {
            document.getElementById("linkMisPosts").style.display = 'none';
            document.getElementById("logOutUser").style.display = 'none';
            document.getElementById("nombreuser").style.display = 'none';
            document.getElementById("avatarUsuarioContenedor").style.display = 'none';
        }

        if (page === 'MainPage.jsp') {
            if (sessionStorage.getItem('usr')) {
                document.getElementById("nombreuser").innerHTML = JSON.parse(sessionStorage.getItem('usr')).nombreCompleto;
            } else {
                document.getElementById("idBotonAgregarPost").style.display = 'none';
            }
            this.despliegaPosts();
        } else if (page === 'Home.jsp') {
            if (sessionStorage.getItem('usr')) {
                document.getElementById("nombrePresentacion").innerHTML = JSON.parse(sessionStorage.getItem('usr')).nombreCompleto;
            } else {
                document.getElementById("idBotonAgregarPost").style.display = 'none';
            }
            this.despliegaMisPosts();
        } else if (page === 'Agregar.jsp') {

            if (sessionStorage.getItem('usr')) {
                
                document.getElementById("nombrePostUsuario").innerHTML = JSON.parse(sessionStorage.getItem('usr')).nombreCompleto;
            } else {
                document.getElementById("btnSubmitPost").style.display = 'none';
            }
            this.agregarPost();
        } else if (page === 'Edit.jsp') {
            if (sessionStorage.getItem('usr')) {
                document.getElementById("nombrePostUsuario").innerHTML = JSON.parse(sessionStorage.getItem('usr')).nombreCompleto;
            }
            this.editarPost();
        }

    }

    despliegaPosts() {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = './js/DisplayAllPosts.js';
        head.appendChild(script);
    }

    despliegaMisPosts() {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = './js/DisplayMyPosts.js';
        head.appendChild(script);
    }

    agregarPost() {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = './js/AddPost.js';
        head.appendChild(script);
    }

    editarPost() {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = './js/EditPostJS.js';
        head.appendChild(script);
    }

}

window.onload = () => new DisplayUserData();

