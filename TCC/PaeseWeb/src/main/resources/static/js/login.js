document.addEventListener("DOMContentLoaded", () => {
    const errorAlert = document.getElementById("errorAlert");
    const successAlert = document.getElementById("successAlert");
    const loginForm = document.getElementById("loginForm");

    function hideAlerts() {
        if (errorAlert) errorAlert.style.display = "none";
        if (successAlert) successAlert.style.display = "none";
    }

    // Esconde automaticamente após 5 segundos
    setTimeout(hideAlerts, 5000);

    // Esconde quando o usuário digitar em qualquer input
    if (loginForm) {
        const inputs = loginForm.querySelectorAll("input");
        inputs.forEach(input => input.addEventListener("input", hideAlerts));
    }
});


