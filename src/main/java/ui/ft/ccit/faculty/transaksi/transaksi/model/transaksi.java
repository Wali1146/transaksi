package ui.ft.ccit.faculty.transaksi.transaksi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transaksi")
public class transaksi {
    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "tgl_transaksi")
    private String tglTransaksi;

    @Column(name = "id_pelanggan", length = 4)
    private String idPelanggan;

    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    protected transaksi(){
        // for JPA
    }

    public transaksi(String kodeTransaksi, String tglTransaksi,
            String idPelanggan, String idKaryawan){
        this.kodeTransaksi = kodeTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.idPelanggan = idPelanggan;
        this.idKaryawan = idKaryawan;
    }

    // GETTER & SETTER
    public String getKodeTransaksi(){
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi){
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getTglTransaksi(){
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi){
        this.tglTransaksi = tglTransaksi;
    }

    public String getIdPelanggan(){
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan){
        this.idPelanggan = idPelanggan;
    }

    public String getIdKaryawan(){
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan){
        this.idKaryawan = idKaryawan;
    }
}
