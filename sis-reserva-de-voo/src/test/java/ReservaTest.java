import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    private Reserva reserva;
    private Usuario usuario;
    private Voo voo;

    @BeforeEach
    public void setUp() {
        Reserva = new Reserva();
        usuario = new Usuario();
        voo = new Voo("F123", "Recife", "Rio", "2023-08-20", "08:00", 200.0, 150);
    }

    @Test
    public void testPesquisaVoos() {
        String origem = "Recife";
        String destino = "Rio";
        String data = "2023-08-20";
        int numeroPassageiros = 2;
        List<Voo> voosDisponiveis = usuario.pesquisarVoos(origem, destino, data, numeroPassageiros);
        assertEquals(false, voosDisponiveis.isEmpty());
    }

    @Test
    public void testReservaEConfirmacao() {
        usuario.reservarVoo(voo, "João Silva", 2, "joao@gmail.com");
        Reserva reserva = usuario.getReservas().get(0);
        assertEquals(voo, reserva.getVoo());
        assertEquals("João Silva", reserva.getNomePassageiro());
        assertEquals(2, reserva.getNumeroPassageiros());
        assertEquals("joao@gmail.com", reserva.getEmailContato());
        String confirmacao = Reserva.gerarConfirmacao(reserva);
        String esperado = "Detalhes da Reserva:\n" +
                "Voo: F123 - De Recife para Rio\n" +
                "Data: 2023-08-20 às 08:00\n" +
                "Preço Total: 400.0\n" +
                "Nome do Passageiro: João Silva\n" +
                "Número de Passageiros: 2\n" +
                "Email de Contato: joao@gmail.com";
        assertEquals(esperado, confirmacao);
    }

    @Test
    public void testCancelamentoReserva() {
        usuario.reservarVoo(voo, "Maria Souza", 3, "maria@gmail.com");
        Reserva reserva = usuario.getReservas().get(0);
        boolean cancelamentoSucesso = usuario.cancelarReservaPorCodigo(reserva.getCodigoReserva());
        assertEquals(true, cancelamentoSucesso);
    }
}