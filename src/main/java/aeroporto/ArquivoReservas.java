package aeroporto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Responsável por salvar e ler os dados das reservas em um arquivo de texto.
 */
public class ArquivoReservas {

    private static final Path CAMINHO = Path.of("dados", "reservas.txt");

    /**
     * Salva as reservas cadastradas no arquivo reservas.txt.
     * Cada linha contém o código da reserva, CPF do passageiro,
     * código do voo e status da reserva.
     *
     * @param reservas lista de reservas que será salva
     * @throws RuntimeException se ocorrer um erro durante a gravação
     */
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

    /**
     * Lê as informações das reservas armazenadas no arquivo.
     *
     * @return lista contendo as linhas do arquivo ou uma lista vazia
     *         caso o arquivo ainda não exista
     * @throws RuntimeException se ocorrer um erro durante a leitura
     */
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