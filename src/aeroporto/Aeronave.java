package aeroporto;

public class Aeronave {
    private String codigo;
    private String modelo;
    private int capacidade;
    private String status;

    public Aeronave(String codigo, String modelo, int capacidade, String status) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }
}