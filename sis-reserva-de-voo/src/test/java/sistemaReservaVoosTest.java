import org.example.sisvoo.Reserva;
import org.example.sisvoo.SistemaReservaVoos;
import org.example.sisvoo.Voo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class sistemaReservaVoosTest {
    private SistemaReservaVoos sistema;
    private Voo voo1;
    private Voo voo2;
    private Reserva reserva1;
    private Reserva reserva2;

    @BeforeEach
    @DisplayName("Configura o sistema de reserva de voos")
    @Order(0)
    public void setUp() {
        sistema = new SistemaReservaVoos();
        voo1 = new Voo("F123","São Paulo", "Rio de Janeiro", "2023-09-15", " 08:30", 220.00, 100);
        voo2 = new Voo("F12","Brasília", "Salvador", "2023-10-05", " 14:15", 280.50, 120);
        sistema.adicionarVoo(voo1);
        sistema.adicionarVoo(voo2);
        reserva1 = sistema.reservarVoo(voo1, "João da Silva", 2, "joao@email.com");
        reserva2 = sistema.reservarVoo(voo2, "Maria Souza", 1, "maria@email.com");
    }

    @Test
    @DisplayName("Adiciona um voo ao sistema")
    @Order(1)
    public void adicionarVooTest() {
        assertTrue(sistema.getVoos().contains(voo1));
    }

    @Test
    @DisplayName("org.example.sisvoo.Reserva um voo")
    @Order(1)
    public void reservarVooTest() {
        assertNotNull(reserva1);
        assertTrue(sistema.getReservas().contains(reserva1));
    }

   @Test
   @DisplayName("Cancela uma reserva")
   @Order(3)
   public void cancelarReservaTest() {
       assertTrue(sistema.cancelarReserva(reserva2));
       assertFalse(sistema.getReservas().contains(reserva2));
    }

    @Test
    @DisplayName("Exibe os voos disponíveis")
    @Order(2)
    public void exibirVoosTest() {
        ArrayList<Voo> voosEsperados = new ArrayList<>();
        voosEsperados.add(voo1);
        voosEsperados.add(voo2);

        ArrayList<Voo> voosExibidos = sistema.getVoos();

        assertEquals(voosEsperados.size(), voosExibidos.size());
    }
}
