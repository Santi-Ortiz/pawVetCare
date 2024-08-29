let index = 0;

function cambiarMascota(direccion) {
    const items = document.querySelectorAll('.mascota-item');
    if (items.length === 0) return;

    index = (index + direccion + items.length) % items.length;
    document.querySelector('.carrusel').style.transform = `translateX(-${index * 106.5}%)`;
}

// Función para moverse automáticamente cada 6 segundos
function autoMoverCarrusel() {
    cambiarMascota(1);
}

// Iniciar el movimiento automático del carrusel
setInterval(autoMoverCarrusel, 6000);

document.getElementById('mascota_agregar').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita el envío automático del formulario

    // Obtiene los valores de los campos del formulario
    const nombre = document.getElementById('nombre').value;
    const raza = document.getElementById('raza').value;
    const edad = document.getElementById('edad').value;
    const peso = document.getElementById('peso').value;
    const enfermedad = document.getElementById('enfermedad').value;
    const idCliente = parseInt(document.getElementById('dueno').value, 10);
    const estado = document.getElementById('estado').value;
    const foto = document.getElementById('url').value;

    // Crea un nuevo formulario
    const form = document.createElement('form');
    form.method = 'POST';
    form.action = '/mascota/agregar'; // URL para enviar los datos al backend

    // Crea campos ocultos y añádelos al formulario
    const createHiddenField = (name, value) => {
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = name;
        input.value = value;
        return input;
    };

    //form.appendChild(createHiddenField('id', 10))
    form.appendChild(createHiddenField('nombre', nombre));
    form.appendChild(createHiddenField('raza', raza));
    form.appendChild(createHiddenField('edad', edad));
    form.appendChild(createHiddenField('peso', peso));
    form.appendChild(createHiddenField('enfermedad', enfermedad));
    form.appendChild(createHiddenField('idCliente', idCliente));
    form.appendChild(createHiddenField('estado', estado));
    form.appendChild(createHiddenField('foto', foto));

    // Añade el formulario al DOM (puede ser en el body o en un contenedor invisible)
    document.body.appendChild(form);

    // Envía el formulario
    form.submit();
});

