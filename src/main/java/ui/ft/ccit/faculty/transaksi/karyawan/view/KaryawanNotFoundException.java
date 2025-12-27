package ui.ft.ccit.faculty.transaksi.karyawan.view;

public class KaryawanNotFoundException extends RuntimeException{
    public KaryawanNotFoundException(String idKaryawan) {
        super("Karyawan dengan id " + idKaryawan + " sudah ada");
    }
}
