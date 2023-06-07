package org.example;

import org.example.controlador.ControladorOceano;
import org.example.vista.VentanaOceano;

public class Main {
    public static void main(String[] args) {

        VentanaOceano view = new VentanaOceano("MVC y JDBC");
        ControladorOceano controller = new ControladorOceano(view);

    }
    }


