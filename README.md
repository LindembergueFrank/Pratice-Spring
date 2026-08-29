# Spring Practice — estudos e pequenos projetos

Repositório de estudos dedicado a **Spring e Spring Boot**, preservando diferentes experimentos e pequenos projetos desenvolvidos durante a evolução em backend Java.

> Este é um repositório de prática. Ele registra aprendizado e experimentação; projetos autorais mais recentes devem ser considerados a principal evidência de engenharia de software do portfólio.

## Conteúdo

O repositório reúne projetos independentes, entre eles:

- `ManagementGuests/` — aplicação Spring voltada ao gerenciamento de convidados, com controller, modelo, persistência e templates;
- `spring-example/` — exemplo de estudo do ecossistema Spring;
- `spring-example2/` — segundo exemplo incremental de estudo.

Cada diretório deve ser tratado como um projeto separado e pode possuir dependências, configuração e forma de execução próprias.

## Conceitos praticados

Conforme o projeto, o repositório registra contato com:

- Spring Boot;
- arquitetura MVC;
- controllers;
- persistência de dados;
- templates web;
- configuração de aplicações;
- Docker e banco de dados em etapas posteriores do histórico.

## Organização e higiene

Arquivos de IDE, saídas de build e configurações locais não devem ser versionados. O `.gitignore` na raiz cobre IntelliJ IDEA, Eclipse/STS, VS Code, diretórios de build e arquivos `.env`.

## Como executar

Entre no diretório do projeto desejado e consulte seu `pom.xml`, `README.md` e arquivos de configuração. Para projetos Maven com wrapper, o fluxo típico é:

```bash
./mvnw test
./mvnw spring-boot:run
```

Os comandos podem variar conforme a idade e a estrutura de cada exemplo.

## Papel no portfólio

Este repositório demonstra **progressão de aprendizado em Spring**. Ele não deve substituir projetos autorais completos que mostrem requisitos reais, testes, segurança, CI/CD, banco de dados, documentação arquitetural e decisões de produção.

## Autor

**Lindembergue Frank**
