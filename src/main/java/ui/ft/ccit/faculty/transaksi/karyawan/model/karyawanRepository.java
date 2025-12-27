package ui.ft.ccit.faculty.transaksi.karyawan.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KaryawanRepository extends JpaRepository<Karyawan, String>{
    // Cari berdasarkan nama yang mengandung kata tertentu
    List<Karyawan> findByNamaContainingIgnoreCase(String keyword);

    // Cari nama berdasarkan kelamin
    List<Karyawan> findByJenisKelamin(String jenisKelamin);

    // Berapa banyak barang dengan id tertentu
    long countByIdKaryawanIn(List<String> ids);
}
