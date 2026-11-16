package aeroporto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaAeroportoTest {

    @Test
    void deveCadastrarPassageiro() {
        SistemaAeroporto sistema = new SistemaAeroporto();

        Passageiro passageiro = new Passageiro(
                "Ana",
                "12345678900",
                "ana@email.com",
                "81999999999",
                "BR123456"
        );

        sistema.cadastrarPassageiro(passageiro);

        assertEquals(1, sistema.listarPassageiros().size());
        assertEquals("Ana", sistema.listarPassageiros().get(0).getNome());
    }

    @Test
    void naoDeveCadastrarPassageiroDuplicado() {
        SistemaAeroporto sistema = new SistemaAeroporto();

        Passageiro passageiro1 = new Passageiro(
                "Ana",
                "12345678900",
                "ana@email.com",
                "81999999999",
                "BR123456"
        );

        Passageiro passageiro2 = new Passageiro(
                "Maria",
                "12345678900",
                "maria@email.com",
                "81988888888",
                "BR654321"
        );

        sistema.cadastrarPassageiro(passageiro1);

        assertThrows(
                CadastroDuplicadoException.class,
                () -> sistema.cadastrarPassageiro(passageiro2)
        );
    }

    @Test
    void naoDeveCadastrarPassageiroNulo() {
        SistemaAeroporto sistema = new SistemaAeroporto();

        assertThrows(
                DadosInvalidosException.class,
                () -> sistema.cadastrarPassageiro(null)
        );
    }

    @Test
    void naoDeveCadastrarPassageiroSemCpf() {
        SistemaAeroporto sistema = new SistemaAeroporto();

        Passageiro passageiro = new Passageiro(
                "Ana",
                "",
                "ana@email.com",
                "81999999999",
                "BR123456"
        );

        assertThrows(
                DadosInvalidosException.class,
                () -> sistema.cadastrarPassageiro(passageiro)
        );
    }
}
