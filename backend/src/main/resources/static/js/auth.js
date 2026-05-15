document.addEventListener('DOMContentLoaded', () => {
    const user = JSON.parse(localStorage.getItem('user'));
    const authLink = document.getElementById('auth-link');
    
    if (user && authLink) {
        authLink.innerHTML = `
            <div style="display: flex; gap: 1rem; align-items: center;">
                <span style="font-size: 0.875rem; font-weight: 600;">Hi, ${user.email.split('@')[0]}</span>
                <button onclick="logout()" class="btn btn-outline" style="padding: 0.4rem 0.8rem;">Logout</button>
            </div>
        `;
    }
});

function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    window.location.href = 'index.html';
}
