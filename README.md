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
```
src/
└── main/
    ├── java/
    │   └── com/example/apiclaro/
    │       ├── domain/              # Modelos da aplicação (entidades e DTOs)
    │       │   ├── dto/
    │       │   │   ├── TaskDetails.java
    │       │   │   └── TaskOutput.java
    │       │   └── Task.java
    │       ├── exceptions/          # Exceções personalizadas
    │       │   └── TaskNotFoundException.java
    │       ├── infrastructure/      # Camada de serviço (lógica de negócio)
    │       │   └── TaskService.java
    │       ├── repository/          # Interfaces JPA (acesso a dados)
    │       │   └── TaskRepository.java
    │       ├── web/                 # Camada de controle (REST Controllers)
    │       │   └── TaskController.java
    │       └── Application.java     # Classe principal da aplicação
    └── resources/
        └── application.yml          # Arquivo de configuração do Spring Boot

```
---

## 💻 Como executar localmente

1. **Clone o repositório:**

```bash
https://github.com/LucasSSV-Dev/gerenciador-de-tarefas.git
```
Configure o application.yml
```
spring:
  application:
    name: apiclaro

  datasource:
    url: jdbc:postgresql://localhost:5433/task
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

Execute o projeto com sua IDE (ex: IntelliJ IDEA)
Certifique-se de que o PostgreSQL está rodando localmente com o banco criado.

---

### ✨ O que fazer a seguir:

- Criar uma **versão com Swagger** para documentar os endpoints. (Em aprendizado)
- Adicionar **validações** com `@Valid`. (Em aprendizado)
- Escrever **testes unitários e de integração** com JUnit e Mockito. (Em aprendizado)
