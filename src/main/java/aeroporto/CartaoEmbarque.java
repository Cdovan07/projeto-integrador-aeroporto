package aeroporto;

/**
 * Representa o cartão de embarque de um passageiro.
 * Armazena informações sobre o assento e o grupo de embarque.
 */
public class CartaoEmbarque {
    private String codigo;
    private String assento;
    private String grupoEmbarque;

    private CheckIn checkIn;

    /**
     * Cria um cartão de embarque com seus dados iniciais.
     *
     * @param codigo código identificador do cartão
     * @param assento assento atribuído ao passageiro
     * @param grupoEmbarque grupo de embarque do passageiro
     * @param checkIn check-in associado ao cartão
     */
    public CartaoEmbarque(String codigo, String assento, String grupoEmbarque, CheckIn checkIn) {
        this.codigo = codigo;
        this.assento = assento;
        this.grupoEmbarque = grupoEmbarque;
        this.checkIn = checkIn;
    }

    /**
     * Retorna o código do cartão de embarque.
     *
     * @return código do cartão
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do cartão de embarque.
     *
     * @param codigo novo código do cartão
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o assento atribuído ao passageiro.
     *
     * @return assento do passageiro
     */
    public String getAssento() {
        return assento;
    }

    /**
     * Define o assento do passageiro.
     *
     * @param assento novo assento
     */
    public void setAssento(String assento) {
        this.assento = assento;
    }

    /**
     * Retorna o grupo de embarque do passageiro.
     *
     * @return grupo de embarque
     */
    public String getGrupoEmbarque() {
        return grupoEmbarque;
    }

    /**
     * Define o grupo de embarque do passageiro.
     *
     * @param grupoEmbarque novo grupo de embarque
     */
    public void setGrupoEmbarque(String grupoEmbarque) {
        this.grupoEmbarque = grupoEmbarque;
    }

    /**
     * Retorna o check-in associado ao cartão.
     *
     * @return check-in associado
     */
    public CheckIn getCheckIn() {
        return checkIn;
    }

    /**
     * Define o check-in associado ao cartão.
     *
     * @param checkIn novo check-in associado
     */
    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Emite o cartão de embarque, exibindo uma mensagem no console.
     */
    public void emitir() {
        System.out.println("Cartão de embarque emitido.");
    }

    /**
     * Retorna os dados principais do cartão de embarque.
     *
     * @return informações do cartão, assento e grupo
     */
    public String consultarDados() {
        return "Cartão: " + codigo + " | Assento: " + assento
                + " | Grupo: " + grupoEmbarque;
    }
}