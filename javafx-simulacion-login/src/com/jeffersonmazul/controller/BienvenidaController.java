package com.jeffersonmazul.controller;

import com.jeffersonmazul.view.BienvenidaView;
import javafx.stage.Stage;

public class BienvenidaController {

    // Referencia inmutable hacia los elementos gráficos de la vista de bienvenida
    private final BienvenidaView BIENVENIDA_VIEW;
    
    // Variables de control para almacenar la posición del puntero durante el arrastre
    private double ejeX = 0;
    private double ejeY = 0;

    /**
     * Constructor que vincula el controlador con su respectiva vista.
     * 
     * @param bienvenidaView Instancia gráfica que será controlada.
     */
    public BienvenidaController(BienvenidaView bienvenidaView) {
        this.BIENVENIDA_VIEW = bienvenidaView;
        configurarAcciones();
    }

    private void configurarAcciones() {
        
        // Manejador del botón de cierre de la barra superior
        this.BIENVENIDA_VIEW.getBtnCerrarVentana().setOnAction(evento -> {
            // Se recupera el contenedor de la ventana actual para proceder a ocultarla
            Stage escenarioSecundario = (Stage) this.BIENVENIDA_VIEW.getScene().getWindow();
            escenarioSecundario.hide();
        });

        // Captura las coordenadas locales del mouse en el instante que se presiona la barra
        this.BIENVENIDA_VIEW.getBarraDeVentana().setOnMousePressed(evento -> {
            ejeX = evento.getX();
            ejeY = evento.getY();
        });

        // Actualiza de forma dinámica la posición de la ventana en pantalla al arrastrar
        this.BIENVENIDA_VIEW.getBarraDeVentana().setOnMouseDragged(evento -> {
            Stage escenarioSecundario = (Stage) this.BIENVENIDA_VIEW.getScene().getWindow();
            // Resta el desplazamiento interno para asegurar un movimiento fluido sin retrasos
            escenarioSecundario.setX(evento.getScreenX() - ejeX);
            escenarioSecundario.setY(evento.getScreenY() - ejeY);
        });
    }
}