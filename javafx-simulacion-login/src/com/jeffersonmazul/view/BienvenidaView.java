package com.jeffersonmazul.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Paint;

public class BienvenidaView extends BorderPane {

    private static BienvenidaView instanciaBienvenidaView;

    // Componentes visuales de la barra superior de navegación
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;

    // Componentes visuales de la sección interna de información
    private VBox contenedorCentral;
    private Label lblMensajeBienvenida;
    private Label lblMensajeExito;

    /**
     * Constructor privado que define los contenedores, componentes y estilos
     * estéticos correspondientes a la interfaz de bienvenida.
     */
    private BienvenidaView() {
        // Dimensionado interno del contenedor principal
        this.setPadding(new Insets(20));

        // Configuración de bordes Aqua con esquinas redondeadas coincidentes con el Login
        this.setBorder(new Border(
                new BorderStroke(Color.AQUA,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(25),
                        new BorderWidths(12))
        ));

        // Configuración del fondo con esquinas redondeadas
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#AFC06A"),
                        new CornerRadii(22),
                        Insets.EMPTY)
        ));

        // 1. Construcción y alineación de la barra superior
        barraDeVentana = new HBox(20);
        barraDeVentana.setAlignment(Pos.CENTER_LEFT);

        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("Sistema - Bienvenida");
        lblTituloVentana.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);

        // 2. Construcción y centrado del contenedor de información central
        contenedorCentral = new VBox(15);
        contenedorCentral.setAlignment(Pos.CENTER);

        lblMensajeBienvenida = new Label("¡Bienvenido, Usuario!");
        lblMensajeBienvenida.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        lblMensajeExito = new Label("Inicio de sesión exitoso");
        lblMensajeExito.setStyle("-fx-font-size: 12px; -fx-text-fill: #333333; -fx-font-style: italic;");

        contenedorCentral.getChildren().addAll(lblMensajeBienvenida, lblMensajeExito);
        this.setCenter(contenedorCentral);
    }

    /**
     * @param nombre Nombre descriptivo o completo del usuario autenticado.
     */
    public void setNombreUsuario(String nombre) {
        this.lblMensajeBienvenida.setText("¡Bienvenido, " + nombre + "!");
    }

    /**
     * Obtiene la instancia única global de la vista de bienvenida.
     *
     * @return Instancia de tipo BienvenidaView.
     */
    public static BienvenidaView getInstanciaBienvenidaView() {
        if (instanciaBienvenidaView == null) {
            instanciaBienvenidaView = new BienvenidaView();
        }
        return instanciaBienvenidaView;
    }

    public static void setInstanciaBienvenidaView(BienvenidaView instanciaBienvenidaView) {
        BienvenidaView.instanciaBienvenidaView = instanciaBienvenidaView;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public HBox getBarraDeVentana() {
        return barraDeVentana;
    }
}
