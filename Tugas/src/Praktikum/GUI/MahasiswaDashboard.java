package Praktikum.GUI;

import Praktikum.Data.DataStore;
import Praktikum.Data.Item;
import Praktikum.Users.Mahasiswa;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard extends Application {

    private ObservableList<Item> laporanData;

    private Mahasiswa mahasiswa;

    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.laporanData = FXCollections.observableArrayList();
        // Load semua laporan yang sudah ada dari DataStore
        this.laporanData.addAll(DataStore.ReportedItems);
    }

    public MahasiswaDashboard() {
        this.laporanData = FXCollections.observableArrayList();
        this.laporanData.addAll(DataStore.ReportedItems);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lost & Found Kampus");

        Label welcomeLabel = new Label("Selamat datang, " + mahasiswa.getInput1());
        Label laporanLabel = new Label("Laporkan Barang Hilang/Temuan");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi Barang");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");
        laporBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String deskripsi = deskripsiField.getText();
            String lokasi = lokasiField.getText();

            if (!nama.isEmpty() && !lokasi.isEmpty()) {
                Item item = new Item(nama, deskripsi, lokasi, "Reported");
                laporanData.add(item);
                DataStore.ReportedItems.add(item);

                namaField.clear();
                deskripsiField.clear();
                lokasiField.clear();
            }
        });

        HBox inputBox = new HBox(10, namaField, deskripsiField, lokasiField, laporBtn);
        inputBox.setPadding(new Insets(10));

        TableView<Item> laporanTable = new TableView<>();
        laporanTable.setItems(laporanData);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNamaItem()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLokasi()));

        laporanTable.getColumns().addAll(namaCol, lokasiCol);

        Label daftarLaporanLabel = new Label("Daftar Laporan Anda");

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            try {
                // Kembali ke halaman LoginPane di stage yang sama
                LoginPane loginPane = new LoginPane();
                loginPane.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(10, welcomeLabel, laporanLabel, inputBox, daftarLaporanLabel, laporanTable, logoutBtn);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
