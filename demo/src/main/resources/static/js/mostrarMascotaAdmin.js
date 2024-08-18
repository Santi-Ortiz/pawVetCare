function toggleEliminar() {
    const botonEliminar = document.getElementById("eliminarBtn");
    botonEliminar.classList.toggle("expanded");
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
const labels = document.querySelectorAll(".info-label");

if (!botonEditar.classList.contains("expanded")) {
// Expandir el botón y cambiar a campos de entrada
labels.forEach(label => {
    const input = document.createElement("input");
    input.type = "text";
    input.value = label.innerText;
    input.className = "input-text";
    ajustarAnchoInput(input);
    label.replaceWith(input);
});
botonEditar.classList.add("expanded");
botonEditar.innerHTML = "<span class='text'>Editar Todo</span>";
} else {
    // Colapsar el botón y volver a etiquetas de texto
    const inputs = document.querySelectorAll(".input-text");
    inputs.forEach(input => {
        const label = document.createElement("label");
        label.className = "info-label";
        label.innerText = input.value;
        input.replaceWith(label);
    });
    botonEditar.classList.remove("expanded");
    botonEditar.innerHTML = "<span class='icon'>✎</span><span class='text'>Editar todo</span>";
    }
}