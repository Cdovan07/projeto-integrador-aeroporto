package aeroporto;

/**
 * Representa uma aeronave cadastrada no sistema do aeroporto.
 */
public class Aeronave {
    private String codigo;
    private String modelo;
    private int capacidade;
    private String status;

    /**
     * Cria uma aeronave com seus dados iniciais.
     *
     * @param codigo código identificador da aeronave
     * @param modelo modelo da aeronave
     * @param capacidade quantidade máxima de passageiros
     * @param status situação atual da aeronave
     */
    public Aeronave(String codigo, String modelo, int capacidade, String status) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.status = status;
    }

    /**
     * Retorna o código da aeronave.
     *
     * @return código da aeronave
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código da aeronave.
     *
     * @param codigo novo código da aeronave
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o modelo da aeronave.
     *
     * @return modelo da aeronave
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo da aeronave.
     *
     * @param modelo novo modelo da aeronave
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna a capacidade da aeronave.
     *
     * @return quantidade máxima de passageiros
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade da aeronave.
     *
     * @param capacidade nova capacidade da aeronave
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Retorna o status da aeronave.
     *
     * @return status atual da aeronave
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status da aeronave.
     *
     * @param status novo status da aeronave
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Atualiza o status da aeronave.
     *
     * @param status novo status da aeronave
     */
    public void atualizarStatus(String status) {
        this.status = status;
    }
}