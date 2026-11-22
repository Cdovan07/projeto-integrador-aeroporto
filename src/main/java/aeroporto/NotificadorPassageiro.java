package aeroporto;

/**
 * Representa um passageiro que recebe notificações sobre alterações em voos.
 * Implementa a interface ObservadorVoo do padrão Observer.
 */
public class NotificadorPassageiro implements ObservadorVoo {

    private String nomePassageiro;

    /**
     * Cria um notificador associado a um passageiro.
     *
     * @param nomePassageiro nome do passageiro que receberá as notificações
     */
    public NotificadorPassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    /**
     * Exibe uma notificação sobre a alteração do status de um voo.
     *
     * @param codigoVoo código identificador do voo
     * @param status novo status do voo
     */
    @Override
    public void atualizar(String codigoVoo, String status) {
        System.out.println(
                "Notificação para " + nomePassageiro +
                ": o voo " + codigoVoo +
                " teve seu status alterado para " + status + "."
        );
    }
}
