import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingsUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Panel principal
        BorderPane mainPane = new BorderPane();

        Region blueBackground = new Region();
        blueBackground.setStyle("-fx-background-color: #242E49;"); // Azul
        mainPane.setTop(blueBackground);

        Region spacer1 = new Region();
        spacer1.setPrefWidth(15);
        
        // Logo e ícono de regreso
        HBox topBar = new HBox(15);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #242E49;");

        ImageView backIcon = new ImageView(new Image("back.png"));
        backIcon.setFitWidth(30);
        backIcon.setFitHeight(50);

        ImageView logo = new ImageView(new Image("logo.png"));
        logo.setFitWidth(100);
        logo.setFitHeight(100);

        Label title = new Label("AJUSTES");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        topBar.getChildren().addAll(spacer1, backIcon, logo, title);

        // Panel izquierdo: Idioma y Región
        VBox leftPanel = new VBox(15);

        leftPanel.setPadding(new Insets(0, 50, 10, 50));  // 10px arriba, 10px derecha, 10px abajo, 30px izquierda
        leftPanel.setStyle("-fx-background-color: #242E49;");

        Region region = new Region();
        region.setPrefHeight(5);

        Label regionLabel = new Label("Idioma y Región");
        regionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        regionLabel.setStyle("-fx-text-fill: white;");

        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("Español", "Inglés", "Francés", "Alemán", "Italiano", "Portugués", 
        "Ruso", "Chino", "Japonés", "Coreano", "Árabe", "Turco", "Vietnamita", "Polaco", "Ucraniano", "Griego", 
        "Holandés", "Sueco", "Noruego", "Danés", "Finlandés", "Checo", "Húngaro", "Hebreo", "Tailandés");
        languageComboBox.setValue("Español");

        languageComboBox.setStyle(
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-background-color: #364C63; " +
            "-fx-pref-width: 200; " +
            "-fx-pref-height: 40;" 
        );
        
        languageComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #364C63;");
                }
            }
        });
            
        ComboBox<String> regionComboBox = new ComboBox<>();
        regionComboBox.getItems().addAll("México", "Estados Unidos", "Canadá", "España", "Colombia", 
        "Brasil", "Argentina", "Chile", "Perú", "Venezuela", "Ecuador", "Uruguay", "Paraguay", "Bolivia", 
        "Cuba", "Costa Rica", "Panamá", "Guatemala", "Honduras", "El Salvador", "Nicaragua", 
        "República Dominicana", "Puerto Rico", "Alemania", "Francia", "Italia", "Reino Unido", 
        "Rusia", "China", "Japón", "India", "Australia", "Sudáfrica", "Egipto", "Turquía", 
        "Grecia", "Corea del Sur", "Indonesia", "Filipinas", "Vietnam", "Tailandia", "Malasia", 
        "Singapur", "Nueva Zelanda", "Suecia", "Noruega", "Dinamarca", "Finlandia", "Polonia", 
        "Hungría", "Chequia", "Portugal", "Irlanda", "Suiza", "Austria", "Bélgica", "Países Bajos");
        regionComboBox.setValue("México");

        regionComboBox.setStyle(
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-background-color: #364C63; " +
            "-fx-pref-width: 200; " +
            "-fx-pref-height: 40;" 
        );
        
        regionComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #364C63;");
                }
            }
        });

        Region spacer2 = new Region();
        spacer2.setPrefHeight(10);

        Button notificationsButton = new Button();

        // Cargar la imagen
        Image icon = new Image("link.png");  // Reemplaza con la ruta de tu imagen
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(20);  // Ajusta el tamaño de la imagen
        iconView.setFitHeight(20);

        // Crear un contenedor HBox para el texto y la imagen (texto primero)
        HBox buttonContent = new HBox(15);  // Espacio entre el texto y la imagen
        buttonContent.setAlignment(Pos.CENTER);  // Centrar contenido dentro del HBox

        // Establecer el texto con estilo
        Label textLabel = new Label("Notificaciones");
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        textLabel.setTextFill(javafx.scene.paint.Color.WHITE);  // Color de texto blanco

        // Añadir texto e imagen al HBox
        buttonContent.getChildren().addAll(textLabel, iconView);

        // Configurar el botón
        notificationsButton.setGraphic(buttonContent);  // Asignar el HBox al botón
        notificationsButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;" +
            "-fx-text-fill: #999999;"        
        );
        notificationsButton.setPrefWidth(200);
        notificationsButton.setPrefHeight(50);

        Region spacer3 = new Region();
        spacer3.setPrefHeight(10);

        Label regionLabel2 = new Label("Asistencia");
        regionLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        regionLabel2.setStyle("-fx-text-fill: white;");

        // Crear los botones
        Button assistanceButton = new Button("Solicitar asistencia");
        assistanceButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        assistanceButton.setPrefWidth(200);
        assistanceButton.setPrefHeight(40);
        assistanceButton.setFont(Font.font("Arial", 14));
        assistanceButton.setTextFill(javafx.scene.paint.Color.WHITE);

        Region spacer4 = new Region();
        spacer4.setPrefHeight(10);

        Button termsButton = new Button("Condiciones del Servicio");
        termsButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        termsButton.setPrefWidth(200);
        termsButton.setPrefHeight(40);
        termsButton.setFont(Font.font("Arial", 14));
        termsButton.setTextFill(javafx.scene.paint.Color.WHITE);

        Button communityButton = new Button("Normas Comunitarias");
        communityButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        communityButton.setPrefWidth(200);
        communityButton.setPrefHeight(40);
        communityButton.setFont(Font.font("Arial", 14));
        communityButton.setTextFill(javafx.scene.paint.Color.WHITE);

        Region spacer5 = new Region();
        spacer5.setPrefHeight(10);

        Button aboutButton = new Button("Acerca de SoundSphere");
        aboutButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        aboutButton.setPrefWidth(200);
        aboutButton.setPrefHeight(40);
        aboutButton.setFont(Font.font("Arial", 14));
        aboutButton.setTextFill(javafx.scene.paint.Color.WHITE);

        leftPanel.getChildren().addAll(region, regionLabel, languageComboBox, regionComboBox, spacer2, notificationsButton, spacer3, regionLabel2, assistanceButton, spacer4, termsButton, communityButton, aboutButton);

        // Panel central: Configuración de Reproducción
        VBox centerPanel = new VBox(15);
        centerPanel.setPadding(new Insets(-20, 10, 10, 10));  // 10px arriba, 10px derecha, 10px abajo, 30px izquierda
        centerPanel.setStyle("-fx-background-color: #242E49;");

        Region region1 = new Region();
        region1.setPrefHeight(5);

        Label playbackLabel = new Label("Configuración de Reproducción");
        playbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        playbackLabel.setStyle("-fx-text-fill: white;");

        Button equalizerButton = new Button("Ecualizador");
        equalizerButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;" +
            "-fx-text-fill: #FFFFFF;"        
        );
        equalizerButton.setPrefWidth(200);
        equalizerButton.setPrefHeight(40);

        Label regionLabel3 = new Label("Crossfade");
        regionLabel3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        regionLabel3.setStyle("-fx-text-fill: white;");

        // Contenedor HBox para centrar el botón
        HBox equalizerButtonBox = new HBox(equalizerButton);
        equalizerButtonBox.setMaxWidth(Double.MAX_VALUE); // Asegura que ocupe todo el espacio horizontal disponible
        equalizerButtonBox.setPadding(new Insets(10, 10, 10, 100)); // Agrega 20px de espacio a la izquierda

        Slider crossfadeSlider = new Slider(0, 12, 0);
        crossfadeSlider.setShowTickMarks(true);
        crossfadeSlider.setShowTickLabels(true);
        crossfadeSlider.setStyle("-fx-control-inner-background: #555;");
        crossfadeSlider.setMaxWidth(400); // Limitar el ancho máximo del slider

        HBox sliderBox = new HBox(crossfadeSlider);
        sliderBox.setAlignment(Pos.CENTER_LEFT);

        // Permite que el slider se expanda para ocupar todo el espacio disponible
        HBox.setHgrow(crossfadeSlider, Priority.ALWAYS);

        // Elimina el límite de ancho máximo
        sliderBox.setMaxWidth(Double.MAX_VALUE);  // Esto asegura que el HBox ocupe todo el espacio disponible

        Region region6 = new Region();
        region6.setPrefHeight(5);

        CheckBox volumeNormalization = new CheckBox("Normalización de Volumen");
        volumeNormalization.setSelected(true);
        volumeNormalization.setStyle("-fx-text-fill: white;");  // Establece el color del texto a blanco
        volumeNormalization.setFont(Font.font("Arial",16));

        CheckBox songCache = new CheckBox("Caché de Canciones");
        songCache.setSelected(true);
        songCache.setStyle("-fx-text-fill: white;");  // Establece el color del texto a blanco
        songCache.setFont(Font.font("Arial",16));

        CheckBox offlineMode = new CheckBox("Modo Offline");
        offlineMode.setSelected(false);
        offlineMode.setStyle("-fx-text-fill: white;");  // Establece el color del texto a blanco
        offlineMode.setFont(Font.font("Arial",16));

        Region region5 = new Region();
        region5.setPrefHeight(5);

        Label regionLabel4 = new Label("Calidad del audio");
        regionLabel4.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        regionLabel4.setStyle("-fx-text-fill: white;");

        ComboBox<String> playbackQualityCombo = new ComboBox<>();
        playbackQualityCombo.getItems().addAll("Alta", "Media", "Baja");
        playbackQualityCombo.setValue("Alta");

        playbackQualityCombo.setStyle(
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-background-color: #364C63; " +
            "-fx-pref-width: 200; " +
            "-fx-pref-height: 40;" 
        );
        
        playbackQualityCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #364C63;");
                }
            }
        });

        Region region7 = new Region();
        region7.setPrefHeight(5);

        Label regionLabel7 = new Label("Calidad de descargas");
        regionLabel7.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        regionLabel7.setStyle("-fx-text-fill: white;");

        ComboBox<String> downloadQualityCombo = new ComboBox<>();
        downloadQualityCombo.getItems().addAll("Muy Alta", "Alta", "Media", "Baja");
        downloadQualityCombo.setValue("Muy Alta");

        downloadQualityCombo.setStyle(
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-background-color: #364C63; " +
            "-fx-pref-width: 200; " +
            "-fx-pref-height: 40;"
        );

        downloadQualityCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #364C63;");
                }
            }
        });

        centerPanel.getChildren().addAll(
            region1,
            playbackLabel,
            equalizerButtonBox,  // Agregar el contenedor centrado
            regionLabel3,
            sliderBox,
            region6,
            volumeNormalization,
            songCache,
            offlineMode,
            region5,
            regionLabel4,
            playbackQualityCombo,
            regionLabel7,
            downloadQualityCombo
        );

        // Panel derecho: Configuración Social
        VBox rightPanel = new VBox(15);
        rightPanel.setPadding(new Insets(0, 50, 10, 10)); // Ajusta el padding para consistencia
        rightPanel.setStyle("-fx-background-color: #242E49;");
        

        // Etiqueta principal
        Label socialLabel = new Label("Configuración Social");
        socialLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        socialLabel.setStyle("-fx-text-fill: white;");

        Region region11 = new Region();
        region11.setPrefHeight(5);

        // Botón "Cuenta" con imagen
        // Cargar la imagen
        Image accountIcon = new Image("link.png");  // Reemplaza con la ruta de tu imagen
        ImageView accountIconView = new ImageView(accountIcon);
        accountIconView.setFitWidth(20);  // Ajusta el tamaño de la imagen
        accountIconView.setFitHeight(20);

        // Crear un contenedor HBox para el texto y la imagen (texto primero)
        HBox accountButtonContent = new HBox(15);  // Espacio entre el texto y la imagen
        accountButtonContent.setAlignment(Pos.CENTER);  // Centrar contenido dentro del HBox

        // Establecer el texto con estilo
        Label accountTextLabel = new Label("Cuenta");
        accountTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        accountTextLabel.setTextFill(javafx.scene.paint.Color.WHITE);  // Color de texto blanco

        // Añadir texto e imagen al HBox
        accountButtonContent.getChildren().addAll(accountTextLabel, accountIconView);

        // Configurar el botón
        Button accountButton = new Button();  // Botón vacío porque usamos el HBox como contenido
        accountButton.setGraphic(accountButtonContent);  // Asignar el HBox al botón
        accountButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;" +
            "-fx-text-fill: #999999;"
        );
        accountButton.setPrefWidth(200);
        accountButton.setPrefHeight(50);

        Region region8 = new Region();
        region8.setPrefHeight(5);

        // CheckBoxes
        CheckBox publicProfile = new CheckBox("Perfil Público");
        publicProfile.setSelected(true);
        publicProfile.setStyle("-fx-text-fill: white;");
        publicProfile.setFont(Font.font("Arial", 16));

        CheckBox publicPlaylists = new CheckBox("Playlist Públicas");
        publicPlaylists.setSelected(true);
        publicPlaylists.setStyle("-fx-text-fill: white;");
        publicPlaylists.setFont(Font.font("Arial", 16));

        CheckBox activityLog = new CheckBox("Registro de Actividad");
        activityLog.setSelected(true);
        activityLog.setStyle("-fx-text-fill: white;");
        activityLog.setFont(Font.font("Arial", 16));

        // Botón "Descargar tu información"
        Button downloadInfoButton = new Button("Descargar tu información");
        downloadInfoButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;" +
            "-fx-text-fill: #FFFFFF;"
        );
        downloadInfoButton.setPrefWidth(200);
        downloadInfoButton.setPrefHeight(40);
        downloadInfoButton.setFont(Font.font("Arial", 14));
        downloadInfoButton.setTextFill(javafx.scene.paint.Color.WHITE);

        Region region9 = new Region();
        region9.setPrefHeight(15);

        // Botón "Agregar Cuenta"
        Image addAccountIcon = new Image("link.png");  // Reemplaza con la ruta de tu imagen
        ImageView addAccountIconView = new ImageView(addAccountIcon);
        addAccountIconView.setFitWidth(20);  // Ajusta el tamaño de la imagen
        addAccountIconView.setFitHeight(20);

        // Crear un contenedor HBox para el texto y la imagen (texto primero)
        HBox addAccountButtonContent = new HBox(15);  // Espacio entre el texto y la imagen
        addAccountButtonContent.setAlignment(Pos.CENTER);  // Centrar contenido dentro del HBox

        // Establecer el texto con estilo
        Label addAccountTextLabel = new Label("Agregar Cuenta");
        addAccountTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        addAccountTextLabel.setTextFill(javafx.scene.paint.Color.WHITE);  // Color de texto blanco

        // Añadir texto e imagen al HBox
        addAccountButtonContent.getChildren().addAll(addAccountTextLabel, addAccountIconView);

        // Configurar el botón
        Button addAccountButton = new Button();  // Botón vacío porque usamos el HBox como contenido
        addAccountButton.setGraphic(addAccountButtonContent);  // Asignar el HBox al botón
        addAccountButton.setStyle(
            "-fx-background-color: #364C63; " +
            "-fx-border-color: #5A6D86; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;" +
            "-fx-text-fill: #FFFFFF;"
        );
        addAccountButton.setPrefWidth(200);
        addAccountButton.setPrefHeight(50);

        // Botón "Cerrar Sesión"
        HBox logoutButtonContent = new HBox(15);  // Espacio entre texto e imagen (aunque no tiene imagen)
        logoutButtonContent.setAlignment(Pos.CENTER);  // Centrar contenido dentro del HBox

        Label logoutTextLabel = new Label("Cerrar Sesión");
        logoutTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        logoutTextLabel.setTextFill(javafx.scene.paint.Color.WHITE);  // Color de texto blanco

        logoutButtonContent.getChildren().addAll(logoutTextLabel);

        Button logoutButton = new Button();
        logoutButton.setGraphic(logoutButtonContent);  // Asignar el HBox al botón
        logoutButton.setStyle(
            "-fx-background-color: #B4182D; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 5; " +
            "-fx-text-fill: white;"
        );
        logoutButton.setPrefWidth(200);
        logoutButton.setPrefHeight(50);

        // Agregar todos los elementos al panel
        rightPanel.getChildren().addAll(
            socialLabel,
            region11,
            accountButton,
            region8,
            publicProfile,
            publicPlaylists,
            activityLog,
            downloadInfoButton,
            region9,
            addAccountButton,
            logoutButton
);

        // Añadir paneles al diseño principal
        mainPane.setTop(topBar);
        mainPane.setLeft(leftPanel);
        mainPane.setCenter(centerPanel);
        mainPane.setRight(rightPanel);

        // Escena y configuración
        Scene scene = new Scene(mainPane, 1000, 700);
        primaryStage.setTitle("Gestor de Ajustes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
