# Controle de Locadora de Fitas VHS


Este é o trabalho semestral da disciplina de Desenvolvimento Web III, que consiste em uma aplicação web para gerenciamento de uma coleção de fitas VHS, incluindo controle de categorias e autenticação de usuários.


## 1. Descrição do Projeto


O objetivo deste projeto foi desenvolver uma aplicação web seguindo a arquitetura em camadas (MVC), utilizando a linguagem Java com o framework Spring Boot. A aplicação permite que um usuário, após se autenticar, gerencie sua coleção de fitas VHS. É possível cadastrar, listar, editar, excluir e alterar o status de cada fita, além de gerenciar as categorias.


## 2. Funcionalidades Implementadas
A aplicação desenvolvida é um sistema de gerenciamento de coleções completo. O usuário, após realizar a autenticação na plataforma, tem acesso a um conjunto de funcionalidades para a manipulação dos dados.


O módulo principal permite o gerenciamento completo de fitas VHS, incluindo operações de cadastro (Create), listagem (Read), atualização (Update) e exclusão (Delete). Uma funcionalidade específica para a alteração de status da fita (como DISPONÍVEL, EMPRESTADA ou INDISPONÍVEL) também foi implementada.


O sistema possui um módulo para gerenciamento de Categorias, com interfaces para a criação, edição e remoção. Também foi implementada uma regra de negócio que impede a exclusão de uma categoria caso esta esteja vinculada a uma ou mais fitas.


Toda a plataforma é protegida por um sistema de autenticação, em que apenas usuários autorizados podem acessar e modificar as informações.
Os formulários de cadastro contam com validações de dados no lado do servidor para garantir a consistência e qualidade das informações persistidas.


## 3. Tecnologias Utilizadas


- **Backend:**
  - **Java 21**
  - **Spring Boot:** Framework principal para a construção da aplicação.
    - **Spring Web:** Para a criação de controladores e da arquitetura web MVC.
    - **Spring Data JPA:** Para a camada de persistência de dados com o banco de dados.
    - **Spring Security:** Para a implementação do sistema de autenticação e autorização.
    - **Spring Boot DevTools:** Para o live-reload durante o desenvolvimento.
- **Frontend:**
  - **Thymeleaf:** Motor de templates para a renderização das páginas HTML dinâmicas.
  - **HTML5 & CSS3:** Para a estruturação e estilização das páginas.
- **Banco de Dados:**
  - **PostgreSQL:** Banco de dados relacional utilizado para a persistência dos dados.
- **Build & Gerenciamento de Dependências:**
  - **Apache Maven:** Ferramenta para gerenciamento do projeto e suas dependências.


## 4. Processo de Desenvolvimento e Arquitetura


O projeto foi desenvolvido seguindo o padrão arquitetural em camadas para garantir a separação de responsabilidades, manutenibilidade e escalabilidade do código. As camadas são:


1.  **Camada de Entidade (`entidades`):** Classes que representam os objetos do domínio (`VHS`, `Category`, `Usuario`), mapeadas para as tabelas do banco de dados com anotações JPA.
2.  **Camada de Repositório (`repositorios`):** Interfaces que estendem `JpaRepository`, responsáveis pela abstração do acesso aos dados no banco.
3.  **Camada de Serviço (`servicos`):** Classes que contêm a lógica de negócio da aplicação (ex: impedir a exclusão de uma categoria em uso).
4.  **Camada de Controlador (`controladores`):** Classes que recebem as requisições HTTP do usuário, processam as entradas, interagem com a camada de serviço e retornam a visão (página HTML) apropriada.
5.  **Camada de Visão (`templates`):** Arquivos HTML com Thymeleaf responsáveis pela apresentação dos dados ao usuário.


## 5. Como Baixar e Instalar o Projeto


Siga os passos abaixo para executar a aplicação.




### Pré-requisitos
- **Java Development Kit (JDK)** - Versão 17 ou superior.
- **Apache Maven** - Versão 3.6 ou superior.
- **PostgreSQL** - Um servidor PostgreSQL instalado e em execução.
- **Git**


### Passos para Instalação


1.  **Clone o repositório:**
    ```bash
    git clone 
    cd controle-de-locadora-vhs
    ```


1.  **Configure o Banco de Dados:**
    - Crie um novo banco de dados no seu PostgreSQL com o nome `locadora_vhs`.
    - Abra o arquivo `src/main/resources/application.properties`.
    - Altere as seguintes linhas com o seu usuário e senha do PostgreSQL:
      ```properties
      spring.datasource.username=seu_usuario
      spring.datasource.password=sua_senha
      ```


2.  **Execute a Aplicação:**
    - Abra um terminal na raiz do projeto.
    - Execute o seguinte comando:
      ```bash
      ./mvnw spring-boot:run
      ```


4.  **Acesse a Aplicação:**
    - Abra seu navegador e acesse: `http://localhost:8080`
    - Você será redirecionado para a página de login.
    - Use as credenciais padrão para o primeiro acesso:
      - **Usuário:** `admin`
      - **Senha:** `password`


## 6. Resultados Obtidos


O desenvolvimento deste projeto permitiu a aplicação prática e a consolidação de conceitos fundamentais de desenvolvimento web. O resultado é uma aplicação robusta, segura e funcional que atende a todos os requisitos solicitados.

