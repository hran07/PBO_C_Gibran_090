package Praktikum.Data;

public class Item {
    private String NamaItem;
    private String DeskripsiItem;
    private String Lokasi;
    private String Status;

    public Item(String namaItem, String deskripsiItem, String lokasi, String status) {
        NamaItem = namaItem;
        DeskripsiItem = deskripsiItem;
        Lokasi = lokasi;
        Status = status;
    }

    public String getNamaItem() {
        return NamaItem;
    }

    public String getDeskripsiItem() {
        return DeskripsiItem;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
