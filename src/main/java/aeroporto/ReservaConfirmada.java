package aeroporto;

/**
 * Representa uma reserva que já foi confirmada.
 * Permite cancelar a reserva, mas não confirmá-la novamente.
 */
public class ReservaConfirmada implements EstadoReserva {

    /**
     * Cria um estado de reserva confirmada.
     */
    public ReservaConfirmada() {
    }

    /**
     * Impede a confirmação de uma reserva já confirmada.
     *
     * @param reserva reserva que seria confirmada
     * @throws IllegalStateException se a reserva já estiver confirmada
     */
    @Override
    public void confirmar(Reserva reserva) {
        throw new IllegalStateException("A reserva já está confirmada.");
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
        return "Confirmada";
    }
}