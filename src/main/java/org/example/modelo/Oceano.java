package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Oceano {
    private int Id;
    private String Nombre;
    private String Tamano;
    private String Salinidad;
    private String Temperatura;
    private String URL;

    public Oceano() {
    }

    public Oceano(int id, String nombre, String tamano, String salinidad, String temperatura, String URL) {
        this.Id = id;
        this.Nombre = nombre;
        this.Tamano = tamano;
        this.Salinidad = salinidad;
        this.Temperatura = temperatura;
        this.URL = URL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String tamano) {
        Tamano = tamano;
    }

    public String getSalinidad() {
        return Salinidad;
    }

    public void setSalinidad(String salinidad) {
        Salinidad = salinidad;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        Temperatura = temperatura;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Oceano{" +
                "id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Tamano='" + Tamano + '\'' +
                ", Salinidad='" + Salinidad + '\'' +
                ", Temperatura='" + Temperatura + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.URL);
        return new ImageIcon(urlImagen);
    }
}
