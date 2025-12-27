package ui.ft.ccit.faculty.transaksi.barang.controller;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.view.BarangService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/barang")
public class BarangController {

    private final BarangService service;

    public BarangController(BarangService service) {
        this.service = service;
    }

    // GET list semua barang
    @Operation(summary = "Mendapatkan daftar semua barang dengan opsi pagination")
    @GetMapping
    public List<Barang> list(
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

    // GET satu barang by id
    @Operation(summary = "Mendapatkan barang berdasarkan id")
    @GetMapping("/{id}")
    public Barang get(@PathVariable String id) {
        return service.getById(id);
    }

    // SEARCH by nama
    @Operation(summary = "Mencari barang berdasarkan nama")
    @GetMapping("/search")
    public List<Barang> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    // POST - create barang baru
    @Operation(summary = "Membuat barang baru")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Barang create(@RequestBody Barang barang) {
        return service.save(barang);
    }

    // POST - create barang bulk baru
    @Operation(summary = "Membuat beberapa barang secara bulk")
    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Barang> createBulk(@RequestBody List<Barang> barang) {
        return service.saveBulk(barang);
    }

    // PUT - edit/update barang
    @Operation(summary = "Memperbarui barang berdasarkan id")
    @PutMapping("/{id}")
    public Barang update(@PathVariable String id, @RequestBody Barang barang) {
        return service.update(id, barang);
    }

    // DELETE - hapus multiple barang
    @Operation(summary = "Menghapus beberapa barang secara bulk berdasarkan daftar id")
    @DeleteMapping("/bulk")
    public void deleteBulk(@RequestBody List<String> ids) {
        service.deleteBulk(ids);
    }

    // DELETE - hapus barang
    @Operation(summary = "Menghapus barang berdasarkan id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
