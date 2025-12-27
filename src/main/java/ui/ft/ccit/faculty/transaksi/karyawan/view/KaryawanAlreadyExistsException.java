package ui.ft.ccit.faculty.transaksi.karyawan.view;

public class KaryawanAlreadyExistsException extends RuntimeException{
    public KaryawanAlreadyExistsException(String idKaryawan) {
        super("Karyawan dengan id " + idKaryawan + " sudah ada");
    }
}
