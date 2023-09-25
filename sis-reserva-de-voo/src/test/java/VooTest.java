import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VooTest {

    private Voo voo;

    @BeforeEach
    public void setUp() {
        voo = new Voo("F123", "GRU", "SDU", "2023-08-20", "08:00", 200.0, 150);
    }

    @Test
    public void testGetNumero() {
        assertEquals("F123", voo.getNumero());
    }

    @Test
    public void testGetOrigem() {
        assertEquals("GRU", voo.getOrigem());
    }

    @Test
    public void testGetDestino() {
        assertEquals("SDU", voo.getDestino());
    }

    @Test
    public void testGetData() {
        assertEquals("2023-08-20", voo.getData());
    }

    @Test
    public void testGetHora() {
        assertEquals("08:00", voo.getHora());
    }

    @Test
    public void testGetPreco() {
        assertEquals(200.0, voo.getPreco(), 0.001);
    }

    @Test
    public void testGetAssentosDisponiveis() {
        assertEquals(150, voo.getAssentosDisponiveis());
    }

    @Test
    public void testReservarAssento() {
        voo.reservarAssento(3);
        assertEquals(147, voo.getAssentosDisponiveis());
    }

    @Test
    public void testCancelarAssento() {
        voo.cancelarAssento(2);
        assertEquals(152, voo.getAssentosDisponiveis());
    }
}
