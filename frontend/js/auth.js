document.addEventListener('DOMContentLoaded', () => {
    const nav = document.getElementById('auth-link');
    if (!nav) return;

    const userStr = localStorage.getItem('user');
    let user = null;
    try {
        user = userStr ? JSON.parse(userStr) : null;
    } catch (e) {
        console.error('Auth check failed');
    }

    const isAdminUser = user && user.role === 'ROLE_ADMIN';
    if (isAdminUser) document.body.classList.add('is-admin');

    // Standard Links for everyone
    let html = `<li><a href="home.html">Home</a></li>`;
    html += `<li><a href="destinations.html">Destinations</a></li>`;
    html += `<li><a href="hotels.html">Hotels</a></li>`;
    html += `<li><a href="activities.html">Activities</a></li>`;

    if (user) {
        // Logged in links
        if (isAdminUser) {
            html += `<li><a href="management.html">Bookings Hub</a></li>`;
            html += `<li><a href="view-users.html">View Users</a></li>`;
            html += `<li><a href="payment-details.html">Payment Details</a></li>`;
        } else {

            html += `<li><a href="package-builder.html">Plan Trip</a></li>`;
            html += `<li><a href="my-bookings.html">My Bookings</a></li>`;
        }
        html += `<li style="display: flex; align-items: center; gap: 0.5rem;">
                    <div style="width: 32px; height: 32px; border-radius: 50%; overflow: hidden; background: var(--primary-light); display: flex; align-items: center; justify-content: center; border: 2px solid white; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
                        ${user.profilePicture ? `<img src="${user.profilePicture}" style="width: 100%; height: 100%; object-fit: cover;">` : `<span style="font-size: 0.75rem; font-weight: 700; color: var(--primary);">${user.name.charAt(0).toUpperCase()}</span>`}
                    </div>
                    <a href="profile.html">My Profile</a>
                 </li>`;
        html += `<li><a href="#" onclick="logout()">Logout</a></li>`;
    } else {
        // Not logged in
        html += `<li><a href="login.html" class="btn btn-outline" style="padding: 0.4rem 1rem; margin-left: 1rem; display: inline-block;">Login</a></li>`;
        html += `<li><a href="signup.html" class="btn btn-primary" style="padding: 0.4rem 1rem; color: white; display: inline-block;">Sign Up</a></li>`;
    }

    nav.innerHTML = html;
});

function isAdmin() {
    const userStr = localStorage.getItem('user');
    if (!userStr) return false;
    try {
        const user = JSON.parse(userStr);
        return user && user.role === 'ROLE_ADMIN';
    } catch (e) {
        return false;
    }
}

function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    window.location.href = 'index.html';
}
