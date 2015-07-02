package br.com.lojadafatima.ConexaoBDpostgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Azevedo
 */
public class ConexaoPostgre {

    public static Connection ConexaoPostgre;
    public static Statement statement;
    public static ResultSet resultset;
    public ResultSetMetaData metaData;
    public int retorno = 0;
    public static boolean informaconexaobanco;

    public ConexaoPostgre() {
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoPostgre != null) {
            return ConexaoPostgre;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                ConexaoPostgre = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lojafatima", "lojafatima", "lojafatima");
                System.out.println("Conectado");
                if (informaconexaobanco) {
                    JOptionPane.showMessageDialog(null, "Banco de Dados Conectado!");
                }
                return ConexaoPostgre;

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado: \n" + ex);
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: \n" + ex);
                return null;
            }
        }
    }

    public void desconecta() {
        try {
            ConexaoPostgre.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados: \n" + fecha);
        }
    }

    public void incluirSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 00001) {
                JOptionPane.showMessageDialog(null, "Os dados não puderam ser incluidos pois já estão cadastrados!", "As informações não foram gravadas", JOptionPane.YES_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql (" + sqlex + "), \nO comando SQL passado foi: " + sql, "O comando SQL retornou um erro!", JOptionPane.YES_OPTION);
            }
            retorno = 0;
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            retorno = 1;
            metaData = resultset.getMetaData();
        } catch (SQLException sqlex) {
            System.out.println(sqlex +"\n"+sql);
        }
    }

    public void deleteSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "O resgistro não pôde ser excluído porque ele está sendo utilizado em outro cadastro/movimento", "Registro em uso", JOptionPane.YES_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql de exclusão (" + sqlex + ") \nO sql passado foi " + sql, "O comando SQL retornou um erro!", JOptionPane.YES_OPTION);
            }
            retorno = 0;
        }
    }

    public void atualizarSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "Os dados não puderam ser atualizados pois estão sendo utilizados", "Dados em uso", JOptionPane.YES_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando SQL de atualização (" + sqlex + ") \nO comando SQL passado foi " + sql, "O comando SQL retornou um erro!", JOptionPane.YES_OPTION);
            }
            retorno = 0;
        }
    }
}
