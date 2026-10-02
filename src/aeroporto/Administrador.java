package aeroporto;

public class Administrador extends Funcionario {

    public Administrador(String nome, String cpf, String email, String telefone, String matricula) {
        super(nome, cpf, email, telefone, matricula, "Administrador");
    }

    @Override
    public void exibirTipo() {
        System.out.println("Administrador");
    }
}