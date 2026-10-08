Sistema de Gerenciamento de Aeroporto

1. Identificação do Sistema

Nome: Sistema de Gerenciamento de Aeroporto

Área: Aviação e gerenciamento aeroportuário

Tipo: Sistema de gerenciamento desenvolvido utilizando Programação Orientada a Objetos em Java.

2. Descrição do Sistema

O Sistema de Gerenciamento de Aeroporto tem como objetivo auxiliar no gerenciamento das principais operações relacionadas aos passageiros, voos e embarques realizados em um aeroporto.

O sistema permitirá o cadastro e gerenciamento de passageiros, funcionários, companhias aéreas, aeronaves e portões de embarque. Também serão controladas as reservas de voos, a realização do check-in e a emissão do cartão de embarque.

A proposta é desenvolver uma aplicação que represente, de forma simplificada, o funcionamento de algumas operações de um aeroporto, utilizando conceitos de Programação Orientada a Objetos.

3. Objetivo

O objetivo principal do sistema é organizar e facilitar o gerenciamento das informações relacionadas aos voos e passageiros, permitindo que funcionários e administradores realizem operações de gerenciamento e que passageiros possam consultar suas informações de viagem.

O sistema também será utilizado como aplicação prática dos conceitos de Programação Orientada a Objetos estudados na disciplina.

4. Principais Funcionalidades

O sistema deverá permitir:

- Cadastrar e consultar passageiros;
- Cadastrar e gerenciar funcionários;
- Cadastrar companhias aéreas;
- Cadastrar e gerenciar aeronaves;
- Cadastrar e gerenciar voos;
- Cadastrar e gerenciar portões de embarque;
- Realizar reservas de voos;
- Consultar reservas;
- Cancelar reservas;
- Realizar check-in;
- Cancelar check-in;
- Emitir cartão de embarque;
- Consultar informações do cartão de embarque;
- Consultar informações dos voos.

5. Atores

Passageiro

O passageiro poderá consultar voos, realizar e consultar reservas, cancelar reservas, realizar check-in e consultar seu cartão de embarque.

Funcionário

O funcionário será responsável por operações relacionadas ao gerenciamento do aeroporto, podendo cadastrar passageiros, gerenciar voos, aeronaves, portões e reservas, além de realizar check-in e emitir cartões de embarque.

Administrador

O administrador terá funções de gerenciamento do sistema, podendo administrar funcionários, usuários, companhias aéreas, voos, aeronaves e portões de embarque.

6. Escopo

O sistema será desenvolvido como uma aplicação acadêmica, com foco no gerenciamento das informações e operações básicas de um aeroporto.

Serão contemplados:

- Passageiros;
- Funcionários;
- Administradores;
- Companhias aéreas;
- Aeronaves;
- Voos;
- Portões de embarque;
- Reservas;
- Check-in;
- Cartões de embarque.

7. Funcionalidades Fora do Escopo

Não serão implementados nesta versão:

- Controle de tráfego aéreo;
- Sistemas de radar;
- Rastreamento de aeronaves em tempo real;
- Sistemas de segurança física;
- Controle de imigração;
- Pagamentos reais;
- Integração com sistemas reais de companhias aéreas;
- Emissão oficial de documentos;
- Sistemas reais de controle de bagagem.

8. Justificativa Técnica

O domínio aeroportuário é adequado para o desenvolvimento de uma aplicação orientada a objetos por possuir diversas entidades que podem ser representadas como classes, como Pessoa, Passageiro, Funcionário, Administrador, Voo, Aeronave, Companhia Aérea, Reserva, Check-in e Portão de Embarque.

A relação entre essas entidades também permite representar conceitos importantes da Programação Orientada a Objetos. A herança pode ser utilizada para representar diferentes tipos de pessoas, enquanto o encapsulamento permite proteger os atributos das classes por meio de métodos de acesso. As associações entre voos, aeronaves, companhias aéreas, passageiros e reservas permitem representar as relações existentes no domínio.

Dessa forma, o sistema possibilita aplicar conceitos de classes, objetos, atributos, métodos, encapsulamento, herança, polimorfismo e relacionamentos entre objetos em um problema com características próximas de uma aplicação real.

9. Tecnologias

- Java;
- Programação Orientada a Objetos;
- UML para modelagem;
- Git e GitHub para controle de versão.