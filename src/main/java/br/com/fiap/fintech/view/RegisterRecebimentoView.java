package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.RecebimentoDao;
import br.com.fiap.fintech.model.Recebimento;
import java.sql.SQLException;
import java.util.List;

public class RegisterRecebimentoView {

    public static void main(String[] args) {
        try {
            RecebimentoDao dao = new RecebimentoDao();
            cadastrarRecebimentos(dao);
            listarRecebimentos(dao);

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
    private static void cadastrarRecebimentos(RecebimentoDao dao) {
        try {
            Recebimento recebimento1 = new Recebimento(25, 150.75, "2024-10-16", "Salário", "Mensal");
            Recebimento recebimento2 = new Recebimento(25, 200.00, "2024-10-17", "Salário", "Mensal");
            Recebimento recebimento3 = new Recebimento(25, 50.25, "2024-10-18", "Salário", "Mensal");
            Recebimento recebimento4 = new Recebimento(25, 300.00, "2024-10-19", "Salário", "Mensal");
            Recebimento recebimento5 = new Recebimento(25, 100.75, "2024-10-20", "Salário", "Mensal");

            dao.cadastrar(recebimento1);
            dao.cadastrar(recebimento2);
            dao.cadastrar(recebimento3);
            dao.cadastrar(recebimento4);
            dao.cadastrar(recebimento5);

            System.out.println("Os 5 recebimentos foram cadastrados com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar recebimentos: " + e.getMessage());
        }
    }

    private static void listarRecebimentos(RecebimentoDao dao) {
        try {
            List<Recebimento> recebimentos = dao.listar();

            if (recebimentos.isEmpty()) {
                System.out.println("Nenhum recebimento encontrado.");
            } else {
                System.out.println("Recebimentos cadastrados:");
                for (Recebimento recebimento : recebimentos) {
                    System.out.println("ID: " + recebimento.getIdRecebimento());
                    System.out.println("ID Usuário: " + recebimento.getIdUsuario());
                    System.out.println("Valor: " + recebimento.getValor());
                    System.out.println("Data: " + recebimento.getData());
                    System.out.println("Categoria: " + recebimento.getCategoria());
                    System.out.println("Recorrência: " + recebimento.getRecorrencia());
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar recebimentos: " + e.getMessage());
        }
    }
}
