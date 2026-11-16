package aeroporto;

public class PortaoEmbarque {
    private int numero;
    private String terminal;
    private String status;

    public PortaoEmbarque(int numero, String terminal, String status) {
        this.numero = numero;
        this.terminal = terminal;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void abrirEmbarque() {
        status = "Embarque aberto";
    }

    public void fecharEmbarque() {
        status = "Embarque fechado";
    }

    public String consultarStatus() {
        return status;
    }
}