package aeroporto;

/**
 * Define os comportamentos possíveis dos estados de uma reserva.
 * Faz parte da implementação do padrão State.
 */
public interface EstadoReserva {

    /**
     * Confirma uma reserva.
     *
     * @param reserva reserva que terá seu estado alterado
     */
    void confirmar(Reserva reserva);

    /**
     * Cancela uma reserva.
     *
     * @param reserva reserva que terá seu estado alterado
     */
    void cancelar(Reserva reserva);

    /**
     * Retorna o nome do estado atual.
     *
     * @return nome do estado
     */
    String getNome();
}
