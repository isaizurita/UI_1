import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

//Ésta interfaz es análoga a las dos anteriores en cuanto a componentes y configuraciones
public class SignupUI extends Application 
    {

        @Override
        public void start(Stage primaryStage) 
            {
                VBox root = new VBox(15);
                root.setAlignment(Pos.CENTER);
                root.setStyle("-fx-background-color: #242E49;");

                ImageView logo = new ImageView(new Image("file:logo.png"));
                logo.setFitWidth(180);
                logo.setPreserveRatio(true);

                Text title = new Text("Registro para nuevos usuarios");
                title.setFont(Font.font("Montserrat", 20));
                title.setStyle("-fx-fill: white;");

                Text title2 = new Text("Para crear tu cuenta ingresa la siguiente información:");
                title2.setFont(Font.font("Montserrat", 14));
                title2.setStyle("-fx-fill: white;");

                Region spacer1 = new Region();
                spacer1.setPrefHeight(5);

                TextField usernameField = new TextField();
                usernameField.setPromptText("Ingresa un correo electrónico");
                usernameField.setFont(Font.font("Montserrat", 14));

                TextField usernameField2 = new TextField();
                usernameField2.setPromptText("Crea un nombre de usuario");
                usernameField2.setFont(Font.font("Montserrat", 14));

                Region spacer2 = new Region();
                spacer2.setPrefHeight(8);

                PasswordField passwordField = new PasswordField();
                passwordField.setPromptText("Crea una contraseña");
                passwordField.setFont(Font.font("Montserrat", 14));

                PasswordField passwordField2 = new PasswordField();
                passwordField2.setPromptText("Crea una contraseña");
                passwordField2.setFont(Font.font("Montserrat", 14));

                Region spacer3 = new Region();
                spacer3.setPrefHeight(12);

                Button Button = new Button("Crear cuenta");
                Button.setFont(Font.font("Montserrat", 14));
                Button.setStyle("-fx-background-color: #37415C; -fx-text-fill: white;");

                Button.setOnMouseEntered(e -> 
                    {
                        Button.setStyle("-fx-background-color: #5A6D86; -fx-text-fill: white;");
                    });

                Button.setOnMouseExited(e -> 
                    {
                        Button.setStyle("-fx-background-color: #37415C; -fx-text-fill: white;");
                    });

                root.getChildren().addAll(logo, title, title2, spacer1, usernameField,usernameField2, spacer2, passwordField, passwordField2, spacer3, Button);

                Scene scene = new Scene(root, 400, 650);
                scene.getRoot().setStyle("-fx-background-color: #242E49;");

                Platform.runLater(() -> 
                    {
                        root.requestFocus();
                    });

                primaryStage.setTitle("SoundSphere - Registro");
                primaryStage.setScene(scene);
                primaryStage.show();
            }

        public static void main(String[] args) 
            {
                launch(args);
            }
    }
