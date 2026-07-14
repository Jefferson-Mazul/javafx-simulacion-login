/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeffersonmazul.controller;

import com.jeffersonmazul.model.Modelo;
import com.jeffersonmazul.view.VistaEscenario;
import javafx.stage.Stage;

/**
 *
 * @author jeff2
 */
public class Controlador {

    // 🔹 Instancia única (Singleton)
    private static Controlador instancia;

    private Modelo modelo;
    private VistaEscenario vista;

    // 🔒 Constructor privado
    private Controlador() {
        modelo = new Modelo();
        vista = new VistaEscenario();
    }

    // 🔹 Método para obtener la instancia única
    public static Controlador getInstancia() {

        if (instancia == null) {
            instancia = new Controlador();
        }

        return instancia;
    }

    // 🔹 Método que inicia la app
    public void iniciar(Stage stage) {
        vista.mostrar(stage);
    }
}
