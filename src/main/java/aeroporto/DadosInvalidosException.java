package aeroporto;

/**
 * Exceção lançada quando os dados informados são inválidos.
 */
public class DadosInvalidosException extends RuntimeException {

    /**
     * Cria uma exceção com uma mensagem explicativa.
     *
     * @param mensagem descrição dos dados inválidos
     */
    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}