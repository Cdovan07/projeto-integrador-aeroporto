
# Sistema de Gerenciamento de Aeroporto

## 1. Sobre o projeto

O Sistema de Gerenciamento de Aeroporto é um projeto desenvolvido em Java com o objetivo de representar e organizar operações básicas de um aeroporto.

O sistema permite cadastrar passageiros, funcionários, voos e reservas, além de gerenciar check-ins e cartões de embarque.

## 2. Funcionalidades

- Cadastro de passageiros.
- Cadastro de voos.
- Cadastro de reservas.
- Consulta de reservas.
- Cancelamento de reservas.
- Gerenciamento de check-in.
- Emissão de cartões de embarque.
- Gerenciamento de portões de embarque.
- Validação de dados e prevenção de cadastros duplicados.
- Leitura e gravação de reservas em arquivos.

## 3. Tecnologias utilizadas

- Java 25.
- Apache Maven.
- JUnit 5.
- Visual Studio Code.
- Git e GitHub.

## 4. Conceitos de programação utilizados

- Programação Orientada a Objetos.
- Encapsulamento.
- Herança.
- Polimorfismo.
- Classes e objetos.
- Coleções: List, Map e Set.
- Tratamento de exceções personalizadas.
- Manipulação de arquivos.
- Testes automatizados com JUnit.

## 5. Organização do projeto

```text
projeto-integrador-aeroporto/
├── docs/
├── dados/
│   └── reservas.txt
├── src/
│   ├── main/
│   │   └── java/
│   │       └── aeroporto/
│   │           ├── Administrador.java
│   │           ├── Aeronave.java
│   │           ├── ArquivoReservas.java
│   │           ├── CartaoEmbarque.java
│   │           ├── CheckIn.java
│   │           ├── CompanhiaAerea.java
│   │           ├── DadosInvalidosException.java
│   │           ├── CadastroDuplicadoException.java
│   │           ├── Funcionario.java
│   │           ├── Passageiro.java
│   │           ├── Pessoa.java
│   │           ├── PortaoEmbarque.java
│   │           ├── Principal.java
│   │           ├── Reserva.java
│   │           ├── ReservaNaoEncontradaException.java
│   │           ├── SistemaAeroporto.java
│   │           └── Voo.java
│   └── test/
│       └── java/
│           └── aeroporto/
│               └── SistemaAeroportoTest.java
├── pom.xml
└── README.md
```

## 6. Como executar o projeto

É necessário ter Java 25 e Apache Maven instalados.

Para compilar o projeto:

```bash
mvn compile
```

Para executar o sistema:

```bash
mvn exec:java '-Dexec.mainClass=aeroporto.Principal'
```

## 7. Como executar os testes

Para executar os testes automatizados com JUnit:

```bash
mvn test
```

## 8. Persistência de dados

O sistema utiliza arquivos de texto para armazenar informações das reservas.

Os dados são salvos no arquivo `dados/reservas.txt`, permitindo a leitura posterior das informações registradas.

## 9. Testes automatizados

O projeto possui testes unitários que verificam:

- Cadastro correto de passageiros.
- Impedimento de passageiros com CPF duplicado.
- Impedimento de cadastro de passageiros nulos.
- Impedimento de cadastro de passageiros sem CPF.
