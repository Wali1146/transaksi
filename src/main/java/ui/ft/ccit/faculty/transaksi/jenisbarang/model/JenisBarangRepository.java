package ui.ft.ccit.faculty.transaksi.jenisBarang.model;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JenisBarangRepository extends JpaRepository<JenisBarang, Byte> {
    // cari berdasarkan nama jenis
    List<JenisBarang> findByNamaJenisContainingIgnoreCase(String keyword);

    // cari barang berdasarkan suatu jenis
    @Query("SELECT b FROM Barang b WHERE b.idJenisBarang = :id")
    List<Barang> findBarangByJenisId(@Param("id") Byte id);

    // Berapa banyak jenis barang berdasarkan id
    long countByIdJenisBarangIn(List<Byte> ids);
}
