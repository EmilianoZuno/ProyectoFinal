package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaOceano extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblTamano;
    private JLabel lblSalinidad;
    private JLabel lblTemperatura;
    private JLabel lblURL;
    private JLabel lblBorrar;
    private JLabel imagenOceano;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTamano;
    private JTextField txtSalinidad;
    private JTextField txtTemperatura;
    private JTextField txtURL;
    private JTextField txtUpdate;
    private JTextArea txaUpdate;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnBorrar;
    private JButton btnUpdate;
    private JTable tblOceano;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public VentanaOceano(String title) throws HeadlessException {
        super(title);
        this.setSize(1000,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(239,200,200));
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblTamano = new JLabel("Tamano:");
        lblSalinidad = new JLabel("Salinidad:");
        lblTemperatura = new JLabel("Temperatura:");
        lblURL = new JLabel("Url:");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(10);
        txtTamano = new JTextField(15);
        txtSalinidad = new JTextField(15);
        txtTemperatura = new JTextField(15);
        txtURL = new JTextField(40);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblTamano);
        panel1.add(txtTamano);
        panel1.add(lblSalinidad);
        panel1.add(txtSalinidad);
        panel1.add(lblTemperatura);
        panel1.add(txtTemperatura);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);

        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(209,241,193));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblOceano = new JTable();
        scrollPane = new JScrollPane(tblOceano);
        panel2.add(scrollPane);


        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(200,239,232));
        imagenOceano = new JLabel("...");
        panel3.add(imagenOceano);


        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(213,200,239));
        lblBorrar = new JLabel("Seleccionar fila ");
        btnBorrar = new JButton("Borrar");
        txaUpdate = new JTextArea("Para actualizar:"+ "\n1.Escribir el nuevo valor" + "\n 2.Seleccionar la casilla que desee sustituir" + " \n 3.Oprimir el boton");
        txaUpdate.setBackground(null);
        txtUpdate = new JTextField(10);
        btnUpdate = new JButton("Actualizar");
        panel4.add(lblBorrar);
        panel4.add(btnBorrar);
        panel4.add(txaUpdate);
        panel4.add(txtUpdate);
        panel4.add(btnUpdate);

        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTamano() {
        return lblTamano;
    }

    public void setLblTamano(JLabel lblTamano) {
        this.lblTamano = lblTamano;
    }

    public JLabel getLblSalinidad() {
        return lblSalinidad;
    }

    public void setLblSalinidad(JLabel lblSalinidad) {
        this.lblSalinidad = lblSalinidad;
    }

    public JLabel getLblTemperatura() {
        return lblTemperatura;
    }

    public void setLblTemperatura(JLabel lblTemperatura) {
        this.lblTemperatura = lblTemperatura;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTamano() {
        return txtTamano;
    }

    public void setTxtTamano(JTextField txtTamano) {
        this.txtTamano = txtTamano;
    }

    public JTextField getTxtSalinidad() {
        return txtSalinidad;
    }

    public void setTxtSalinidad(JTextField txtSalinidad) {
        this.txtSalinidad = txtSalinidad;
    }

    public JTextField getTxtTemperatura() {
        return txtTemperatura;
    }

    public void setTxtTemperatura(JTextField txtTemperatura) {
        this.txtTemperatura = txtTemperatura;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblOceano() {
        return tblOceano;
    }

    public void setTblOceano(JTable tblOceano) {
        this.tblOceano = tblOceano;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getImagenOceano() {
        return imagenOceano;
    }

    public void setImagenOceano(JLabel imagenOceano) {
        this.imagenOceano = imagenOceano;
    }

    public JLabel getLblBorrar() {
        return lblBorrar;
    }

    public void setLblBorrar(JLabel lblBorrar) {
        this.lblBorrar = lblBorrar;
    }

    public JTextField getTxtUpdate() {
        return txtUpdate;
    }

    public void setTxtUpdate(JTextField txtUpdate) {
        this.txtUpdate = txtUpdate;
    }

    public JTextArea getTxaUpdate() {
        return txaUpdate;
    }

    public void setTxaUpdate(JTextArea txaUpdate) {
        this.txaUpdate = txaUpdate;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtTamano.setText("");
        txtSalinidad.setText("");
        txtTemperatura.setText("");
        txtURL.setText("");
    }
    public void limpiarupdate(){
        txtUpdate.setText("");
    }
}
