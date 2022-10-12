function traerInformacion(){
    $.ajax({
        url:"/api/Costume/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            pintarRespuesta(respuesta);
        },
        error:function(xhr, respuesta){
            alert("Error de peticion")
        }
    });
}

function guardarInformacion(){
    let dataToSend = JSON.stringify(obtenerDatos());
    $.ajax({
        url:"/api/Costume/save",
        type:"POST",
        datatype:"JSON",
        contentType:"application/json",
        data:dataToSend,
        success:function(respuesta){
            limpiarDatos();
        },
        error:function(xhr, respuesta){
            alert("Error de peticion")
        }
    }       );
}

function editarInformacion(){
    let dataToSend = JSON.stringify(obtenerDatos());
    $.ajax({
        url:"https://gbfd8e46a86e2ab-dydw68nms7c2dtt4.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/peticiones/peticiones",
        type:"PUT",
        datatype:"JSON",
        contentType:"application/json",
        data:dataToSend,
        success:function(respuesta){
            limpiarDatos();
        },
        error:function(xhr, respuesta){
            alert("Error de  peticion")
        }
    });
}

function borrarElemento(idElemento){
    let data = {
        id:idElemento
    };
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url:"https://gbfd8e46a86e2ab-dydw68nms7c2dtt4.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/peticiones/peticiones",
        type:"DELETE",
        datatype:"JSON",
        contentType:"application/json",
        data:dataToSend,
        success:function(respuesta){
            limpiarDatos();
        },
        error:function(xhr, respuesta){
            alert("Error de  peticion")
        }
    });
}

function obtenerDatos(){
    let data = {
        id:$("#id").val(),
        name:$("#name").val(),
        brand:$("#brand").val(),
        year:$("#year").val(),
        category_id:$("#category").val(),
    };
    return data;
}

function pintarRespuesta(items){
    let tabla = '<div class="container"><div class="row">';
    for(i = 0;i<items.length;i++){
        tabla+=`
            <div class="card m-2">
                <div class="card-body">
                    <h5 class="card-tittle">${items[i].brand}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${items[i].year}</h6>
                    <p class="card-text">${items[i].name}</p>
                 
                    <p class="card-tittle">Category</p>
                    <button class="btn btn-danger" onclick="borrarElemento(${items[i].id})">Borrar</button>
                </div>  
            </div>
                `
    }
    tabla+= "</div></div>";
    $("#resultado").append(tabla);
}

function imprimir(items){
    let tabla ="<table border=2px>";
    for (i = 0; i < items.length; i++) {
        tabla+="<tr>";
        tabla+="<td>"+ items[i].id +"</td>";
        tabla+="<td>"+ items[i].name +"</td>";
        tabla+="<td>"+ items[i].brand +"</td>";
        tabla+="<td>"+ items[i].model +"</td>";
        tabla+="<td> <button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        tabla+="</tr>";
    }
    tabla+="</table>"
    $("#resultado").append(tabla);
}

function limpiarDatos(){
    $("#resultado").empty();
    $("#id").val("");
    $("#name").val("");
    $("#brand").val("");
    $("#model").val("");
    $("#category").val("");
    traerInformacion();
}