function toggleEliminar() {
    const botonEliminar = document.getElementById("eliminarBtn");

    // Si el botón ya está expandido, ejecuta la acción de eliminar
    if (botonEliminar.classList.contains("expanded")) {
        document.getElementById("mascota_delete").submit();
    } else {
        // Si no está expandido, lo expande y espera a la próxima interacción
        botonEliminar.classList.add("expanded");
    }
}

function ajustarAnchoInput(input) {
    const tempSpan = document.createElement("span");
    tempSpan.style.visibility = "hidden";
    tempSpan.style.fontSize = window.getComputedStyle(input).fontSize;
    document.body.appendChild(tempSpan);
    tempSpan.textContent = input.value || input.placeholder;

    let anchoCalculado = tempSpan.offsetWidth;
    const anchoMinimo = 20; // Ancho mínimo en píxeles
    const anchoMaximo = 100; // Ancho máximo en píxeles

    // Ajustar el ancho del input dentro de los límites
    if (anchoCalculado < anchoMinimo) {
        anchoCalculado = anchoMinimo;
    } else if (anchoCalculado > anchoMaximo) {
        anchoCalculado = anchoMaximo;
    }

    input.style.width = anchoCalculado + "px";
    document.body.removeChild(tempSpan);
}

function toggleEditar() {
    const botonEditar = document.getElementById("editarBtn");
    const inputs = document.querySelectorAll(".info-label");
    const estado = document.getElementById("state");
    

    if (botonEditar.classList.contains("expanded")) {
        
        inputs.forEach(input => {
            input.setAttribute("readonly", true);
        });
        botonEditar.classList.remove("expanded");
        botonEditar.innerHTML = "<span class='icon'>✎</span><span class='text'>Editar todo</span>";
        
        
        document.getElementById("mascotaForm").submit();
    } else {
        
        inputs.forEach(input => {
            input.removeAttribute("readonly");
        });
        estado.disabled = false;
        botonEditar.classList.add("expanded");
        botonEditar.innerHTML = "<span class='text'>Guardar</span>";
    }
} 