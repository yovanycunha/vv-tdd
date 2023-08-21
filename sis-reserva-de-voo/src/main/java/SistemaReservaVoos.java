import java.util.ArrayList;
import java.util.Collection;

public class SistemaReservaVoos {
    private ArrayList<Voo> voos;
    private ArrayList<Reserva> reservas;

    public SistemaReservaVoos() {
        this.voos = new ArrayList<Voo>();
        this.reservas = new ArrayList<Reserva>();
    }


    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }


    public Reserva reservarVoo(Voo voo, String nomeUsuario, int qntdAssentos, String mail) {
        Reserva reserva = new Reserva(voo, nomeUsuario, qntdAssentos, mail);
        reservas.add(reserva);

        int index = voos.indexOf(voo);
        Voo vooAtual = voos.get(index);
        vooAtual.reservarAssento(qntdAssentos);
        voos.set(index, vooAtual);

        return reserva;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }


    public boolean cancelarReserva(Reserva reserva) {
        return reservas.remove(reserva);
    }
}
