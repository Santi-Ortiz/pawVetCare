let currentPage = 1;
const itemsPerPage = 4;
const veterinarios = document.querySelectorAll('.veterinario-item');

function showPage(page) {
    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;

    veterinarios.forEach((veterinario, index) => {
        if (index >= start && index < end) {
            veterinario.style.display = 'block';
        } else {
            veterinario.style.display = 'none';
        }
    });

    document.getElementById('pageNumber').textContent = page;
}

function changePage(direction) {
    const totalPages = Math.ceil(veterinarios.length / itemsPerPage);

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