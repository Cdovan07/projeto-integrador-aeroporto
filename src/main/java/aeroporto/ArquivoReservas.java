package aeroporto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ArquivoReservas {

    private static final Path CAMINHO = Path.of("dados", "reservas.txt");

    public void salvarReservas(List<Reserva> reservas) {
        try {
            Files.createDirectories(CAMINHO.getParent());

            List<String> linhas = reservas.stream()
                    .map(reserva -> reserva.getCodigo() + ";" +
                            reserva.getPassageiro().getCpf() + ";" +
                            reserva.getVoo().getCodigo() + ";" +
                            reserva.getStatus())
                    .toList();

            Files.write(
                    CAMINHO,
                    linhas,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar as reservas.", e);
        }
    }

    public List<String> lerReservas() {
        try {
            if (!Files.exists(CAMINHO)) {
                return List.of();
            }

            return Files.readAllLines(CAMINHO, StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler as reservas.", e);
        }
    }
}
