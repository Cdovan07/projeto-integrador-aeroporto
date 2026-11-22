package aeroporto;

/**
 * Representa uma pessoa cadastrada no sistema do aeroporto.
 * Serve como classe base para Passageiro e Funcionario.
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    /**
     * Cria uma pessoa com seus dados pessoais.
     *
     * @param nome nome da pessoa
     * @param cpf CPF da pessoa
     * @param email email da pessoa
     * @param telefone telefone da pessoa
     */
    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome novo nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CPF da pessoa.
     *
     * @return CPF da pessoa
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf novo CPF da pessoa
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o email da pessoa.
     *
     * @return email da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da pessoa.
     *
     * @param email novo email da pessoa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o telefone da pessoa.
     *
     * @return telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     *
     * @param telefone novo telefone da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Exibe o tipo da pessoa.
     * Pode ser sobrescrito pelas classes que herdam de Pessoa.
     */
    public void exibirTipo() {
        System.out.println("Pessoa");
    }
}