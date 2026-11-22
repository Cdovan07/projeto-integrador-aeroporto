package aeroporto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Gerencia os principais dados e operações do sistema do aeroporto.
 * Responsável pelo cadastro, consulta, cancelamento e listagem
 * de passageiros, voos e reservas.
 */
public class SistemaAeroporto {

    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Voo> voos = new ArrayList<>();

    private Map<String, Reserva> reservas = new HashMap<>();

    private Set<String> cpfsCadastrados = new HashSet<>();
    private Set<String> codigosVoos = new HashSet<>();

    /**
     * Cadastra um passageiro no sistema.
     *
     * @param passageiro passageiro que será cadastrado
     * @throws DadosInvalidosException se o passageiro ou seu CPF for inválido
     * @throws CadastroDuplicadoException se já existir um passageiro com o mesmo CPF
     */
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

    /**
     * Cadastra um voo no sistema.
     *
     * @param voo voo que será cadastrado
     * @throws DadosInvalidosException se o voo ou seu código for inválido
     * @throws CadastroDuplicadoException se já existir um voo com o mesmo código
     */
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

    /**
     * Cadastra uma reserva no sistema.
     *
     * @param reserva reserva que será cadastrada
     * @throws DadosInvalidosException se a reserva ou seu código for inválido
     * @throws CadastroDuplicadoException se já existir uma reserva com o mesmo código
     */
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

    /**
     * Consulta uma reserva pelo seu código.
     *
     * @param codigo código identificador da reserva
     * @return reserva encontrada
     * @throws ReservaNaoEncontradaException se não existir uma reserva com o código informado
     */
    public Reserva consultarReserva(String codigo) {
        Reserva reserva = reservas.get(codigo);

        if (reserva == null) {
            throw new ReservaNaoEncontradaException("Reserva não encontrada: " + codigo);
        }

        return reserva;
    }

    /**
     * Cancela uma reserva cadastrada no sistema.
     *
     * @param codigo código identificador da reserva
     * @throws ReservaNaoEncontradaException se a reserva não for encontrada
     * @throws IllegalStateException se o estado atual não permitir o cancelamento
     */
    public void cancelarReserva(String codigo) {
        Reserva reserva = consultarReserva(codigo);
        reserva.cancelar();
    }

    /**
     * Retorna a lista de passageiros cadastrados.
     *
     * @return nova lista contendo os passageiros cadastrados
     */
    public List<Passageiro> listarPassageiros() {
        return new ArrayList<>(passageiros);
    }

    /**
     * Retorna a lista de voos cadastrados.
     *
     * @return nova lista contendo os voos cadastrados
     */
    public List<Voo> listarVoos() {
        return new ArrayList<>(voos);
    }

    /**
     * Retorna a lista de reservas cadastradas.
     *
     * @return nova lista contendo as reservas cadastradas
     */
    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas.values());
    }
}