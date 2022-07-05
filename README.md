# wallet_tansations

Para rodar o projeto, você irá precisar:
*   Banco de dados postgresql
*   Java 11

Atualizar o arquivo .example.application.properties com os dados entre colchetes. Exemplo de arquivo válido:

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://localhost:5432/wallet?createDatabaseIfNotExist=true&serverTimezone=UTC
createDatabaseIfNotExist=true
spring.datasource.username=postgres
spring.datasource.password=123456
```
Existe um arquivo "Waller.postman_collectionjson" que pode ser utilizado para testes nas rotas da API.



