package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.UserDao;
import br.com.fiap.fintech.model.User;

import java.sql.SQLException;
import java.util.List;

public class RegisterUserView {

    public static void main(String[] args) {
        // Cadastrar um novo usuário
        cadastrarUsuario();

        // Listar todos os usuários
        listarUsuarios();
    }

    private static void cadastrarUsuario() {
        try {
            UserDao dao = new UserDao();
            User user = new User(2, "Bruno", "breno@email.com", "senha123");
            dao.cadastrar(user);
            dao.fecharConexao();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void listarUsuarios() {
        try {
            UserDao dao = new UserDao();
            List<User> usuarios = dao.listar();

            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                System.out.println("Usuários cadastrados:");
                for (User user : usuarios) {
                    System.out.println("ID: " + user.getIdUsuario());
                    System.out.println("Nome: " + user.getNomeUsuario());
                    System.out.println("Email: " + user.getEmailUsuario());
                    System.out.println("Senha: " + user.getSenhaUsuario());
                    System.out.println("-----------------------------");
                }
            }

            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao consultar usuários: " + e.getMessage());
        }
    }
}
