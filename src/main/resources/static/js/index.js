// Boton para activar Dark Mode en el Login
document.addEventListener("DOMContentLoaded", () => {
    const toggle = document.getElementById("darkModeToggle");

    // Load from localStorage
    if(localStorage.getItem("darkMode") === "enabled") {
        document.body.classList.add("dark-mode")
        toggle.checked = true;
    }

    toggle.addEventListener("change", () => {
        if(toggle.checked) {
            document.body.classList.add("dark-mode")
            localStorage.setItem("dark-mode", "enabled")
        } else {
            document.body.classList.remove("dark-mode")
            localStorage.setItem("dark-mode", "disabled")
        }
    })
})