package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.GastoDao;
import br.com.fiap.fintech.model.Gasto;

import java.sql.SQLException;
import java.util.List;

public class RegisterGastoView {

    public static void main(String[] args) {
        // Cadastrar um novo gasto
       cadastrarGasto();

        // Listar todos os gastos
        listarGastos();
    }

    private static void cadastrarGasto() {
        try {
            GastoDao dao = new GastoDao();
            // Crie um gasto com os dados desejados
            Gasto gasto = new Gasto(25, 150.75, "2024-10-16"); // Troque "25" pelo ID do usuário desejado
            dao.cadastrar(gasto);
            dao.fecharConexao();
            System.out.println("Gasto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar gasto: " + e.getMessage());
        }
    }

    private static void listarGastos() {
        try {
            GastoDao dao = new GastoDao();
            List<Gasto> gastos = dao.listar();

            if (gastos.isEmpty()) {
                System.out.println("Nenhum gasto encontrado.");
            } else {
                System.out.println("Gastos cadastrados:");
                for (Gasto gasto : gastos) {
                    System.out.println("ID: " + gasto.getIdGasto());
                    System.out.println("ID Usuário: " + gasto.getIdUsuario());
                    System.out.println("Valor: " + gasto.getValor());
                    System.out.println("Data: " + gasto.getData());
                    System.out.println("-----------------------------");
                }
            }

            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao consultar gastos: " + e.getMessage());
        }
    }
}
