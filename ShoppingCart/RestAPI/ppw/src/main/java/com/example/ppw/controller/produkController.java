package com.example.ppw.controller;


import com.example.ppw.model.produk;
import com.example.ppw.repository.produkRepo;
import com.example.ppw.repository.testNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoppingcart")
public class produkController {
    @Autowired
    com.example.ppw.repository.produkRepo produkRepo;
    @CrossOrigin
    @GetMapping("/produk")
    public List<produk>retrieveAllproduk(){ return produkRepo.findAll();}
    @CrossOrigin
    @GetMapping("/produk/{kode}")
    public produk retrieveproduk(@PathVariable Integer kode){
        Optional<produk> test= produkRepo.findById(kode);
        if (!test.isPresent())
            throw new testNotFoundException("kode-" + kode);
        return test.get();
    }
    @CrossOrigin
    @PostMapping("/produk/save")
    public produk save(@RequestBody  produk produk){
        produk produk1=new produk(
                produk.getKode(),
                produk.getNama(),
                produk.getHarga(),
                produk.getPhoto(),
                produk.getRam(),
                produk.getRom(),
                produk.getProcessor()
        );
        return produkRepo.save(produk1);
    }
    @CrossOrigin
    @DeleteMapping("/produk/delete/{kode}")
    public String deleteproduk(@PathVariable Integer kode){
        produkRepo.deleteById(kode);
        return "sukses";
    }

}
