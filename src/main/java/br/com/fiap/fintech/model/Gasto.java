package br.com.fiap.fintech.model;

public class Gasto {
    private int idGasto;
    private int idUsuario;
    private double valor;
    private String data;

    // Construtor
    public Gasto(int idGasto, int idUsuario, double valor, String data) {
        this.idGasto = idGasto;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.data = data;
    }

    // Construtor sem 'ID' para Cadastro de Gastos
    public Gasto(int idUsuario, double valor, String data) {
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.data = data;
    }

    // Getters e Setters
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
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
