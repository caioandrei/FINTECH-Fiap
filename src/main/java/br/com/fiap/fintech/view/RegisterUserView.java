package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.UserDao;
import br.com.fiap.fintech.model.User;
import java.sql.SQLException;

public class RegisterUserView {

    public static void main(String[] args) {
        try {
            UserDao dao = new UserDao();
            User user = new User(2, "Breno", "breno@email.com", "senha123");
            dao.cadastrar(user);
            dao.fecharConexao();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
