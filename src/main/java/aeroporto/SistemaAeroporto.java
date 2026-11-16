package aeroporto;

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

    public void cadastrarPassageiro(Passageiro passageiro) {
        if (passageiro == null) {
            throw new DadosInvalidosException("Passageiro inválido.");
        }

        if (passageiro.getCpf() == null || passageiro.getCpf().isBlank()) {
            throw new DadosInvalidosException("O CPF do passageiro é obrigatório.");
        }

        if (cpfsCadastrados.contains(passageiro.getCpf())) {
            throw new CadastroDuplicadoException("Já existe um passageiro com esse CPF.");
        }

        passageiros.add(passageiro);
        cpfsCadastrados.add(passageiro.getCpf());
    }

    public void cadastrarVoo(Voo voo) {
        if (voo == null) {
            throw new DadosInvalidosException("Voo inválido.");
        }

        if (voo.getCodigo() == null || voo.getCodigo().isBlank()) {
            throw new DadosInvalidosException("O código do voo é obrigatório.");
        }

        if (codigosVoos.contains(voo.getCodigo())) {
            throw new CadastroDuplicadoException("Já existe um voo com esse código.");
        }

        voos.add(voo);
        codigosVoos.add(voo.getCodigo());
    }

    public void cadastrarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new DadosInvalidosException("Reserva inválida.");
        }

        if (reserva.getCodigo() == null || reserva.getCodigo().isBlank()) {
            throw new DadosInvalidosException("O código da reserva é obrigatório.");
        }

        if (reservas.containsKey(reserva.getCodigo())) {
            throw new CadastroDuplicadoException("Já existe uma reserva com esse código.");
        }

        reservas.put(reserva.getCodigo(), reserva);
    }

    public Reserva consultarReserva(String codigo) {
        Reserva reserva = reservas.get(codigo);

        if (reserva == null) {
            throw new ReservaNaoEncontradaException("Reserva não encontrada: " + codigo);
        }

        return reserva;
    }

    public void cancelarReserva(String codigo) {
        Reserva reserva = consultarReserva(codigo);
        reserva.cancelar();
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
