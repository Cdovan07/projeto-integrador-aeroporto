package aeroporto;

/**
 * Representa uma companhia aérea cadastrada no sistema do aeroporto.
 */
public class CompanhiaAerea {
    private String codigo;
    private String nome;
    private String cnpj;

    /**
     * Cria uma companhia aérea com seus dados iniciais.
     *
     * @param codigo código identificador da companhia
     * @param nome nome da companhia aérea
     * @param cnpj CNPJ da companhia aérea
     */
    public CompanhiaAerea(String codigo, String nome, String cnpj) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    /**
     * Retorna o código da companhia aérea.
     *
     * @return código da companhia
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código da companhia aérea.
     *
     * @param codigo novo código da companhia
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome da companhia aérea.
     *
     * @return nome da companhia
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da companhia aérea.
     *
     * @param nome novo nome da companhia
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CNPJ da companhia aérea.
     *
     * @return CNPJ da companhia
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ da companhia aérea.
     *
     * @param cnpj novo CNPJ da companhia
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}