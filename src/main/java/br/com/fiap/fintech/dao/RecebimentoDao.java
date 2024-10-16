package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Recebimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecebimentoDao {

    private Connection conexao;

    public RecebimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    // Método para cadastrar um Recebimento
    public void cadastrar(Recebimento recebimento) throws SQLException {
        String sql = "INSERT INTO TB_RECEBIMENTO (id_usuario, valor, data) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'))";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {

            stm.setInt(1, recebimento.getIdUsuario());
            stm.setDouble(2, recebimento.getValor());
            stm.setString(3, recebimento.getData());

            stm.executeUpdate();
        }
    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    // Implementação do método listar para buscar todos os recebimentos
    public List<Recebimento> listar() throws SQLException {
        List<Recebimento> recebimentos = new ArrayList<>();
        String sql = "SELECT id_recebimento, id_usuario, valor, data FROM tb_recebimento";

        try (PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_recebimento");
                int usuario = rs.getInt("id_recebimento");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");

                Recebimento recebimento = new Recebimento(id, usuario, valor, data);
                recebimentos.add(recebimento);
            }
        }
        return recebimentos;
    }
}
