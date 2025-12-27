package ui.ft.ccit.faculty.transaksi.detailTransaksi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface DetailTransaksiRepository extends JpaRepository<DetailTransaksi, String>{
    // Jumlah barang yang kurang dari angka tertentu
    List<DetailTransaksi> findByJumlahLessThan(Integer jumlah);
}
