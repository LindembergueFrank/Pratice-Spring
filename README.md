# Spring Boot Practice Lab

Repositório de estudos e projetos práticos com **Java e Spring Boot**, usado para exercitar desenvolvimento web, persistência de dados e organização de aplicações em módulos independentes.

## Objetivo

Consolidar fundamentos de backend com foco em aplicações Spring, mantendo exemplos separados para facilitar evolução, comparação de abordagens e experimentação técnica.

## Projetos

| Projeto | Objetivo |
| --- | --- |
| `ManagementGuests` | Aplicação web para prática de Spring MVC, persistência com JPA e renderização server-side com Thymeleaf |
| `spring-example` | Projeto experimental para exercícios com Spring Boot |
| `spring-example2` | Segundo projeto experimental para evolução dos estudos com Spring Boot |

## ManagementGuests

O módulo `ManagementGuests` utiliza uma stack moderna de desenvolvimento Java:

- **Java 21**
- **Spring Boot 3.4.0**
- **Spring Web / MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database**
- **Maven Wrapper**
- **Lombok**
- **JUnit / Spring Boot Test**

### Organização esperada

A aplicação segue a separação de responsabilidades típica de projetos Spring:

```text
Controller  -> recebe requisições e coordena o fluxo HTTP
Service     -> concentra regras de negócio
Repository  -> abstrai persistência de dados
Entity      -> representa o modelo persistido
Template    -> camada de apresentação com Thymeleaf
```

Essa divisão reduz acoplamento e facilita testes, manutenção e evolução da aplicação.

## Executando um módulo

Cada projeto deve ser executado a partir de seu próprio diretório. Exemplo com `ManagementGuests`:

```bash
cd ManagementGuests
./mvnw spring-boot:run
```

No Windows:

```powershell
cd ManagementGuests
.\mvnw.cmd spring-boot:run
```

Para validar build e testes:

```bash
./mvnw verify
```

## Práticas adotadas

Este repositório é evoluído incrementalmente com foco em boas práticas de engenharia de software, incluindo:

- separação de responsabilidades;
- organização por camadas;
- persistência via JPA;
- testes automatizados;
- versionamento com Git;
- commits seguindo **Conventional Commits**.

## Próximas evoluções

As melhorias serão aplicadas de forma incremental, priorizando qualidade de código, testes, segurança, documentação e automação de build sem misturar grandes refatorações em uma única alteração.
