// Abrir/fechar submenus (apenas um aberto por vez)
function toggleSubmenu(id) {
    const submenus = document.querySelectorAll('.submenu');
    submenus.forEach(sm => {
        if (sm.id !== id) sm.classList.remove('show');
    });
    const submenu = document.getElementById(id);
    submenu.classList.toggle('show');
}

// Toggle sidebar em mobile
const menuToggle = document.getElementById('menuToggle');
const sidebar = document.getElementById('sidebar');

if(menuToggle){
    menuToggle.addEventListener('click', () => {
        sidebar.classList.toggle('active');
    });
}
