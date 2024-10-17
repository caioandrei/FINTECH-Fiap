package br.com.fiap.fintech.model;

public class Gasto {
    private int idUsuario;
    private double valor;
    private String data;
    private String categoria;
    private String recorrencia;

    // Construtor
    public Gasto(int idUsuario, double valor, String data, String categoria, String recorrencia) {
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.recorrencia = recorrencia;
    }

    // Construtor sem 'ID' para Cadastro de Gastos
    public Gasto(double valor, String data, String categoria, String recorrencia) {
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.recorrencia = recorrencia;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }
}
