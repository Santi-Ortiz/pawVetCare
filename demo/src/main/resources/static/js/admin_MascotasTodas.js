let currentPage = 1;
const itemsPerPage = 4;
const mascotas = document.querySelectorAll('.mascota-item');

function showPage(page) {
    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;

    mascotas.forEach((mascota, index) => {
        if (index >= start && index < end) {
            mascota.style.display = 'block';
        } else {
            mascota.style.display = 'none';
        }
    });

    document.getElementById('pageNumber').textContent = page;
}

function changePage(direction) {
    const totalPages = Math.ceil(mascotas.length / itemsPerPage);

    currentPage += direction;

    if (currentPage < 1) {
        currentPage = 1;
    } else if (currentPage > totalPages) {
        currentPage = totalPages;
    }

    showPage(currentPage);
}

document.addEventListener('DOMContentLoaded', () => {
    showPage(currentPage);
});
