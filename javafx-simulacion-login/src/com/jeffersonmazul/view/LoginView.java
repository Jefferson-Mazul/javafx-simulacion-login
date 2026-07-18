package com.jeffersonmazul.view;

import com.jeffersonmazul.controller.ImageController;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LoginView extends BorderPane {

    public static LoginView instanciaLoginView;

    // Contenedores y componentes de la barra superior
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;

    // Componentes del cuerpo del formulario
    private ImageView imgLogoLogin;
    private TextField txtNombreUsuario;
    private Label lblNombreUsuario;
    private PasswordField pwdClave;
    private Label lblClave;

    private GridPane formulario;
    private Button btnIniciarSesion;
    private VBox cajaVertical;
    private final String RUTA_ESTILOS = "/com/jeffersonmazul/styles/";

    private LoginView() {

        // Carga e inyección segura de la hoja de estilos CSS de la aplicación
        URL cssResource = getClass().getResource(RUTA_ESTILOS + "LoginStyles.css");
        if (cssResource != null) {
            this.getStylesheets().add(cssResource.toExternalForm());
        }

        // Espaciados y dimensionamiento del contenedor raíz
        this.setPadding(new Insets(20));

        // Diseño de bordesAqua con esquinas redondeadas
        this.setBorder(new Border(
                new BorderStroke(Color.AQUA,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(25),
                        new BorderWidths(12))
        ));

        // Configuración decorativa del fondo de la ventana
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#AFC06A"),
                        new CornerRadii(22),
                        Insets.EMPTY)
        ));

        // 1. Configuración estructural de la barra superior
        barraDeVentana = new HBox(20);
        barraDeVentana.setAlignment(Pos.CENTER_LEFT);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JavaFX - MAT - Simulador login");
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);

        // 2. Configuración y centrado de los contenedores del cuerpo
        cajaVertical = new VBox(15);
        cajaVertical.setAlignment(Pos.CENTER);

        formulario = new GridPane();
        formulario.setHgap(10); // Espaciado horizontal entre celdas
        formulario.setVgap(10); // Espaciado vertical entre celdas
        formulario.setAlignment(Pos.CENTER); // Centrado geométrico de la cuadrícula

        // Inicialización de campos y textos interactivos
        lblNombreUsuario = new Label("Ingrese su Nombre Usuario");
        txtNombreUsuario = new TextField();

        lblClave = new Label("Ingrese su clave");
        pwdClave = new PasswordField();

        // Construcción de la cuadrícula del formulario
        formulario.add(lblNombreUsuario, 0, 0);
        formulario.add(txtNombreUsuario, 1, 0);
        formulario.add(lblClave, 0, 1);
        formulario.add(pwdClave, 1, 1);

        btnIniciarSesion = new Button("Iniciar Sesion");

        // Carga y dimensionamiento del logotipo
        imgLogoLogin = new ImageView(new ImageController().getImageLogin("logo"));
        imgLogoLogin.setFitHeight(100);
        imgLogoLogin.setFitWidth(100);
        imgLogoLogin.setCache(true);

        // Agrupación final en el contenedor vertical central
        cajaVertical.getChildren().addAll(imgLogoLogin, formulario, btnIniciarSesion);
        this.setCenter(cajaVertical);
    }

    /**
     * Obtiene la instancia única global de la interfaz del Login.
     *
     * @return Instancia única de LoginView.
     */
    public static LoginView getInstanciaLoginView() {
        if (instanciaLoginView == null) {
            instanciaLoginView = new LoginView();
        }
        return instanciaLoginView;
    }

    public static void setInstanciaLoginView(LoginView instanciaLoginView) {
        LoginView.instanciaLoginView = instanciaLoginView;
    }

    public HBox getBarraDeVentana() {
        return barraDeVentana;
    }

    public void setBarraDeVentana(HBox barraDeVentana) {
        this.barraDeVentana = barraDeVentana;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public Label getLblTituloVentana() {
        return lblTituloVentana;
    }

    public void setLblTituloVentana(Label lblTituloVentana) {
        this.lblTituloVentana = lblTituloVentana;
    }

    public ImageView getImgLogoLogin() {
        return imgLogoLogin;
    }

    public void setImgLogoLogin(ImageView imgLogoLogin) {
        this.imgLogoLogin = imgLogoLogin;
    }

    public TextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(TextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public Label getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(Label lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public PasswordField getPwdClave() {
        return pwdClave;
    }

    public void setPwdClave(PasswordField pwdClave) {
        this.pwdClave = pwdClave;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(Button btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }
}
