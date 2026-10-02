package aeroporto;

import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {

        CompanhiaAerea companhia = new CompanhiaAerea(
                "LA",
                "LATAM",
                "12345678000100"
        );

        Aeronave aeronave = new Aeronave(
                "A001",
                "Airbus A320",
                180,
                "Disponível"
        );

        PortaoEmbarque portao = new PortaoEmbarque(
                10,
                "Terminal 1",
                "Fechado"
        );

        Passageiro passageiro = new Passageiro(
                "Eduardo",
                "12345678900",
                "eduardo@email.com",
                "81999999999",
                "BR123456"
        );

        Funcionario funcionario = new Funcionario(
                "Carlos",
                "98765432100",
                "carlos@email.com",
                "81988888888",
                "F001",
                "Atendente"
        );

        Administrador administrador = new Administrador(
                "Ana",
                "11122233344",
                "ana@email.com",
                "81977777777",
                "A001"
        );

        Voo voo = new Voo(
                "LA123",
                "Recife",
                "São Paulo",
                LocalDateTime.of(2026, 10, 2, 14, 30),
                "Programado"
        );

        voo.setCompanhiaAerea(companhia);
        voo.setAeronave(aeronave);
        voo.setPortaoEmbarque(portao);

        Reserva reserva = new Reserva(
                "R001",
                LocalDateTime.now(),
                "Pendente",
                passageiro,
                voo
        );

        CheckIn checkIn = new CheckIn(
                "C001",
                LocalDateTime.now(),
                "Pendente",
                reserva
        );

        CartaoEmbarque cartao = new CartaoEmbarque(
                "CE001",
                "12A",
                "Grupo 1",
                checkIn
        );

        System.out.println("=== TESTE DO SISTEMA ===");

        System.out.println("\nPassageiro:");
        System.out.println(passageiro.getNome());
        passageiro.exibirTipo();

        System.out.println("\nFuncionário:");
        System.out.println(funcionario.getNome());
        funcionario.exibirTipo();

        System.out.println("\nAdministrador:");
        System.out.println(administrador.getNome());
        administrador.exibirTipo();

        System.out.println("\nVoo:");
        System.out.println(voo.consultarInformacoes());
        System.out.println("Status: " + voo.getStatus());

        System.out.println("\nReserva:");
        System.out.println("Status: " + reserva.consultarStatus());
        reserva.confirmar();
        System.out.println("Status após confirmação: " + reserva.consultarStatus());

        System.out.println("\nCheck-in:");
        System.out.println("Status: " + checkIn.consultarStatus());
        checkIn.realizar();
        System.out.println("Status após realização: " + checkIn.consultarStatus());

        System.out.println("\nCartão de embarque:");
        cartao.emitir();
        System.out.println(cartao.consultarDados());

        System.out.println("\nPortão:");
        portao.abrirEmbarque();
        System.out.println(portao.consultarStatus());

        System.out.println("\n=== TESTE DE POLIMORFISMO ===");

        Pessoa pessoa1 = new Passageiro(
                "João",
                "22233344455",
                "joao@email.com",
                "81966666666",
                "BR654321"
        );

        Pessoa pessoa2 = new Funcionario(
                "Maria",
                "55566677788",
                "maria@email.com",
                "81955555555",
                "F002",
                "Atendente"
        );

        pessoa1.exibirTipo();
        pessoa2.exibirTipo();
    }
}