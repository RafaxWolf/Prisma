// Boton para activar Dark Mode en el Login
/*document.addEventListener("DOMContentLoaded", () => {
    const toggle = document.getElementById("darkModeToggle");
    document.cookie = "darkmode=false";
    var isDark = document.cookie;
    // Load from localStorage
    if(localStorage.getItem("darkMode") === "enabled") {
        document.body.classList.add("dark-mode")
        toggle.checked = true;
    }

    toggle.addEventListener("change", () => {
        if(toggle.checked) {
        isDark=true
        if (isDark){
            document.body.classList.add("dark-mode")
            localStorage.setItem("dark-mode", "enabled")}
        } else {
        if(!isDark){
            document.body.classList.remove("dark-mode")
            localStorage.setItem("dark-mode", "disabled")
            }
        }
    })
})*/


document.addEventListener("DOMContentLoaded", () => {
    const toggle = document.getElementById("darkModeToggle");

    // Función para obtener cookie
    function getCookie(name) {
        const cookies = document.cookie.split("; ");
        for (let c of cookies) {
            const [key, value] = c.split("=");
            if (key === name) return value;
        }
        return null;
    }

    // Función para setear cookie
    function setCookie(name, value, days) {
        const d = new Date();
        d.setTime(d.getTime() + (days*24*60*60*1000));
        const expires = "expires=" + d.toUTCString();
        document.cookie = `${name}=${value}; ${expires}; path=/`;
    }

    // Leer cookie al cargar
    const isDark = getCookie("darkmode");

    if (isDark === "true") {
        document.body.classList.add("dark-mode");
        toggle.checked = true;
    } else {
        document.body.classList.remove("dark-mode");
        toggle.checked = false;
    }

    // Evento del toggle
    toggle.addEventListener("change", () => {
        if (toggle.checked) {
            document.body.classList.add("dark-mode");
            setCookie("darkmode", "true", 30); // guarda por 30 días
        } else {
            document.body.classList.remove("dark-mode");
            setCookie("darkmode", "false", 30);
        }
    });
});