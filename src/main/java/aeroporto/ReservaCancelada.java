package aeroporto;

/**
 * Representa uma reserva que foi cancelada.
 * Não permite confirmar ou cancelar novamente a reserva.
 */
public class ReservaCancelada implements EstadoReserva {

    /**
     * Cria um estado de reserva cancelada.
     */
    public ReservaCancelada() {
    }

    /**
     * Impede a confirmação de uma reserva cancelada.
     *
     * @param reserva reserva que seria confirmada
     * @throws IllegalStateException se a reserva estiver cancelada
     */
    @Override
    public void confirmar(Reserva reserva) {
        throw new IllegalStateException("Não é possível confirmar uma reserva cancelada.");
    }

    /**
     * Impede o cancelamento de uma reserva já cancelada.
     *
     * @param reserva reserva que seria cancelada
     * @throws IllegalStateException se a reserva já estiver cancelada
     */
    @Override
    public void cancelar(Reserva reserva) {
        throw new IllegalStateException("A reserva já está cancelada.");
    }

    /**
     * Retorna o nome do estado.
     *
     * @return nome do estado
     */
    @Override
    public String getNome() {
        return "Cancelada";
    }
}