let listUsersDir = [];//Arreglo de objetos JSON, 1 por cada veterinario
let listInfos = [];
let listCat = [];
let CatActual;
let itemsContainer = document.getElementById("list-items"); //la lista se llena con los veterinarios
let checkFilter = document.getElementsByClassName("custom-control-input"); //filtros por categorías
let btnFiltrar = document.getElementById("btnFiltrar");
	

window.addEventListener("load", function () {
	
	let url = '/api/usuarios/';
	let url2 = '/api/info_veterinarios/';
	let url3 = '/api/categoria_vet/';
		
		fetch(url, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response){	
		listUsersDir = response;
		
		fetch(url2, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response2){
			listInfos = response2;
			
		fetch(url3, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(categorias){	
		listCat = categorias;		
		
		for (let i = 0; i < listUsersDir.length; i++){
				
				if(listUsersDir[i].tipo_usuario_id == 2){
					let idUser = listUsersDir[i].id;
					
					for (let j = 0; j < listInfos.length; j++){	
											
						if(listInfos[j].usuarios_usuario_id == idUser){
							let usuario = listUsersDir[i];
							let info = listInfos[j];
							
							let contador=info.veterinario_calificacion;//letrero patitas
						        //console.log(contador)
						        let letrero="";
						        for(let k=0;k<5;k++){
						            
						          if(k<contador){ //contador es el número de la estrella a la que le di click
						          letrero+=`<i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata1"></i>`
						         
						          }else{
						           letrero+=`<i class="fa fa-paw " style="color:black; text-shadow: 0 0 3px #000;" id="pata1"></i>`
						          }//patitas
						          }//for patitas
						          
						          for (let l = 0; l < listCat.length; l++){
									if(listCat[l].categoria_id == info.categoria_vet_categoria_id)
									{
										CatActual= listCat[l].categoria_nombre;
									
									 itemsContainer.innerHTML += `
					                <div class="card ${checkCat(CatActual)} all col-md-4 m-3">
					                    <div class="presentacion">
					                         <div class="img">
					                            <img id="imagenTest" src="${usuario.veterinario_url_imagen}" height="300px" width="10000px" class="card-img-top"  alt="...">
					                        </div>
					                        <div class="producto-info">
					                            <div class="producto-texto">
					                            
					                            <h1 class="card-title">${usuario.usuario_nombre}</h1>
					                            <p class="card-text">${letrero}</p>
					                            <h2 class="card-text">${info.veterinario_especialidad}</h2>
					                            <p class="card-text">${info.veterinario_descripcion}</p>
					                            <p class="card-text">Consulta General<strong> $${info.veterinario_costo_consulta} MXN</strong></p>
					                            
					                        <div class="precio-btn">
					                            <button><a href="../pages/doctorVerMas.html"type="buton" class="btn" id="btnVerMas_${idUser}">Ver más</a></button>
					                        </div>
					                    </div>
					                </div>`;				
									}//if si la categoria coincide 			
							     }//for se identifica cual categoria tiene 						         
							}//if el id coincide
					}//for sacar toda la info de veterinarios
				}// if Sacamos a los usuarios que sean tipo veterinario	            
       		 };//for sacar todos los elementos de las tablas 		
		   });//get lista categorias url3									
		});//get lista de info de veterinarios url2		
	});//GET lista de usuarios url        
});//window addEventListener


itemsContainer.addEventListener("click", function (event) {
    //event.preventDefault();
   console.log(event.target.id)  //muestra el lugar donde se hizo click
   if((event.target.id).includes("btnVerMas_")){    
        console.log(event.target.id);
    let posCard = (event.target.id).slice(10);     
    localStorage.setItem("card", posCard);
   }
});//Escuchar cualquier click en el contenedor

btnFiltrar.addEventListener("click", function (event) {
    if (checkFilter[0].checked) {
        checkFilter[0].click();
    }
})//filtrar por especialidad

checkFilter[0].addEventListener("click", checkAll);//limpia los checkboxes
checkFilter[1].addEventListener("click", checkStatus);
checkFilter[2].addEventListener("click", checkStatus);
checkFilter[3].addEventListener("click", checkStatus);
checkFilter[4].addEventListener("click", checkStatus);
checkFilter[5].addEventListener("click", checkStatus);
checkFilter[6].addEventListener("click", checkStatus);
checkFilter[7].addEventListener("click", checkStatus);
checkFilter[8].addEventListener("click", checkStatus);
checkFilter[9].addEventListener("click", checkStatus);
checkFilter[10].addEventListener("click", checkStatus);
checkFilter[11].addEventListener("click", checkStatus);
checkFilter[12].addEventListener("click", checkStatus);

function checkAll(event) {

    for (let i = 1; i < checkFilter.length; i++) {
        if (checkFilter[i].checked) {
            checkFilter[i].click();
        }
    }//recorre todos los checkbox y si están activos los desactiva

    let elementos = Array.from(document.getElementsByClassName(event.target.value));
    elementos.forEach((e) => {
        if (event.target.checked) {
            e.classList.remove("d-none");
            e.classList.add("d-block");
            // e.style.display = "block";
        } else {
            e.classList.remove("d-block");
            e.classList.add("d-none");
            //e.style.display = "none";
        }
    })//recorre todas las cards

}//Si presiono el de mostrar todos, deselecciona los demás

function checkStatus(event) {

    let elementos = Array.from(document.getElementsByClassName(event.target.value));
    elementos.forEach((e) => {
        if (event.target.checked) {
            e.classList.remove("d-none");
            e.classList.add("d-block");
            // e.style.display = "block";
        } else {
            e.classList.remove("d-block");
            e.classList.add("d-none");
            //e.style.display = "none";
        }
    })

}//identifica la categoria seleccionada con los checkbox y los muestra u oculta

function checkCat(nombreCat){
	let c = "";
	switch (nombreCat){
		case "Veterinario General":
			c="vetG";
			break;
			
		case "Veterinario Aviar":
				c="vetAv";
				break;
		
		case "Veterinario Reptiles":
				c="vetRep";
				break;
		
		case "Veterinario Ganadería":
				c="vetGan";
				break;
				
		case "Veterinario Ortopedista":
				c="vetOrt";
				break;
				
		case "Veterinario Cirujano":
				c="vetCir";
				break;
				
		case "Veterinario Oncólogo":
				c="vetOnc";
				break;
				
		case "Veterinario Oftalmólogo":
				c="vetOft";
				break;
				
		case "Veterinario Fisioterapeuta":
				c="vetFis";
				break;
				
		case "Veterinario Dermatólogo":
				c="vetDer";
				break;
				
		case "Veterinario Odontólogo":
				c="vetOdo";
				break;
				
		case "Otros":
				c="otros";
				break;
				
		default:
				c="all";
				break;		
	}//switch
	return c;
}//funcion Switch para agregar categorias de checkbox
