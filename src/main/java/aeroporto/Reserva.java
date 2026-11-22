package aeroporto;

import java.time.LocalDateTime;

/**
 * Representa uma reserva de passagem aérea.
 * Utiliza o padrão State para controlar os estados da reserva.
 */
public class Reserva {
    private String codigo;
    private LocalDateTime dataReserva;
    private EstadoReserva estado;

    private Passageiro passageiro;
    private Voo voo;

    /**
     * Cria uma reserva com seus dados iniciais.
     *
     * @param codigo código identificador da reserva
     * @param dataReserva data de criação da reserva
     * @param status estado inicial da reserva
     * @param passageiro passageiro associado à reserva
     * @param voo voo associado à reserva
     */
    public Reserva(String codigo, LocalDateTime dataReserva, String status,
                   Passageiro passageiro, Voo voo) {
        this.codigo = codigo;
        this.dataReserva = dataReserva;
        this.estado = criarEstado(status);
        this.passageiro = passageiro;
        this.voo = voo;
    }

    private EstadoReserva criarEstado(String status) {
        switch (status) {
            case "Pendente":
                return new ReservaPendente();
            case "Confirmada":
                return new ReservaConfirmada();
            case "Cancelada":
                return new ReservaCancelada();
            default:
                throw new IllegalArgumentException("Status de reserva inválido.");
        }
    }

    /**
     * Retorna o código da reserva.
     *
     * @return código da reserva
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código da reserva.
     *
     * @param codigo novo código da reserva
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a data de criação da reserva.
     *
     * @return data da reserva
     */
    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    /**
     * Define a data da reserva.
     *
     * @param dataReserva nova data da reserva
     */
    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    /**
     * Retorna o nome do estado atual da reserva.
     *
     * @return estado atual da reserva
     */
    public String getStatus() {
        return estado.getNome();
    }

    /**
     * Altera o estado da reserva.
     *
     * @param status nome do novo estado
     */
    public void setStatus(String status) {
        this.estado = criarEstado(status);
    }

    /**
     * Retorna o objeto que representa o estado atual.
     *
     * @return estado atual da reserva
     */
    public EstadoReserva getEstado() {
        return estado;
    }

    /**
     * Define o objeto que representa o estado da reserva.
     *
     * @param estado novo estado da reserva
     */
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    /**
     * Retorna o passageiro associado à reserva.
     *
     * @return passageiro da reserva
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Define o passageiro associado à reserva.
     *
     * @param passageiro passageiro da reserva
     */
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    /**
     * Retorna o voo associado à reserva.
     *
     * @return voo da reserva
     */
    public Voo getVoo() {
        return voo;
    }

    /**
     * Define o voo associado à reserva.
     *
     * @param voo voo da reserva
     */
    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    /**
     * Confirma a reserva de acordo com seu estado atual.
     */
    public void confirmar() {
        estado.confirmar(this);
    }

    /**
     * Cancela a reserva de acordo com seu estado atual.
     */
    public void cancelar() {
        estado.cancelar(this);
    }

    /**
     * Consulta o estado atual da reserva.
     *
     * @return nome do estado atual
     */
    public String consultarStatus() {
        return estado.getNome();
    }
}
