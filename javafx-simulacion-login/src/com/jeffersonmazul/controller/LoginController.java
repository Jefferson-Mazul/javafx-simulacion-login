/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeffersonmazul.controller;

import com.jeffersonmazul.model.Usuario;
import com.jeffersonmazul.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class LoginController {

    private final LoginView LOGIN_VIEW;
    private double ejeX = 0;
    private double ejeY = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }

    public void construirAcciones() {
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                (evento) -> {
                    System.exit(0);
                }
        );

        this.LOGIN_VIEW.setOnMouseClicked(
                (evento) -> {
                    ejeX = evento.getSceneX();
                    ejeY = evento.getSceneY();

                    System.out.println("Y " + ejeY);
                    System.out.println("X: " + ejeX);
                }
        );

        this.LOGIN_VIEW.setOnMouseDragged(
                (evento) -> {
                    double ejeXVentanaDesplazamiento = evento.getScreenX();
                    double ejeYVentanaDesplazamiento = evento.getScreenY();

                    System.out.println("X d " + ejeXVentanaDesplazamiento);
                    System.out.println("Y d " + ejeYVentanaDesplazamiento);

                    escenario.setX(ejeXVentanaDesplazamiento - ejeX);
                    escenario.setY(ejeYVentanaDesplazamiento - ejeY);
                }
        );

        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
                (evento) -> {
                    iniciarSesion();
                }
        );
    }

    private AuthSistema authSistema = new AuthSistema();

    public void iniciarSesion() {
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No deje el campo de nombre de usuario vacio");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            
        } else if (clave.isEmpty()) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null, "No deje el campo de la clave vacio");
        
    }else {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");
            Usuario usuario = authSistema.login(nombreUsuario, clave);
            if (usuario == null)
                JOptionPane.showMessageDialog(null, "Valide sus credenciales");
            else
                SceneManager.getInstanciaSceneManager().ventanaBienvenida();
        }
    }
}
