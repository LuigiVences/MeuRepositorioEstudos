document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById('loginForm');
  const cancelBtn = document.getElementById('cancelBtn');
  const alertPlaceholder = document.getElementById('alertPlaceHolder');

  function showAlert(message, type) {
    if (!alertPlaceholder) return;
    alertPlaceholder.innerHTML = `
      <div class="alert alert-${type} alert-dismissible fade show mt-3" role="alert">
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
    `;
    setTimeout(() => { alertPlaceholder.innerHTML = ''; }, 5000);
  }

  function hideAlerts() {
    if (alertPlaceholder) alertPlaceholder.innerHTML = '';
  }

  // Mensagens do Spring Security
  const urlParams = new URLSearchParams(window.location.search);
  const error = urlParams.get('error');
  const logout = urlParams.get('logout');
  if (error) showAlert(error, 'danger');
  if (logout) showAlert(logout, 'success');

  // Botão Cancelar
  if (cancelBtn && form) {
    cancelBtn.addEventListener('click', () => {
      form.reset();
      form.classList.remove('was-validated');
      hideAlerts();
      form.querySelectorAll('input').forEach(input => {
        input.classList.remove('is-valid', 'is-invalid');
      });
    });
  }

  // Validação do formulário
  if (form) {
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      e.stopPropagation();

      const emailInput = document.getElementById('email');
      const passwordInput = document.getElementById('password');

      let valid = true;

      // Limpa classes antigas
      [emailInput, passwordInput].forEach(input => {
        input.classList.remove('is-valid', 'is-invalid');
      });

      // Validação email
      if (!emailInput.value) {
        emailInput.classList.add('is-invalid');
        valid = false;
      } else {
        emailInput.classList.add('is-valid');
      }

      // Validação senha
      if (!passwordInput.value) {
        passwordInput.classList.add('is-invalid');
        valid = false;
      } else {
        passwordInput.classList.add('is-valid');
      }

      // Adiciona classe was-validated para ativar estilos do Bootstrap
      form.classList.add('was-validated');

      if (!valid) {
        showAlert('Por favor, preencha corretamente todos os campos.', 'danger');
        return;
      }

      // Se válido, envia para o backend
      form.submit();
    });

    // Remove alertas ao digitar e limpa borda vermelha
    form.querySelectorAll('input').forEach(input => {
      input.addEventListener('input', () => {
        hideAlerts();
        input.classList.remove('is-invalid');
      });
    });
  }
});