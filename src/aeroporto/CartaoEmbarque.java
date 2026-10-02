package aeroporto;

public class CartaoEmbarque {
    private String codigo;
    private String assento;
    private String grupoEmbarque;

    private CheckIn checkIn;

    public CartaoEmbarque(String codigo, String assento, String grupoEmbarque, CheckIn checkIn) {
        this.codigo = codigo;
        this.assento = assento;
        this.grupoEmbarque = grupoEmbarque;
        this.checkIn = checkIn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getGrupoEmbarque() {
        return grupoEmbarque;
    }

    public void setGrupoEmbarque(String grupoEmbarque) {
        this.grupoEmbarque = grupoEmbarque;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public void emitir() {
        System.out.println("Cartão de embarque emitido.");
    }

    public String consultarDados() {
        return "Cartão: " + codigo + " | Assento: " + assento
                + " | Grupo: " + grupoEmbarque;
    }
}