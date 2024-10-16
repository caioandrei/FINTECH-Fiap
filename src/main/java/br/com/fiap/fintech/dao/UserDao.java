package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conexao;

    public UserDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(User user) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement(
                "INSERT INTO tb_usuario (id_usuario, nome_usuario, email_usuario, senha_usuario) " +
                        "VALUES (seq_usuario.nextval, ?, ?, ?)"
        );

        stm.setString(1, user.getNomeUsuario());
        stm.setString(2, user.getEmailUsuario());
        stm.setString(3, user.getSenhaUsuario());

        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    // Implementação do método listar para buscar todos os usuários
    public List<User> listar() throws SQLException {
        List<User> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, nome_usuario, email_usuario, senha_usuario FROM tb_usuario";

        try (PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome_usuario");
                String email = rs.getString("email_usuario");
                String senha = rs.getString("senha_usuario");

                User user = new User(id, nome, email, senha);
                usuarios.add(user);
            }
        }
        return usuarios;
    }
}
