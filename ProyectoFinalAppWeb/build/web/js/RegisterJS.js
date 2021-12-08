/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Register {

    constructor() {
        this.llenarEstados();
        document.getElementById("cmbEstado").onchange = this.llenarMunicipios;
        this.llenarMunicipios(new Event("change"));
        document.getElementById("formRegister").onsubmit = this.registrarUser;
    }

    llenarEstados() {
        fetch('/DemoAJAX/EstadosServlet')
                .then((response) => {
                    document.getElementById("cmbEstado").innerHTML = "";
                    return response.json();
                })
                .then((estados) => {
                    //Llena el combEstado con los valores de item.clave
                    estados.forEach((item, index) => {
                        let option = "<option value='" + item.clave + "'>" + item.nombre + "</option>\n";
                        document.getElementById("cmbEstado").innerHTML += option;
                    });

                })
                .catch((err) => {
                    alert("Error al recuperar estados.");
                    console.log(err);
                });
        ;
    }

    llenarMunicipios(evt) {
        evt.preventDefault();
        fetch('/DemoAJAX/EstadosServlet')
                .then((response) => {
                    document.getElementById("cmbMunicipio").innerHTML = "";
                    return response.json();
                })
                .then((estados) => {
                    //Lllena el combEstado con los valores de item.clave
                    console.log("entra");
                    let claveEstadoSeleccionado = document.getElementById("cmbEstado").options[document.getElementById("cmbEstado").selectedIndex].value;
                    let estado;

                    estados.forEach((item, index) => {
                        if (item.clave === claveEstadoSeleccionado) {
                            estado = item;
                        }
                    });

                    estado.municipios.forEach((item, index) => {
                        let option = "<option value='" + item + "'>" + item + "</option>\n";
                        document.getElementById("cmbMunicipio").innerHTML += option;
                    });

                })
                .catch((err) => {
                    alert("Error al recuperar municipios.");
                    console.log(err);
                });
        ;

    }

    registrarUser(evt) {
        evt.preventDefault();

        let reader = new FileReader();

        let usuarioNuevo = new Object();

        reader.readAsBinaryString(document.getElementById("profilePicUsr").files[0]);
        let avatarLeido;

        reader.onload = function (e) {
            avatarLeido = reader.result;

            usuarioNuevo.nombreCompleto = document.getElementById("nombreUsr").value;
            usuarioNuevo.correo = document.getElementById("emailUsr").value;
            usuarioNuevo.contrasenia = document.getElementById("passwordUsr").value;
            usuarioNuevo.confCon = document.getElementById("confPassUsr").value;
            usuarioNuevo.telefono = document.getElementById("telephoneUsr").value;
            usuarioNuevo.fechaNacimiento = document.getElementById("bithdayUsr").value;
            usuarioNuevo.genero = document.getElementById("genderUsr").options[document.getElementById("genderUsr").selectedIndex].value;
            usuarioNuevo.ciudad = document.getElementById("cmbMunicipio").options[document.getElementById("cmbMunicipio").selectedIndex].value;

            usuarioNuevo.avatar = btoa(avatarLeido);

            console.log(usuarioNuevo);
            
            fetch('/ProyectoFinalAppWeb/ServletUsuario', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(usuarioNuevo)
            }).then((data) => {
                alert("Se ha registrado con exito.");
            }).then(() => {
                window.location.replace("./LogIn.html");
            }).catch((err) => {
                console.log(err);
            });

        };

    }

}

window.onload = () => new Register();
