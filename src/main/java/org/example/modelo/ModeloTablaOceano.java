package org.example.modelo;

import org.example.persistencia.OceanoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaOceano implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Oceano> datos;
    private OceanoDAO odao;

    public ModeloTablaOceano() {
        odao = new OceanoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaOceano(ArrayList<Oceano> datos) {
        this.datos = datos;
        odao = new OceanoDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Tamano";
            case 3:
                return "Salinidad";
            case 4:
                return "Temperatura";
            case 5:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Oceano tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getTamano();
            case 3:
                return tmp.getSalinidad();
            case 4:
                return tmp.getTemperatura();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) o);
                break;
            case 2:
                datos.get(rowIndex).setTamano((String) o);
                break;
            case 3:
                datos.get(rowIndex).setSalinidad((String) o);
                break;
            case 4:
                datos.get(rowIndex).setTemperatura((String) o);
                break;
            case 5:
                datos.get(rowIndex).setURL((String) o);
                break;
            default:
                System.out.println("No se modifica nada");

        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            ArrayList<Oceano> tirar = odao.obtenerTodo();
            System.out.println(tirar);
            datos = odao.obtenerTodo();

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarOceano(Oceano oceano) {
        boolean resultado = false;
        try {
            if (odao.insertar(oceano)) {
                datos.add(oceano);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return resultado;

    }

    public boolean borrarOceano(int Id) {
        boolean resultado = false;
        try {
            if (odao.delete(Id)) {
                resultado = true;
            }else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println("Error al borrar");
        }
        return resultado;
    }

    public Oceano getOceanoAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean actualizarUnElemento(Object o, int id, int column){
        boolean resultado = false;
        try {
            if (odao.updateUnElemento(o,id,column)) {
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println("Error al actualizar");
        }
        return resultado;
    }
}
