/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeffersonmazul.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jeff2
 */
public class VistaEscenario {

    public void mostrar(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("MVC + Singleton en Controlador");
        stage.setScene(scene);
        stage.show();
    }
}
