package org.example.sisvoo;

public class Reserva {

    private Voo voo;
    private String nomeUsuario;
    private int qntdAssentos;
    private String mail;

    public Reserva(Voo voo, String nomeUsuario, int qntdAssentos, String mail) {
        this.voo = voo;
        this.nomeUsuario = nomeUsuario;
        this.qntdAssentos = qntdAssentos;
        this.mail = mail;
    }
}
