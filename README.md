mirian 44444teste # 💡 Projeto TechSmart - 

Bem-vindo ao repositório do **TechSmart**! Este projeto utiliza **Spring Boot** com Java 17 e segue uma arquitetura limpa, clara e escalável. Ideal para aplicações modernas e robustas. 🚀

---

## ✅ Pré-requisitos

Antes de rodar o projeto, garanta que os seguintes softwares estejam instalados:

| Ferramenta       | Finalidade                                                                  |
|------------------|-------------------------------------------------------------------------------|
| **Eclipse 2025** ou **Spring Tools Suite** | IDE para desenvolvimento em Java                    |
| **Maven**        | Gerenciamento de dependências e build do projeto                            |
| **Java 17**      | Linguagem principal do projeto                                               |
| **Lombok**       | Redução de boilerplate com anotações úteis                                  |
| **Git**          | Controle de versionamento                                                    |

> ℹ️ Caso não possua algum desses itens, acesse a pasta **`Instalação`** no Drive e siga os tutoriais de configuração.

```
https://drive.google.com/drive/u/1/folders/14EZh-sAtGhGTIauW_vkgX6EPjtaWKeG8
```

---

## 🧱 Estrutura do Projeto

```plaintext
Projeto TechSmart
│
├── src
│   └── main
│       ├── database                          # Scripts do banco de dados
│       │   ├── creation-scripts              # Scripts de criação de base de dados
│       │   │   ├── create-database-and-tables.sql
│       │   │   └── create-database-user.sql
│       │   ├── develop-scripts               # Scripts em desenvolvimento
│       │   │   └── [pasta por branch com arquivos .sql]
│       │   └── production-scripts            # Scripts testados e aprovados
│       │       └── [pasta por branch com arquivos .sql]
│       │
│       ├── java                              # Código-fonte principal
│       │   └── com.techsmart
│       │       ├── controller                # Controllers (ligam frontend e backend)
│       │       │   └── UsuarioController.java
│       │       ├── dto                       # Data Transfer Objects (DTOs)
│       │       │   └── UsuarioDTO.java
│       │       ├── model                     # Entidades Java (Usuario, Endereco, etc.)
│       │       │   ├── Usuario.java
│       │       │   └── Endereco.java
│       │       ├── repository                # Repositórios (acesso a dados)
│       │       │   └── UsuarioRepository.java
│       │       └── TechSmartApplication.java
│       │
│       └── resources                         # Recursos estáticos e templates
│           ├── static                        # CSS e JS
│           │   └── usuario
│           │       ├── usuario.css
│           │       └── usuario.js
│           ├── templates                     # Templates Thymeleaf
│           │   ├── fragments                 # Partes reutilizáveis (navbar, footer, etc.)
│           │   └── pages
│           │       └── usuario.html
│           ├── index.html                    # Página inicial da aplicação
│           └── application.properties        # Configurações da aplicação
│
└── pom.xml                                   # Dependências e build do Maven
```

---

## 🛠️ Comandos Maven Importantes

| Comando                         | Função                                                                 |
|---------------------------------|------------------------------------------------------------------------|
| `mvn clean install -U`         | Compila e instala o projeto                                           |
| `mvn dependency:resolve`       | Resolve e baixa todas as dependências do `pom.xml`                   |
| `mvn spring-boot:run`          | Executa a aplicação Spring Boot                                      |

> Dica: para rodar o projeto pela IDE, utilize a opção "Run as Spring Boot App".

---

## 🌐 URL de Acesso

A aplicação estará disponível em:

```
http://localhost:8080
```

---

Desenvolvido com 💻 por **TechSmart** — Inovando com tecnologia.
