var msj_bot ={
    saludo: "hola",
    despedida: "adios",
    preocupacion: "como estas",
    sorpresa: "orale"

}

var arr_msj = ["hola", "adios", "como estas", "orale"]

function test() {
    let mensajes = document.getElementById("msjs")
    //mensajes.innerHTML = arr_msj
    //mensajes.innerHTML = msj_bot
    mensajes.innerHTML = JSON.stringify(msj_bot)
}

function procesa() {
    let campo = document.getElementById("msj").value
    console.log(woz(campo))

    let mensajes = document.getElementById("msjs")
    mensajes.innerHTML = msj_bot[woz(campo)]
}

function woz(params) {
    if(params == "hola"){
        return "saludo"
    }
    if(params == "me siento mal"){
        return "sorpresa"
    }
    if(params == "adios"){
        return "despedida"
    }
    if(params == ""){
        return "preocupacion"
    }
    
}
