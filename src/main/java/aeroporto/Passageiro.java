package aeroporto;

/**
 * Representa um passageiro cadastrado no sistema do aeroporto.
 * Herda os dados pessoais da classe Pessoa.
 */
public class Passageiro extends Pessoa {
    private String numeroPassaporte;

    /**
     * Cria um passageiro com seus dados pessoais e número do passaporte.
     *
     * @param nome nome do passageiro
     * @param cpf CPF do passageiro
     * @param email email do passageiro
     * @param telefone telefone do passageiro
     * @param numeroPassaporte número do passaporte do passageiro
     */
    public Passageiro(String nome, String cpf, String email, String telefone, String numeroPassaporte) {
        super(nome, cpf, email, telefone);
        this.numeroPassaporte = numeroPassaporte;
    }

    /**
     * Retorna o número do passaporte do passageiro.
     *
     * @return número do passaporte
     */
    public String getNumeroPassaporte() {
        return numeroPassaporte;
    }

    /**
     * Define o número do passaporte do passageiro.
     *
     * @param numeroPassaporte novo número do passaporte
     */
    public void setNumeroPassaporte(String numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }

    /**
     * Exibe o tipo da pessoa, identificando-a como passageiro.
     */
    @Override
    public void exibirTipo() {
        System.out.println("Passageiro");
    }
}