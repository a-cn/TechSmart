let produtos = [];
let idProduto = 1;

document.getElementById('btnCadastrar').onclick = function() {
    const modelo = document.getElementById('modelo').value;
    const quantidade = document.getElementById('quantidade').value;
    const tipo = document.getElementById('tipo').value;
    const descricao = document.getElementById('descricao').value;
    const valor = document.getElementById('valor').value;

    const produto = {
        id: idProduto++,
        modelo,
        quantidade,
        tipo,
        descricao,
        valor,
        situacao: 'Em Estoque',
    };

    produtos.push(produto);
    atualizarTabela();
    limparFormulario();
};

function atualizarTabela() {
    const tbody = document.getElementById('produtosTable').getElementsByTagName('tbody')[0];
    tbody.innerHTML = ''; // Limpa a tabela antes de atualizar

    produtos.forEach(prod => {
        const tr = tbody.insertRow();
        tr.innerHTML = `
            <td>${prod.id}</td>
            <td>${prod.modelo}</td>
            <td>${prod.quantidade}</td>
            <td>${prod.situacao}</td>
            <td>${prod.tipo}</td>
            <td class="actions">
                <button onclick="editarProduto(${prod.id})">Editar</button>
                <button onclick="deletarProduto(${prod.id})">Excluir</button>
            </td>
        `;
    });
}

function editarProduto(id) {
    const produto = produtos.find(prod => prod.id === id);
    if (produto) {
        document.getElementById('modelo').value = produto.modelo;
        document.getElementById('quantidade').value = produto.quantidade;
        document.getElementById('tipo').value = produto.tipo;
        document.getElementById('descricao').value = produto.descricao;
        document.getElementById('valor').value = produto.valor;

        // Remover produto da lista para evitar duplicação
        produtos = produtos.filter(prod => prod.id !== id);
        atualizarTabela();
    }
}

function deletarProduto(id) {
    produtos = produtos.filter(prod => prod.id !== id);
    atualizarTabela();
}

function limparFormulario() {
    document.getElementById('modelo').value = '';
    document.getElementById('quantidade').value = '';
    document.getElementById('tipo').value = '';
    document.getElementById('descricao').value = '';
    document.getElementById('valor').value = '';
}