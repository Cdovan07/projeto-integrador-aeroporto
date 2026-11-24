package aeroporto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ArquivoDadosAeroporto {

    private final Path pasta = Path.of("dados");

    private final Path arquivoPassageiros =
            pasta.resolve("passageiros.txt");

    private final Path arquivoVoos =
            pasta.resolve("voos.txt");

    private final Path arquivoReservas =
            pasta.resolve("reservas-interface.txt");

    private String codificar(String valor) {
        if (valor == null) {
            valor = "";
        }

        return Base64.getEncoder().encodeToString(
                valor.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String decodificar(String valor) {
        return new String(
                Base64.getDecoder().decode(valor),
                StandardCharsets.UTF_8
        );
    }

    private void salvarLinhas(Path caminho, List<String> linhas) {
        try {
            Files.createDirectories(pasta);

            Files.write(
                    caminho,
                    linhas,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

        } catch (IOException erro) {
            throw new RuntimeException(
                    "Erro ao salvar os dados em " + caminho + ".", erro
            );
        }
    }

    private List<String> lerLinhas(Path caminho) {
        try {
            if (!Files.exists(caminho)) {
                return List.of();
            }

            return Files.readAllLines(
                    caminho,
                    StandardCharsets.UTF_8
            );

        } catch (IOException erro) {
            throw new RuntimeException(
                    "Erro ao ler os dados de " + caminho + ".", erro
            );
        }
    }

    public void salvarPassageiros(List<Passageiro> passageiros) {
        List<String> linhas = new ArrayList<>();

        for (Passageiro passageiro : passageiros) {
            linhas.add(
                    codificar(passageiro.getNome()) + ";" +
                    codificar(passageiro.getCpf()) + ";" +
                    codificar(passageiro.getEmail()) + ";" +
                    codificar(passageiro.getTelefone()) + ";" +
                    codificar(passageiro.getNumeroPassaporte()) + ";" +
                    codificar(passageiro.getSenha())
            );
        }

        salvarLinhas(arquivoPassageiros, linhas);
    }

    public List<String[]> lerPassageiros() {
        List<String[]> passageiros = new ArrayList<>();

        for (String linha : lerLinhas(arquivoPassageiros)) {
            String[] dados = linha.split(";", -1);

            if (dados.length == 5 || dados.length == 6) {
                passageiros.add(new String[]{
                    decodificar(dados[0]),
                    decodificar(dados[1]),
                    decodificar(dados[2]),
                    decodificar(dados[3]),
                    decodificar(dados[4]),
                    dados.length == 6 ? decodificar(dados[5]) : ""
                });
            }
        }

        return passageiros;
    }

    public void salvarVoos(List<Voo> voos) {
        List<String> linhas = new ArrayList<>();

        for (Voo voo : voos) {
            linhas.add(
                    codificar(voo.getCodigo()) + ";" +
                    codificar(voo.getOrigem()) + ";" +
                    codificar(voo.getDestino()) + ";" +
                    codificar(voo.getDataHora().toString()) + ";" +
                    codificar(voo.getStatus())
            );
        }

        salvarLinhas(arquivoVoos, linhas);
    }

    public List<String[]> lerVoos() {
        List<String[]> voos = new ArrayList<>();

        for (String linha : lerLinhas(arquivoVoos)) {
            String[] dados = linha.split(";", -1);

            if (dados.length == 5) {
                voos.add(new String[]{
                    decodificar(dados[0]),
                    decodificar(dados[1]),
                    decodificar(dados[2]),
                    decodificar(dados[3]),
                    decodificar(dados[4])
                });
            }
        }

        return voos;
    }

    public void salvarReservas(List<Reserva> reservas) {
        List<String> linhas = new ArrayList<>();

        for (Reserva reserva : reservas) {
            linhas.add(
                    codificar(reserva.getCodigo()) + ";" +
                    codificar(reserva.getPassageiro().getCpf()) + ";" +
                    codificar(reserva.getVoo().getCodigo()) + ";" +
                    codificar(reserva.getDataReserva().toString()) + ";" +
                    codificar(reserva.getStatus())
            );
        }

        salvarLinhas(arquivoReservas, linhas);
    }

    public List<String[]> lerReservas() {
        List<String[]> reservas = new ArrayList<>();

        for (String linha : lerLinhas(arquivoReservas)) {
            String[] dados = linha.split(";", -1);

            if (dados.length == 5) {
                reservas.add(new String[]{
                    decodificar(dados[0]),
                    decodificar(dados[1]),
                    decodificar(dados[2]),
                    decodificar(dados[3]),
                    decodificar(dados[4])
                });
            }
        }

        return reservas;
    }
}
