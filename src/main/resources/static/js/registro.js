let campoNombre = document.getElementById("inputNombre");
let campoCorreo = document.getElementById("inputCorreo");
let campoCont1 = document.getElementById("inputCont1");
let campoCont2 = document.getElementById("inputCont2");
let btnRegistro = document.getElementById("btnRegistro");//Botón
let listUsuarios = [];
let vetCheck = document.getElementById("vetCheck");


//validación nombre:
campoNombre.addEventListener("keyup",function(e){    
    e.preventDefault();
    validarNombre();
});
function validarNombre(){
    let flag = false;
    let regex = /^[\sA-Záéíóú']{3,50}$/i;
    let testNombre = regex.test(campoNombre.value);

    if(testNombre && isNaN(campoNombre.value)){
        campoNombre.classList.remove("is-invalid");
        campoNombre.classList.add("is-valid");
        flag=true;
        
    }else{
        campoNombre.classList.remove("is-valid");
        campoNombre.classList.add("is-invalid");
    }
    return flag;
}

//validacion de correo, minimo un arroba y un punto.
campoCorreo.addEventListener("keyup", function(e){
    e.preventDefault();
    validarCorreo();
});
function validarCorreo() {
    let flag = false;
    let regex = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,5})+$/;
    let testCorreo = regex.test(campoCorreo.value);
    if(testCorreo) {
        campoCorreo.classList.remove("is-invalid");
        campoCorreo.classList.add("is-valid");
        flag=true;
        
    }else{
        campoCorreo.classList.remove("is-valid");
        campoCorreo.classList.add("is-invalid");
    }
    return flag;
}

//Validacion de contraseña
campoCont1.addEventListener("keyup", function (e) {
    e.preventDefault()    
    validarPass();
});
function validarPass() {
    let flag = false;
    let regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?#$&_-])[A-Za-z\d$@$!%*?#&_-]{8,15}$/;
let result = regex.test(campoCont1.value);
if(result){
    campoCont1.classList.remove("is-invalid");
    campoCont1.classList.add("is-valid");
    flag = true;
   
} 
else {
    campoCont1.classList.remove("is-valid");
    campoCont1.classList.add("is-invalid");
    
    
}
    return flag;
};

//Validacion de confirmacion de contraseña
campoCont2.addEventListener("keyup", function (e) {
    e.preventDefault()    
    validarPassCon();
});
function validarPassCon() {
    let flag = false;
    if(campoCont1.value==campoCont2.value && campoCont2.value.length > 0){
        campoCont2.classList.remove("is-invalid");
        campoCont2.classList.add("is-valid");
        flag = true;        
    } 
    else {
        campoCont2.classList.remove("is-valid");
        campoCont2.classList.add("is-invalid");         
    }
    return flag;
};

btnRegistro.addEventListener("click", function (e) {
    e.preventDefault();
    let flag = true;
    let valorNombre = document.getElementById("inputNombre").value;
    let valorCorreo = document.getElementById("inputCorreo").value;
    let valorCont1 = document.getElementById("inputCont1").value; 
    console.log("prueba");
//no tocar
if(validarNombre() && validarCorreo() && validarPass() && validarPassCon()){
    let flag2 = true   
    let tipoUsuario = 0;
    let urlRedir = "";
    let urlImg = "";
    
    let url = '/api/usuarios/';    
		fetch(url, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(usuarios){	
		listUsuarios = usuarios;
		for(let i=0;  i < listUsuarios.length; i++){
			if(listUsuarios[i].usuario_correo == valorCorreo){				
				flag2=false;
				break;
			}//si ya existe
		}//for que recorre los usuarios
			
		if(flag2){	
			if(vetCheck.checked){
				tipoUsuario = 2;
				urlRedir = "http://localhost:8080/pages/ingresarVet.html";
				urlImg = "../src/veterinarios/vet17.jpg";
			}else{
				tipoUsuario = 1;
				urlRedir = "http://localhost:8080/pages/logIn.html";
				urlImg = "../src/veterinarios/vet5.jpg";
			}//Si no es un usuario veterinario, entonces si haz el post
						
		let data = {         
        usuario_nombre: valorNombre,
        usuario_correo: valorCorreo,
        usuario_contrasena: valorCont1,
        veterinario_url_imagen: urlImg,
        tipo_usuario_id: tipoUsuario
    	}//data body JSON
					
			fetch(url, {
			  method: 'POST', // or 'PUT'
			  body: JSON.stringify(data), // data can be `string` or {object}!
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}).then(res => res.json())
			.catch(error => console.error('Error:', error))
			.then(function (newUsuario){				
				console.log(newUsuario);
				localStorage.setItem("nameRegisterVet", valorNombre);
                localStorage.setItem("correoRegisterVet", valorCorreo);
				let sendCuerpo = "Bienvenido a Dr. Lomito, tu usuario es: " + valorCorreo+ " y tu contraseña es: " +valorCont1;
                Email.send({
                    Host : "smtp.elasticemail.com",
                    Username : "hola.drlomito@gmail.com",
                    Password : "D2688BAD0F83F061575A92C02049DCD40FEE",
                    To : valorCorreo,
                    From : "hola.drlomito@gmail.com",
                    Subject : "Bienvenido a Dr. Lomito",
                    Body : sendCuerpo
                }).then(
                    Swal.fire({
                        background: '#FFF9E3',
                        position: 'center',
                        icon: 'success',
                        title: '¡Su cuenta ha sido registrada con éxito!',
                        showConfirmButton: false,
                        timer: 2500,
                        timerProgressBar: true
                        })//sweet alert
                );    
                campoNombre.value = "";
			    campoCorreo.value = "";
			    campoCont1.value = "";
			    campoCont2.value = "";  
			     if(vetCheck.checked){
			        vetCheck.click();
			    }
			    campoNombre.classList.remove("is-valid");
			    campoCorreo.classList.remove("is-valid");
			    campoCont1.classList.remove("is-valid");
			    campoCont2.classList.remove("is-valid");
                    setTimeout( ()=>{ 
                    location.href = urlRedir }, 2500);	
								
			});//POST Agregar usuario normal	
			
		}else{
        campoCorreo.classList.add("is-invalid");
        Swal.fire({
            background: '#FFF9E3',
            position: 'center',
            icon: 'error',
            title: 'UPS, el correo ya ha sido registrado.',
            showConfirmButton: false,
            timer: 3500,
            timerProgressBar: true
            })//sweet alert
    }//si ya existe el correo envia el alert de que ya existe			
 });//GET todos los usuarios
     
   
}else{
	validarNombre();
    validarCorreo();
    validarPass();
    validarPassCon(); 
    Swal.fire({
        background: '#FFF9E3',
        position: 'center',
        icon: 'error',
        title: 'ERROR: Verifique los campos por favor.',
        showConfirmButton: false,
        timer: 2500,
        timerProgressBar: true
        })
}//if validaciones pasaron   


});//evento click
