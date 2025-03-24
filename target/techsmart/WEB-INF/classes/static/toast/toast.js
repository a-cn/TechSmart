function showToast(message, type) {
    const container = document.getElementById("toast-container");
    const toast = document.createElement("div");
    toast.classList.add("toast");

    switch(type) {
        case "success":
            toast.classList.add("toast-success");
            break;
        case "error":
            toast.classList.add("toast-error");
            break;
        case "warning":
            toast.classList.add("toast-warning");
            break;
        default:
            toast.classList.add("toast-success");
    }

    toast.textContent = message;
    container.appendChild(toast);

    setTimeout(() => {
        toast.remove();
    }, 10000);
}
