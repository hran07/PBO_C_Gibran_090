package Praktikum.GUI;

import Praktikum.Main.LoginSystem;
import Praktikum.Users.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class LoginPane extends Application {

    private ComboBox<String> roleCombo;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;

    public LoginPane() {
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kampus - Brann");

        Label titleLabel = new Label("Login Sistem");

        roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Mahasiswa", "Admin");
        roleCombo.setValue("Mahasiswa");

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> handleLogin(primaryStage));
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLogin(primaryStage);
            }
        });
        messageLabel = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                titleLabel, roleCombo, usernameField, passwordField, loginBtn, messageLabel);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin(Stage stage) {
        String role = roleCombo.getValue();
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = LoginSystem.tryLogin(username, password);

        if (user != null) {
            if (role.equals("Mahasiswa") && user instanceof Mahasiswa) {
                MahasiswaDashboard mhsDash = new MahasiswaDashboard((Mahasiswa) user);
                mhsDash.start(new Stage());
                stage.close();
            } else if (role.equals("Admin") && user instanceof Admin) {
                AdminDashboard adminDash = new AdminDashboard((Admin) user);
                adminDash.start(new Stage());
                stage.close();
            } else {
                messageLabel.setText("Login gagal, periksa peran (role) Anda.");
            }
        } else {
            messageLabel.setText("Login gagal, periksa kredensial.");
        }
    }
}
