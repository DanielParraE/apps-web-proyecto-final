/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class AddPost {
    constructor() {

        if (sessionStorage.getItem("usr")) {

            if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === false) {
                document.getElementById("tipoPost").style.display = 'none';
            }
            document.getElementById("form-post").onsubmit = this.agregarPos
        } else {
            document.getElementById("form-post").style.display = 'none';
        }
        t;
    }

    agregarPost(evt) {

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

            console.log(post);

            fetch('/ProyectoFinalAppWeb/AgregarPostServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(post)
            }).then((data) => {
                alert("Su publicacion ha sido publicado con exito.");
            }).then(() => {
                window.location.replace("./MainPage.jsp");
            }).catch((err) => {
                console.log(err);
            });
        }

    }

}

new AddPost();
