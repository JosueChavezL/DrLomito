
let idCardVerMas = "";
let user = [];
let userLogged = [];
let listInfo = [];
let listContacto = [];
let listOpiniones = [];
let infovet = [];
let contactoVet = [];

let itemsContainer = document.getElementById("list-items");
let opinionContainer = document.getElementsByClassName("listOpiniones");
let checkOpiAutor = document.getElementById("checkAnoni");
let autorOpi = document.getElementById("autor");
let califOpi = document.getElementById("selectCalif");
let msgOpi = document.getElementById("Opinion");
let btnEnviarOp = document.getElementById("btnEnviarOp");
let btnCerrarModal = document.getElementById("btnCerrarModal");
let cardOpinTmp = document.getElementById("opinionTemporal");;

let estrellas =[document.getElementById("pata1"),document.getElementById("pata2"),document.getElementById("pata3"),document.getElementById("pata4"),document.getElementById("pata5")];
let nameLoggedIn = "";
let userLoggedIn = false;

let url = '/api/usuarios/';
let url2 = '/api/info_veterinarios/';
let url3 = '/api/contactoVet/';



window.addEventListener("load", function (e){  


     if(localStorage.getItem("card")){        
        idCardVerMas = localStorage.getItem("card");
        
    fetch((url+idCardVerMas), {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response){	
		user = response;		
		
		fetch(url2, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response2){
			listInfo = response2;
			
			for(let i = 0; i < listInfo.length;i++){
				if(listInfo[i].usuarios_usuario_id == idCardVerMas){
					infovet = listInfo[i];													
					break;		
				}//if encontrar la info del vet 		
			}//for para encontrar la info del vetrinario
			
			fetch(url3, {
				  method: 'GET',
				  headers:{'Content-Type': 'application/json'}
				}).then(res => res.json())
				.catch(error => console.error('Error:', error))
				.then(function(contacto){	
				listContacto = contacto;		
		
				for(let j = 0; j < listContacto.length;j++){
					if(listContacto[j].usuarios_usuario_id == idCardVerMas){
						contactoVet = listContacto[j];													
						break;		
						}//if encontrar la info del vet 
					}//for recorrer a la tabla de contactovet
					
				 //letrero patitas
			        let contador=infovet.veterinario_calificacion;
			       
			        let letrero="";
			        for(let k=0;k<5;k++){
			            
			          if(k<contador){ //contador es el número de la estrella a la que le di click
			          letrero+=`<i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata1"></i>`
			         
			          }else{
			            letrero+=`<i class="fa fa-paw " style="color:black; text-shadow: 0 0 3px #000;" id="pata1"></i>`
			          }
			      }//for calificacion
						
				itemsContainer.innerHTML += `<div class="vetCardContainer">
			        <div class="cardHeader">
			          <a href="#">
			            <img src="${user.veterinario_url_imagen}" alt="">
			          </a>
			          <h2>${user.usuario_nombre}</h2>
			          <h4>${infovet.veterinario_especialidad}</h4>
			          <p>${letrero}</p> <!--esta es la parte a modificar-->
			        </div>
			        <div class="descripcion">
			          <p><strong>Descripción: </strong> ${infovet.veterinario_descripcion}</p>
			              <p><strong>Servicios: </strong>${infovet.veterinario_servicios}</p>
			              <p><strong>Dirección: </strong>${contactoVet.veterinario_direccion}</p>
			              <p><strong>Teléfono: </strong>${contactoVet.veterinario_telefono1}</p>
			              <p><strong>Teléfono Personal: </strong>${contactoVet.veterinario_telefono2}</p>
			              <p><strong>Correo: </strong>${user.usuario_correo}</p>
			              <p><strong>Horario: </strong>Lunes a viernes de: ${contactoVet.veterinario_horario_inicio} a ${contactoVet.veterinario_horario_cierre}</p>
			              <p><strong>Disponibilidad Urgencias 24/7: </strong>Disponible</p>
			              <p><strong>Costo Consulta: </strong>${infovet.veterinario_costo_consulta} mxn</p>
			              <div class="botones">                
			                <a href="#escribirOpinion" data-toggle="modal" id="btnOpinar">Escribir Opinión</a>
			              </div>
			        </div>
			      </div>`;
			      
			      let url5 = "/api/opinionesVet/"
		
					fetch(url5, {
					  method: 'GET',
					  headers:{'Content-Type': 'application/json'}
					}).then(res => res.json())
					.catch(error => console.error('Error:', error))
					.then(function(opin){	
					listOpiniones = opin;	
					
					for(let l = 0; l < listOpiniones.length;l++){
						if(listOpiniones[l].usuarios_usuario_id == idCardVerMas){
							
							let letrero2="";
							let contador2 = listOpiniones[l].opiniones_calificacion;
					        for(let m=0;m<5;m++){
					            
					          if(m<contador2){ //contador es el número de la estrella a la que le di click
					          letrero2+=`<i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata1"></i>`
					         
					          }else{
					            letrero2+=`<i class="fa fa-paw " style="color:black; text-shadow: 0 0 3px #000;" id="pata1"></i>`
					          }
					      }//for calificacion
							
							cardOpinTmp.style.display = "none";
							opinionContainer[0].insertAdjacentHTML("beforebegin", `<div class="card_ swiper-slide">
			            <div class="image-content">
			              <span class="overlay"></span>
			  
			              <div class="card-image">
			                <img src="../src/6.png" alt="" class="card-img">
			              </div>
			            </div>
			              <div class="puntuacion">
			                <p>${letrero2}</p>
			              </div>
			              
			              <div class="card-content">
			                <h2 class="nombre">${listOpiniones[l].opiniones_nombre_autor}</h2>
			                <p class="opinion">${listOpiniones[l].opiniones_comentario}</p>
			              </div>`)
						}//Si las opiniones pertenecen al veterinario
						}//for recorrer todas las opiniones		
					});//get opiniones
		 		});//GET todos los contactos
		 	});//get info_veterinarios
		});//get Usuario
		
		if(localStorage.getItem("userLogged") && localStorage.getItem("loggedIn") == "true"){
			let idUserLogged = localStorage.getItem("userLogged");
		
		fetch((url+idUserLogged), {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(autor){	
		userLogged = autor;			
		autorOpi.value = userLogged.usuario_nombre;
		});//vamos por el nombre del usuario que se acaba de firmar
        
        
        checkOpiAutor.addEventListener("click", function(e){
          if(checkOpiAutor.checked){
            autorOpi.value = "Usuario Anónimo Verificado";            
          }else{
            autorOpi.value = userLogged.usuario_nombre;           
          }
        })//Permuta el usuario de solo lectura por si quisiera hacerlo anonimo 

        msgOpi.addEventListener("keyup", function(e){
          e.preventDefault();
          validaOpinion();
        })//Validar que exista opinion
        function validaOpinion() {         
            let flag = false;             
            if(msgOpi.value.length > 20 && msgOpi.value.length<=200 && isNaN(msgOpi.value)){
              msgOpi.classList.remove("is-invalid");
              msgOpi.classList.add("is-valid");
              flag=true;
            }else{
              msgOpi.classList.remove("is-valid");
              msgOpi.classList.add("is-invalid");
            }
            return flag;
        };
        function validarCalif() {
          let flag = false;
          if(califOpi.options[califOpi.selectedIndex].value != 0){
            califOpi.classList.remove("is-invalid");
            califOpi.classList.add("is-valid");
            flag=true;
          }else{
            califOpi.classList.remove("is-valid");
            califOpi.classList.add("is-invalid");
          }
          return flag;
        }
        
        btnEnviarOp.addEventListener("click", function(e){
          e.preventDefault();
        
          if(validarCalif() && validaOpinion()){    

            let imgcalif=califOpi.options[califOpi.selectedIndex].value;
                        
            let url6 = '/api/opinionesVet/';
			let opinionBody = {				
		       
		        opiniones_nombre_autor: autorOpi.value ,
		        opiniones_calificacion: imgcalif,
		        opiniones_comentario:msgOpi.value ,
		        usuarios_usuario_id: idCardVerMas    
				};
			
			fetch(url6, {
			  method: 'POST', // or 'PUT'
			  body: JSON.stringify(opinionBody), // data can be `string` or {object}!
			  headers:{
			    'Content-Type': 'application/json',
			    'Authorization': "Bearer: "+localStorage.getItem("token")
			  }
			}).then(res => res.json())
			.catch(error => console.error('Error:', error))
			.then(function (newOp){
				 Swal.fire({
	              background: '#FFF9E3',
	              position: 'center',
	              icon: 'success',
	              title: 'Se revisará su opinión y si cumple las normas, se publicará en el perfil del usuario',
	              showConfirmButton: false,
	              timer: 3000,
	              timerProgressBar: true
	              });
	             setTimeout(() => {
	              btnCerrarModal.click();
	              location.reload();
	             }, 3000); 
				});//post opinion 
          }else{            
            validarCalif();
            validaOpinion();
          }//if llenado correcto
        })//btn click opinar       	 
	}else{		
        //let btnEnviarOp = document.getElementById("btnEnviarOp");       
        btnEnviarOp.classList.add("d-none");
	}//valida que local storage tenga el dato de inicio de sesion	
	}//if local Storage tiene card    
});//se inserta la card 






var swiper = new Swiper(".slide-content", {
  slidesPerView: 3,
  spaceBetween: 25,
  loop: false,
  centerSlide: 'true',
  fade: 'true',
  grabCursor: 'true',
   pagination: {
    el: ".swiper-pagination",
    clickable: true,
    dynamicBullets: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },

  breakpoints:{
      0:{
          slidesPerView: 1, 
      },
      520:{
          slidesPerView: 2, 
      },
      950:{
          slidesPerView: 3, 
      },
  },
});//propiedad responsiva del carrusel

