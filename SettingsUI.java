import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SettingsUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Panel principal
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(10));
        
        // Logo e ícono de regreso
        HBox topBar = new HBox(10);
        topBar.setAlignment(Pos.CENTER_LEFT);

        ImageView backIcon = new ImageView(new Image("back-icon.png"));
        backIcon.setFitWidth(30);
        backIcon.setFitHeight(30);

        ImageView logo = new ImageView(new Image("logo.png"));
        logo.setFitWidth(50);
        logo.setFitHeight(50);

        Label title = new Label("AJUSTES");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        topBar.getChildren().addAll(backIcon, logo, title);

        // Panel izquierdo: Idioma y Región
        VBox leftPanel = new VBox(15);

        leftPanel.setPadding(new Insets(10));
        leftPanel.setStyle("-fx-background-color: #2F3B46; -fx-border-radius: 10; -fx-border-color: #555;");

        Label regionLabel = new Label("Idioma y Región");
        regionLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("Español", "Inglés", "Francés", "Alemán", "Italiano", "Portugués", 
        "Ruso", "Chino", "Japonés", "Coreano", "Árabe", "Turco", "Vietnamita", "Polaco", "Ucraniano", "Griego", 
        "Holandés", "Sueco", "Noruego", "Danés", "Finlandés", "Checo", "Húngaro", "Hebreo", "Tailandés");
        languageComboBox.setValue("Español");

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

        Button notificationsButton = new Button("Notificaciones");
        Button assistanceButton = new Button("Solicitar asistencia");
        Button termsButton = new Button("Condiciones del Servicio");
        Button communityButton = new Button("Normas Comunitarias");
        Button aboutButton = new Button("Acerca de SoundSphere");

        leftPanel.getChildren().addAll(regionLabel, languageComboBox, regionComboBox, notificationsButton, assistanceButton, termsButton, communityButton, aboutButton);

        // Panel central: Configuración de Reproducción
        VBox centerPanel = new VBox(15);
        centerPanel.setPadding(new Insets(10));
        centerPanel.setStyle("-fx-background-color: #2F3B46; -fx-border-radius: 10; -fx-border-color: #555;");
        Label playbackLabel = new Label("Configuración de Reproducción");
        playbackLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");
        Button equalizerButton = new Button("Ecualizador");
        
        // Slider de crossfade con ancho limitado
        Slider crossfadeSlider = new Slider(0, 12, 0);
        crossfadeSlider.setShowTickMarks(true);
        crossfadeSlider.setShowTickLabels(true);
        crossfadeSlider.setStyle("-fx-control-inner-background: #555;");
        crossfadeSlider.setMaxWidth(400); // Limitar el ancho máximo del slider

        // Contenedor HBox para el slider
        HBox sliderBox = new HBox(crossfadeSlider);
        sliderBox.setAlignment(Pos.CENTER_LEFT);
        sliderBox.setMaxWidth(400); // Limitar el ancho del contenedor (opcional)

        CheckBox volumeNormalization = new CheckBox("Normalización de Volumen");
        volumeNormalization.setSelected(true);
        CheckBox songCache = new CheckBox("Caché de Canciones");
        songCache.setSelected(true);
        CheckBox offlineMode = new CheckBox("Modo Offline");
        offlineMode.setSelected(true);
        ComboBox<String> playbackQualityCombo = new ComboBox<>();
        playbackQualityCombo.getItems().addAll("Alta", "Media", "Baja");
        playbackQualityCombo.setValue("Alta");
        ComboBox<String> downloadQualityCombo = new ComboBox<>();
        downloadQualityCombo.getItems().addAll("Muy Alta", "Alta", "Media", "Baja");
        downloadQualityCombo.setValue("Muy Alta");
        centerPanel.getChildren().addAll(playbackLabel, equalizerButton, sliderBox, volumeNormalization, songCache, offlineMode, new Label("Calidad del audio"), playbackQualityCombo, downloadQualityCombo);

        // Panel derecho: Configuración Social
        VBox rightPanel = new VBox(15);
        rightPanel.setPadding(new Insets(10));
        rightPanel.setStyle("-fx-background-color: #2F3B46; -fx-border-radius: 10; -fx-border-color: #555;");

        Label socialLabel = new Label("Configuración Social");
        socialLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

        Button accountButton = new Button("Cuenta");

        CheckBox publicProfile = new CheckBox("Perfil Público");
        publicProfile.setSelected(true);

        CheckBox publicPlaylists = new CheckBox("Playlist Públicas");
        publicPlaylists.setSelected(true);

        CheckBox activityLog = new CheckBox("Registro de Actividad");
        activityLog.setSelected(true);

        Button downloadInfoButton = new Button("Descargar tu información");
        Button addAccountButton = new Button("Agregar Cuenta");
        Button logoutButton = new Button("Cerrar Sesión");
        logoutButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        rightPanel.getChildren().addAll(socialLabel, accountButton, publicProfile, publicPlaylists, activityLog, downloadInfoButton, addAccountButton, logoutButton);

        // Añadir paneles al diseño principal
        mainPane.setTop(topBar);
        mainPane.setLeft(leftPanel);
        mainPane.setCenter(centerPanel);
        mainPane.setRight(rightPanel);

        // Escena y configuración
        Scene scene = new Scene(mainPane, 1000, 700);
        scene.getStylesheets().add("styles.css"); // Archivo CSS opcional para personalizar estilos
        primaryStage.setTitle("Gestor de Ajustes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
