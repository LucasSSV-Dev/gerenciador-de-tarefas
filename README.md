# API de Gerenciamento de Tarefas - Claro 📋

API RESTful desenvolvida em Java 21 com Spring Boot para gerenciar tarefas com persistência em banco de dados PostgreSQL.  
Projeto criado com foco em boas práticas, arquitetura em camadas e aprendizado técnico.

---

## ✅ Funcionalidades disponíveis

- Criar nova tarefa
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar uma tarefa existente
- Marcar tarefa como completa/incompleta (PATCH)
- Deletar uma tarefa por ID
- Deletar **todas** as tarefas

---

## 🚀 Tecnologias utilizadas

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- IntelliJ IDEA  
- Maven

---

## 🧠 Arquitetura do projeto

Organizado em camadas conforme boas práticas:

src/
└── main/
├── java/
│ └── com.example.apiclaro/
│ ├── domain/ # Modelos da aplicação
│ ├── infrastructure/ # Lógica de negócio (Service)
│ ├── repository/ # Interface com banco de dados (JPA)
│ └── web/ # Camada de controle (REST Controller)
└── resources/
└── application.yml # Configurações do Spring Boot

---

## 💻 Como executar localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/seuusuario/apiclaro3.git
```
Configure o application.yml
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nome_do_banco
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

Execute o projeto com sua IDE (ex: IntelliJ IDEA)
Certifique-se de que o PostgreSQL está rodando localmente com o banco criado.

---

### ✨ O que fazer a seguir:


- Usar **DTOs** (para entrada e saída de dados). (Praticamente pronto.)
- Criar uma **versão com Swagger** para documentar os endpoints.
- Adicionar **validações** com `@Valid`.
- Escrever **testes unitários e de integração** com JUnit e Mockito.


