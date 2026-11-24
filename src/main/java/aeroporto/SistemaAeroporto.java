package aeroporto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaAeroporto {

    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Voo> voos = new ArrayList<>();

    private Map<String, Reserva> reservas = new HashMap<>();

    private Set<String> cpfsCadastrados = new HashSet<>();
    private Set<String> codigosVoos = new HashSet<>();

    private ArquivoDadosAeroporto arquivoDados =
            new ArquivoDadosAeroporto();

    private final boolean persistenciaAtiva;
    private boolean carregandoDados = false;

    public SistemaAeroporto() {
        this(false);
    }

    public SistemaAeroporto(boolean persistenciaAtiva) {
        this.persistenciaAtiva = persistenciaAtiva;

        if (persistenciaAtiva) {
            carregandoDados = true;
            carregarDados();
            carregandoDados = false;
        }
    }

    private void carregarDados() {
        for (String[] dados : arquivoDados.lerPassageiros()) {
            Passageiro passageiro = new Passageiro(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4],
                    dados.length >= 6 ? dados[5] : ""
            );

            cadastrarPassageiro(passageiro);
        }

        for (String[] dados : arquivoDados.lerVoos()) {
            Voo voo = new Voo(
                    dados[0],
                    dados[1],
                    dados[2],
                    LocalDateTime.parse(dados[3]),
                    dados[4]
            );

            cadastrarVoo(voo);
        }

        for (String[] dados : arquivoDados.lerReservas()) {
            Passageiro passageiro = buscarPassageiro(dados[1]);
            Voo voo = buscarVoo(dados[2]);

            if (passageiro == null || voo == null) {
                throw new RuntimeException(
                        "Não foi possível recuperar a reserva "
                        + dados[0] + ": passageiro ou voo não encontrado."
                );
            }

            Reserva reserva = new Reserva(
                    dados[0],
                    LocalDateTime.parse(dados[3]),
                    dados[4],
                    passageiro,
                    voo
            );

            cadastrarReserva(reserva);
        }
    }

    private Passageiro buscarPassageiro(String cpf) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getCpf().equals(cpf)) {
                return passageiro;
            }
        }

        return null;
    }

    private Voo buscarVoo(String codigo) {
        for (Voo voo : voos) {
            if (voo.getCodigo().equals(codigo)) {
                return voo;
            }
        }

        return null;
    }

    private void salvarDados() {
        if (!persistenciaAtiva || carregandoDados) {
            return;
        }

        arquivoDados.salvarPassageiros(passageiros);
        arquivoDados.salvarVoos(voos);
        arquivoDados.salvarReservas(listarReservas());
    }

    public void cadastrarPassageiro(Passageiro passageiro) {
        if (passageiro == null) {
            throw new DadosInvalidosException("Passageiro inválido.");
        }

        if (passageiro.getCpf() == null
                || passageiro.getCpf().isBlank()) {
            throw new DadosInvalidosException(
                    "O CPF do passageiro é obrigatório."
            );
        }

        if (cpfsCadastrados.contains(passageiro.getCpf())) {
            throw new CadastroDuplicadoException(
                    "Já existe um passageiro com esse CPF."
            );
        }

        passageiros.add(passageiro);
        cpfsCadastrados.add(passageiro.getCpf());

        salvarDados();
    }

    public Passageiro autenticarPassageiro(String cpf, String senha) {
        Passageiro passageiro = buscarPassageiro(cpf);

        if (passageiro == null || !passageiro.getSenha().equals(senha)) {
            return null;
        }

        return passageiro;
    }

    public void excluirPassageiro(String cpf) {
        Passageiro passageiro = buscarPassageiro(cpf);

        if (passageiro == null) {
            throw new IllegalArgumentException(
                    "Passageiro não encontrado."
            );
        }

        for (Reserva reserva : reservas.values()) {
            if (reserva.getPassageiro().getCpf().equals(cpf)) {
                throw new IllegalStateException(
                        "Não é possível excluir este passageiro "
                        + "porque ele possui reservas cadastradas."
                );
            }
        }

        passageiros.remove(passageiro);
        cpfsCadastrados.remove(cpf);

        salvarDados();
    }

    public void cadastrarVoo(Voo voo) {
        if (voo == null) {
            throw new DadosInvalidosException("Voo inválido.");
        }

        if (voo.getCodigo() == null || voo.getCodigo().isBlank()) {
            throw new DadosInvalidosException(
                    "O código do voo é obrigatório."
            );
        }

        if (codigosVoos.contains(voo.getCodigo())) {
            throw new CadastroDuplicadoException(
                    "Já existe um voo com esse código."
            );
        }

        voos.add(voo);
        codigosVoos.add(voo.getCodigo());

        salvarDados();
    }

    public void excluirVoo(String codigo) {
        Voo voo = buscarVoo(codigo);

        if (voo == null) {
            throw new IllegalArgumentException(
                    "Voo não encontrado."
            );
        }

        for (Reserva reserva : reservas.values()) {
            if (reserva.getVoo().getCodigo().equals(codigo)) {
                throw new IllegalStateException(
                        "Não é possível excluir este voo "
                        + "porque ele possui reservas cadastradas."
                );
            }
        }

        voos.remove(voo);
        codigosVoos.remove(codigo);

        salvarDados();
    }

    public void cadastrarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new DadosInvalidosException("Reserva inválida.");
        }

        if (reserva.getCodigo() == null
                || reserva.getCodigo().isBlank()) {
            throw new DadosInvalidosException(
                    "O código da reserva é obrigatório."
            );
        }

        if (reservas.containsKey(reserva.getCodigo())) {
            throw new CadastroDuplicadoException(
                    "Já existe uma reserva com esse código."
            );
        }

        reservas.put(reserva.getCodigo(), reserva);

        salvarDados();
    }

    public void excluirReserva(String codigo) {
        Reserva reserva = reservas.remove(codigo);

        if (reserva == null) {
            throw new ReservaNaoEncontradaException(
                    "Reserva não encontrada: " + codigo
            );
        }

        salvarDados();
    }

    public Reserva consultarReserva(String codigo) {
        Reserva reserva = reservas.get(codigo);

        if (reserva == null) {
            throw new ReservaNaoEncontradaException(
                    "Reserva não encontrada: " + codigo
            );
        }

        return reserva;
    }

    public void cancelarReserva(String codigo) {
        Reserva reserva = consultarReserva(codigo);
        reserva.cancelar();

        salvarDados();
    }

    public void confirmarReserva(String codigo) {
        Reserva reserva = consultarReserva(codigo);
        reserva.confirmar();

        salvarDados();
    }

    public void alterarStatusVoo(String codigo, String novoStatus) {
        Voo voo = buscarVoo(codigo);

        if (voo == null) {
            throw new IllegalArgumentException(
                    "Voo não encontrado: " + codigo
            );
        }

        voo.alterarStatus(novoStatus);

        salvarDados();
    }

    public List<Passageiro> listarPassageiros() {
        return new ArrayList<>(passageiros);
    }

    public List<Voo> listarVoos() {
        return new ArrayList<>(voos);
    }

    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas.values());
    }
}
