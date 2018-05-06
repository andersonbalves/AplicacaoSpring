# AplicacaoSpring
Aplicação contendo exemplos de uso de Spring Boot e MVC

## Motivação
Construir uma aplicação utilzando Spring Boot MVC e JPA para estudo das tecnologias

## Conteúdo
A aplicação disponibiliza uma API Rest contendo as seguintes operações

- Adicionar Planta

- Adicionar Plantas

- ListarPlantas

- Buscar Planta

- Excluir Planta

## Como Rodar a Aplicação

### Requisitos
 - Java 8
 - Maven
 
### Instalando as Dependências
Primeiramente é necessário instalar as dependências da aplicação através do Maven rodando o seguinte comando na raiz do projeto
 
```bat
mvn install
```
Após rodar a instalação, o jar da aplicação será gerado na pasta "target" do projeto.
```bat
java -jar aplicacao-spring-1.0.0.jar
```

### Rodando a Aplicação
Para rodar a aplicação basta rodar o comando java -jar referenciando o jar da aplicação

## Documentação da API em Swagger
É possível acessar uma documentação das operações disponibilizadas pela API através do Swagger UI existente dentro da aplicação
O Swagger fica acessível à partir do path "/swagger-ui.html" da aplicação.

```url
http://localhost:8080/swagger-ui.html
```
