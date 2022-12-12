function agregar() {
    nodo = document.createElement("li")
    texto = document.createTextNode(document.getElementById("msj").value)

    nodo.appendChild(texto)
    nodo.setAttribute("id", "idx")
    document.getElementById("lista").appendChild(nodo)
}