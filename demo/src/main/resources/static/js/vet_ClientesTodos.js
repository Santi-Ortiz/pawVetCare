let currentPage = 1;
const itemsPerPage = 4;
const clientes = document.querySelectorAll('.cliente-item');

function showPage(page) {
    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;

    clientes.forEach((cliente, index) => {
        if (index >= start && index < end) {
            cliente.style.display = 'block';
        } else {
            cliente.style.display = 'none';
        }
    });

    document.getElementById('pageNumber').textContent = page;
}

function changePage(direction) {
    const totalPages = Math.ceil(clientes.length / itemsPerPage);

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
