# MovSaúdeWeb

MovSaudeWeb é uma aplicação **em desenvolvimento** com Spring Boot, permitindo o cadastro, listagem, busca edição e exclusão de pacientes, psicólogos e consultas de psicoterapia.
O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no Github.

---
## Visão geral
Esse sistema foi desenvolvido para gerenciar pacientes, psicólogos e suas consultas. Cada consulta é a tribuída a um único psicólogo e paciente, enquanto um paciente e um psicólogo podem ser atribuídos a várias consultas. As principais funcionalidades são:
- Cadastro de pacientes com nome, cpf, email, telefone e data de nascimento.
- Cadastro de psicólogos com nome, cpf, email, telefone, data de nascimento e crp (registro do psicólogo no Conselho Regional de Psicologia).
- Atribuição de uma consulta para um paciente e um psicólogo.
- Gerenciamento de consultas e dos pacientes e psicólogos associados a elas.

---
## Tecnologias utilizadas
- Spring Boot: para criação da aplicação web e gerenciamento de dependências
- Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
- Flyway: para gerenciamento de migrações do banco de dados.
- JPA: Para mapeamento objeto-relacional.
- Spring Data JPA: Para integração com o banco de dados.
- Maven: Para build e gerenciamento de dependências do projeto.
- Docker: Para build externo do banco de dados
- SQL: Manipulação do banco de dados

---
## Configuração
1. Clone o repositório: `https://github.com/jacqkruk/MovSaudeWeb.git`
2. Navegue até o diretório do projeto: `cd MovSaudeWeb`
3. Construa o projeto: `mvn clean install`
4. Execute a aplicação: `mvn spring-boot:run`
5. Acesse a aplicação em `http://localhost:8080`

