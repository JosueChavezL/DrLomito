let listUsuarios = [];
let listInfos = [];
let cardIndex = document.getElementById("cardIndex");

window.addEventListener("load", function(e){
e.preventDefault();
		let cont = 0;
		let url = '/api/usuarios/';
		let url2 = '/api/info_veterinarios/';
		
		fetch(url, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response){	
		listUsuarios = response,
		
		
		
		fetch(url2, {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
		}).then(res => res.json())
		.catch(error => console.error('Error:', error))
		.then(function(response2){
			listInfos = response2;
		//console.log(response2);
		for (let i = 0; i < listUsuarios.length; i++){	
					
				if(listUsuarios[i].tipo_usuario_id == 2 && cont < 3){
					let idUser = listUsuarios[i].id;
					//console.log(idUser);
					
					for (let j = 0; j < listInfos.length; j++){
						
						if(listInfos[j].usuarios_usuario_id == idUser){
							let usuario = listUsuarios[i];
							let info = listInfos[j];
							
							  cardIndex.innerHTML += `
							  <div class="card  all col-md-3 m-0">
							      <div class="presentacion">
							           <div class="img">
							              <img id="imagenTest" src="${usuario.veterinario_url_imagen}" height="300px" class="card-img-top"  alt="...">
							          </div>
							          <div class="producto-info">
							              <div class="producto-texto" style="text-align: center;">
							              
							              <h1 class="card-title">${usuario.usuario_nombre}</h1>
							              <p class="card-text">
							              <i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata">
							              <i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata"></i>
							              <i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata"></i>
							              <i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata"></i>
							              <i class="fa fa-paw " style="color:orange; text-shadow: 0 0 3px #000;" id="pata"></i>
							              </i></p>
							              <h2 class="card-text">${info.veterinario_especialidad}</h2>
							              <p class="card-text">${info.veterinario_descripcion}</p>
							              <br>
							              <p class="card-text">Consulta General<strong> $ ${info.veterinario_costo_consulta} MXN</strong></p>
							              
							              <br>
							              <div class="precio-btn">
							              <button><a href="../pages/doctorVerMas.html"type="buton" class="btn" id="btnVerMas_${idUser}">Ver más</a></button>
							          </div>
							      </div>
							  </div>`;
							 cont++;
						}//si el id del usuario coincide con el id_usuario de la tabla info
					}//for se recorre la tabla de info veterinario			
				}//if usuario == tipo2	 
		}//for se recorre la lista de usuarios
		});//response2 de la lista de informaciones
		});//function response de la lista de usuarios
});//window addEventListener