package org.example.controlador;

import org.example.modelo.ModeloTablaOceano;
import org.example.modelo.Oceano;
import org.example.vista.VentanaOceano;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

public class ControladorOceano extends MouseAdapter {
    private VentanaOceano view;
    private ModeloTablaOceano modelo;

    public ControladorOceano(VentanaOceano view) {
        this.view = view;
        modelo = new ModeloTablaOceano();
        modelo.cargarDatos();
        this.view.getTblOceano().setModel(modelo);
        this.view.getTblOceano().updateUI();
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnUpdate().addMouseListener(this);
        this.view.getTblOceano().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblOceano().setModel(modelo);
            this.view.getTblOceano().updateUI();
        }

        if (e.getSource() == this.view.getBtnAgregar()) {
            Oceano oceano = new Oceano();
            oceano.setId(0);
            oceano.setNombre(this.view.getTxtNombre().getText());
            oceano.setTamano(this.view.getTxtTamano().getText());
            oceano.setSalinidad(this.view.getTxtSalinidad().getText());
            oceano.setTemperatura(this.view.getTxtTemperatura().getText());
            oceano.setURL(this.view.getTxtURL().getText());
            if (modelo.agregarOceano(oceano)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblOceano().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Por favor revise su conexion", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }

            this.view.limpiar();

        }

        if (e.getSource() == this.view.getTblOceano()) {
            int index = this.view.getTblOceano().getSelectedRow();
            Oceano tmp = modelo.getOceanoAtIndex(index);
            try {
                this.view.getImagenOceano().setIcon(tmp.getImagen());
                this.view.getImagenOceano().setText("...");
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }

        }

        if (e.getSource() == view.getBtnBorrar()) {
            int index = this.view.getTblOceano().getSelectedRow();
            int id = modelo.getOceanoAtIndex(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Deseas borrar el elemento seleccionado?", "Aviso", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                if (modelo.borrarOceano(id)) {
                    JOptionPane.showMessageDialog(view, "Borrado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    modelo.cargarDatos();
                    this.view.getTblOceano().setModel(modelo);
                    this.view.getTblOceano().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "Error al borrar", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == view.getBtnUpdate()) {
                Object o = this.view.getTxtUpdate().getText();
                int index = this.view.getTblOceano().getSelectedRow();
                int id = modelo.getOceanoAtIndex(index).getId();
                int columna = this.view.getTblOceano().getSelectedColumn();

                if (modelo.actualizarUnElemento(o, id, columna)) {
                    JOptionPane.showMessageDialog(view, "Actualizado con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    this.view.limpiarupdate();
                    modelo.cargarDatos();
                    this.view.getTblOceano().setModel(modelo);
                    this.view.getTblOceano().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "Error al actualizar");
                }
            }


        }
    }
