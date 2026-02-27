<p align="center"> <img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java" /> <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat&logo=spring-boot&logoColor=white" alt="Spring Boot" /> <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat&logo=mysql&logoColor=white" alt="MySQL" /> <img src="https://img.shields.io/badge/RabbitMQ-Messaging-FF6600?style=flat&logo=rabbitmq&logoColor=white" alt="RabbitMQ" /> <img src="https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=flat&logo=swagger&logoColor=black" alt="Swagger" /> <img src="https://img.shields.io/badge/Docker-Compose-2496ED?style=flat&logo=docker&logoColor=white" alt="Docker" /> <img src="https://img.shields.io/badge/Prometheus-Metrics-E6522C?style=flat&logo=prometheus&logoColor=white" alt="Prometheus" /> <img src="https://img.shields.io/badge/Grafana-Dashboards-F46800?style=flat&logo=grafana&logoColor=white" alt="Grafana" /> </p> 

# CondoManager: Microservices Architecture

Um sistema distribuído para gestão de condomínios, projetado com arquitetura de microsserviços. O ecossistema permite o gerenciamento de áreas comuns, controle de moradores e funcionários, e um fluxo assíncrono para solicitação de manutenções.

Projeto acadêmico desenvolvido na disciplina de Engenharia de Software II no curso de Ciência da Computação da UNESP Rio Claro, com foco na aplicação prática de padrões de microsserviços, mensageria e observabilidade.

---

## 🏗️ Arquitetura do Sistema

O projeto é um *monorepo* composto por três microsserviços independentes, cada um com seu próprio banco de dados e responsabilidades bem definidas:

### 1. MSCondominium (Porta `8083`)
Microsserviço base responsável pelo gerenciamento físico do condomínio (Unidades e Áreas). 
* **Padrões:** Domain-Driven Design (DDD) na estruturação de DTOs polimórficos.


### 2. MSResident (Porta `8081`)
Gerencia o cadastro de moradores e é a porta de entrada para solicitações de manutenção. 
* **Observabilidade:** Expõe métricas de uso e saúde da aplicação via **Prometheus** e dashboards no **Grafana**.
* **Mensageria (Producer):** Ao registrar uma solicitação de manutenção em uma área comum, atua como *Producer*, publicando o evento em uma fila.

### 3. MSEmployee (Porta `8082`)
Gerencia os funcionários do condomínio e orquestra as ordens de serviço.
* **Mensageria (Consumer):** Escuta ativamente a fila do **RabbitMQ**. Assim que o `MSResident` emite uma solicitação de manutenção, este serviço consome a mensagem e notifica os funcionários responsáveis, garantindo baixo acoplamento entre os domínios.

---

## 🔄 Fluxo de Mensageria (RabbitMQ)

A funcionalidade central de comunicação assíncrona ocorre no fluxo de Manutenção:

1. O morador (`MSResident`) faz uma requisição HTTP POST solicitando reparo em uma área comum (ex: "Rede Elétrica").
2. O `MSResident` publica uma mensagem de evento na fila configurada no RabbitMQ.
3. O `MSEmployee`, rodando em background como *Consumer*, intercepta a mensagem.
4. O `MSEmployee` processa os dados e despacha a notificação/ordem de serviço internamente, sem travar a requisição original do morador.

---

## 🚀 Como Executar o Projeto Localmente

Devido à natureza isolada dos microsserviços durante o desenvolvimento, cada serviço possui seu próprio ambiente conteinerizado.

### Pré-requisitos
* Java 17+
* Docker e Docker Compose
* Maven

### Passo a Passo

**1. Subir a Infraestrutura do MSEmployee (RabbitMQ + MySQL)**
Abra o terminal na pasta do `MSEmployee` e inicie os containers:
```bash
cd MSEmployee
docker-compose up -d
```

_Inicie a aplicação Spring Boot do MSEmployee na sua IDE (rodará na porta 8082)._

**2. Subir a Infraestrutura do MSResident (Prometheus + Grafana + MySQL)** Abra um novo terminal na pasta do `MSResident` e inicie os containers:

```bash
cd MSResident
docker-compose up -d
```

_Inicie a aplicação Spring Boot do MSResident na sua IDE (rodará na porta 8081)._

**3. Executar o MSCondominium** Para gerenciar as áreas físicas, acesse a pasta do serviço, suba o banco de dados e rode a aplicação:

```bash
cd MSCondominium
docker-compose up -d
```

_Inicie a aplicação Spring Boot do MSCondominium na sua IDE (rodará na porta 8083)._

## 📚 Documentação das APIs (Swagger)

Todos os microsserviços possuem a interface do Swagger UI habilitada para testes simplificados dos endpoints REST. Com as aplicações rodando, acesse no navegador:

-   **MSCondominium:** `http://localhost:8083/swagger-ui.html`
    
-   **MSResident:** `http://localhost:8081/swagger-ui.html`
    
-   **MSEmployee:** `http://localhost:8082/swagger-ui.html`

## 📊 Diagramas de Domínio (UML)

### UML MSCondominium

![MSCondominium](https://imgur.com/Tfbq5V0.jpg, "UML MSCondominium")

### UML MSEmployee

![MSEmployee](https://imgur.com/a59mZ36.jpg, "UML MSEmployee")

### UML MSResident

![MSResident](https://imgur.com/wDUFNHd.jpg, "UML MSResident")
