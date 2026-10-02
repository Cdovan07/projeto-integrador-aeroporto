package aeroporto;

import java.time.LocalDateTime;

public class CheckIn {
    private String codigo;
    private LocalDateTime dataHora;
    private String status;

    private Reserva reserva;

    public CheckIn(String codigo, LocalDateTime dataHora, String status, Reserva reserva) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.status = status;
        this.reserva = reserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void realizar() {
        status = "Realizado";
        dataHora = LocalDateTime.now();
    }

    public void cancelar() {
        status = "Cancelado";
    }

    public String consultarStatus() {
        return status;
    }
}