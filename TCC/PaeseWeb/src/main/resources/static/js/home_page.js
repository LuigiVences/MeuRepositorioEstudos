// Função para abrir/fechar a sidebar (mobile)
function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("active");
}

// Função para abrir/fechar submenus
function toggleSubmenu(id) {
    const submenu = document.getElementById(id);

    if (!submenu) return;

    // Fecha outros submenus antes de abrir o clicado
    document.querySelectorAll(".submenu").forEach(s => {
        if (s.id !== id) {
            s.style.display = "none";
        }
    });

    // Alterna visibilidade do submenu clicado
    if (submenu.style.display === "block") {
        submenu.style.display = "none";
    } else {
        submenu.style.display = "block";
    }
}

// Fecha sidebar se clicar fora dela (apenas em telas pequenas)
document.addEventListener("click", function (event) {
    const sidebar = document.getElementById("sidebar");
    const toggleButton = document.querySelector(".sidebar-toggle");

    if (window.innerWidth <= 991) {
        if (!sidebar.contains(event.target) && !toggleButton.contains(event.target)) {
            sidebar.classList.remove("active");
        }
    }
});
