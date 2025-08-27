const form = document.getElementById('userForm');
const cancelBtn = document.getElementById('cancelBtn');
const alertPlaceholder = document.getElementById('alertPlaceholder');

  function showAlert(message, type) {
    alertPlaceholder.innerHTML = `
      <div class="alert alert-${type} alert-dismissible fade show mt-3" role="alert">
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
    `;
  }

  cancelBtn.addEventListener('click', () => {
    form.reset();
    form.classList.remove('was-validated');
    alertPlaceholder.innerHTML = '';
  });

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    e.stopPropagation();
    form.classList.add('was-validated');

    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();

    if (form.checkValidity()) {
      showAlert(`Usuário "${name}" criado com sucesso!`, 'success');
      form.reset();
      form.classList.remove('was-validated');
    } else {
      showAlert('Por favor, preencha corretamente todos os campos.', 'danger');
    }
  });