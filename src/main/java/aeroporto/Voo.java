package aeroporto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um voo do sistema aeroportuário.
 * Utiliza o padrão Observer para notificar interessados
 * quando o status do voo é alterado.
 */
public class Voo {
    private String codigo;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private String status;

    private CompanhiaAerea companhiaAerea;
    private Aeronave aeronave;
    private PortaoEmbarque portaoEmbarque;

    private List<ObservadorVoo> observadores = new ArrayList<>();

    /**
     * Cria um voo com suas informações iniciais.
     *
     * @param codigo código identificador do voo
     * @param origem cidade de origem
     * @param destino cidade de destino
     * @param dataHora data e horário do voo
     * @param status situação inicial do voo
     */
    public Voo(String codigo, String origem, String destino, LocalDateTime dataHora, String status) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.status = status;
    }

    /**
     * Retorna o código do voo.
     *
     * @return código do voo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do voo.
     *
     * @param codigo novo código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a origem do voo.
     *
     * @return cidade de origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Define a origem do voo.
     *
     * @param origem nova origem
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * Retorna o destino do voo.
     *
     * @return cidade de destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define o destino do voo.
     *
     * @param destino novo destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Retorna a data e o horário do voo.
     *
     * @return data e horário do voo
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e o horário do voo.
     *
     * @param dataHora nova data e horário
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Retorna o status atual do voo.
     *
     * @return status do voo
     */
    public String getStatus() {
        return status;
    }

    /**
     * Altera o status do voo e notifica os observadores.
     *
     * @param status novo status do voo
     */
    public void setStatus(String status) {
        alterarStatus(status);
    }

    /**
     * Retorna a companhia aérea responsável pelo voo.
     *
     * @return companhia aérea
     */
    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    /**
     * Define a companhia aérea responsável pelo voo.
     *
     * @param companhiaAerea companhia aérea
     */
    public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    /**
     * Retorna a aeronave associada ao voo.
     *
     * @return aeronave do voo
     */
    public Aeronave getAeronave() {
        return aeronave;
    }

    /**
     * Define a aeronave associada ao voo.
     *
     * @param aeronave aeronave do voo
     */
    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    /**
     * Retorna o portão de embarque do voo.
     *
     * @return portão de embarque
     */
    public PortaoEmbarque getPortaoEmbarque() {
        return portaoEmbarque;
    }

    /**
     * Define o portão de embarque do voo.
     *
     * @param portaoEmbarque portão de embarque
     */
    public void setPortaoEmbarque(PortaoEmbarque portaoEmbarque) {
        this.portaoEmbarque = portaoEmbarque;
    }

    /**
     * Adiciona um observador para receber notificações do voo.
     *
     * @param observador observador que será cadastrado
     */
    public void adicionarObservador(ObservadorVoo observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    /**
     * Remove um observador da lista de notificações.
     *
     * @param observador observador que será removido
     */
    public void removerObservador(ObservadorVoo observador) {
        observadores.remove(observador);
    }

    /**
     * Envia uma atualização para todos os observadores cadastrados.
     */
    private void notificarObservadores() {
        for (ObservadorVoo observador : observadores) {
            observador.atualizar(codigo, status);
        }
    }

    /**
     * Altera o status do voo e informa todos os observadores.
     *
     * @param status novo status do voo
     */
    public void alterarStatus(String status) {
        this.status = status;
        notificarObservadores();
    }

    /**
     * Retorna um resumo das informações do voo.
     *
     * @return código, origem e destino do voo
     */
    public String consultarInformacoes() {
        return codigo + " - " + origem + " para " + destino;
    }

    /**
     * Define o portão de embarque do voo.
     *
     * @param portaoEmbarque portão de embarque
     */
    public void definirPortao(PortaoEmbarque portaoEmbarque) {
        this.portaoEmbarque = portaoEmbarque;
    }
}
