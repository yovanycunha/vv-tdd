public class Voo {
    private String numero;
    private String origem;
    private String destino;
    private String data;
    private String hora;
    private double preco;
    private int assentosDisponiveis;


    public Voo(String numero, String origem, String destino, String date, String time, double preco, int assentosDisponiveis) {

        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.data = date;
        this.hora = time;
        this.preco = preco;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public double getPreco() {
        return preco;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void reservarAssento(int numeroAssentos) {
        assentosDisponiveis -= numeroAssentos;
    }

    public void cancelarAssento(int numeroAssentos) {
        assentosDisponiveis += numeroAssentos;
    }
}
