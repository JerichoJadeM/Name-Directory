// Form validation
function validateForm() {
    let isValid = true;
    clearErrors();

    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value.trim();

    // Validate username
    if (!username) {
        showError('usernameError', 'Username or email is required');
        isValid = false;
    } else if (username.length < 3) {
        showError('usernameError', 'Username or email must be at least 3 characters');
        isValid = false;
    }

    // Validate password
    if (!password) {
        showError('passwordError', 'Password is required');
        isValid = false;
    } else if (password.length < 6) {
        showError('passwordError', 'Password must be at least 6 characters');
        isValid = false;
    }

    return isValid;
}

function showError(elementId, message) {
    const errorElement = document.getElementById(elementId);
    if (errorElement) {
        errorElement.textContent = message;
        errorElement.classList.add('show');
        errorElement.parentElement.classList.add('has-error');
    }
}

function clearErrors() {
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach(error => {
        error.classList.remove('show');
        error.textContent = '';
    });

    const formGroups = document.querySelectorAll('.form-group');
    formGroups.forEach(group => {
        group.classList.remove('has-error');
    });
}

// Show alert message if passed from controller
function showAlert(message, type) {
    const alertElement = type === 'success' ? document.getElementById('successAlert') : 
                       type === 'error' ? document.getElementById('errorAlert') :
                       document.getElementById('warningAlert');
    if (message && alertElement) {
        alertElement.textContent = message;
        alertElement.classList.add('show');
        setTimeout(() => {
            alertElement.classList.remove('show');
        }, 5000);
    }
}

// Initialize on page load
document.addEventListener('DOMContentLoaded', function() {
    // Get URL parameters
    const params = new URLSearchParams(window.location.search);
    const message = params.get('message');
    const type = params.get('type') || 'success';

    if (message) {
        showAlert(message, type);
    }

    // Clear errors on input
    document.querySelectorAll('input').forEach(field => {
        field.addEventListener('focus', () => {
            const formGroup = field.closest('.form-group');
            if (formGroup) {
                formGroup.classList.remove('has-error');
            }
        });
    });
});
