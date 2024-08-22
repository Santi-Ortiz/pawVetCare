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

document.getElementById('cliente_agregar').addEventListener('submit', function(event) {
    event.preventDefault(); 

    const nombre = document.getElementById('nombre').value;
    const cedula = document.getElementById('cedula').value;
    const correo = document.getElementById('correo').value;
    const celular = document.getElementById('celular').value;

    const form = document.createElement('form');
    form.method = 'POST';
    form.action = '/cliente/agregar'; 

    const createHiddenField = (name, value) => {
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = name;
        input.value = value;
        return input;
    };

    //form.appendChild(createHiddenField('id', 10))
    form.appendChild(createHiddenField('nombre', nombre));
    form.appendChild(createHiddenField('cedula', cedula));
    form.appendChild(createHiddenField('correo', correo));
    form.appendChild(createHiddenField('celular', celular));

    // Añade el formulario al DOM
    document.body.appendChild(form);

    form.submit();
});

