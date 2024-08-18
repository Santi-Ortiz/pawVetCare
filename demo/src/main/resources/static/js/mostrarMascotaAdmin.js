function toggleEliminar() {
    const botonEliminar = document.getElementById("eliminarBtn");
    botonEliminar.classList.toggle("expanded");
    if (botonEliminar.classList.contains("expanded")) {
        form.submit();
    } else {
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
    const anchoMinimo = 100; // Ancho mínimo en píxeles
    const anchoMaximo = 700; // Ancho máximo en píxeles

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
        botonEditar.classList.add("expanded");
        botonEditar.innerHTML = "<span class='text'>Guardar</span>";
    }
}
