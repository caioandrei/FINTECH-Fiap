package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private Connection conexao;
    public UserDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(User user) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_usuario (id_usuario, nome_usuario, email_usuario, senha_usuario) VALUES (seq_usuario.nextval, ?, ?, ?)");

        stm.setString(1, user.getNomeUsuario());
        stm.setString(2, user.getEmailUsuario());
        stm.setString(3, user.getSenhaUsuario());

        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public List<User> listar(){
        return null;
    }
}
