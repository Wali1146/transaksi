package ui.ft.ccit.faculty.transaksi.jenisBarang.controller;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.jenisBarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisBarang.view.JenisBarangService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/jenisBarang")
public class JenisBarangController {
    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    // GET list semua jenis barang
    @Operation(summary = "Mendapatkan daftar semua jenis barang dengan opsi pagination")
    @GetMapping
    public List<JenisBarang> list(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        // TANPA pagination
        if (page == null && size == null) {
            return service.getAll();
        }

        // DENGAN pagination
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 5;
        return service.getAllWithPagination(p, s);
    }

    // GET satu jenis barang by id
    @Operation(summary = "Mendapatkan jenis barang berdasarkan id")
    @GetMapping("/{id}")
    public JenisBarang get(@PathVariable Byte id) {
        return service.getById(id);
    }

    // SEARCH by nama
    @Operation(summary = "Mencari jenis barang berdasarkan nama")
    @GetMapping("/search")
    public List<JenisBarang> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    // GET barang by id jenis
    @Operation(summary = "Mendapatkan daftar barang berdasarkan id jenis")
    @GetMapping("/barangByJenis")
    public List<Barang> getBarangByJenis(@RequestParam Byte id){
        return service.getBarangByJenis(id);
    }

    // POST - create jenis barang baru
    @Operation(summary = "Membuat jenis barang baru")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return service.save(jenisBarang);
    }

    // POST - create barang bulk baru
    @Operation(summary = "Membuat beberapa jenis barang secara bulk")
    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<JenisBarang> createBulk(@RequestBody List<JenisBarang> jenisBarang) {
        return service.saveBulk(jenisBarang);
    }

    // PUT - edit/update barang
    @Operation(summary = "Memperbarui jenis barang berdasarkan id")
    @PutMapping("/{id}")
    public JenisBarang update(@PathVariable Byte id, @RequestBody JenisBarang jenisBarang) {
        return service.update(id, jenisBarang);
    }

    // DELETE - hapus multiple barang
    @Operation(summary = "Menghapus beberapa jenis barang secara bulk berdasarkan daftar id")
    @DeleteMapping("/bulk")
    public void deleteBulk(@RequestBody List<Byte> ids) {
        service.deleteBulk(ids);
    }

    // DELETE - hapus barang
    @Operation(summary = "Menghapus jenis barang berdasarkan id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Byte id) {
        service.delete(id);
    }
}
