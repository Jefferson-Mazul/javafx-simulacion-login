package com.jeffersonmazul.controller;

import com.jeffersonmazul.model.Usuario;
import com.jeffersonmazul.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    // Referencias a la vista y componentes de navegación
    private final LoginView LOGIN_VIEW;
    private final AuthSistema authSistema = new AuthSistema();
    private final Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();
    
    // Coordenadas de control para el movimiento fluido de la interfaz sin bordes
    private double ejeX = 0;
    private double ejeY = 0;

    /**
     * Constructor del controlador que inicializa la vista y sus manejadores de eventos.
     * 
     * @param loginView Instancia de la interfaz gráfica del Login.
     */
    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }

    /**
     * Define y asigna todos los oyentes (listeners) de eventos sobre la interfaz del Login.
     */
    public void construirAcciones() {
        
        // Manejador para cerrar la aplicación por completo al pulsar el botón X
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(evento -> {
            System.exit(0);
        });

        // Captura las coordenadas locales del mouse eliminando cualquier salto inicial
        this.LOGIN_VIEW.setOnMousePressed(evento -> {
            ejeX = evento.getX();
            ejeY = evento.getY();
        });

        // Desplaza la ventana principal acompañando de forma fluida el movimiento del cursor
        this.LOGIN_VIEW.setOnMouseDragged(evento -> {
            escenario.setX(evento.getScreenX() - ejeX);
            escenario.setY(evento.getScreenY() - ejeY);
        });

        // Evento que desencadena el proceso de validación e inicio de sesión
        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(evento -> {
            iniciarSesion();
        });
    }

    /**
     * Valida que las entradas de texto no estén vacías y procesa la 
     * verificación de credenciales en el sistema de autenticación.
     */
    public void iniciarSesion() {
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        // Limpieza de estados visuales previos de error
        this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
        this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");

        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No deje el campo de nombre de usuario vacio");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            this.LOGIN_VIEW.getTxtNombreUsuario().requestFocus();

        } else if (clave.isEmpty()) {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            this.LOGIN_VIEW.getPwdClave().requestFocus();
            JOptionPane.showMessageDialog(null, "No deje el campo de la clave vacio");

        } else {
            // Proceso de autenticación con las credenciales limpias
            Usuario usuario = authSistema.login(nombreUsuario, clave);
            
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Valide sus credenciales");
            } else {
                // Navegación exitosa enviando los datos del usuario logueado
                SceneManager.getInstanciaSceneManager().ventanaBienvenida(usuario);
            }
        }
    }
}