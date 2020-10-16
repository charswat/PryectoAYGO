// console.log('funcionando');

var formulario = document.getElementById('formulario');
var respuesta = document.getElementById('respuesta');

formulario.addEventListener('submit', function(e){
    e.preventDefault();
    console.log('me diste un click')

    var datos = new FormData(formulario);

    //console.log(datos)
    var data = {"nombre": datos.get('usuario')};
    //console.log(datos.get('usuario'))

    fetch('http://127.17.0.1:8090/add',{
        method: 'POST',
        body: JSON.stringify(data),
        headers:{
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Request-Method': 'OPTIONS,POST,GET',
                'Access-Control-Request-Headers': 'Content-Type',
                 'Content-Length': 'content.length.toString()',
                  'X-Custom-Header': 'ProcessThisImmediately'
              },
    })
        .then( res => res.json())
        .then( data => {
            console.log(data)
            if(data === 'error'){
                respuesta.innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Llena todos los campos
                </div>
                `
            }else{

                          tbody=document.querySelector('#tablaUsuarios tbody');
                          tbody.innerHTML = '';

                         for(var i=0;i<data.length;i++){
                           var fila =tbody.insertRow(i);
                           var dateCell = fila.insertCell(0);
                           var nameCell = fila.insertCell(1);

                           dateCell.innerHTML = data[i].fecha_cracion;
                           nameCell.innerHTML = data[i].nombre;
                           tbody.appendChild(fila);

                              }

            }
        } )
})