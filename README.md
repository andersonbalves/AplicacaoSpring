# AplicacaoSpring
Aplicação contendo exemplos de uso de Spring Boot e MVC

## Motivação
Construir uma aplicação utilzando Spring Boot MVC e JPA para estudo das tecnologias

## Conteúdo
A aplicação disponibiliza uma API Rest contendo as seguintes operações

### Adicionar Planta
Adiciona uma planta à base de dados da aplicação
- URL: \planta
- HTTP: POST
- Tipo de Entrada: JSON:
```json
{
    "nome": "Orquidea",
    "nomeCientifico": "Orchidaceae",
    "dataCatalogo": "2017-11-24T02:00:00.000+0000"
}
````

### Adicionar Plantas
Adiciona uma lista de plantas à base de dados da aplicação
- URL: \plantas
- HTTP: POST
- Tipo de Entrada: JSON[]:
```json
[
    {
        "nome": "Acerola",
        "nomeCientifico": "Malpighia emarginata",
        "dataCatalogo": "2018-09-21T02:00:00.000+0000"
    },
    {
        "nome": "Lupulo",
        "nomeCientifico": "Humulus lupulus",
        "dataCatalogo": "2018-01-25T02:00:00.000+0000"
    }
]
````

### ListarPlantas
Lista todas as plantas existentes na base da aplicação
- URL: \plantas
- HTTP: GET

### Buscar Planta
Busca uma planta em específico existente na base da aplicação através do nome informado na URL
- URL: \planta\{nome}
- HTTP: GET

### Excluir Planta
Exclui uma planta em específico existente na base da aplicação através do id informado na URL
- URL: \planta\{id}
- HTTP: DELETE

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

### Rodando a Aplicação
Para rodar a aplicação basta rodar o comando java -jar referenciando o jar da aplicação
```bat
java -jar aplicacao-spring-1.0.0.jar
```
## Documentação da API em Swagger
É possível acessar uma documentação das operações disponibilizadas pela API através do Swagger UI existente dentro da aplicação
O Swagger fica acessível à partir do path "/swagger-ui.html" da aplicação.

```url
http://localhost:8080/swagger-ui.html
```
