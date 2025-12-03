/**
 * Consolidated Forms Module
 * Common form validation, error handling, and alert functionality
 * Used by: login, registration, person-form templates
 */

// ==================== VALIDATION UTILITIES ====================

/**
 * Generic form validation function
 * Validates form fields based on their IDs and types
 * @returns {boolean} - Whether the form is valid
 */
function validateForm() {
    let isValid = true;
    clearErrors();

    // Validate all form groups
    document.querySelectorAll('.form-group').forEach(group => {
        const input = group.querySelector('input, textarea');
        if (input && !validateField(input)) {
            isValid = false;
        }
    });

    return isValid;
}

/**
 * Validate individual field based on ID and type
 * @param {HTMLElement} field - The input field to validate
 * @returns {boolean} - Whether the field is valid
 */
function validateField(field) {
    const fieldId = field.id;
    const value = field.value.trim();
    const type = field.type;

    // Username validation
    if (fieldId === 'username') {
        if (!value) {
            showError(fieldId + 'Error', 'Username or email is required');
            return false;
        } else if (value.length < 3) {
            showError(fieldId + 'Error', 'Username must be at least 3 characters');
            return false;
        }
        return true;
    }

    // Password validation
    if (fieldId === 'password') {
        if (!value) {
            showError(fieldId + 'Error', 'Password is required');
            return false;
        } else if (value.length < 6) {
            showError(fieldId + 'Error', 'Password must be at least 6 characters');
            return false;
        }
        return true;
    }

    // Confirm Password validation
    if (fieldId === 'confirmPassword') {
        const password = document.getElementById('password')?.value || '';
        if (!value) {
            showError(fieldId + 'Error', 'Please confirm your password');
            return false;
        } else if (value !== password) {
            showError(fieldId + 'Error', 'Passwords do not match');
            return false;
        }
        return true;
    }

    // First Name validation
    if (fieldId === 'firstName') {
        if (!value) {
            showError(fieldId + 'Error', 'First name is required');
            return false;
        } else if (value.length < 2) {
            showError(fieldId + 'Error', 'First name must be at least 2 characters');
            return false;
        }
        return true;
    }

    // Last Name validation
    if (fieldId === 'lastName') {
        if (!value) {
            showError(fieldId + 'Error', 'Last name is required');
            return false;
        } else if (value.length < 2) {
            showError(fieldId + 'Error', 'Last name must be at least 2 characters');
            return false;
        }
        return true;
    }

    // Email validation
    if (fieldId === 'email' || type === 'email') {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!value) {
            showError(fieldId + 'Error', 'Email is required');
            return false;
        } else if (!emailRegex.test(value)) {
            showError(fieldId + 'Error', 'Please enter a valid email address');
            return false;
        }
        return true;
    }

    // Generic required field validation
    if (field.hasAttribute('required') && !value) {
        showError(fieldId + 'Error', 'This field is required');
        return false;
    }

    return true;
}

/**
 * Display error message for a field
 * @param {string} elementId - ID of the error message element
 * @param {string} message - Error message to display
 */
function showError(elementId, message) {
    const errorElement = document.getElementById(elementId);
    if (errorElement) {
        errorElement.textContent = message;
        errorElement.classList.add('show');
        const formGroup = errorElement.parentElement;
        if (formGroup) {
            formGroup.classList.add('has-error');
        }
    }
}

/**
 * Clear all error messages from the form
 */
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

// ==================== ALERT UTILITIES ====================

/**
 * Display alert message
 * @param {string} message - Message to display
 * @param {string} type - Alert type: 'success', 'error', 'warning'
 */
function showAlert(message, type) {
    let alertElement;
    
    if (type === 'success') {
        alertElement = document.getElementById('successAlert');
    } else if (type === 'error') {
        alertElement = document.getElementById('errorAlert');
    } else {
        alertElement = document.getElementById('warningAlert');
    }

    if (message && alertElement) {
        alertElement.textContent = message;
        alertElement.classList.add('show');
        setTimeout(() => {
            alertElement.classList.remove('show');
        }, 5000);
    }
}

// ==================== INITIALIZATION ====================

/**
 * Initialize form functionality on page load
 */
document.addEventListener('DOMContentLoaded', function() {
    // Check for alert message in URL parameters
    const params = new URLSearchParams(window.location.search);
    const message = params.get('message');
    const type = params.get('type') || 'success';

    if (message) {
        showAlert(message, type);
    }

    // Attach focus listeners to clear errors on input
    document.querySelectorAll('input, textarea').forEach(field => {
        field.addEventListener('focus', function() {
            const formGroup = this.closest('.form-group');
            if (formGroup) {
                formGroup.classList.remove('has-error');
            }
        });

        // Optional: Real-time validation on blur
        field.addEventListener('blur', function() {
            if (this.value.trim() !== '') {
                validateField(this);
            }
        });
    });

    // Attach submit listener to form
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function(e) {
            if (!validateForm()) {
                e.preventDefault();
            }
        });
    }
});
