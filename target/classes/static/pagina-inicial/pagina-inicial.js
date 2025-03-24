document.querySelectorAll('.grid-item').forEach(item => {
    item.addEventListener('click', () => {
        alert(`Você clicou em: ${item.textContent}`);
    });
});