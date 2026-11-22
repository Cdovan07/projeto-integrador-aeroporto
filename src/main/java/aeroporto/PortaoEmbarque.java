package aeroporto;

/**
 * Representa um portão de embarque do aeroporto.
 * Armazena seu número, terminal e status de funcionamento.
 */
public class PortaoEmbarque {
    private int numero;
    private String terminal;
    private String status;

    /**
     * Cria um portão de embarque com seus dados iniciais.
     *
     * @param numero número identificador do portão
     * @param terminal terminal onde o portão está localizado
     * @param status situação atual do portão
     */
    public PortaoEmbarque(int numero, String terminal, String status) {
        this.numero = numero;
        this.terminal = terminal;
        this.status = status;
    }

    /**
     * Retorna o número do portão de embarque.
     *
     * @return número do portão
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número do portão de embarque.
     *
     * @param numero novo número do portão
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Retorna o terminal do portão.
     *
     * @return terminal do portão
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Define o terminal do portão.
     *
     * @param terminal novo terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * Retorna o status atual do portão.
     *
     * @return status do portão
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do portão.
     *
     * @param status novo status do portão
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Abre o embarque no portão, atualizando seu status.
     */
    public void abrirEmbarque() {
        status = "Embarque aberto";
    }

    /**
     * Fecha o embarque no portão, atualizando seu status.
     */
    public void fecharEmbarque() {
        status = "Embarque fechado";
    }

    /**
     * Consulta o status atual do portão.
     *
     * @return status do portão
     */
    public String consultarStatus() {
        return status;
    }
}