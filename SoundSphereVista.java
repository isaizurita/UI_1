package Vista;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class SoundSphereVista {
    private BorderPane raiz;
    private HBox barraSuperior;
    private VBox panelIzquierdo;
    private VBox panelCentral;
    private HBox barraInferior;
    private TextField barraBusqueda;
    private Button botonReproducir;
    private Button botonSiguiente;
    private Button botonAnterior;
 
    public SoundSphereVista() {
        raiz = new BorderPane();
        
        // Fondo azul
        raiz.setStyle("-fx-background-color: #547296;");

        // Barra superior
        barraSuperior = crearBarraSuperior();

        // Panel izquierdo
        panelIzquierdo = crearPanelIzquierdo();

        // Panel central
        //panelCentral = crearPanelCentral();
        panelCentral = crearPanelPlaylist();

        // Barra inferior
        barraInferior = crearBarraInferior();

        // Layout principal
        raiz.setTop(barraSuperior);
        raiz.setLeft(panelIzquierdo);
        raiz.setCenter(panelCentral);
        raiz.setBottom(barraInferior);
    }

    private HBox crearBarraSuperior() {
        HBox barraSuperior = new HBox(10);
        barraSuperior.setStyle("-fx-background-color: #2d2d2d; -fx-padding: 10;");
        barraSuperior.setPadding(new Insets(0,0,20,0));

        // Logo
        Label logo = new Label("S");
        logo.setFont(new Font("Arial", 20));
        logo.setTextFill(Color.WHITE);

        // Barra de búsqueda
        barraBusqueda = new TextField();
        barraBusqueda.setPromptText("¿Qué quieres escuchar?");
        barraBusqueda.setPrefWidth(200);

        // Íconos
        Button notificaciones = new Button("🔔");
        Button perfil = new Button("Usuario123");
        notificaciones.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        perfil.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        // Alineación de los elementos
        HBox.setHgrow(barraBusqueda, Priority.ALWAYS);
        barraSuperior.getChildren().addAll(logo, barraBusqueda, notificaciones, perfil);
        return barraSuperior;
    }

    private VBox crearPanelIzquierdo() {
        // Configuración del panel izquierdo
        VBox panelIzquierdo = new VBox(15);
        panelIzquierdo.setStyle("-fx-background-color: #000000; -fx-padding: 10;");
        panelIzquierdo.setPrefWidth(200);
    
        // Agregar margen al panel izquierdo
        panelIzquierdo.setPadding(new Insets(20, 10, 20, 10));
    
        // Botón de búsqueda de playlist
        Button botonBuscarPlaylist = new Button("🔍");
        botonBuscarPlaylist.setTooltip(new Tooltip("Buscar Playlist"));
        botonBuscarPlaylist.setStyle(
            "-fx-background-color: #3a3a3a; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16; " +
            "-fx-background-radius: 5; " +
            "-fx-padding: 5;"
        );
        botonBuscarPlaylist.setPrefSize(40, 40);
    
        // Botón de más opciones
        Button botonMasOpciones = new Button("☰");
        botonMasOpciones.setTooltip(new Tooltip("Más opciones"));
        botonMasOpciones.setStyle(
            "-fx-background-color: #3a3a3a; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16; " +
            "-fx-background-radius: 5; " +
            "-fx-padding: 5;"
        );
        botonMasOpciones.setPrefSize(40, 40);
    
        // Contenedor para los botones superiores
        HBox contenedorBotones = new HBox(10);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.getChildren().addAll(botonBuscarPlaylist, botonMasOpciones);
    
        // Contenedor para las playlists
        VBox listaPlaylists = new VBox(10);
        listaPlaylists.setStyle("-fx-background-color: #000000;");
    
        // Añadir playlists simuladas
        for (int i = 1; i <= 10; i++) {
            HBox playlist = new HBox(10);
    
            // Imagen de la playlist (simulada por ahora)
            ImageView imagenPlaylist = new ImageView();
            imagenPlaylist.setFitWidth(40);
            imagenPlaylist.setFitHeight(40);
            imagenPlaylist.setStyle("-fx-background-color: #3a3a3a; -fx-border-radius: 5;");
    
            // Nombre de la playlist
            Label nombrePlaylist = new Label("Playlist " + i);
            nombrePlaylist.setTextFill(Color.WHITE);
            nombrePlaylist.setFont(new Font("Arial", 14));
    
            // Añadir imagen y texto a cada playlist
            playlist.getChildren().addAll(imagenPlaylist, nombrePlaylist);
            playlist.setAlignment(Pos.CENTER_LEFT);
            playlist.setStyle("-fx-background-color: #1c1c1c; -fx-padding: 5; -fx-border-radius: 5;");
            playlist.setPadding(new Insets(5));
    
            // Añadir la playlist al contenedor principal
            listaPlaylists.getChildren().add(playlist);
        }
    
        // Crear ScrollPane para las playlists
        ScrollPane scrollPanePlaylist = new ScrollPane();
        scrollPanePlaylist.setContent(listaPlaylists);
        scrollPanePlaylist.setFitToHeight(true);
        scrollPanePlaylist.setFitToWidth(true);
        scrollPanePlaylist.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Ocultar barra horizontal
        scrollPanePlaylist.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Mostrar barra vertical cuando sea necesario
    
        // Estilo del ScrollPane
        scrollPanePlaylist.setStyle(
            "-fx-background-color: #000000;" +
            "-fx-background: #000000;" +
            "-fx-control-inner-background: #000000;" +
            "-fx-border-color: transparent;" +
            "-fx-border-width: 0;"
        );
    
        // Eliminar márgenes internos en el contenido del ScrollPane
        scrollPanePlaylist.setPadding(Insets.EMPTY);
    
        // Añadir botones y el ScrollPane al panel izquierdo
        panelIzquierdo.getChildren().addAll(contenedorBotones, scrollPanePlaylist);
    
        return panelIzquierdo;
    }
    
  /* * 
    private VBox crearPanelCentral() {
        VBox panelCentral = new VBox(10);
        panelCentral.setStyle("-fx-background-color: transparent; -fx-padding: 10;");
    
        // Imagen del álbum/canción
        ImageView imagenCancion = new ImageView();
        imagenCancion.setFitWidth(150);
        imagenCancion.setFitHeight(150);
        imagenCancion.setStyle("-fx-border-color: white; -fx-border-width: 2;");
    
        // Cargar una imagen de ejemplo
        try {
            Image imagenEjemplo = new Image(getClass().getResource("Everybody_Wants_to_Rule_the_World.png").toExternalForm());
            imagenCancion.setImage(imagenEjemplo);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + e.getMessage());
        }
    
        // Título y artista
        Label tituloCancion = new Label("Nombre de la canción");
        Label nombreArtista = new Label("Artista");
        tituloCancion.setFont(new Font("Arial", 25));
        tituloCancion.setTextFill(Color.WHITE);
        nombreArtista.setTextFill(Color.LIGHTGRAY);
    
        // Botones funcionales
        HBox botonesFuncionales = new HBox(15);
        botonesFuncionales.setAlignment(Pos.CENTER_LEFT);
    
        Button botonAgregar = new Button("+");
        botonAgregar.setTooltip(new Tooltip("Agregar a playlist"));
        botonAgregar.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");
    
        Button botonMeGusta = new Button("❤");
        botonMeGusta.setTooltip(new Tooltip("Me gusta"));
        botonMeGusta.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");
    
        Button botonVerLetra = new Button("🎵");
        botonVerLetra.setTooltip(new Tooltip("Ver letra completa"));
        botonVerLetra.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");
    
        Button botonCompartir = new Button("✉");
        botonCompartir.setTooltip(new Tooltip("Compartir"));
        botonCompartir.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");
    
        Button botonMasAcciones = new Button("☰");
        botonMasAcciones.setTooltip(new Tooltip("Más acciones"));
        botonMasAcciones.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");
    
        botonesFuncionales.getChildren().addAll(botonAgregar, botonMeGusta, botonVerLetra, botonCompartir, botonMasAcciones);
    
        VBox infoCancion = new VBox(10);
        infoCancion.getChildren().addAll(tituloCancion, nombreArtista, botonesFuncionales);
    
        HBox contenedorSuperior = new HBox(15);
        contenedorSuperior.setAlignment(Pos.CENTER_LEFT);
        contenedorSuperior.getChildren().addAll(imagenCancion, infoCancion);
    
        VBox subpanel1 = new VBox(10);
        subpanel1.setStyle("-fx-background-color: #2d2d2d; -fx-padding: 10;");
        subpanel1.getChildren().addAll(contenedorSuperior);
    
        VBox.setVgrow(subpanel1, Priority.NEVER);
    
        // Letra de la canción
        VBox subpanel2 = new VBox(10);
        subpanel2.setStyle("-fx-background-color: #3a3a3a; -fx-padding: 10;");
        Label tituloLetra = new Label("Letra de la canción");
        tituloLetra.setTextFill(Color.WHITE);
        tituloLetra.setFont(new Font("Arial", 16));
        TextArea areaLetra = new TextArea();
        areaLetra.setEditable(false);
        areaLetra.setWrapText(true);
        areaLetra.setStyle("-fx-control-inner-background: #2d2d2d; -fx-text-fill: white; -fx-font-size: 14;");
    
        areaLetra.setPrefWidth(300);
        areaLetra.setPrefHeight(300);
        subpanel2.getChildren().addAll(tituloLetra, areaLetra);
    
        // Acerca del artista
        VBox subpanel3 = new VBox(10);
        subpanel3.setStyle("-fx-background-color: #3a3a3a; -fx-padding: 10;");
        Label tituloBioArtista = new Label("Acerca del artista");
        tituloBioArtista.setTextFill(Color.WHITE);
        tituloBioArtista.setFont(new Font("Arial", 16));
        Button botonSeguir = new Button("Seguir");
        botonSeguir.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 5 10; -fx-font-size: 10;");
        TextArea areaBioArtista = new TextArea();
        areaBioArtista.setEditable(false);
        areaBioArtista.setWrapText(true);
        areaBioArtista.setStyle("-fx-control-inner-background: #2d2d2d; -fx-text-fill: white; -fx-font-size: 14;");
    
        areaBioArtista.setPrefWidth(300);
        areaBioArtista.setPrefHeight(300);
        subpanel3.getChildren().addAll(new HBox(10, tituloBioArtista, botonSeguir), areaBioArtista);
    
        HBox subpanelInferior = new HBox(10);
        subpanelInferior.setAlignment(Pos.CENTER);
        subpanelInferior.getChildren().addAll(subpanel2, subpanel3);
    
        VBox.setVgrow(subpanelInferior, Priority.ALWAYS);
    
        panelCentral.getChildren().addAll(subpanel1, subpanelInferior);
    
        return panelCentral;
    }    
  */
  private VBox crearPanelPlaylist() {
    VBox panelPlaylist = new VBox(10);
    panelPlaylist.setStyle("-fx-background-color: transparent; -fx-padding: 10;");

    // Imagen de la playlist
    ImageView imagenPlaylist = new ImageView();
    imagenPlaylist.setFitWidth(150);
    imagenPlaylist.setFitHeight(150);
    imagenPlaylist.setStyle("-fx-border-color: white; -fx-border-width: 2;");

    // Nombre de la playlist y creador
    Label tituloPlaylist = new Label("Nombre de la playlist");
    Label creadorPlaylist = new Label("Creador");
    tituloPlaylist.setFont(new Font("Arial", 25));
    tituloPlaylist.setTextFill(Color.WHITE);
    creadorPlaylist.setTextFill(Color.LIGHTGRAY);

    // Botones funcionales
    HBox botonesFuncionales = new HBox(15);
    botonesFuncionales.setAlignment(Pos.CENTER_LEFT);

    Button botonDescargar = new Button("🔒");
    botonDescargar.setTooltip(new Tooltip("Privacidad de la playlist"));
    botonDescargar.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");

    Button botonAgregar = new Button("⬇");
    botonAgregar.setTooltip(new Tooltip("Descargar playlist"));
    botonAgregar.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");

    Button botonMeGusta = new Button("❤");
    botonMeGusta.setTooltip(new Tooltip("Me gusta"));
    botonMeGusta.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");

    Button botonMasAcciones = new Button("☰");
    botonMasAcciones.setTooltip(new Tooltip("Más acciones"));
    botonMasAcciones.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: white; -fx-font-size: 14;");

    botonesFuncionales.getChildren().addAll(botonDescargar, botonAgregar, botonMeGusta, botonMasAcciones);

    VBox infoPlaylist = new VBox(10);
    infoPlaylist.getChildren().addAll(tituloPlaylist, creadorPlaylist, botonesFuncionales);

    HBox contenedorSuperior = new HBox(15);
    contenedorSuperior.setAlignment(Pos.CENTER_LEFT);
    contenedorSuperior.getChildren().addAll(imagenPlaylist, infoPlaylist);

    VBox subpanelSuperior = new VBox(10);
    subpanelSuperior.setStyle("-fx-background-color: #2d2d2d; -fx-padding: 10;");
    subpanelSuperior.getChildren().addAll(contenedorSuperior);

    // Tabla para las canciones
    TableView<String> tablaCanciones = new TableView<>();
    tablaCanciones.setStyle("-fx-background-color: #3a3a3a; -fx-control-inner-background: #3a3a3a; -fx-text-fill: white;");

    TableColumn<String, String> columnaNumero = new TableColumn<>("#");
    columnaNumero.setPrefWidth(50);

    TableColumn<String, String> columnaTitulo = new TableColumn<>("Título");
    columnaTitulo.setPrefWidth(200);

    TableColumn<String, String> columnaAlbum = new TableColumn<>("Álbum");
    columnaAlbum.setPrefWidth(150);

    TableColumn<String, String> columnaFechaAgregado = new TableColumn<>("Fecha en la que se agregó");
    columnaFechaAgregado.setPrefWidth(200);

    TableColumn<String, String> columnaDuracion = new TableColumn<>("Duración");
    columnaDuracion.setPrefWidth(100);

    tablaCanciones.getColumns().addAll(columnaNumero, columnaTitulo, columnaAlbum, columnaFechaAgregado, columnaDuracion);

    VBox.setVgrow(tablaCanciones, Priority.ALWAYS);

    panelPlaylist.getChildren().addAll(subpanelSuperior, tablaCanciones);

    return panelPlaylist;
}


    private HBox crearBarraInferior() {
        HBox barraInferior = new HBox(10);
        barraInferior.setStyle("-fx-background-color: #000000; -fx-padding: 10;");
        
        // Agregar margen a la barra inferior
        HBox.setMargin(barraInferior, new javafx.geometry.Insets(10, 10, 10, 10));

        barraInferior.setAlignment(Pos.CENTER);

        // Controles de reproducción
        botonAnterior = new Button("⏮");
        botonReproducir = new Button("▶");
        botonSiguiente = new Button("⏭");

        barraInferior.getChildren().addAll(botonAnterior, botonReproducir, botonSiguiente);
        return barraInferior;
    }

    public BorderPane getRaiz() {
        return raiz;
    }

    public TextField getBarraBusqueda() {
        return barraBusqueda;
    }

    public Button getBotonReproducir() {
        return botonReproducir;
    }

    public Button getBotonSiguiente() {
        return botonSiguiente;
    }

    public Button getBotonAnterior() {
        return botonAnterior;
    }
}