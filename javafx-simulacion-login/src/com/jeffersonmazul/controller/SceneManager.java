package com.jeffersonmazul.controller;

import com.jeffersonmazul.model.Usuario;
import com.jeffersonmazul.view.BienvenidaView;
import com.jeffersonmazul.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Stage escenarioSecundario;
    private Scene escenaPrincipal;
    private Scene escenaSecundaria;

    /**
     * Constructor privado para restringir la instanciación externa.
     */
    private SceneManager() {
    }

    /**
     * Configura y aplica un panel raíz sobre el escenario principal del
     * sistema.
     *
     * @param panel Contenedor visual base.
     * @param ancho Dimensión horizontal de la ventana.
     * @param alto Dimensión vertical de la ventana.
     */
    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            escenaPrincipal = new Scene(panel, ancho, alto);

            // Carga e inyección de la hoja de estilos CSS de forma segura
            var cssResource = getClass().getResource("/com/jeffersonmazul/styles/LoginStyles.css");
            if (cssResource != null) {
                escenaPrincipal.getStylesheets().add(cssResource.toExternalForm());
            }

            escenaPrincipal.setFill(Color.TRANSPARENT);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.show();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: CambiarEscena Principal");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre.printStackTrace();
        }
    }

    /**
     * Prepara e inicializa la interfaz gráfica del Login principal.
     */
    public void ventanaLogin() {
        try {
            // Se eliminan las decoraciones por defecto del sistema operativo
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(login, 600, 500);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);
            new LoginController(login);

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Login");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
            errorPadre.printStackTrace();
        }
    }

    /**
     * @param usuarioLogueado Instancia del usuario que completó la
     * autenticación con éxito.
     */
     public void ventanaBienvenida(Usuario usuarioLogueado) {
        try {
            // 1. Inicialización y jerarquía del escenario secundario
            escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
            this.escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            this.escenarioSecundario.initOwner(escenarioPrincipal);

            // 2. Obtención de la vista mediante su patrón Singleton
            BienvenidaView bienvenida = BienvenidaView.getInstanciaBienvenidaView();
            
            if (bienvenida.getScene() != null) {
                bienvenida.getScene().setRoot(new javafx.scene.layout.Pane());
            }

            // 3. Inyección dinámica del nombre completo del usuario autenticado
            bienvenida.setNombreUsuario(usuarioLogueado.getNombreCompleto());

            // 4. Configuración de la escena y remoción del fondo por defecto
            escenaSecundaria = new Scene(bienvenida, 400, 300);
            escenaSecundaria.setFill(Color.TRANSPARENT);

            // 5. Asignación y renderizado de la ventana secundaria
            this.escenarioSecundario.setScene(escenaSecundaria);
            this.escenarioSecundario.sizeToScene();
            this.escenarioSecundario.show();

            // 6. Vinculación del controlador encargado de la lógica y el arrastre
            new BienvenidaController(bienvenida);

        } catch (Exception errorPadre) {
            errorPadre.printStackTrace();
        }
    }

    /**
     * Obtiene la instancia única global del administrador de escenas.
     *
     * @return Instancia única de SceneManager.
     */
    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }

    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {
        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Stage getEscenarioSecundario() {
        return escenarioSecundario;
    }

    public void setEscenarioSecundario(Stage escenarioSecundario) {
        this.escenarioSecundario = escenarioSecundario;
    }

    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }

    public void setEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }

    public Scene getEscenaSecundaria() {
        return escenaSecundaria;
    }

    public void setEscenaSecundaria(Scene escenaSecundaria) {
        this.escenaSecundaria = escenaSecundaria;
    }
}