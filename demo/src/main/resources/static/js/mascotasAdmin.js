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

function enviarDatos() {
    const nombre = document.getElementById('nombre').value;
    const raza = document.getElementById('raza').value;
    const edad = document.getElementById('edad').value;
    const peso = document.getElementById('peso').value;
    const enfermedad = document.getElementById('enfermedad').value;
    const dueno = document.getElementById('dueno').value;
    const estado = document.getElementById('estado').value;
    const url = document.getElementById('url').value;

    // Crear un objeto con los datos
    const mascota = {
        nombre: nombre,
        raza: raza,
        edad: edad,
        peso: peso,
        enfermedad: enfermedad,
        dueno: dueno,
        estado: estado,
        url: url
    };

    fetch('URL_DEL_SERVIDOR', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(mascota)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Éxito:', data);
        // Opcionalmente, puedes limpiar los campos aquí
        document.getElementById('nombre').value = '';
        document.getElementById('raza').value = '';
        document.getElementById('edad').value = '';
        document.getElementById('peso').value = '';
        document.getElementById('enfermedad').value = '';
        document.getElementById('dueno').value = '';
        document.getElementById('estado').value = '';
        document.getElementById('url').value = '';
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
