
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
- Controle de estados das reservas.
- Notificação sobre alterações no status dos voos.

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
- Padrões de projeto GoF: State e Observer.
- Documentação de código com Javadoc.

## 5. Padrões de projeto GoF

O projeto utiliza dois padrões de projeto comportamentais do catálogo GoF: State e Observer.

### 5.1. Padrão State

O padrão State foi aplicado na classe `Reserva` para controlar os diferentes estados de uma reserva.

**Problema resolvido:** antes da aplicação do padrão, o estado da reserva era controlado diretamente por textos, como "Pendente", "Confirmada" e "Cancelada". Isso concentrava na própria classe as decisões sobre as mudanças de estado.

**Solução implementada:** foi criada a interface `EstadoReserva`, com os comportamentos de confirmar, cancelar e consultar o nome do estado. Ela é implementada pelas classes:

- `ReservaPendente`
- `ReservaConfirmada`
- `ReservaCancelada`

A classe `Reserva` delega as operações ao objeto que representa seu estado atual.

**Justificativa:** esse padrão é adequado porque cada estado possui comportamentos e regras diferentes. Dessa forma, as transições ficam organizadas em classes próprias, facilitando a manutenção e a evolução do sistema.

### 5.2. Padrão Observer

O padrão Observer foi aplicado na classe `Voo` para notificar interessados quando o status de um voo é alterado.

**Problema resolvido:** quando um voo tem seu status alterado, os passageiros interessados precisam receber essa informação. Sem um mecanismo de notificação, seria necessário consultar o voo manualmente para verificar mudanças.

**Solução implementada:** foi criada a interface `ObservadorVoo`, que define o método de atualização. A classe `NotificadorPassageiro` implementa essa interface e recebe as notificações.

A classe `Voo` mantém uma lista de observadores e oferece métodos para adicionar, remover e notificar esses observadores sempre que o status é alterado.

**Justificativa:** esse padrão é adequado porque permite que um voo informe automaticamente diferentes interessados sobre suas alterações, sem precisar conhecer os detalhes de cada observador.

## 6. Organização do projeto

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
│   │           ├── CadastroDuplicadoException.java
│   │           ├── CheckIn.java
│   │           ├── CompanhiaAerea.java
│   │           ├── DadosInvalidosException.java
│   │           ├── EstadoReserva.java
│   │           ├── Funcionario.java
│   │           ├── NotificadorPassageiro.java
│   │           ├── ObservadorVoo.java
│   │           ├── Passageiro.java
│   │           ├── Pessoa.java
│   │           ├── PortaoEmbarque.java
│   │           ├── Principal.java
│   │           ├── Reserva.java
│   │           ├── ReservaCancelada.java
│   │           ├── ReservaConfirmada.java
│   │           ├── ReservaNaoEncontradaException.java
│   │           ├── ReservaPendente.java
│   │           ├── SistemaAeroporto.java
│   │           └── Voo.java
│   └── test/
│       └── java/
│           └── aeroporto/
│               └── SistemaAeroportoTest.java
├── pom.xml
└── README.md
```

## 7. Como executar o projeto

É necessário ter Java 25 e Apache Maven instalados.

Para compilar o projeto:

```bash
mvn compile
```

Para executar o sistema:

```bash
mvn exec:java '-Dexec.mainClass=aeroporto.Principal'
```

## 8. Como executar os testes

Para executar os testes automatizados com JUnit:

```bash
mvn test
```

## 9. Persistência de dados

O sistema utiliza arquivos de texto para armazenar informações das reservas.

Os dados são salvos no arquivo `dados/reservas.txt`, permitindo a leitura posterior das informações registradas.

## 10. Testes automatizados

O projeto possui testes unitários que verificam:

- Cadastro correto de passageiros.
- Impedimento de passageiros com CPF duplicado.
- Impedimento de cadastro de passageiros nulos.
- Impedimento de cadastro de passageiros sem CPF.
- Confirmação de reservas pendentes.
- Cancelamento de reservas pendentes.
- Cancelamento de reservas confirmadas.
- Impedimento de confirmação de reservas canceladas.
- Funcionamento das notificações de voos.
- Remoção de observadores.
- Impedimento de cadastro de observadores nulos.

O projeto possui 18 testes automatizados utilizando JUnit 5, cobrindo funcionalidades de cadastro de passageiros, gerenciamento de reservas, padrões de projeto State e Observer, persistência em arquivos e tratamento de exceções.

Todos os 18 testes foram executados com sucesso, sem falhas ou erros.