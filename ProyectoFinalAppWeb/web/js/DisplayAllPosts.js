/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class DisplayAllPosts {

    constructor() {
        this.obtienePosts();
    }

    obtienePosts() {

        fetch('/ProyectoFinalAppWeb/ObtenerPostsServlet')
                .then(response => response.json())
                .then(itemsObtenidos => {
                    this.desplegarPostsAnclados(itemsObtenidos[2]);
                    //console.log(itemsObtenidos[2]);
                    this.desplegarPostsComunes(itemsObtenidos[0], itemsObtenidos[1]);
                })
                .catch(exception => console.log(exception));

    }

    desplegarPostsComunes(postsComunes, comentarios) {

        for (var item = 0; item < postsComunes.length; item++) {

            let containerPostsGeneral = document.createElement("div");
            containerPostsGeneral.setAttribute("class", "publication");
            //---------------
            let containerPost = document.createElement("section");
            containerPost.setAttribute("class", "publication-container");
            //---------------
            let messageContainer = document.createElement("div");
            messageContainer.setAttribute("class", "message-container");
            //---------------
            let listaDatosPost = document.createElement("ul");
            listaDatosPost.setAttribute("class", "title-list");
            //---------------
            let datoTituloContainer = document.createElement("li");
            let datoTitulo = document.createElement("h3");
            datoTitulo.innerHTML = postsComunes[item].titulo;
            datoTituloContainer.appendChild(datoTitulo);
            //--------------
            let datoAutorContainer = document.createElement("li");
            let datoAutor = document.createElement("h4");
            datoAutor.innerHTML = postsComunes[item].usuario.nombreCompleto;
            datoAutorContainer.appendChild(datoAutor);
            //--------------
            let datoFechaContainer = document.createElement("li");
            datoFechaContainer.innerHTML = postsComunes[item].fechaHoraCreacion;
            //--------------
            let contenidoContainer = document.createElement("p");
            contenidoContainer.innerHTML = postsComunes[item].contenido;
            //--------------
            listaDatosPost.appendChild(datoTituloContainer);
            listaDatosPost.appendChild(datoAutorContainer);
            listaDatosPost.appendChild(datoFechaContainer);
            //-------------
            let containerSingle = document.createElement("section");
            containerSingle.setAttribute("class", "containerPostSingle");
            //-------------

            messageContainer.appendChild(listaDatosPost);
            messageContainer.appendChild(contenidoContainer);

            containerPost.appendChild(messageContainer);

            //---------------
            // Container pa comentar
            if (sessionStorage.getItem('usr')) {

                if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === false) {

                    let formularioComentario = document.createElement("form");
                    formularioComentario.setAttribute("action", "#");
                    formularioComentario.setAttribute("method", "POST");

                    //--------

                    let inputContainer = document.createElement("div");
                    inputContainer.setAttribute("class", "input-container");

                    //--------

                    let escribeContainer = document.createElement("div");
                    escribeContainer.setAttribute("class", "escribe-comentario");

                    //---------

                    let inputComentario = document.createElement("input");
                    inputComentario.setAttribute("class", "input-comentario");
                    inputComentario.setAttribute("type", "text");
                    inputComentario.setAttribute("placeholder", "Comentario...");
                    inputComentario.setAttribute("name", "comentarioContenido");
                    inputComentario.setAttribute("required", "required");

                    escribeContainer.appendChild(inputComentario);

                    //---------

                    let inputIDPost = document.createElement("input");
                    inputIDPost.setAttribute("type", "hidden");
                    inputIDPost.setAttribute("value", postsComunes[item].id);
                    inputIDPost.setAttribute("name", "idpostcomentar");

                    //---------

                    let botonSubir = document.createElement("button");
                    botonSubir.setAttribute("type", "submit");
                    botonSubir.setAttribute("class", "btn-comentario");

                    let imgBotonSubir = document.createElement("img");
                    imgBotonSubir.setAttribute("src", "./imagenes/flechablancaconnegro.png");
                    imgBotonSubir.setAttribute("alt", "#");

                    botonSubir.appendChild(imgBotonSubir);

                    inputContainer.appendChild(escribeContainer);
                    inputContainer.appendChild(inputIDPost);
                    inputContainer.appendChild(botonSubir);

                    formularioComentario.appendChild(inputContainer);

                    formularioComentario.onsubmit = function (evt) {
                        evt.preventDefault();

                        new AddComment(formularioComentario);

                    };
                    containerPost.appendChild(formularioComentario);
                    //containerSingle.appendChild(containerPost);
                }

            }

            containerSingle.appendChild(containerPost);

            // document.getElementById("containerGeneral").appendChild(containerPost);

            //---------------

            /*
             * 
             * <aside>
             <ul class="btnList">
             <li><a href="EliminarPostServlet?idpost=${postComun.id}"><button class="btnRed">Eliminar</button></a></li>
             </ul>
             *  </aside>
             * 
             */

            if (sessionStorage.getItem('usr')) {
                if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === true) {

                    let asideEliminar = document.createElement("aside");
                    let ulEliminar = document.createElement("ul");
                    ulEliminar.setAttribute("class", "btnList");

                    let liEliminar = document.createElement("li");

                    //liEliminar.innerHTML = "<a href=\"" + postsComunes[item].id + "\"><button class=\"btnRed\">Eliminar</button></a>";

                    let aEliminar = document.createElement("a");
                    aEliminar.setAttribute("href", postsComunes[item].id);
                    aEliminar.innerHTML = "<button class=\"btnRed\">Eliminar</button>";

                    aEliminar.onclick = function (evt) {
                        evt.preventDefault();
                        var r = confirm("Esta seguro que desea eliminar este post?");
                        if (r === true) {
                            new DeletePost(aEliminar);
                        }

                    };

                    liEliminar.appendChild(aEliminar);

                    ulEliminar.appendChild(liEliminar);
                    asideEliminar.appendChild(ulEliminar);

                    containerSingle.appendChild(asideEliminar);

                }
            }

            //---------------

            let tieneComentarios = false;

            for (var i = 0; i < comentarios.length; i++) {
                if (comentarios[i].postComun.id === postsComunes[item].id) {
                    tieneComentarios = true;
                    break;
                }
            }

            if (tieneComentarios) {
                for (var i = 0; i < comentarios.length; i++) {
                    if (comentarios[i].postComun.id === postsComunes[item].id) {

                        let containerComentarios = document.createElement("section");
                        containerComentarios.setAttribute("class", "container-comentarios");

                        //----------

                        let containerComentario = document.createElement("div");
                        containerComentario.setAttribute("class", "comentario");

                        //----------

                        let autorComentarioContainer = document.createElement("h3");
                        autorComentarioContainer.innerHTML = "<b>" + comentarios[i].usuarioNormal.nombreCompleto + "</b>";

                        //----------

                        let comentarioContainer = document.createElement("p");
                        comentarioContainer.innerHTML = comentarios[i].contenido;

                        //----------

                        containerComentario.appendChild(autorComentarioContainer);
                        containerComentario.appendChild(comentarioContainer);

                        containerComentarios.appendChild(containerComentario);

                        containerSingle.appendChild(containerComentarios);

                        //document.getElementById("containerGeneral").appendChild(containerComentarios);
                        containerSingle.appendChild(document.createElement("br"));
                    }
                }

            } else {
                document.getElementById("containerGeneral").appendChild(document.createElement("br"));
                document.getElementById("containerGeneral").appendChild(document.createElement("br"));

            }

            document.getElementById("containerGeneral").appendChild(containerSingle);

        }

    }

    desplegarPostsAnclados(postsAnclados) {

        if (sessionStorage.getItem('usr')) {
            for (var item = 0; item < postsAnclados.length; item++) {

                let containerPostsGeneral = document.createElement("div");
                containerPostsGeneral.setAttribute("class", "publication");
                //---------------
                let containerPost = document.createElement("section");
                containerPost.setAttribute("class", "publication-container");
                //---------------
                let messageContainer = document.createElement("div");
                messageContainer.setAttribute("class", "message-container");
                //---------------
                let listaDatosPost = document.createElement("ul");
                listaDatosPost.setAttribute("class", "title-list");
                //---------------
                let datoTituloContainer = document.createElement("li");
                let datoTitulo = document.createElement("h3");
                datoTitulo.innerHTML = postsAnclados[item].titulo;
                datoTituloContainer.appendChild(datoTitulo);
                //--------------
                let datoAutorContainer = document.createElement("li");
                let datoAutor = document.createElement("h4");
                datoAutor.innerHTML = postsAnclados[item].usuario.nombreCompleto;
                datoAutorContainer.appendChild(datoAutor);
                //--------------
                let datoFechaContainer = document.createElement("li");
                datoFechaContainer.innerHTML = postsAnclados[item].fechaHoraCreacion;
                //--------------
                let contenidoContainer = document.createElement("p");
                contenidoContainer.innerHTML = postsAnclados[item].contenido;
                //--------------
                let containerSingle = document.createElement("section");
                containerSingle.setAttribute("class", "containerPostSingle");
                //--------------
                listaDatosPost.appendChild(datoTituloContainer);
                listaDatosPost.appendChild(datoAutorContainer);
                listaDatosPost.appendChild(datoFechaContainer);

                messageContainer.appendChild(listaDatosPost);
                messageContainer.appendChild(contenidoContainer);

                containerPost.appendChild(messageContainer);
                containerPost.style.padding = "5px 0px 5px 0px";
                
                containerSingle.appendChild(containerPost);

                if (sessionStorage.getItem('usr')) {
                    if (JSON.parse(sessionStorage.getItem('usr')).esAdmin === true) {

                        let asideEliminar = document.createElement("aside");
                        let ulEliminar = document.createElement("ul");
                        ulEliminar.setAttribute("class", "btnList");

                        let liEliminar = document.createElement("li");

                        //liEliminar.innerHTML = "<a href=\"" + postsComunes[item].id + "\"><button class=\"btnRed\">Eliminar</button></a>";

                        let aEliminar = document.createElement("a");
                        aEliminar.setAttribute("href", postsAnclados[item].id);
                        aEliminar.innerHTML = "<button class=\"btnRed\">Eliminar</button>";

                        aEliminar.onclick = function (evt) {
                            evt.preventDefault();
                            var r = confirm("Esta seguro que desea eliminar este post?");
                            if (r === true) {
                                new DeletePost(aEliminar);
                            }

                        };

                        liEliminar.appendChild(aEliminar);

                        ulEliminar.appendChild(liEliminar);
                        asideEliminar.appendChild(ulEliminar);

                        containerSingle.appendChild(asideEliminar);

                    }
                }
                
                document.getElementById("containerGeneralDeAnclados").appendChild(containerSingle);

            }

            document.getElementById("containerGeneralDeAnclados").style.padding = "50px 0px 50px 0px";
        }

    }
}

class AddComment {

    constructor(formularioComentario) {
        this.agregarComentario(formularioComentario);
    }

    agregarComentario(formularioComentario) {

        let cmt = new Object();
        cmt.contenido = formularioComentario.children[0].children[0].children[0].value;
        cmt.usrFix = JSON.parse(sessionStorage.getItem('usr'));
        cmt.idPost = formularioComentario.children[0].children[1].value;

        fetch('/ProyectoFinalAppWeb/ComentarServlet', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cmt)
        }).then(() => {
            window.location.reload();
        }).catch((err) => {
            console.log(err);
        });

    }

}

class DeletePost {

    constructor(linkA) {

        this.eliminarPost(linkA);

    }

    eliminarPost(linkA) {

        let idPost = linkA.getAttribute('href');

        let url = '/ProyectoFinalAppWeb/EliminarPostServlet?idpost=' + idPost;

        fetch(url)
                .then(response => response.json())
                .then(data => {
                    alert("Post Eliminado");
                }).then(() => {
            window.location.reload();
        })
                .catch(exception => console.log(exception));

    }

}

new DisplayAllPosts();

