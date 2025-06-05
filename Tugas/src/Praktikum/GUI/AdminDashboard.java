package Praktikum.GUI;

import Praktikum.Data.DataStore;
import Praktikum.Users.Admin;
import Praktikum.Users.Mahasiswa;
import Praktikum.Data.Item;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard extends Application {

    private Admin user;

    public AdminDashboard(Admin user) {
        this.user = user;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lost & Found Kampus");

        // Label atas
        Label greetingLabel = new Label("Halo, Administrator " + (user != null ? user.getInput1() : "admin"));
        greetingLabel.setPadding(new Insets(10, 0, 10, 10));

        // Table untuk laporan barang, pakai Item langsung
        TableView<Item> laporanTable = new TableView<>();
        laporanTable.setPlaceholder(new Label("Belum ada laporan"));

        TableColumn<Item, String> colNamaBarang = new TableColumn<>("Nama");
        colNamaBarang.setPrefWidth(150);
        colNamaBarang.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNamaItem()));

        TableColumn<Item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setPrefWidth(150);
        colLokasi.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLokasi()));

        TableColumn<Item, String> colStatus = new TableColumn<>("Status");
        colStatus.setPrefWidth(100);
        colStatus.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatus()));

        laporanTable.getColumns().addAll(colNamaBarang, colLokasi, colStatus);
        laporanTable.setPrefHeight(200);

        // Isi data dari DataStore
        ObservableList<Item> laporanData = FXCollections.observableArrayList(DataStore.ReportedItems);
        laporanTable.setItems(laporanData);

        Button tandaiClaimedBtn = new Button("Tandai Claimed");
        tandaiClaimedBtn.setOnAction(e -> {
            Item selected = laporanTable.getSelectionModel().getSelectedItem();
            if(selected != null) {
                selected.setStatus("Claimed");
                laporanTable.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih laporan barang terlebih dahulu.");
                alert.showAndWait();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            try {
                LoginPane loginPane = new LoginPane();
                loginPane.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        VBox leftPane = new VBox(10, greetingLabel, new Label("Laporan Barang"), laporanTable, tandaiClaimedBtn, logoutBtn);
        leftPane.setPadding(new Insets(10));
        leftPane.setPrefWidth(450);

        // Table untuk data mahasiswa, pakai Mahasiswa langsung
        TableView<Mahasiswa> mahasiswaTable = new TableView<>();
        mahasiswaTable.setPlaceholder(new Label("Belum ada data"));

        TableColumn<Mahasiswa, String> colNamaMahasiswa = new TableColumn<>("Nama");
        colNamaMahasiswa.setPrefWidth(200);
        colNamaMahasiswa.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getInput1()));

        TableColumn<Mahasiswa, String> colNIM = new TableColumn<>("NIM");
        colNIM.setPrefWidth(150);
        colNIM.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getInput2()));

        mahasiswaTable.getColumns().addAll(colNamaMahasiswa, colNIM);
        mahasiswaTable.setPrefHeight(200);

        // Isi data mahasiswa dari DataStore.UserList, filter yang Mahasiswa
        ObservableList<Mahasiswa> mahasiswaData = FXCollections.observableArrayList();
        for (var u : DataStore.UserList) {
            if (u instanceof Mahasiswa mhs) {
                mahasiswaData.add(mhs);
            }
        }
        mahasiswaTable.setItems(mahasiswaData);

        // Form input bawah
        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambah");
        tambahBtn.setPrefWidth(140);  // Atur lebar supaya muat teks
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText().trim();
            String nim = nimField.getText().trim();

            if(nama.isEmpty() || nim.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Nama dan NIM harus diisi!");
                alert.showAndWait();
                return;
            }

            Mahasiswa newMhs = new Mahasiswa(nama, nim);
            DataStore.UserList.add(newMhs);
            mahasiswaData.add(newMhs);

            namaField.clear();
            nimField.clear();
        });

        Button hapusBtn = new Button("Hapus");
        hapusBtn.setPrefWidth(140);  // Atur lebar supaya muat teks
        hapusBtn.setOnAction(e -> {
            Mahasiswa selected = mahasiswaTable.getSelectionModel().getSelectedItem();
            if(selected != null) {
                DataStore.UserList.remove(selected);
                mahasiswaData.remove(selected);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih mahasiswa terlebih dahulu.");
                alert.showAndWait();
            }
        });

        HBox form = new HBox(10, namaField, nimField, tambahBtn, hapusBtn);
        form.setPadding(new Insets(10));

        VBox rightPane = new VBox(10, new Label("Data Mahasiswa"), mahasiswaTable, form);
        rightPane.setPadding(new Insets(10));
        rightPane.setPrefWidth(400);

        // Layout utama
        HBox root = new HBox(leftPane, rightPane);

        Scene scene = new Scene(root, 850, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
