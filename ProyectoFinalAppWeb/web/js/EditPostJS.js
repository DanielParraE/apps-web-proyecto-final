/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class EditPost {

    constructor() {

        if (sessionStorage.getItem('usr')) {

            this.mostrarPost();

            if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === false) {
                document.getElementById("tipoPost").style.display = 'none';
            }

            document.getElementById("formEditar").onsubmit = this.editarPost;
        } else {
            document.getElementById("formEditar").style.display = 'none';
        }

    }

    mostrarPost() {

        let postID = new Object();

        postID.id = sessionStorage.getItem("idPostMod");

        fetch('/ProyectoFinalAppWeb/MostrarPostModificarServlet', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postID)
        }).then((response) => {
            return response.json();
        }).then((postRecibido) => {
            sessionStorage.removeItem('idPostMod');
            document.getElementById("tituloPost").setAttribute("value", postRecibido.titulo);
            document.getElementById("contenidoPost").setAttribute("value", postRecibido.contenido);
            document.getElementById("postIDModify").setAttribute("value", postRecibido.id);
        }).catch((err) => {
            console.log(err);
            alert("Error al recuperar post.");
        });


    }

    editarPost(evt) {
        evt.preventDefault();
        if (sessionStorage.getItem('usr')) {

            let esAnclado = false;

            if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === true) {
                esAnclado = (document.getElementById("tipoPost").options[document.getElementById("tipoPost").selectedIndex].value === 'true');
            }

            let post = new Object();

            post.usrFix = JSON.parse(sessionStorage.getItem('usr'));
            post.titulo = document.getElementById("tituloPost").value;
            post.contenido = document.getElementById("contenidoPost").value;
            post.esAnclado = esAnclado;
            post.id = document.getElementById("postIDModify").value;
            
            fetch('/ProyectoFinalAppWeb/ModificarPostServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(post)
            }).then((data) => {
                alert("Su publicacion ha sido modificada con exito.");
            }).then(() => {
                window.location.replace("./MainPage.jsp");
            }).catch((err) => {
                console.log(err);
            });
        }

    }

}

new EditPost();
