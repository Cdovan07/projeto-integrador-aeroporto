# Justificativa da Modelagem

## 1. Introdução

A modelagem do Sistema de Gerenciamento de Aeroporto foi desenvolvida com base nos requisitos e funcionalidades definidos na Etapa 1. O objetivo foi representar as principais entidades do domínio aeroportuário por meio de classes, seus atributos, métodos e relacionamentos.

A modelagem foi realizada utilizando os conceitos de Programação Orientada a Objetos e UML, buscando manter uma estrutura organizada e coerente com as funcionalidades propostas para o sistema.

## 2. Classes

Foram definidas onze classes principais para representar o domínio do sistema:

* Pessoa;
* Passageiro;
* Funcionario;
* Administrador;
* CompanhiaAerea;
* Aeronave;
* Voo;
* PortaoEmbarque;
* Reserva;
* CheckIn;
* CartaoEmbarque.

A classe Pessoa representa informações comuns aos indivíduos que utilizam o sistema. Passageiro e Funcionario especializam Pessoa, enquanto Administrador especializa Funcionario.

As classes CompanhiaAerea, Aeronave, Voo e PortaoEmbarque representam elementos relacionados à operação dos voos.

As classes Reserva, CheckIn e CartaoEmbarque representam as etapas relacionadas à viagem do passageiro.

## 3. Herança

Foi utilizada herança para representar diferentes tipos de pessoas no sistema.

A classe Passageiro herda de Pessoa, pois possui as informações básicas de uma pessoa e acrescenta informações específicas relacionadas ao passageiro.

A classe Funcionario também herda de Pessoa, acrescentando informações como matrícula e cargo.

A classe Administrador herda de Funcionario, pois representa um funcionário com responsabilidades administrativas.

Essa estrutura permite reutilizar atributos e métodos e representa uma relação de especialização entre as classes.

## 4. Encapsulamento

Os atributos das classes foram definidos com visibilidade privada. O acesso e a alteração desses atributos são realizados por meio de métodos públicos, como getters e setters.

Essa decisão permite aplicar o conceito de encapsulamento, evitando o acesso direto aos atributos dos objetos e mantendo maior controle sobre seus dados.

## 5. Polimorfismo

O polimorfismo é utilizado na hierarquia de Pessoa. O método exibirTipo() é definido na classe Pessoa e sobrescrito pelas classes Passageiro, Funcionario e Administrador.

Dessa forma, objetos de diferentes subclasses podem ser tratados como objetos do tipo Pessoa, mas executar comportamentos específicos de acordo com sua classe.

## 6. Relacionamentos

A classe Voo possui relacionamentos com CompanhiaAerea, Aeronave e PortaoEmbarque, representando a companhia responsável pelo voo, a aeronave utilizada e o portão de embarque associado.

A classe Reserva relaciona Passageiro e Voo, representando a reserva realizada por um passageiro para determinado voo.

A classe CheckIn está relacionada a uma Reserva, representando a realização do check-in associado à viagem.

A classe CartaoEmbarque está relacionada a um CheckIn e representa o cartão de embarque emitido após a realização do procedimento.

## 7. Multiplicidades

As multiplicidades representam a quantidade de objetos que podem participar de cada relacionamento.

Uma CompanhiaAerea pode estar relacionada a vários Voos, enquanto cada Voo está associado a uma CompanhiaAerea.

Um Passageiro pode possuir várias Reservas, e cada Reserva está relacionada a um Passageiro e a um Voo.

Uma Reserva pode possuir nenhum ou um CheckIn, enquanto um CheckIn está relacionado a uma Reserva.

Cada CheckIn está associado a um CartaoEmbarque.

## 8. Visibilidade

Os atributos das classes possuem visibilidade privada, enquanto os construtores e métodos necessários para utilização das classes possuem visibilidade pública.

Essa definição mantém os dados internos das classes protegidos e permite que suas operações sejam acessadas de maneira controlada.

## 9. Coerência com a Etapa 1

A modelagem foi construída de acordo com as funcionalidades e entidades identificadas na proposta inicial. As classes representam os principais elementos do domínio e os relacionamentos representam as interações necessárias para realizar as operações previstas no sistema.

A estrutura também permite que a implementação em Java seja realizada de forma gradual, mantendo a possibilidade de adicionar posteriormente coleções, tratamento de exceções, persistência de dados e testes.
