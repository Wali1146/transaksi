package ui.ft.ccit.faculty.transaksi.pelanggan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pelanggan")
public class pelanggan {
    @Id
    @Column(name = "id_pelangan", length = 4)
    private String idPelanggan;

    @Column(name = "nama", length = 20)
    private String nama;

    @Column(name = "jenis_kelamin", length = 1)
    private String jenisKelamin;

    @Column(name = "alamat", length = 50)
    private String alamat;

    @Column(name = "telepon", length = 15)
    private String telepon;

    @Column(name = "tgl_lahir")
    private String tglLahir;

    @Column(name = "jenis_pelanggan", length = 1)
    private String jenisPelanggan;

    protected pelanggan(){
        // for JPA
    }

    public pelanggan(String idPelanggan, String nama, String jenisKelamin,
            String alamat, String telepon, String tglLahir, String jenisPelanggan){
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tglLahir = tglLahir;
        this.jenisPelanggan = jenisPelanggan;
    }

    // GETTER & SETTER
    public String getIdPelanggan(){
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan){
        this.idPelanggan = idPelanggan;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getJenisKelamin(){
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getTelepon(){
        return telepon;
    }

    public void setTelepon(String telepon){
        this.telepon = telepon;
    }

    public String getTglLahir(){
        return tglLahir;
    }

    public void setTglLahir(String tglLahir){
        this.tglLahir = tglLahir;
    }

    public String getJenisPelanggan(){
        return jenisPelanggan;
    }

    public void setJenisPelanggan(String jenisPelanggan){
        this.jenisPelanggan = jenisPelanggan;
    }
}
