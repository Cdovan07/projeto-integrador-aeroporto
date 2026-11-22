package aeroporto;

/**
 * Representa um funcionário do aeroporto.
 * Herda os dados pessoais da classe Pessoa.
 */
public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;

    /**
     * Cria um funcionário com seus dados pessoais e profissionais.
     *
     * @param nome nome do funcionário
     * @param cpf CPF do funcionário
     * @param email email do funcionário
     * @param telefone telefone do funcionário
     * @param matricula matrícula do funcionário
     * @param cargo cargo ocupado pelo funcionário
     */
    public Funcionario(String nome, String cpf, String email, String telefone, String matricula, String cargo) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    /**
     * Retorna a matrícula do funcionário.
     *
     * @return matrícula do funcionário
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define a matrícula do funcionário.
     *
     * @param matricula nova matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Retorna o cargo do funcionário.
     *
     * @return cargo do funcionário
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário.
     *
     * @param cargo novo cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Exibe o tipo da pessoa, identificando-a como funcionário.
     */
    @Override
    public void exibirTipo() {
        System.out.println("Funcionário");
    }
}