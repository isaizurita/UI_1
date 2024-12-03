import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

public class LoginUI extends Application 
    {

        @Override
        public void start(Stage primaryStage) 
            {
                //Se crea el VBox que usaremos para la ventana y se define un color de fondo
                VBox root = new VBox(15);
                root.setAlignment(Pos.CENTER);
                root.setStyle("-fx-background-color: #242E49;");

                //Se carga la imagen y se configura
                ImageView logo = new ImageView(new Image("file:logo.png"));
                logo.setFitWidth(180);
                logo.setPreserveRatio(true);

                //Título
                Text title = new Text("SOUNDSPHERE");
                title.setFont(Font.font("Montserrat", 20));
                title.setStyle("-fx-fill: white;");

                //Uso de espacios solo por cuestiones estéticas
                Region spacer1 = new Region();
                spacer1.setPrefHeight(5);

                //Texto tipo "TextField" el cual se usa para indicar al usuario la información que debe ingresar
                TextField usernameField = new TextField();
                usernameField.setPromptText("Nombre de Usuario o Email");
                usernameField.setFont(Font.font("Montserrat", 14));

                //Campo de tipo "Password", cuando el usuario ingresa información, ésta no es visible
                PasswordField passwordField = new PasswordField();
                passwordField.setPromptText("Contraseña");
                passwordField.setFont(Font.font("Montserrat", 14));

                Region spacer2 = new Region();
                spacer2.setPrefHeight(5);

                //Creación y animación del botón principal para dar la sensación al usuario de que el botón está activo y se puede usar en cualquier momento
                Button loginButton = new Button("Iniciar Sesión");
                loginButton.setFont(Font.font("Montserrat", 14));
                loginButton.setStyle("-fx-background-color: #37415C; -fx-text-fill: white;");

                loginButton.setOnMouseEntered(e -> 
                    {
                        loginButton.setStyle("-fx-background-color: #5A6D86; -fx-text-fill: white;");
                    });

                loginButton.setOnMouseExited(e -> 
                    {
                        loginButton.setStyle("-fx-background-color: #37415C; -fx-text-fill: white;");
                    });

                Region spacer3 = new Region();
                spacer3.setPrefHeight(0);

                //Creación de un HBox dentro de un VBox para mayor claridad entre los datos
                HBox forgotPasswordBox = new HBox();
                forgotPasswordBox.setAlignment(Pos.CENTER);
                forgotPasswordBox.setSpacing(2);

                Text forgotPasswordText = new Text("¿Olvidaste tu contraseña?");
                forgotPasswordText.setFont(Font.font("Montserrat", 14));
                forgotPasswordText.setStyle("-fx-fill: white;");

                //Se subraya cuando se pasa el mouse por este texto
                Hyperlink forgotPasswordLink = new Hyperlink("Click aquí");
                forgotPasswordLink.setFont(Font.font("Montserrat", 14));
                forgotPasswordLink.setStyle("-fx-text-fill: white;");

                forgotPasswordBox.getChildren().addAll(forgotPasswordText, forgotPasswordLink);

                HBox registerBox = new HBox();
                registerBox.setAlignment(Pos.CENTER);
                registerBox.setSpacing(2);

                Text registerText = new Text("¿Aún no tienes una cuenta?");
                registerText.setFont(Font.font("Montserrat", 14));
                registerText.setStyle("-fx-fill: white;");

                Hyperlink registerLink = new Hyperlink("Regístrate aquí");
                registerLink.setFont(Font.font("Montserrat", 14));
                registerLink.setStyle("-fx-text-fill: white;");

                registerBox.getChildren().addAll(registerText, registerLink);

                //Se cargan todos los componentes
                root.getChildren().addAll(logo, title, spacer1, usernameField, passwordField, spacer2, loginButton, spacer3, forgotPasswordBox, registerBox);

                //Se carga y configura la escena
                Scene scene = new Scene(root, 400, 550);
                scene.getRoot().setStyle("-fx-background-color: #242E49;");

                //Función utilizada para que al iniciar la interfaz no haya aún una casilla seleccionada, ésto permite ver al usuario el tipo de información que debe ingresar
                Platform.runLater(() -> 
                    {
                        root.requestFocus();
                    });

                primaryStage.setTitle("SoundSphere - Inicio de Sesión");
                primaryStage.setScene(scene);
                primaryStage.show();
            }

        public static void main(String[] args) 
            {
                launch(args);
            }
    }
