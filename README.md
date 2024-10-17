# Projeto de Testes Automatizados com Selenium Webdriver

## Desafio Accenture - Testes Automatizados

Este projeto foi desenvolvido para o desafio da Accenture e utiliza **Selenium** e **JUnit** para testes automatizados de aplicações frontend. 
O objetivo é testar a interface de uma aplicação web de maneira eficiente e automatizada.

## Tecnologias Utilizadas

Certifique-se de que seu ambiente de desenvolvimento atende aos seguintes requisitos:

- **Java** (versão 17)
- **Selenium** (versão 4.15.0)
- **JUnit** (versão 4.13.1)
- **SLF4J** para logging (versão 2.0.7)
- **IntelliJ IDEA 2023.2.2 (Community Edition)** (ou outra IDE de sua preferência)
- **Maven** (ou Gradle, dependendo do seu gerenciador de dependências)
- **Git** (opcional, para controle de versão)

## Configurações do Projeto

Os principais requisitos são:
- **JDK 17** instalado.
- **Maven** para gerenciamento de dependências.

## Dependências

As principais dependências utilizadas no projeto são:
- **Selenium Java**: Biblioteca principal para automação de testes em navegadores. 
- **JUnit**: Framework de testes para escrita e execução dos casos de teste.****
- **SLF4J**: Framework de logging utilizado para simplificar a geração de logs durante a execução dos testes.

As dependências estão configuradas no arquivo pom.xml. Para instalar todas as dependências, execute o comando Maven:

```bash
mvn clean install
```

## Estrutura do Projeto

- **src/main/java**: Contém os casos de teste automatizados utilizando Selenium e JUnit.
- **src/main/resources**: Contém os recursos e configurações utilizadas durante a execução dos testes.

A estrutura do projeto segue o padrão Maven, com os diretórios separados para código fonte e testes:

```
/CursoSelenium/
|-- src/
|   |-- main/
|   |   |-- java/
|           |-- br
                |-- pb 
                    |-- thiagofb84jp
                        |-- core
                        |-- page
                        |-- test
        |-- resources
|-- pom.xml
|-- README.md
```

## Links Importantes:
- Projeto no Github: https://github.com/thiagofb84jp/desafio-accenture-frontend

## Contribuição:

Sinta-se à vontade para abrir issues ou enviar pull requests caso encontre algo que possa ser melhorado ou corrigido.