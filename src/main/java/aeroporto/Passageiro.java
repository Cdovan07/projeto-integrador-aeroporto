package aeroporto;

public class Passageiro extends Pessoa {
    private String numeroPassaporte;

    public Passageiro(String nome, String cpf, String email, String telefone, String numeroPassaporte) {
        super(nome, cpf, email, telefone);
        this.numeroPassaporte = numeroPassaporte;
    }

    public String getNumeroPassaporte() {
        return numeroPassaporte;
    }

    public void setNumeroPassaporte(String numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }

    @Override
    public void exibirTipo() {
        System.out.println("Passageiro");
    }
}