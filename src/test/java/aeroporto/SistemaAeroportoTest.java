package aeroporto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

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

    @Test
    void deveConfirmarReservaPendente() {
        Reserva reserva = new Reserva(
                "R001",
                LocalDateTime.now(),
                "Pendente",
                null,
                null
        );

        reserva.confirmar();

        assertEquals("Confirmada", reserva.getStatus());
    }

    @Test
    void deveCancelarReservaPendente() {
        Reserva reserva = new Reserva(
                "R002",
                LocalDateTime.now(),
                "Pendente",
                null,
                null
        );

        reserva.cancelar();

        assertEquals("Cancelada", reserva.getStatus());
    }

    @Test
    void deveCancelarReservaConfirmada() {
        Reserva reserva = new Reserva(
                "R003",
                LocalDateTime.now(),
                "Confirmada",
                null,
                null
        );

        reserva.cancelar();

        assertEquals("Cancelada", reserva.getStatus());
    }

    @Test
    void naoDeveConfirmarReservaCancelada() {
        Reserva reserva = new Reserva(
                "R004",
                LocalDateTime.now(),
                "Cancelada",
                null,
                null
        );

        assertThrows(
                IllegalStateException.class,
                () -> reserva.confirmar()
        );
    }


    @Test
    void deveNotificarPassageiroQuandoStatusDoVooMudar() {
        Voo voo = new Voo(
                "LA123",
                "Recife",
                "Sao Paulo",
                LocalDateTime.now(),
                "Programado"
        );

        NotificadorPassageiro notificador =
                new NotificadorPassageiro("Ana");

        voo.adicionarObservador(notificador);

        assertDoesNotThrow(() -> voo.alterarStatus("Cancelado"));
        assertEquals("Cancelado", voo.getStatus());
    }

    @Test
    void devePermitirRemoverObservador() {
        Voo voo = new Voo(
                "LA456",
                "Recife",
                "Salvador",
                LocalDateTime.now(),
                "Programado"
        );

        NotificadorPassageiro notificador =
                new NotificadorPassageiro("Maria");

        voo.adicionarObservador(notificador);
        voo.removerObservador(notificador);

        assertDoesNotThrow(() -> voo.alterarStatus("Atrasado"));
        assertEquals("Atrasado", voo.getStatus());
    }

    @Test
    void naoDeveAdicionarObservadorNulo() {
        Voo voo = new Voo(
                "LA789",
                "Recife",
                "Fortaleza",
                LocalDateTime.now(),
                "Programado"
        );

        voo.adicionarObservador(null);

        assertDoesNotThrow(() -> voo.alterarStatus("Cancelado"));
    }

}
