// Show alert message if passed from controller
function showAlert(message, type) {
    const alertElement = type === 'success' ? document.getElementById('successAlert') : document.getElementById('errorAlert');
    if (message) {
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
});
