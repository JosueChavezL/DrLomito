let formContainer = document.getElementById("caseVet");
let user = [];
let listInfo = [];
let listContacto = [];
let infovet = [];
let contactoVet = [];
let listCateg = [];
let categ = 0;
let nombreCateg = "";


window.addEventListener("load", function(e){
e.preventDefault();

let userId = localStorage.getItem("userLogged");
let url = '/api/usuarios/';

fetch((url+userId), {
		  method: 'GET',
		  headers:{'Content-Type': 'application/json'}
			}).then(res => res.json())
			.catch(error => console.error('Error:', error))
			.then(function(response){	
		 	 user = response;
		 	
		 	 
		 	 if(user.tipo_usuario_id == 1){			
			 formContainer.innerHTML +=`<form id="formVet" class="form-group col-sm-5">
				      <br>
				        <div class="form-group">
				          <!-- NOMBRE -->
				          <div class="form-row d-flex justify-content-start">
				            <div class="form-group col-md-12">
				            <label for="inputNombre">Nombre:</label>
				            <input type="text" class="form-control" id="inputNombre" value="${user.usuario_nombre}" readonly>
				            </div>
				          </div>
				          <div class="form-row d-flex justify-content-start">
				            <div class="form-group col-md-12">
				              <!--correo-->
				              <label for="inputCorreo">Correo:</label>
				              <input type="email" class="form-control" id="inputCorreo" value="${user.usuario_correo}" placeholder="ejemplo@correo.com" readonly>
				            </div>
				          </div>
				   </div>
				   </form>`
				}else{
					
					let url2 = '/api/info_veterinarios/';
					fetch(url2, {
							  method: 'GET',
							  headers:{'Content-Type': 'application/json'}
								}).then(res => res.json())
								.catch(error => console.error('Error:', error))
								.then(function(info){	
							 	 listInfo = info;
							 	
							 	 for(let i = 0; i < listInfo.length;i++){
									if(listInfo[i].usuarios_usuario_id == userId){
										infovet = listInfo[i];
										categ = listInfo[i].categoria_vet_categoria_id;									
										break;		
									}//if encontrar la info del vet 		
								}//for recorrer a todas las infos en busca del id
							 	 
							 	 let url3 = '/api/contactoVet/';
								fetch(url3, {
										  method: 'GET',
										  headers:{'Content-Type': 'application/json'}
											}).then(res => res.json())
											.catch(error => console.error('Error:', error))
											.then(function(contact){	
										 	 listContacto = contact;
										 	 
										 	 for(let j = 0; j < listContacto.length;j++){
												if(listContacto[j].usuarios_usuario_id == userId){
													contactoVet = listContacto[j];													
													break;		
												}//if encontrar la info del vet 
												}//for recorrer a la tabla de contactovet
										 	 
										 	  let url4 = '/api/categoria_vet/';
												fetch((url4+categ), {
														  method: 'GET',
														  headers:{'Content-Type': 'application/json'}
															}).then(res => res.json())
															.catch(error => console.error('Error:', error))
															.then(function(listCat){	
														 	 listCateg = listCat;														 	 
														 	 nombreCateg = listCateg.categoria_nombre;
														 	  console.log("true categorias");
														 	 
														 	  formContainer.innerHTML += `<form id="formVet">
															    <br>
															      <div class="form-group">
															        <!-- NOMBRE -->
															        <div class="form-row d-flex justify-content-center">
															          <div class="form-group col-md-4">
															          <label for="inputNombre">Nombre:</label>
															          <input type="text" class="form-control" id="inputNombre" value="${user.usuario_nombre}" readonly>
															          </div>
															          <div class="form-group col-md-4">
															            <!--correo-->
															            <label for="inputCorreo">Correo:</label>
															            <input type="email" class="form-control" id="inputCorreo" value="${user.usuario_correo}" placeholder="ejemplo@correo.com" readonly>            
															          </div>
															           <!-- Categoria -->
															          <div class="form-group col-md-3">            
															          <label for="inputCorreo">Categoría:</label>
															          <input type="text" class="form-control" id="categoriaPerf" value="${nombreCateg}" readonly>           
															          </div>
															        </div>          
															    
															        <div class="form-row d-flex justify-content-center">
															            <div class="form-group col-md-4">
															              <!-- Especialidad -->
															              <label for="inputEspecialidad">Especialidad:</label>
															              <input type="text" class="form-control" id="inputEspecialidad" value="${infovet.veterinario_especialidad}" placeholder="Especialidad" readonly>
															            </div>  
															            <div class="form-group col-md-3">
															              <!-- Consulta -->
															              <label for="inputConsulta">Consulta</label>
															              <input type="text" class="form-control" id="inputConsulta" value="${infovet.veterinario_costo_consulta}" placeholder="Costo por consulta" readonly>
															              <small class="form-text text-muted">
															                Ejemplo: 300.00
															              </small>
															              <div class="invalid-feedback">
															                Recuerda este campo solo debe contener números.
															              </div>
															            </div>
															            <div class="form-group col-md-4">
															              <!-- Direccion -->
															              <label for="inputDireccion">Dirección</label>
															              <input type="text" class="form-control" id="inputDireccion" value="${contactoVet.veterinario_direccion}" placeholder="Dirección" readonly>
															              <small class="form-text text-muted">
															                Ejemplo: Calle y # exterior
															              </small>
															              <div class="invalid-feedback">
															                  Recuerda este campo debe contener entre 5 y 300 caracteres
															              </div>
															            </div>     
															        </div>
															       
															       
															        <div class="form-row d-flex justify-content-center">
															          <div class="form-group  col-md-6">
															            <!-- Descripción -->
															            <label for="inputDescripcion">Descripción:</label>
															            <textarea type="text" class="form-control" id="inputDescripcion" placeholder="Descripción" rows="3" readonly>${infovet.veterinario_descripcion}</textarea>            
															          </div>
															          <div class="form-group col-md-5">
															            <!-- Servicios -->
															            <label for="inputServicios">Servicios</label>
															            <textarea type="text" class="form-control" id="inputServicios" placeholder="Servicios" rows="3" readonly>${infovet.veterinario_servicios}</textarea>
															            </div>
															        </div>
															    
															        <div class="form-row d-flex justify-content-center">
															          <!-- Télefono Local -->
															        <div class="form-group col-md-3">
															          <label for="inputTelLocal">Teléfono Local:</label>
															          <input type="text" maxlength="10" class="form-control" id="inputTelLocal" value="${contactoVet.veterinario_telefono1}" placeholder="Número a 10 dígitos" readonly>          
															        </div>
															    
															          <!-- Teléfono Personal -->
															        <div class="form-group col-md-3">
															          <label for="inputTelPersonal">Teléfono Personal:</label>
															          <input type="text" maxlength="10" class="form-control" id="inputTelPersonal" value="${contactoVet.veterinario_telefono2}" placeholder="Número a 10 dígitos" readonly>          
															        </div>
															    
															          <!-- Hora Inicio -->
															        <div class="form-group col-md-3">
															          <label for="inputHoraIni">Hora Apertura:</label>
															          <input type="text" class="form-control" id="inputHoraIni" value="${contactoVet.veterinario_horario_inicio}" placeholder="Hora de Apertura a 2 dígitos" readonly>          
															        </div>
															    
															        <!-- Hora Cierre -->
															      <div class="form-group col-md-2">
															        <label for="inputHoraCie"> Hora de cierre:</label>
															        <input type="text" class="form-control" id="inputHoraCie" value="${contactoVet.veterinario_horario_cierre}" placeholder="Hora de cierre a 2 dígitos" readonly>        
															      </div>              
															    </div>    
															    </div>
															    </form>`;
										 	 
										 	 });//GET todas las categorias
							 	 		});//GET contactos
							 	 });//GET VETINFO
				}//if si es un usuario normal o un veterinario
		 });//GET Usuario


})//window addEventListener