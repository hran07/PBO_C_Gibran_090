package com.example.codelab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;

public class HelloController extends Application {

    private int angkaAcak;
    private int percobaan = 0;

    private final Random random = new Random();

    @Override
    public void start(Stage stage) {
        Label title = new Label(" Tebak Angka 1–100");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        title.setTextFill(Color.web("#FFFFFF"));

        Label feedback = new Label("Masukkan tebakanmu!");
        feedback.setTextFill(Color.WHITE);
        feedback.setFont(Font.font("Times New Roman"));

        TextField inputField = new TextField();
        inputField.setMaxWidth(200);

        Button button = new Button("Coba Tebak!");
        button.setStyle("-fx-background-color: #000080; -fx-text-fill: white;");

        Label percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setTextFill(Color.WHITE);
        percobaanLabel.setFont(Font.font("Times New Roman"));

        button.setOnAction(e -> {
            String input = inputField.getText();
            try {
                int tebakan = Integer.parseInt(input);
                percobaan++;
                percobaanLabel.setText("Jumlah percobaan: " + percobaan);

                if (tebakan < angkaAcak) {
                    feedback.setText("Terlalu kecil!");
                    feedback.setTextFill(Color.RED);
                    feedback.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                } else if (tebakan > angkaAcak) {
                    feedback.setText("Terlalu besar!");
                    feedback.setTextFill(Color.RED);
                    feedback.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                } else {
                    feedback.setText("Benar! Angkanya: " + angkaAcak);
                    feedback.setTextFill(Color.GREEN);
                    button.setText("Main Lagi");
                }

            } catch (NumberFormatException ex) {
                feedback.setText("Masukkan angka yang valid!");
                feedback.setTextFill(Color.RED);
            }
            inputField.clear();
        });

        angkaAcak = random.nextInt(100) + 1;

        VBox vbox = new VBox(10, title, feedback, inputField, button, percobaanLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-background-color: #40E0D0;");

        Scene scene = new Scene(vbox, 600, 600);
        stage.setTitle("Tebak Angka Advance");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
