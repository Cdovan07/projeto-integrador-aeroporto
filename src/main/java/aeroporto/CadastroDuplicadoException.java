package aeroporto;

/**
 * Exceção lançada quando ocorre uma tentativa de realizar um cadastro duplicado.
 */
public class CadastroDuplicadoException extends RuntimeException {

    /**
     * Cria uma exceção com uma mensagem explicativa.
     *
     * @param mensagem descrição do erro ocorrido
     */
    public CadastroDuplicadoException(String mensagem) {
        super(mensagem);
    }
}