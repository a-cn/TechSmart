-- Criação de banco de dados e tabelas TechSmart (pode rodar tudo de uma vez só).
-- Autora: Amanda Caetano Nasser
-- Data: 12/03/2025
-- Última alteração em: 21/03/2025

CREATE DATABASE TechSmartDB; -- Cria um banco de dados chamado "TechSmartDB" para garantir a padronização em todas as máquinas
GO

USE TechSmartDB

-- ================================================================================
-- 1) Tabela: Tipo_Usuario
-- Armazena as categorias de usuários do sistema.
-- ================================================================================
CREATE TABLE Tipo_Usuario (
	tipo_usuario_id	INT			NOT NULL	IDENTITY(1,1),
	descricao		VARCHAR(15)	NOT NULL,
	CONSTRAINT PK_Tipo_Usuario	-- Define a chave primária
		PRIMARY KEY CLUSTERED (tipo_usuario_id ASC)
);
GO

INSERT INTO Tipo_Usuario VALUES
	('Administrador'),
	('Colaborador'),
	('Cliente');
GO

-- ================================================================================
-- 2) Tabela: Endereco
-- Armazena os endereços de usuários e fornecedores cadastrados no sistema.
-- ================================================================================
CREATE TABLE Endereco (
	endereco_id	INT				NOT NULL	IDENTITY(1,1),
	cep			VARCHAR(8)		NOT NULL,
	logradouro	VARCHAR(150)	NOT NULL,
	numero		INT				NOT NULL,
	complemento	VARCHAR(100),
	bairro		VARCHAR(50)		NOT NULL,
	cidade		VARCHAR(50)		NOT NULL,
	estado		VARCHAR(50)		NOT NULL,
	CONSTRAINT PK_Endereco
		PRIMARY KEY CLUSTERED (endereco_id ASC)
);
GO

-- ================================================================================
-- 3) Tabela: Pergunta_Seguranca
-- Armazena as perguntas de segurança para a redefinição de senha.
-- ================================================================================
CREATE TABLE Pergunta_Seguranca (
	pergunta_seguranca_id	INT				NOT NULL	IDENTITY(1,1),
	pergunta				VARCHAR(200)	NOT NULL,
	CONSTRAINT PK_Pergunta_Seguranca
		PRIMARY KEY CLUSTERED (pergunta_seguranca_id ASC)
);
GO

INSERT INTO Pergunta_Seguranca VALUES
	('Qual é a sua comida favorita?'),
	('Qual foi o primeiro local para onde você viajou?'),
	('Qual é a sua cor favorita?'),
	('Qual foi o modelo do seu primeiro celular?'),
	('Qual o nome do seu primeiro animal de estimação?');
GO

-- ================================================================================
-- 4) Tabela: Usuario
-- Armazena os dados de usuários cadastrados no sistema.
-- ================================================================================
CREATE TABLE Usuario (
	usuario_id				INT				NOT NULL	IDENTITY(1,1),
	fk_tipo_usuario			INT				NOT NULL,
	nome					VARCHAR(100)	NOT NULL,
	cpf_cnpj				VARCHAR(14)		NOT NULL,
	data_nascimento			DATE			NOT NULL,
	email					VARCHAR(50)		NOT NULL,
	num_principal			VARCHAR(15)		NOT NULL,
	num_recado				VARCHAR(15),
	fk_endereco				INT				NOT NULL,
	senha					VARCHAR(100)	NOT NULL,
	fk_pergunta_seguranca	INT				NOT NULL,
	resposta_seguranca		VARCHAR(100)	NOT NULL,
	CONSTRAINT PK_Usuario
		PRIMARY KEY CLUSTERED (usuario_id ASC),
	CONSTRAINT FK_Usuario_Tipo_Usuario	-- Define a chave estrangeira e sua referência
		FOREIGN KEY (fk_tipo_usuario) REFERENCES Tipo_Usuario (tipo_usuario_id)
		ON DELETE NO ACTION		-- Não permite excluir se houver registros dependentes
		ON UPDATE NO ACTION,	-- Não propaga atualização de chaves
	CONSTRAINT FK_Usuario_Endereco
		FOREIGN KEY (fk_endereco) REFERENCES Endereco (endereco_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_Usuario_Pergunta_Seguranca
		FOREIGN KEY (fk_pergunta_seguranca) REFERENCES Pergunta_Seguranca (pergunta_seguranca_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 5) Tabela: Fornecedor
-- Armazena os dados de fornecedores registrados no sistema.
-- ================================================================================
CREATE TABLE Fornecedor (
	fornecedor_id	INT				NOT NULL	IDENTITY(1,1),
	nome			VARCHAR(100)	NOT NULL,
	cpf_cnpj		VARCHAR(14)		NOT NULL,
	num_principal	VARCHAR(15)		NOT NULL,
	num_secundario	VARCHAR(15),
	email			VARCHAR(50)		NOT NULL,
	fk_endereco		INT				NOT NULL,
	situacao		VARCHAR(15)		NOT NULL,
	CONSTRAINT PK_Fornecedor
		PRIMARY KEY CLUSTERED (fornecedor_id ASC),
	CONSTRAINT FK_Fornecedor_Endereco
		FOREIGN KEY (fk_endereco) REFERENCES Endereco (endereco_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 6) Tabela: Componente
-- Armazena os dados de componentes registrados no sistema.
-- ================================================================================
CREATE TABLE Componente (
	componente_id	INT				NOT NULL	IDENTITY(1,1),
	nome			VARCHAR(50)		NOT NULL,
	especificacao	VARCHAR(100),
	quantidade		INT				NOT NULL,
	nivel_minimo	INT				NOT NULL,
	nivel_maximo	INT				NOT NULL,
	CONSTRAINT PK_Componente
		PRIMARY KEY CLUSTERED (componente_id ASC)
);
GO

-- ================================================================================
-- 7) Tabela: Producao
-- Armazena as linhas de produção registradas.
-- ================================================================================
CREATE TABLE Producao (
	producao_id	INT			NOT NULL	IDENTITY(1,1),
	nome		VARCHAR(50)	NOT NULL,
	CONSTRAINT PK_Producao
		PRIMARY KEY CLUSTERED (producao_id ASC)
);
GO

-- ================================================================================
-- 8) Tabela: Etapa_Producao
-- Armazena os dados das etapas de produção cadastradas.
-- ================================================================================
CREATE TABLE Etapa_Producao (
	etapa_producao_id	INT			NOT NULL	IDENTITY(1,1),
	fk_producao			INT			NOT NULL,
	ordem				INT			NOT NULL,
	nome				VARCHAR(50)	NOT NULL,
	fk_componente		INT			NOT NULL,
	CONSTRAINT PK_Etapa_Producao
		PRIMARY KEY CLUSTERED (etapa_producao_id ASC),
	CONSTRAINT FK_Etapa_Producao_Producao
		FOREIGN KEY (fk_producao) REFERENCES Producao (producao_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_Etapa_Producao_Componente
		FOREIGN KEY (fk_componente) REFERENCES Componente (componente_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 9) Tabela: ProdutoFinal
-- Armazena os dados de produtos finais montados pela empresa.
-- ================================================================================
CREATE TABLE ProdutoFinal (
	produtofinal_id	INT				NOT NULL	IDENTITY(1,1),
	fk_producao		INT				NOT NULL,
	nome			VARCHAR(50)		NOT NULL,
	descricao		VARCHAR(100),
	valor_venda		FLOAT			NOT NULL,
	quantidade		INT				NOT NULL,
	nivel_minimo	INT				NOT NULL,
	nivel_maximo	INT				NOT NULL,
	CONSTRAINT PK_ProdutoFinal
		PRIMARY KEY CLUSTERED (produtofinal_id ASC),
	CONSTRAINT FK_ProdutoFinal_Producao
		FOREIGN KEY (fk_producao) REFERENCES Producao (producao_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 10) Tabela: Pedido
-- Armazena os dados de pedidos solicitados por clientes da TechSmart.
-- ================================================================================
CREATE TABLE Pedido (
	pedido_id	INT			NOT NULL	IDENTITY(1,1),
	data_hora	DATETIME	NOT NULL,
	fk_usuario	INT			NOT NULL,
	valor_total	FLOAT		NOT NULL,
	situacao	VARCHAR(50),
	CONSTRAINT PK_Pedido
		PRIMARY KEY CLUSTERED (pedido_id ASC),
	CONSTRAINT FK_Pedido_Usuario
		FOREIGN KEY (fk_usuario) REFERENCES Usuario (usuario_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 11) Tabela: Pedido_ProdutoFinal
-- Indica a quantidade de cada produto final selecionado nos pedidos de clientes.
-- ================================================================================
CREATE TABLE Pedido_ProdutoFinal (
	pedido_produtofinal_id	INT NOT NULL IDENTITY(1,1),
	fk_pedido				INT NOT NULL,
	fk_produtofinal			INT NOT NULL,
	quantidade_item			INT	NOT NULL,
	CONSTRAINT PK_Pedido_ProdutoFinal
		PRIMARY KEY CLUSTERED (pedido_produtofinal_id ASC),
	CONSTRAINT FK_Pedido_ProdutoFinal_Pedido
		FOREIGN KEY (fk_pedido) REFERENCES Pedido (pedido_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_Pedido_ProdutoFinal_ProdutoFinal
		FOREIGN KEY (fk_produtofinal) REFERENCES ProdutoFinal (produtofinal_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 12) Tabela: Feedback
-- Armazena as avaliações deixadas por clientes sobre seus pedidos.
-- ================================================================================
CREATE TABLE Feedback (
	feedback_id	INT				NOT NULL	IDENTITY(1,1),
	data_hora	DATETIME		NOT NULL,
	fk_pedido	INT				NOT NULL,
	avaliacao	INT				NOT NULL,
	observacao	VARCHAR(100),
	CONSTRAINT PK_Feedback
		PRIMARY KEY CLUSTERED (feedback_id ASC),
	CONSTRAINT FK_Feedback_Pedido
		FOREIGN KEY (fk_pedido) REFERENCES Pedido (pedido_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 13) Tabela: Movimentacao
-- Armazena as movimentações de estoque, isto é, se o produto terminou de ser montado pela empresa ou se foi comprado por um cliente (entrou ou saiu).
-- ================================================================================
CREATE TABLE Movimentacao (
	movimentacao_id		INT			NOT NULL	IDENTITY(1,1),
	data_hora			DATETIME	NOT NULL,
	tipo_movimentacao	VARCHAR(50)	NOT NULL,
	fk_pedido			INT,
	fk_produtofinal		INT			NOT NULL,
	quantidade			INT			NOT NULL,
	CONSTRAINT PK_Movimentacao
		PRIMARY KEY CLUSTERED (movimentacao_id ASC),
	CONSTRAINT FK_Movimentacao_Pedido
		FOREIGN KEY (fk_pedido) REFERENCES Pedido (pedido_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_Movimentacao_ProdutoFinal
		FOREIGN KEY (fk_produtofinal) REFERENCES ProdutoFinal (produtofinal_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO

-- ================================================================================
-- 14) Tabela: Fornecedor_Componente
-- Indica quais fornecedores estão associados a quais componentes.
-- ================================================================================
CREATE TABLE Fornecedor_Componente (
	fornecedor_componente_id	INT	NOT NULL	IDENTITY(1,1),
	fk_fornecedor				INT	NOT NULL,
	fk_componente				INT NOT NULL,
	custo_componente			FLOAT,
	CONSTRAINT PK_Fornecedor_Componente
		PRIMARY KEY CLUSTERED (fornecedor_componente_id ASC),
	CONSTRAINT FK_Fornecedor_Componente_Fornecedor
		FOREIGN KEY (fk_fornecedor) REFERENCES Fornecedor (fornecedor_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_Fornecedor_Componente_Componente
		FOREIGN KEY (fk_componente) REFERENCES Componente (componente_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
GO