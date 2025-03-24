function toggleFields() {
    const tipoPessoa = document.querySelector('input[name="tipo_pessoa"]:checked').value;
    const cpfFields = document.getElementById("cpf-fields");
    const cnpjFields = document.getElementById("cnpj-fields");

    if (tipoPessoa === "cpf") {
        cpfFields.style.display = "block";
        cnpjFields.style.display = "none";
    } else if (tipoPessoa === "cnpj") {
        cnpjFields.style.display = "block";
        cpfFields.style.display = "none";
    }
}


// Restringir entrada a apenas números para CPF e Razão Social
document.getElementById("cpf").addEventListener("input", function (e) {
	e.target.value = e.target.value.replace(/\D/g, ""); // Remove caracteres não numéricos
});

document.getElementById("razao_social").addEventListener("input", function (e) {
	e.target.value = e.target.value.replace(/\D/g, ""); // Remove caracteres não numéricos
});


function validateForm() {
    const email = document.getElementById("email").value;
    const confirmEmail = document.getElementById("confirmEmail").value;
    const password = document.getElementById("senha").value;
    const confirmPassword = document.getElementById("confirmSenha").value;
    const errorMsg = document.getElementById("error-message");

    // Verifica se os emails são idênticos
    if (email !== confirmEmail) {
        errorMsg.textContent = "Os emails não coincidem.";
        return false;
    }

    // Verifica se as senhas são idênticas
    if (password !== confirmPassword) {
        errorMsg.textContent = "As senhas não coincidem.";
        return false;
    }

    // Verifica os critérios de complexidade da senha
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{9,}$/;
    if (!passwordRegex.test(password)) {
        errorMsg.textContent = "A senha deve ter no mínimo 9 caracteres, incluindo uma letra maiúscula, uma letra minúscula e um caractere especial.";
         return false;

	}
	errorMsg.textContent = "";
	return true;
}