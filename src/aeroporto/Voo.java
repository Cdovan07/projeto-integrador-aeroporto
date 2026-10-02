package aeroporto;

import java.time.LocalDateTime;

public class Voo {
    private String codigo;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private String status;

    private CompanhiaAerea companhiaAerea;
    private Aeronave aeronave;
    private PortaoEmbarque portaoEmbarque;

    public Voo(String codigo, String origem, String destino, LocalDateTime dataHora, String status) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public PortaoEmbarque getPortaoEmbarque() {
        return portaoEmbarque;
    }

    public void setPortaoEmbarque(PortaoEmbarque portaoEmbarque) {
        this.portaoEmbarque = portaoEmbarque;
    }

    public void alterarStatus(String status) {
        this.status = status;
    }

    public String consultarInformacoes() {
        return codigo + " - " + origem + " para " + destino;
    }

    public void definirPortao(PortaoEmbarque portaoEmbarque) {
        this.portaoEmbarque = portaoEmbarque;
    }
}