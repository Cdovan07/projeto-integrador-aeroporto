package aeroporto;

/**
 * Representa uma reserva que ainda está pendente.
 * Permite confirmar ou cancelar a reserva.
 */
public class ReservaPendente implements EstadoReserva {

    /**
     * Cria um estado de reserva pendente.
     */
    public ReservaPendente() {
    }

    /**
     * Altera o estado da reserva para confirmada.
     *
     * @param reserva reserva que será confirmada
     */
    @Override
    public void confirmar(Reserva reserva) {
        reserva.setEstado(new ReservaConfirmada());
    }

    /**
     * Altera o estado da reserva para cancelada.
     *
     * @param reserva reserva que será cancelada
     */
    @Override
    public void cancelar(Reserva reserva) {
        reserva.setEstado(new ReservaCancelada());
    }

    /**
     * Retorna o nome do estado.
     *
     * @return nome do estado
     */
    @Override
    public String getNome() {
        return "Pendente";
    }
}