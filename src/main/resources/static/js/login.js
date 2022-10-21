////////////////////////////////// Animación
function toggleForm(){
    section = document.querySelector("section");
    container = document.querySelector(".container");
    container.classList.toggle("active");
    section.classList.toggle("active");
  }
////////////////////////////////// Login

let campoEmailLog = document.getElementById("emailLog");
let campoPassLog = document.getElementById("passLog");
let btnInicio = document.getElementById("btnInicio");
let flagReady = false;
let listUsuarios = [];

btnInicio.addEventListener("click", function (e){
e.preventDefault();

emailLog = campoEmailLog.value;
passLog = campoPassLog.value;

let url = '/api/login/';
let data = {usuario_correo: campoEmailLog.value, usuario_contrasena: campoPassLog.value};

fetch(url, {
  method: 'POST', // or 'PUT'
  body: JSON.stringify(data), // data can be `string` or {object}!
  headers:{
    'Content-Type': 'application/json'
  }
}).then(res => res.json())
.catch(error => console.error('Error:', error))
.then(function (response){	
	 if(response.accessToken){
		localStorage.setItem("token", response.accessToken);
		
		let url2 = '/api/usuarios/';
		fetch(url2, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(usuarios){	
		listUsuarios = usuarios;		
		for(let i=0;  i < listUsuarios.length; i++){
			if(listUsuarios[i].usuario_correo == campoEmailLog.value){
				localStorage.setItem("userLogged", listUsuarios[i].id)
			}//si el correo es identico al ingresado
		}// for recorrer usuarios
		});//GET usuarios
		
		Swal.fire({
            background: '#FFF9E3',
            position: 'center',
            icon: 'success',
            title: '¡Gracias por formar parte de nuestra comunidad!',
            showConfirmButton: false,
            timer: 2500,
            timerProgressBar: true
            })//SWEET ALERT
       localStorage.setItem("loggedIn", "true")
       setTimeout( ()=>{location.href = "/index.html";}, 2500);
	}else{
		console.log("Hay un error en el usuario o contraseña ");
	Swal.fire({
            background: '#FFF9E3',
            position: 'center',
            icon: 'error',
            title: 'ERROR: Verifique los campos por favor.',
            showConfirmButton: false,
            timer: 2500,
            timerProgressBar: true
            })
        campoEmailLog.value = "";
        campoPassLog.value = "";
	}//else si no mete un dato equivocado	
  });//POST Login
});//btn click inicio

