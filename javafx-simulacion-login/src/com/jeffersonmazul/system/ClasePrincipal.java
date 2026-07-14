/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jeffersonmazul.system;

import com.jeffersonmazul.controller.Controlador;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClasePrincipal extends Application {

   @Override
    public void start(Stage stage) {

        Controlador.getInstancia().iniciar(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
