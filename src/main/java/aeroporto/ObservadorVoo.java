package aeroporto;

/**
 * Define a interface dos observadores de alterações em voos.
 * Faz parte da implementação do padrão Observer.
 */
public interface ObservadorVoo {

    /**
     * Recebe uma atualização quando o status de um voo é alterado.
     *
     * @param codigoVoo código identificador do voo
     * @param status novo status do voo
     */
    void atualizar(String codigoVoo, String status);
}
