# Workshop MongoDB - Spring Boot REST API

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white" />
  <img src="https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
</div>

## Sobre o Projeto
Este projeto é uma API RESTful desenvolvida em **Java** com **Spring Boot** e banco de dados NoSQL **MongoDB**. O sistema simula o back-end de um blog, gerenciando usuários, postagens e comentários. O foco principal deste projeto é explorar o paradigma de banco de dados orientado a documentos, compreendendo as diferenças entre bancos de dados relacionais e não-relacionais, e como estruturar dados aninhados (embedded) e referenciados (references) no MongoDB.

## Tecnologias Utilizadas
* **Backend:** Java, Spring Boot, Spring MVC
* **Persistência de Dados:** Spring Data MongoDB
* **Banco de Dados:** MongoDB
* **Gerenciador de Dependências:** Maven

## Funcionalidades
* **Gerenciamento de Usuários:** Operações completas de CRUD (Create, Read, Update, Delete) para usuários.
* **Consulta de Postagens:** Busca de posts por ID, além de buscas avançadas.
* **Busca Simples e Avançada:** Pesquisa de postagens por título e uma busca completa por textos contidos no título, corpo do post ou nos comentários, filtrando também por intervalo de datas.
* **Associações:** Gerenciamento do relacionamento entre objetos de domínio utilizando aninhamento de objetos (para comentários e autores) e referências de banco de dados (`@DBRef` para associar as postagens aos usuários).
* **Tratamento de Exceções:** Retorno adequado de erros e códigos HTTP padronizados (ex: 404 Not Found) em toda a API através de um manipulador de exceções (`ResourceExceptionHandler`).

## Estrutura da Aplicação
A aplicação segue a separação em camadas bem definidas e o uso do padrão DTO (Data Transfer Object):
* `resources`: Controladores REST (Controllers) responsáveis por expor as rotas da API e lidar com as requisições HTTP e DTOs.
* `services`: Contém a lógica de negócio da aplicação.
* `repository`: Interfaces que estendem `MongoRepository`, responsáveis por interagir com o MongoDB, incluindo *Custom Queries* formatadas em JSON.
* `domain`: Classes de entidade que representam as coleções e os dados persistidos no MongoDB (`User`, `Post`).
* `dto`: Objetos de transferência de dados que definem os dados que trafegam nas requisições sem expor diretamente o domínio.

## Como Executar Localmente

### 1. Banco de Dados MongoDB
Certifique-se de que possui o MongoDB rodando localmente (normalmente na porta `27017`). A aplicação já está configurada para conectar na base de dados local na porta padrão (`application.properties`). O banco de dados se chamará `workshopmongo`.

### 2. Executando a Aplicação
O projeto conta com uma classe `Instantiation` que irá limpar o banco de dados e inserir dados fictícios (semeadura inicial) sempre que a aplicação for iniciada (útil para testes).

Para iniciar, abra a pasta raiz do projeto no terminal e utilize o Maven Wrapper:
```bash
./mvnw spring-boot:run
```
*(No Windows, utilize `mvnw spring-boot:run` ou `mvn spring-boot:run` se tiver o maven instalado)*

### 3. Acesso aos Endpoints
A API estará rodando em `http://localhost:8080/`.
Exemplos de rotas disponíveis:
* **Usuários:** `GET /users`, `GET /users/{id}`, `POST /users`, `PUT /users/{id}`, `DELETE /users/{id}`
* **Posts do Usuário:** `GET /users/{id}/posts`
* **Busca de Post:** `GET /posts/{id}`
* **Busca Avançada:** `GET /posts/titlesearch?text=bom%20dia`, `GET /posts/fullsearch?text=viagem`

<br/>

<div>
  <a href = "mailto:caiodias200109@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="https://www.linkedin.com/in/caio-dias-8a4962246/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href="https://github.com/Caio-Fernando-Dias"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a>
</div>
