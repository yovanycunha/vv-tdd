import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class sistemaReservaVoosTest {
    private SistemaReservaVoos sistema;
    private Voo voo1;
    private Voo voo2;
    private Reserva reserva1;
    private Reserva reserva2;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaReservaVoos();
        Voo voo1 = new Voo("São Paulo", "Rio de Janeiro", "2023-09-15 08:30", 220.00, 100);
        Voo voo2 = new Voo("Brasília", "Salvador", "2023-10-05 14:15", 280.50, 120);
        sistema.adicionarVoo(voo1);
        sistema.adicionarVoo(voo2);
        reserva1 = sistema.reservarVoo(voo1, "João da Silva", 2, "joao@email.com");
        reserva2 = sistema.reservarVoo(voo2, "Maria Souza", 1, "maria@email.com");
    }

    @Test
    public void adicionarVooTest() {
        assertTrue(sistema.getVoos().contains(voo1));
    }

    @Test
    public void reservarVooTest() {
        assertNotNull(reserva1);
        assertTrue(sistema.getReservas().contains(reserva1));
    }

    @Test
    public void cancelarReservaTest() {
        assertTrue(sistema.cancelarReserva(reserva2.getCodigoReserva()));
        assertFalse(sistema.getReservas().contains(reserva2));
    }

    @Test
    public void exibirVoosTest() {
        List<Voo> voosEsperados = new ArrayList<>();
        voosEsperados.add(voo1);
        voosEsperados.add(voo2);

        List<Voo> voosExibidos = sistema.getListaDeVoos();

        assertEquals(voosEsperados.size(), voosExibidos.size());
    }
}
