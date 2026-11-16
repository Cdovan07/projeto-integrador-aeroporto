package aeroporto;

import java.time.LocalDateTime;

public class Reserva {
    private String codigo;
    private LocalDateTime dataReserva;
    private String status;

    private Passageiro passageiro;
    private Voo voo;

    public Reserva(String codigo, LocalDateTime dataReserva, String status,
                   Passageiro passageiro, Voo voo) {
        this.codigo = codigo;
        this.dataReserva = dataReserva;
        this.status = status;
        this.passageiro = passageiro;
        this.voo = voo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public void confirmar() {
        status = "Confirmada";
    }

    public void cancelar() {
        status = "Cancelada";
    }

    public String consultarStatus() {
        return status;
    }
}