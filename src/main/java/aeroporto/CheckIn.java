package aeroporto;

import java.time.LocalDateTime;

/**
 * Representa o processo de check-in de uma reserva.
 * Armazena a data, o horário e o status do check-in.
 */
public class CheckIn {
    private String codigo;
    private LocalDateTime dataHora;
    private String status;

    private Reserva reserva;

    /**
     * Cria um check-in com seus dados iniciais.
     *
     * @param codigo código identificador do check-in
     * @param dataHora data e horário do check-in
     * @param status situação atual do check-in
     * @param reserva reserva associada ao check-in
     */
    public CheckIn(String codigo, LocalDateTime dataHora, String status, Reserva reserva) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.status = status;
        this.reserva = reserva;
    }

    /**
     * Retorna o código do check-in.
     *
     * @return código do check-in
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do check-in.
     *
     * @param codigo novo código do check-in
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a data e o horário do check-in.
     *
     * @return data e horário do check-in
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e o horário do check-in.
     *
     * @param dataHora nova data e horário
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Retorna o status atual do check-in.
     *
     * @return status do check-in
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do check-in.
     *
     * @param status novo status do check-in
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna a reserva associada ao check-in.
     *
     * @return reserva associada
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Define a reserva associada ao check-in.
     *
     * @param reserva nova reserva associada
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * Realiza o check-in, atualizando o status e a data e horário.
     */
    public void realizar() {
        status = "Realizado";
        dataHora = LocalDateTime.now();
    }

    /**
     * Cancela o check-in, atualizando seu status.
     */
    public void cancelar() {
        status = "Cancelado";
    }

    /**
     * Consulta o status atual do check-in.
     *
     * @return status do check-in
     */
    public String consultarStatus() {
        return status;
    }
}