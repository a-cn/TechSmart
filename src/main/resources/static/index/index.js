function enviarLogin() {
    const email = document.getElementById("login").value;
    if (!email) {
        alert("Informe o e-mail antes de recuperar a senha.");
        return;
    }

    window.location.href = "/usuario/buscar-pergunta-seguranca?login=" + encodeURIComponent(email);
}


document.addEventListener("DOMContentLoaded", () => {
    if (typeof mostrarModal !== "undefined" && mostrarModal) {
        const modal = document.getElementById("modal-verificacao");
        if (modal) {
            modal.style.display = "block";
            modal.classList.add("show");
        }
    }
});

