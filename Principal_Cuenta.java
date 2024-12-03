/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu_tarea;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;

/**
 *
 * @author gamaliel
 */
public class Principal_Cuenta extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("IU_Cuenta");
        stage.setWidth(800);
        stage.setHeight(600);
        GridPane gridPane = crearGridPane();
        Scene scene = new Scene(gridPane);
        agregarControles(gridPane);
        agregarImagenes(gridPane);
        cambiarColorFondo(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private GridPane crearGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(110, 110, 110, 110));
        gridPane.setVgap(10);
        gridPane.setHgap(50);
        return gridPane;
    }

    private void agregarControles(GridPane gridPane) {

        // Declaramos todas las etiquetas según el prototipo
        Label labelCuenta = new Label("CUENTA");
        Label labelSuscripcion = new Label("SUSCRIPCIÓN");
        Label labelPago = new Label("PAGO");
        Label labelAsistencia = new Label("ASISTENCIA");
        Label labelNotificaciones = new Label("NOTIFICACIONES");
        Label labelTipoSuscripcion = new Label("Suscripción Premium");

        // Damos formato a las etiquetas
        formatoLabelPrincipal(labelCuenta);
        formatoLabelPrincipal(labelSuscripcion);
        formatoLabelPrincipal(labelPago);
        formatoLabelPrincipal(labelAsistencia);
        formatoLabelPrincipal(labelNotificaciones);
        formatoLabelEspecial(labelTipoSuscripcion);

        // Declaramos todos los botones según el prototipo
        Button botonCuenta = new Button("Editar Perfil");
        Button botonPlanes = new Button("Planes Disponibles");
        Button botonAdministrarSuscripcion = new Button("Administrar Suscripción");
        Button botonTarjetas = new Button("Tarjetas");
        Button botonHistorialPagos = new Button("Historial de Pagos");
        Button botonCambiarContrasena = new Button("Cambiar Contraseña");
        Button botonPrivacidadCuenta = new Button("Privacidad de la Cuenta");
        Button botonAsistencia = new Button("Solicitar Asistencia");
        Button botonConfiguracionNotificaciones = new Button("Configurar Notificaciones");

        // Damos formato a los botones
        formatoBotonSecundario(botonCuenta);
        formatoBotonSecundario(botonPlanes);
        formatoBotonSecundario(botonAdministrarSuscripcion);
        formatoBotonSecundario(botonTarjetas);
        formatoBotonSecundario(botonHistorialPagos);
        formatoBotonSecundario(botonCambiarContrasena);
        formatoBotonSecundario(botonPrivacidadCuenta);
        formatoBotonSecundario(botonAsistencia);
        formatoBotonSecundario(botonConfiguracionNotificaciones);

        // Paneamos en el grid pane
        gridPane.add(labelCuenta, 0, 1);
        gridPane.add(botonCuenta, 0, 2);
        gridPane.add(labelSuscripcion, 0, 3);
        gridPane.add(botonPlanes, 0, 4);
        gridPane.add(botonAdministrarSuscripcion, 0, 5);
        gridPane.add(labelPago, 0, 6);
        gridPane.add(botonTarjetas, 0, 7);
        gridPane.add(botonHistorialPagos, 0, 8);

        // Segunda columna
        gridPane.add(labelTipoSuscripcion, 1, 1);
        gridPane.add(botonCambiarContrasena, 1, 2);
        gridPane.add(botonPrivacidadCuenta, 1, 3);
        gridPane.add(labelAsistencia, 1, 4);
        gridPane.add(botonAsistencia, 1, 5);
        gridPane.add(labelNotificaciones, 1, 6);
        gridPane.add(botonConfiguracionNotificaciones, 1, 7);
    }

    private void agregarImagenes(GridPane gridPane) {

        // Declaramos las imágenes
        Image image = new Image("file:src/iu_tarea/Logo.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        imageView.setPreserveRatio(true);

        Image imageUsuario = new Image("file:src/iu_tarea/Usuario.png");
        ImageView imageViewUsuario = new ImageView(imageUsuario);
        imageViewUsuario.setFitWidth(70);
        imageViewUsuario.setFitHeight(70);
        imageViewUsuario.setPreserveRatio(true);

        // Declaramos las etiquetas:
        Label labelNombreIU = new Label("Perfil");
        formatoLabelTitulo(labelNombreIU);

        Label labelNombreUsuario = new Label("guest1234");
        formatoLabelTitulo(labelNombreUsuario);

        // Declaramos los HBox
        HBox hboxNombreIU = new HBox();
        hboxNombreIU.setPadding(new Insets(10, 10, 10, 10));
        hboxNombreIU.setSpacing(10);
        hboxNombreIU.getChildren().addAll(imageView, labelNombreIU);

        HBox hboxUsuario = new HBox();
        hboxUsuario.setPadding(new Insets(10, 10, 10, 10));
        hboxUsuario.setSpacing(10);
        hboxUsuario.getChildren().addAll(imageViewUsuario, labelNombreUsuario);

        // Las agregamos al gridpane
        gridPane.add(hboxNombreIU, 0, 0);
        gridPane.add(hboxUsuario, 1, 0);
    }

    private void formatoBotonSecundario(Button boton) {
        boton.setPrefWidth(200);
        boton.setPrefHeight(50);
        boton.setFont(new Font(15));
        boton.setStyle("-fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-radius: 5;"
                + "-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, #2663a4 , #162739 );"
                + "-fx-text-fill: #FFFFFF; "
        );
        
        // Al hacer clic en el botón, sus colores de fondo se invierten
        boton.setOnMousePressed(event -> {
            boton.setStyle("-fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-radius: 5;"
                    + "-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, #162739, #2663a4 );"
                    + "-fx-text-fill: #FFFFFF;");
        });
        
        //Vuelve al estado original después de que el clic haya terminado
        boton.setOnMouseReleased(event -> {
            boton.setStyle("-fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-radius: 5;"
                    + "-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, #2663a4 , #162739 );"
                    + "-fx-text-fill: #FFFFFF;");
        });
    }

    private void formatoLabelEspecial(Label label) {
        label.setPrefWidth(300);
        label.setPrefHeight(200);
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setStyle("-fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 2; -fx-background-radius: 7;"
                + "-fx-background-color: #FFFFFF;"
                + "-fx-text-fill: #000000;"
        );

        Image image = new Image(getClass().getResourceAsStream("Bien.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        label.setGraphic(imageView);
    }

    private void formatoLabelTitulo(Label label) {
        label.setPrefWidth(200);
        label.setPrefHeight(200);
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setStyle("-fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 6; -fx-background-radius: 6;"
                + "-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, #FFFFFF, #a2caf3);"
                + "-fx-text-fill: #000000;"
        );
    }

    private void formatoLabelPrincipal(Label label) {
        label.setPrefWidth(400);
        label.setPrefHeight(200);
        label.setFont(new Font(19));
        label.setStyle("-fx-text-fill: #FFFFFF");
    }

    private void cambiarColorFondo(GridPane gridPane) {
        gridPane.setStyle("-fx-background: linear-gradient(from 0% 0% to 0% 100%, #3471b2, #11253b);");
    }
}
