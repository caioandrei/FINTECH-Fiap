package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.GastoDao;
import br.com.fiap.fintech.model.Gasto;
import java.sql.SQLException;
import java.util.List;

public class RegisterGastoView {

    public static void main(String[] args) {
        try {
            GastoDao dao = new GastoDao();
            cadastrarGastos(dao);
            listarGastos(dao);

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    private static void cadastrarGastos(GastoDao dao) {
        try {
            Gasto gasto1 = new Gasto(25, 150.75, "2024-10-16");
            Gasto gasto2 = new Gasto(25, 200.00, "2024-10-17");
            Gasto gasto3 = new Gasto(25, 50.25, "2024-10-18");
            Gasto gasto4 = new Gasto(25, 300.00, "2024-10-19");
            Gasto gasto5 = new Gasto(25, 100.75, "2024-10-20");

            dao.cadastrar(gasto1);
            dao.cadastrar(gasto2);
            dao.cadastrar(gasto3);
            dao.cadastrar(gasto4);
            dao.cadastrar(gasto5);

            System.out.println("Os 5 gastos foram cadastrados com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar gastos: " + e.getMessage());
        }
    }

    private static void listarGastos(GastoDao dao) {
        try {
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
        } catch (SQLException e) {
            System.err.println("Erro ao consultar gastos: " + e.getMessage());
        }
    }
}