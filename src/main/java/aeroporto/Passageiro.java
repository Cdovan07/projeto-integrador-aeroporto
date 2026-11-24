package aeroporto;

public class Passageiro extends Pessoa {

    private String numeroPassaporte;
    private String senha;

    public Passageiro(String nome, String cpf, String email,
            String telefone, String numeroPassaporte) {
        super(nome, cpf, email, telefone);
        this.numeroPassaporte = numeroPassaporte;
        this.senha = "";
    }

    public Passageiro(String nome, String cpf, String email,
            String telefone, String numeroPassaporte, String senha) {
        super(nome, cpf, email, telefone);
        this.numeroPassaporte = numeroPassaporte;
        this.senha = senha;
    }

    public String getNumeroPassaporte() {
        return numeroPassaporte;
    }

    public void setNumeroPassaporte(String numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void exibirTipo() {
        System.out.println("Passageiro");
    }
}
