# API Pedidos 📦

API Spring Boot para cadastro de pedidos com mensageria assincrona usando RabbitMQ.

## 📋 Descrição

Sistema backend desenvolvido em **Java 21** com **Spring Boot 4.0.6** para gerenciar o cadastro de pedidos. A aplicação implementa arquitetura baseada em microsserviços com integração de fila de mensagens para processamento assincrono de pedidos.

## 🚀 Tecnologias

### Backend
- **Java 21** - Linguagem de programação
- **Spring Boot 4.0.6** - Framework web
- **Spring Data JPA** - Persistência de dados e ORM
- **Spring AMQP/RabbitMQ** - Mensageria assincrona
- **Spring Scheduling** - Agendamento de tarefas

### Banco de Dados
- **PostgreSQL 16** - Banco de dados relacional
- **PgAdmin 4** - Interface gráfica para administração do PostgreSQL

### Mensageria
- **RabbitMQ 3** - Message broker para processamento assincrono

### Ferramentas de Desenvolvimento
- **Lombok** - Redução de boilerplate de código
- **Maven** - Gerenciador de dependências e build
- **SpringDoc OpenAPI** - Documentação automática da API (Swagger/OpenAPI)
- **Spring DevTools** - Reload automático em desenvolvimento

### Testes
- **Spring Boot Test** - Framework de testes
- **Spring Rabbit Test** - Testes para RabbitMQ

## 📁 Estrutura do Projeto

```
src/main/java/br/com/cotiinformatica/api_pedidos/
├── ApiPedidosApplication.java      # Classe principal da aplicação
├── components/                      # Componentes reutilizaveis
├── configurations/                  # Configurações da aplicação
├── controllers/                     # Controladores REST
├── dtos/                           # Data Transfer Objects
├── entities/                       # Entidades JPA
├── repositories/                   # Interfaces de acesso aos dados
└── services/                       # Lógica de negócios
```

## 🏗️ Padrões de Arquitetura

### Camadas da Aplicação

1. **Controller Layer** - Recebe requisições HTTP e retorna respostas
2. **Service Layer** - Implementa a lógica de negócios
3. **Repository Layer** - Acesso aos dados com Spring Data JPA
4. **Entity Layer** - Mapeamento objeto-relacional das tabelas
5. **DTO Layer** - Transferência de dados entre camadas

### Integração com RabbitMQ

- **Async Processing** - Processamento assíncrono de pedidos via fila de mensagens
- **Message Queue** - Desacoplamento entre produtor e consumidor
- **Scheduling** - Processamento agendado de tarefas

## 🛠️ Configuração e Setup

### Pré-requisitos

- Java 21 ou superior
- Maven 3.8+
- Docker e Docker Compose (para infraestrutura)

### Variáveis de Ambiente

Configure as seguintes variáveis no arquivo `application.properties` ou `application.yml`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5435/bd-api-pedidos
spring.datasource.username=coti
spring.datasource.password=coti
spring.jpa.hibernate.ddl-auto=update

# RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=coti
spring.rabbitmq.password=coti
```

## 🐳 Docker Compose

Inicie os serviços de infraestrutura:

```bash
docker-compose up -d
```

Isso iniciará:
- **PostgreSQL 16** na porta 5435
- **PgAdmin 4** na porta 5051 (admin/Coti@2026)
- **RabbitMQ 3** nas portas 5672 (AMQP) e 15672 (Management)

### Acessar Serviços

- **API**: http://localhost:8080
- **Swagger/OpenAPI**: http://localhost:8080/swagger-ui.html
- **PgAdmin**: http://localhost:5051
- **RabbitMQ Management**: http://localhost:15672 (coti/coti)

## 📝 Rodando a Aplicação

### Desenvolvimento

```bash
# Com Maven wrapper
./mvnw spring-boot:run

# Ou com Maven instalado
mvn spring-boot:run
```

### Build

```bash
./mvnw clean package
```

### Executar JAR

```bash
java -jar target/api-pedidos-0.0.1-SNAPSHOT.jar
```

## 📚 Documentação da API

A documentação da API é gerada automaticamente pelo **SpringDoc OpenAPI** e está disponível em:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|---|---|---|
| Spring Boot Starter Web | 4.0.6 | Framework web REST |
| Spring Data JPA | 4.0.6 | Persistência com ORM |
| Spring AMQP | 4.0.6 | Integração com RabbitMQ |
| PostgreSQL Driver | 42.7.11 | Driver do banco de dados |
| Lombok | Latest | Redução de boilerplate |
| SpringDoc OpenAPI | 3.0.2 | Documentação automática |

## 🔐 Segurança

- Proteção contra injeção SQL via JPA
- Validação de DTOs
- Tratamento de exceções centralizado
- Autenticação e autorização (a implementar conforme necessário)

## 📋 Versionamento

- **Versão Atual**: 0.0.1-SNAPSHOT
- **Java Version**: 21

## 📞 Suporte

Para dúvidas ou problemas, abra uma issue no repositório.

## 📄 Licença

Este projeto está sob licença não especificada. Consulte o arquivo LICENSE para detalhes.

---

**Desenvolvido por**: Coti Informatica
