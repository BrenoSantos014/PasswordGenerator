 ### Gerador de Senhas/Password Generator

É uma API desenvolvida em Java (Swing) para geração de senhas seguras e armazenamento em banco de dados totalmente academico.
**OBS:**Futuramente todas as anotações no projeto estarão em ingles para pratica  

---

##  Funcionalidades

*  Geração de senhas aleatórias
*  Personalização no suário/site
  * Letras minúsculas
  * Letras maiúsculas
  * Números
  * Símbolos
*  Salvamento de usuários e senhas no banco de dados (MySQL)
*  Navegação entre telas
*  Interface gráfica simples e funcional

---

##  Tecnologias utilizadas

* Java 
* MySQL
* JDBC (MySQL Connector/J)

---

##  Como executar

### 1. Clonar o repositório

```bash
git https://github.com/BrenoSantos014/PasswordGenerator.git
```

### 2. Configurar o banco de dados

```sql
CREATE DATABASE history_data_base;

USE history_data_base;

CREATE TABLE history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    user_password VARCHAR(100)
);

---

### 3. Configurar conexão no Java

No arquivo 'Account.java', ajuste:

```java
String url = "jdbc:mysql://localhost:3306/history_data_base";
String username = "root";
String password = "SUA_SENHA";
```

---

### 4. Executar o projeto

Para executar o projeto, Recomenda-se abrir o IntelliJ e rode a classe principal.

---

## Versões

* v1.0 → Estrutura inicial
* v1.1 → Integração com banco de dados e melhoria na navegação entre as telas

---

## Melhorias futuras

*  Criptografia de senha
*  Optimização do projeto
*  Melhorias na interface gráfica
*  Personalizaçao completa no usuário/site e senha
*  Sistema de login/senha

---

## Autor

Desenvolvido por **Breno Manoel**

---

## Contribuição

Sinta-se livre para contribuir ou sugerir melhorias

