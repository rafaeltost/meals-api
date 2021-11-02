# 						 Mels API

Para o Back-End do projeto, foi desenvolvida uma API Rest em Java conectada ao H2 Database e  deploy no Heroku sendo consumido por um Cliente em Angular.

No desafio, foi solicitado um Back-End que provesse objetos do tipo "Refeição" para consultas em um Cliente. Mas pensando a médio/longo prazo e as possíveis implementações que um sistema real precisaria, foram implementados também, todos os métodos de um Crud básico.

As classes foram divididas entre as DTO, que fazem validações de dados do lado do Cliente utilizando as anotações do `java bean validation` e as classes de mapeamento de requisições, oferecendo tratamento de exceções e respostas mais amigáveis aos usuários.

Além do Java JPA, também foi utilizada a biblioteca `Lombok` , suprimindo as declarações explícitas de constructors, getters, setters, equals and hascode, tornando o código limpo para facilitar a manutenção e trabalhando com boas práticas de programação.

Para os testes unitários, foram utilizados  JUnit 5 e Mock;

**Tecnologias e dependências do projeto:** 

- Java 11 

- Spring Boot 2.5.6

- Maven

- H2 Database

- Lombok

  

**Pontos de acesso para API:** 

- Swagger: https://meals-project-api.herokuapp.com/swagger-ui/index.html

- Cloud: https://meals-project-api.herokuapp.com/api/v1/meals

- Local: `http://localhost:8080/api/v1/meals`

  

**Acesso ao Banco de Dados:** (Não necessita login e senha)

- Local: `http://localhost:8080/h2-console`
