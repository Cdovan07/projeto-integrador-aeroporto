
package aeroporto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static final Scanner entrada = new Scanner(System.in);
    private static final SistemaAeroporto sistema = new SistemaAeroporto();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n================================");
            System.out.println("   SISTEMA DE GERENCIAMENTO");
            System.out.println("          AEROPORTO");
            System.out.println("================================");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Cadastrar voo");
            System.out.println("4 - Listar voos");
            System.out.println("5 - Criar reserva");
            System.out.println("6 - Listar reservas");
            System.out.println("7 - Confirmar reserva");
            System.out.println("8 - Cancelar reserva");
            System.out.println("9 - Excluir passageiro");
            System.out.println("10 - Excluir voo");
            System.out.println("11 - Excluir reserva");
            System.out.println("12 - Demonstracao de POO");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro();

            try {
                switch (opcao) {
                    case 1:
                        cadastrarPassageiro();
                        break;
                    case 2:
                        listarPassageiros();
                        break;
                    case 3:
                        cadastrarVoo();
                        break;
                    case 4:
                        listarVoos();
                        break;
                    case 5:
                        criarReserva();
                        break;
                    case 6:
                        listarReservas();
                        break;
                    case 7:
                        confirmarReserva();
                        break;
                    case 8:
                        cancelarReserva();
                        break;
                    case 9:
                        excluirPassageiro();
                        break;
                    case 10:
                        excluirVoo();
                        break;
                    case 11:
                        excluirReserva();
                        break;
                    case 12:
                        demonstrarPOO();
                        break;
                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        entrada.close();
    }

    private static int lerInteiro() {
        while (!entrada.hasNextInt()) {
            System.out.print("Digite um numero valido: ");
            entrada.nextLine();
        }

        int valor = entrada.nextInt();
        entrada.nextLine();

        return valor;
    }

    private static void cadastrarPassageiro() {

        System.out.println("\n=== CADASTRAR PASSAGEIRO ===");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("Numero do passaporte: ");
        String passaporte = entrada.nextLine();

        Passageiro passageiro = new Passageiro(
                nome, cpf, email, telefone, passaporte
        );

        sistema.cadastrarPassageiro(passageiro);

        System.out.println("Passageiro cadastrado com sucesso!");
    }

    private static void listarPassageiros() {

        System.out.println("\n=== PASSAGEIROS CADASTRADOS ===");

        List<Passageiro> passageiros = sistema.listarPassageiros();

        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
            return;
        }

        for (Passageiro passageiro : passageiros) {
            System.out.println("Nome: " + passageiro.getNome());
            System.out.println("CPF: " + passageiro.getCpf());
            System.out.println("Email: " + passageiro.getEmail());
            System.out.println("----------------------------");
        }
    }

    private static void cadastrarVoo() {

        System.out.println("\n=== CADASTRAR VOO ===");

        System.out.print("Codigo do voo: ");
        String codigo = entrada.nextLine();

        System.out.print("Origem: ");
        String origem = entrada.nextLine();

        System.out.print("Destino: ");
        String destino = entrada.nextLine();

        System.out.print("Data e hora (AAAA-MM-DDTHH:MM): ");
        LocalDateTime data = LocalDateTime.parse(entrada.nextLine());

        Voo voo = new Voo(
                codigo, origem, destino, data, "Programado"
        );

        sistema.cadastrarVoo(voo);

        System.out.println("Voo cadastrado com sucesso!");
    }

    private static void listarVoos() {

        System.out.println("\n=== VOOS CADASTRADOS ===");

        List<Voo> voos = sistema.listarVoos();

        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }

        for (Voo voo : voos) {
            System.out.println(voo.consultarInformacoes());
            System.out.println("Status: " + voo.getStatus());
            System.out.println("----------------------------");
        }
    }

    private static void criarReserva() {

        System.out.println("\n=== CRIAR RESERVA ===");

        System.out.print("CPF do passageiro: ");
        String cpf = entrada.nextLine();

        Passageiro passageiro = null;

        for (Passageiro p : sistema.listarPassageiros()) {
            if (p.getCpf().equals(cpf)) {
                passageiro = p;
                break;
            }
        }

        if (passageiro == null) {
            System.out.println("Passageiro nao encontrado.");
            return;
        }

        System.out.print("Codigo do voo: ");
        String codigoVoo = entrada.nextLine();

        Voo voo = null;

        for (Voo v : sistema.listarVoos()) {
            if (v.getCodigo().equals(codigoVoo)) {
                voo = v;
                break;
            }
        }

        if (voo == null) {
            System.out.println("Voo nao encontrado.");
            return;
        }

        System.out.print("Codigo da reserva: ");
        String codigoReserva = entrada.nextLine();

        Reserva reserva = new Reserva(
                codigoReserva,
                LocalDateTime.now(),
                "Pendente",
                passageiro,
                voo
        );

        sistema.cadastrarReserva(reserva);

        System.out.println("Reserva criada com sucesso!");
    }

    private static void listarReservas() {

        System.out.println("\n=== RESERVAS CADASTRADAS ===");

        List<Reserva> reservas = sistema.listarReservas();

        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        for (Reserva reserva : reservas) {
            System.out.println("Codigo: " + reserva.getCodigo());
            System.out.println("Passageiro: "
                    + reserva.getPassageiro().getNome());
            System.out.println("Voo: "
                    + reserva.getVoo().getCodigo());
            System.out.println("Status: "
                    + reserva.consultarStatus());
            System.out.println("----------------------------");
        }
    }

    private static void confirmarReserva() {

        System.out.println("\n=== CONFIRMAR RESERVA ===");

        System.out.print("Codigo da reserva: ");
        String codigo = entrada.nextLine();

        sistema.confirmarReserva(codigo);

        System.out.println("Reserva confirmada!");
    }

    private static void cancelarReserva() {

        System.out.println("\n=== CANCELAR RESERVA ===");

        System.out.print("Codigo da reserva: ");
        String codigo = entrada.nextLine();

        sistema.cancelarReserva(codigo);

        System.out.println("Reserva cancelada!");
    }

    private static void excluirPassageiro() {

        System.out.println("\n=== EXCLUIR PASSAGEIRO ===");

        System.out.print("CPF do passageiro: ");
        String cpf = entrada.nextLine();

        sistema.excluirPassageiro(cpf);

        System.out.println("Passageiro excluido!");
    }

    private static void excluirVoo() {

        System.out.println("\n=== EXCLUIR VOO ===");

        System.out.print("Codigo do voo: ");
        String codigo = entrada.nextLine();

        sistema.excluirVoo(codigo);

        System.out.println("Voo excluido!");
    }

    private static void excluirReserva() {

        System.out.println("\n=== EXCLUIR RESERVA ===");

        System.out.print("Codigo da reserva: ");
        String codigo = entrada.nextLine();

        sistema.excluirReserva(codigo);

        System.out.println("Reserva excluida!");
    }

    private static void demonstrarPOO() {

        System.out.println("\n=== DEMONSTRACAO DE POO ===");

        Pessoa pessoa1 = new Passageiro(
                "Joao",
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

        System.out.println("\nPassageiro:");
        pessoa1.exibirTipo();

        System.out.println("\nFuncionario:");
        pessoa2.exibirTipo();

        System.out.println("\nPolimorfismo demonstrado com sucesso!");
    }
}
