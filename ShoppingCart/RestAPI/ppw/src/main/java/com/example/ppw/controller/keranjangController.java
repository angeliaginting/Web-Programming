package com.example.ppw.controller;

import com.example.ppw.model.keranjang;
import com.example.ppw.model.produk;
import com.example.ppw.repository.keranjangRepo;
import com.example.ppw.repository.testNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoppingcart")
public class keranjangController {
    @Autowired
    com.example.ppw.repository.keranjangRepo keranjangRepo;
    @CrossOrigin
    @GetMapping("/keranjang")
    public List<keranjang> retrieveAllproduk(){ return keranjangRepo.findAll();}
    @CrossOrigin
    @GetMapping("/keranjang/{kode}")
    public keranjang retrievekeranjang(@PathVariable Integer kode){
        Optional<keranjang> test= keranjangRepo.findById(kode);
        if (!test.isPresent())
            throw new testNotFoundException("kode-" + kode);
        return test.get();
    }
    @CrossOrigin
    @PostMapping("/keranjang/save")
    public keranjang save(@RequestBody keranjang keranjang){
        keranjang keranjang1 = new keranjang(
                keranjang.getKode(),
                keranjang.getNama(),
                keranjang.getHarga(),
                keranjang.getPhoto()
        );
        return keranjangRepo.save(keranjang1);
    }
    @CrossOrigin
    @DeleteMapping("/keranjang/delete/{kode}")
    public String deletekeranjang(@PathVariable Integer kode){
            keranjangRepo.deleteById(kode);
            return "Data berhasil dihapus";
    }

}
