package aeroporto;

/**
 * Exceção lançada quando uma reserva solicitada não é encontrada no sistema.
 */
public class ReservaNaoEncontradaException extends RuntimeException {

    /**
     * Cria uma exceção com uma mensagem explicativa.
     *
     * @param mensagem descrição do erro ocorrido
     */
    public ReservaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}