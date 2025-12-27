package ui.ft.ccit.faculty.transaksi.jenisBarang.view;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.jenisBarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisBarang.model.JenisBarangRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JenisBarangService {
    private final JenisBarangRepository jenisBarangRepository;

    public JenisBarangService(JenisBarangRepository jenisBarangRepository) {
        this.jenisBarangRepository = jenisBarangRepository;
    }

    // Tampilkan semua jenis barang
    public List<JenisBarang> getAll() {
        return jenisBarangRepository.findAll();
    }

    public List<JenisBarang> getAllWithPagination(int page, int size) {
        return jenisBarangRepository
        .findAll(PageRequest.of(page, size))
        .getContent();
    }

    // Cari jenis barang berdasarkan id
    public JenisBarang getById(Byte id) {
        return jenisBarangRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Jenis Barang dengan id " + id + " tidak ditemukan"));
    }

    // CUSTOM: Cari barang berdasarkan nama tertentu
    public List<JenisBarang> searchByNama(String keyword) {
        return jenisBarangRepository.findByNamaJenisContainingIgnoreCase(keyword);
    }

    // CUSTOM: Cari barang berdasarkan id Jenis
    public List<Barang> getBarangByJenis(Byte idJenis) {
        return jenisBarangRepository.findBarangByJenisId(idJenis);
    }

    // CREATE
    public JenisBarang save(JenisBarang jenisBarang) {
        if (jenisBarang.getIdJenisBarang() != null && jenisBarangRepository.existsById(jenisBarang.getIdJenisBarang())) {
            throw new RuntimeException("Jenis Barang dengan id " + jenisBarang.getIdJenisBarang() + " sudah ada");
        }
        return jenisBarangRepository.save(jenisBarang);
    }

    @Transactional
    public List<JenisBarang> saveBulk(List<JenisBarang> jenisBarangList) {
        for (JenisBarang jb : jenisBarangList) {
            if (jb.getIdJenisBarang() != null && jenisBarangRepository.existsById(jb.getIdJenisBarang())) {
                throw new RuntimeException("Salah satu id sudah ada, operasi dibatalkan");
            }
        }
        return jenisBarangRepository.saveAll(jenisBarangList);
    }

    // UPDATE
    public JenisBarang update(Byte id, JenisBarang updated) {
        JenisBarang existing = getById(id); 

        existing.setNamaJenis(updated.getNamaJenis());

        return jenisBarangRepository.save(existing);
    }

    // DELETE
    public void delete(Byte id) {
        if (!jenisBarangRepository.existsById(id)) {
            throw new RuntimeException("Jenis Barang tidak ditemukan");
        }
        jenisBarangRepository.deleteById(id);
    }

    @Transactional
    public void deleteBulk(List<Byte> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("List id tidak boleh kosong");
        }

        if (ids.size() > 10) {
            throw new IllegalArgumentException("Maksimal 10 data per bulk delete");
        }

        // Cek apakah semua id yang dikirim memang ada di DB
        long existingCount = jenisBarangRepository.countByIdJenisBarangIn(ids);
        if (existingCount != ids.size()) {
            throw new IllegalStateException("Sebagian ID tidak ditemukan, operasi dibatalkan");
        }

        jenisBarangRepository.deleteAllById(ids);
    }
}
