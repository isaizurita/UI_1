import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

public class ResetPasswordUI extends Application 
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

                Text title = new Text("Recuperar Contraseña");
                title.setFont(Font.font("Montserrat", 20));
                title.setStyle("-fx-fill: white;");

                Region spacer1 = new Region();
                spacer1.setPrefHeight(5);

                TextField usernameField = new TextField();
                usernameField.setPromptText("Ingresa tu correo electrónico");
                usernameField.setFont(Font.font("Montserrat", 14));

                Region spacer2 = new Region();
                spacer2.setPrefHeight(5);

                Button Button = new Button("Enviar enlace de recuperación");
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

                root.getChildren().addAll(logo, title, spacer1, usernameField, spacer2, Button);

                Scene scene = new Scene(root, 400, 400);
                scene.getRoot().setStyle("-fx-background-color: #242E49;");

                Platform.runLater(() -> 
                    {
                        root.requestFocus();
                    });

                primaryStage.setTitle("SoundSphere - Restablecer Contraseña");
                primaryStage.setScene(scene);
                primaryStage.show();
            }

        public static void main(String[] args) 
            {
                launch(args);
            }
    }
