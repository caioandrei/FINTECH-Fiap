package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Gasto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GastoDao {

    private Connection conexao;

    public GastoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    // Método para cadastrar um gasto
    public void cadastrar(Gasto gasto) throws SQLException {
        String sql = "INSERT INTO tb_gasto (id_gasto, id_usuario, valor, data) VALUES (seq_gasto.nextval, ?, ?, ?)";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {

            stm.setInt(1, gasto.getIdUsuario());
            stm.setDouble(2, gasto.getValor());
            stm.setString(3, gasto.getData());

            stm.executeUpdate();
        }
    }


    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    // Implementação do método listar para buscar todos os gastos
    public List<Gasto> listar() throws SQLException {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT id_gasto, id_usuario, valor, data FROM tb_gasto";

        try (PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_gasto");
                int usuario = rs.getInt("id_usuario");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");

                Gasto gasto = new Gasto(id, usuario, valor, data);
                gastos.add(gasto);
            }
        }
        return gastos;
    }
}
