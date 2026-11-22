package aeroporto;

/**
 * Representa um administrador do sistema do aeroporto.
 * Herda as características da classe Funcionario.
 */
public class Administrador extends Funcionario {

    /**
     * Cria um administrador com seus dados pessoais e matrícula.
     *
     * @param nome nome do administrador
     * @param cpf CPF do administrador
     * @param email email do administrador
     * @param telefone telefone do administrador
     * @param matricula matrícula do administrador
     */
    public Administrador(String nome, String cpf, String email, String telefone, String matricula) {
        super(nome, cpf, email, telefone, matricula, "Administrador");
    }

    /**
     * Exibe o tipo do funcionário.
     */
    @Override
    public void exibirTipo() {
        System.out.println("Administrador");
    }
}