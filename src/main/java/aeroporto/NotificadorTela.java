package aeroporto;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NotificadorTela implements ObservadorVoo {

    private JTextArea areaNotificacoes;

    public NotificadorTela(JTextArea areaNotificacoes) {
        this.areaNotificacoes = areaNotificacoes;
    }

    @Override
    public void atualizar(String codigoVoo, String status) {
        SwingUtilities.invokeLater(() -> {
            areaNotificacoes.append(
                    "O voo " + codigoVoo +
                    " teve seu status alterado para " + status + ".\n"
            );
        });
    }
}
