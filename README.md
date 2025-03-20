# MyMovieList-Backend

## Sobre
O **MyMovieList-Backend** é uma API REST desenvolvida em **Java** com **Spring Boot** para gerenciar uma lista de filmes pessoais. Ele permite aos usuários **adicionar, listar, atualizar e excluir** filmes, armazenando os dados em um banco de dados relacional via **Spring Data JPA**. A API está pronta para ser consumida por um frontend, possibilitando a criação de uma plataforma de organização de filmes.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 / MySQL (dependendo da configuração)**
- **Maven**

## Configuração e Instalação
### Pré-requisitos
- **JDK 17** ou superior
- **Maven** instalado
- (Opcional) **MySQL** se for usar um banco de dados externo

### Clonar o Repositório
```bash
git clone https://github.com/HenrickSilva04/mymovielist-backend.git
cd mymovielist-backend
```

### Configurar Banco de Dados (Opcional)
Por padrão, o projeto está configurado com um banco **H2 em memória**. Se quiser usar MySQL, atualize o arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movies_db
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Executar a Aplicação
```bash
mvn spring-boot:run
```
A API estará disponível em: `http://localhost:8080`

## Endpoints da API
| Método | Endpoint       | Descrição                  |
|--------|---------------|----------------------------|
| GET    | `/movies`      | Lista todos os filmes     |
| POST   | `/movies`      | Adiciona um novo filme    |
| GET    | `/movies/{id}` | Obtém um filme por ID     |
| PUT    | `/movies/{id}` | Atualiza detalhes do filme|
| DELETE | `/movies/{id}` | Exclui um filme por ID    |

### Exemplo de JSON para requisição (POST /movies)
```json
{
  "title": "A Origem",
  "genre": "Ficção Científica",
  "year": 2010
}
```

## Melhorias Futuras
- Implementar autenticação e gerenciamento de usuários
- Adicionar suporte para avaliações e notas de filmes
- Criar um frontend para consumir a API


Desenvolvido por **Henrick Silva** 

