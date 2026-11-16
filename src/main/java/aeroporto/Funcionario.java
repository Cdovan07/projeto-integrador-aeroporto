package aeroporto;

public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;

    public Funcionario(String nome, String cpf, String email, String telefone, String matricula, String cargo) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void exibirTipo() {
        System.out.println("Funcionário");
    }
}