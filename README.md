# Sistema de Gerenciamento de Aeroporto

## 1. Sobre o projeto

O Sistema de Gerenciamento de Aeroporto é um projeto desenvolvido em Java com o objetivo de representar e organizar operações básicas de um aeroporto.

O sistema permite gerenciar passageiros, funcionários, voos e reservas, além de representar operações relacionadas a check-in, cartões de embarque, aeronaves, companhias aéreas e portões de embarque.

O projeto foi desenvolvido aplicando conceitos de Programação Orientada a Objetos (POO) e padrões de projeto GoF.

O sistema possui duas formas de utilização:

- **Interface gráfica:** permite acessar as funcionalidades por meio de telas e menus.
- **Terminal:** disponibiliza um menu interativo para realizar operações do sistema.

## 2. Funcionalidades

- Cadastro de passageiros.
- Cadastro e gerenciamento de voos.
- Consulta de passageiros e voos.
- Criação de reservas.
- Consulta e gerenciamento de reservas.
- Confirmação e cancelamento de reservas.
- Exclusão de passageiros, voos e reservas.
- Cadastro e autenticação de passageiros.
- Login de funcionário.
- Visualização de voos disponíveis para passageiros.
- Criação e cancelamento de reservas pelo passageiro.
- Restrição de acesso às funcionalidades administrativas.
- Gerenciamento de check-in.
- Emissão de cartões de embarque.
- Gerenciamento de portões de embarque.
- Validação de dados e prevenção de cadastros duplicados.
- Leitura e gravação de dados em arquivos na interface gráfica.
- Controle de estados das reservas.
- Notificação sobre alterações no status dos voos.

## 3. Tecnologias utilizadas

- Java 25.
- Apache Maven.
- JUnit 5.
- Java Swing.
- Visual Studio Code.
- Git e GitHub.

## 4. Conceitos de programação utilizados

- Programação Orientada a Objetos.
- Encapsulamento.
- Herança.
- Polimorfismo.
- Classes e objetos.
- Interfaces.
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

**Problema resolvido:** quando um voo tem seu status alterado, os passageiros e outros interessados precisam receber essa informação. Sem um mecanismo de notificação, seria necessário consultar o voo manualmente para verificar mudanças.

**Solução implementada:** foi criada a interface `ObservadorVoo`, que define o método de atualização. As classes `NotificadorPassageiro` e `NotificadorTela` implementam essa interface.

A classe `Voo` mantém uma lista de observadores e oferece métodos para adicionar, remover e notificar esses observadores sempre que o status é alterado.

**Justificativa:** esse padrão permite que um voo informe automaticamente diferentes interessados sobre suas alterações, sem precisar conhecer os detalhes de cada observador.

## 6. Organização do projeto

```text
projeto-integrador-aeroporto/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── aeroporto/
│   │           ├── Administrador.java
│   │           ├── Aeronave.java
│   │           ├── ArquivoDadosAeroporto.java
│   │           ├── ArquivoReservas.java
│   │           ├── CadastroDuplicadoException.java
│   │           ├── CartaoEmbarque.java
│   │           ├── CheckIn.java
│   │           ├── CompanhiaAerea.java
│   │           ├── DadosInvalidosException.java
│   │           ├── EstadoReserva.java
│   │           ├── Funcionario.java
│   │           ├── NotificadorPassageiro.java
│   │           ├── NotificadorTela.java
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
│   │           └── TelaPrincipal.java
│   └── test/
│       └── java/
│           └── aeroporto/
│               └── SistemaAeroportoTest.java
├── pom.xml
└── README.md
```

## 7. Requisitos para execução

Antes de executar o projeto, é necessário ter instalado:

- Java JDK 25.
- Apache Maven.
- Git (opcional, para clonar o repositório).

## 8. Como obter o projeto

Para clonar o repositório:

```bash
git clone https://github.com/Cdovan07/projeto-integrador-aeroporto.git
```

Entre na pasta do projeto:

```bash
cd projeto-integrador-aeroporto
```

## 9. Como executar o projeto

O sistema possui duas formas de execução: interface gráfica e terminal.

### 9.1. Interface gráfica

Para iniciar o sistema com interface gráfica, execute:

```powershell
mvn exec:java '-Dexec.mainClass=aeroporto.TelaPrincipal'
```

A tela inicial permite escolher entre dois perfis de acesso:

**Funcionário:**

- Selecione a opção Funcionário.
- Informe a senha demonstrativa: `poo`.
- Acesse as funcionalidades administrativas do sistema.

**Passageiro:**

- Selecione a opção Passageiro.
- Faça login utilizando CPF e senha.
- Caso ainda não possua cadastro, utilize a opção de cadastro.
- Consulte voos disponíveis.
- Crie e cancele suas próprias reservas.
- Consulte suas reservas.

### 9.2. Terminal interativo

Para iniciar o sistema pelo terminal, execute:

```powershell
mvn exec:java '-Dexec.mainClass=aeroporto.Principal'
```

Será apresentado um menu interativo com opções para:

1. Cadastrar passageiro.
2. Listar passageiros.
3. Cadastrar voo.
4. Listar voos.
5. Criar reserva.
6. Listar reservas.
7. Confirmar reserva.
8. Cancelar reserva.
9. Excluir passageiro.
10. Excluir voo.
11. Excluir reserva.
12. Demonstrar conceitos de POO.
0. Sair.

O usuário pode escolher as operações digitando o número correspondente.

**Observação:** o menu de terminal utiliza armazenamento em memória. Os dados cadastrados nessa execução não são salvos automaticamente após o encerramento do programa.

## 10. Persistência de dados

A interface gráfica utiliza a classe `ArquivoDadosAeroporto` para armazenar e recuperar informações do sistema.

Os arquivos de dados são criados na pasta `dados/`:

- `passageiros.txt`: armazena os dados dos passageiros.
- `voos.txt`: armazena os dados dos voos.
- `reservas-interface.txt`: armazena as reservas cadastradas pela interface gráfica.

Dessa forma, os dados permanecem disponíveis quando o sistema é fechado e iniciado novamente pela interface gráfica.

O projeto também possui a classe `ArquivoReservas`, responsável pela leitura e gravação de reservas em arquivos, utilizada em testes e operações específicas de persistência.

## 11. Como executar os testes

Para executar os testes automatizados com JUnit 5, utilize:

```bash
mvn test
```

Para limpar os arquivos compilados e executar os testes novamente:

```bash
mvn clean test
```

## 12. Testes automatizados

O projeto possui 18 testes automatizados utilizando JUnit 5.

Os testes verificam:

- Cadastro correto de passageiros.
- Impedimento de passageiros com CPF duplicado.
- Impedimento de cadastro de passageiros nulos.
- Impedimento de cadastro de passageiros sem CPF.
- Confirmação de reservas pendentes.
- Cancelamento de reservas pendentes.
- Cancelamento de reservas confirmadas.
- Impedimento de confirmação de reservas canceladas.
- Impedimento de cancelamento de reservas já canceladas.
- Impedimento de criação de reservas com status inválido.
- Funcionamento das notificações de voos.
- Remoção de observadores.
- Impedimento de cadastro de observadores nulos.
- Salvamento de reservas em arquivos.
- Leitura de arquivos inexistentes.
- Tratamento de erros durante a leitura e gravação de arquivos.

Todos os 18 testes foram executados com sucesso, sem falhas ou erros.

## 13. Considerações finais

O projeto demonstra a aplicação prática de conceitos de Programação Orientada a Objetos e padrões de projeto GoF em um sistema de gerenciamento de aeroporto.

A implementação reúne funcionalidades de gerenciamento de passageiros, voos e reservas, além de uma interface gráfica e um menu interativo no terminal.

O desenvolvimento também permitiu aplicar conceitos de organização de código, persistência de dados, tratamento de exceções e testes automatizados.
