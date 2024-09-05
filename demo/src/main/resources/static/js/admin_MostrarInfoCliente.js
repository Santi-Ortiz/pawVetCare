function toggleEliminar() {
    const botonEliminar = document.getElementById("eliminarBtn");

    // Si el botón ya está expandido, ejecuta la acción de eliminar
    if (botonEliminar.classList.contains("expanded")) {
        document.getElementById("cliente_delete").submit();
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

    if (botonEditar.classList.contains("expanded")) {
        
        inputs.forEach(input => {
            input.setAttribute("readonly", true);
        });
        botonEditar.classList.remove("expanded");
        botonEditar.innerHTML = "<span class='icon'>✎</span><span class='text'>Editar todo</span>";
        
        document.getElementById("clienteForm").submit();
    } else {
        
        inputs.forEach(input => {
            input.removeAttribute("readonly");
        });
        botonEditar.classList.add("expanded");
        botonEditar.innerHTML = "<span class='text'>Guardar</span>";
    }
}

/*let index = 0;

function cambiarMascota(direccion) {
    const items = document.querySelectorAll('.mascota-item');
    if (items.length === 0) return;

    index = (index + direccion + items.length) % items.length;
    document.querySelector('.carrusel').style.transform = `translateX(-${index * 106.5}%)`;
}*/

let index = 0;

function cambiarMascota(direccion) {
    const items = document.querySelectorAll('.mascota-item');
    if (items.length === 0) return;

    // Cambiar el índice de la mascota actual
    index = (index + direccion + items.length) % items.length;

    // Actualizar el contenido dinámico de la mascota seleccionada
    const mascotaActual = items[index];

    const nombre = mascotaActual.querySelector('.info-itemNombre .info-label').textContent;
    const raza = mascotaActual.querySelector('.info-itemRaza .info-label').textContent;
    const edad = mascotaActual.querySelector('.info-itemEdad .info-label').textContent;
    const peso = mascotaActual.querySelector('.info-itemPeso .info-label').textContent;
    const enfermedad = mascotaActual.querySelector('.info-itemEnfermedad .info-label').textContent;
    const foto = mascotaActual.querySelector('.mascota-foto').src;

    // Actualizar los campos de la interfaz para reflejar los valores de la mascota actual
    document.querySelector('.info-itemNombre .info-label').textContent = nombre;
    document.querySelector('.info-itemRaza .info-label').textContent = raza;
    document.querySelector('.info-itemEdad .info-label').textContent = edad;
    document.querySelector('.info-itemPeso .info-label').textContent = peso;
    document.querySelector('.info-itemEnfermedad .info-label').textContent = enfermedad;
    document.querySelector('.mascotaimg').src = foto;

    // Ajustar la transformación de desplazamiento visual en el carrusel
    document.querySelector('.carrusel').style.transform = `translateX(-${index * 106.5}%)`;
}


// Función para moverse automáticamente cada 6 segundos
function autoMoverCarrusel() {
    cambiarMascota(1);
}

// Iniciar el movimiento automático del carrusel
setInterval(autoMoverCarrusel, 6000); 