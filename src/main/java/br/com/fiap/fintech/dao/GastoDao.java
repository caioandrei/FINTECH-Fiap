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
        String sql = "INSERT INTO tb_gasto (id_usuario, valor, data, categoria, recorrencia) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {

            stm.setInt(1, gasto.getIdUsuario());
            stm.setDouble(2, gasto.getValor());
            stm.setString(3, gasto.getData());
            stm.setString(4, gasto.getCategoria());
            stm.setString(5, gasto.getRecorrencia());

            stm.executeUpdate();
        }
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    // Implementação do método listar para buscar todos os gastos
    public List<Gasto> listar() throws SQLException {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT id_usuario, valor, data, categoria, recorrencia FROM tb_gasto";

        try (PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int usuario = rs.getInt("id_usuario");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                String categoria = rs.getString("categoria");
                String recorrencia = rs.getString("recorrencia");

                Gasto gasto = new Gasto(usuario, valor, data, categoria, recorrencia);
                gastos.add(gasto);
            }
        }
        return gastos;
    }
}
