package org.example.persistencia;

import org.example.modelo.Oceano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OceanoDAO implements InterfazDAO {

    public OceanoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO oceanos(nombre, tamano, salinidad, temperatura, url) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Oceano) obj).getNombre());
        pstm.setString(2, ((Oceano) obj).getTamano());
        pstm.setString(3, ((Oceano) obj).getSalinidad());
        pstm.setString(4, ((Oceano) obj).getTemperatura());
        pstm.setString(5, ((Oceano) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE oceanos SET nombre = ?, tamano = ?, salinidad = ?, temperatura = ?, url = ? WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Oceano) obj).getNombre());
        pstm.setString(2, ((Oceano) obj).getTamano());
        pstm.setString(3, ((Oceano) obj).getSalinidad());
        pstm.setString(4, ((Oceano) obj).getTemperatura());
        pstm.setString(5, ((Oceano) obj).getURL());
        pstm.setInt(6, ((Oceano) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM oceanos WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, id);
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM oceanos";
        ArrayList<Oceano> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new Oceano(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM oceanos WHERE id = ? ;";
        Oceano oceano = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            oceano = new Oceano(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            return oceano;
        }
        return null;

    }

    public boolean updateUnElemento(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm = null;
        switch (columna) {
            case 0:
                break;
            case 1:
                sqlDelete = "UPDATE oceanos SET nombre = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE oceanos SET tamano = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE oceanos SET salinidad = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE oceanos SET temperatura = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE oceanos SET url = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("oceanosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }
}

