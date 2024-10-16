package br.com.fiap.fintech.model;

public class Recebimento {

    private int idRecebimento;
    private int idUsuario;
    private double valor;
    private String data;

    // Construtor
    public Recebimento(int idGasto, int idUsuario, double valor, String data) {
        this.idRecebimento = idGasto;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.data = data;
    }

    // Construtor sem 'ID' para Cadastro de Gastos
    public Recebimento(int idUsuario, double valor, String data) {
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.data = data;
    }

    // Getters e Setters
    public int getIdRecebimento() {
        return idRecebimento;
    }

    public void setIdRecebimento(int idRecebimento) {
        this.idRecebimento = idRecebimento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}