package com.example.ppw.controller;

import com.example.ppw.model.orders;
import com.example.ppw.repository.ordersRepo;
import com.example.ppw.repository.testNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoppingcart")
public class ordersController {
    @Autowired
    com.example.ppw.repository.ordersRepo ordersRepo;
    @CrossOrigin
    @GetMapping("/orders")
    public List<orders>retrieveAllorders(){
        return ordersRepo.findAll();
    }
    @CrossOrigin
    @GetMapping("orders/{kode}")
    public orders retrievetest(@PathVariable String kode){
        Optional<orders> test= ordersRepo.findById(kode);
        if (!test.isPresent())
            throw new testNotFoundException("kode-" + kode);
        return test.get();
    }
    @CrossOrigin
    @PostMapping("orders/save")
    public orders save(@RequestBody  orders orders){
        orders orders1=new orders(
                orders.getKode(),
                orders.getId_transaksi(),
                orders.getNama_barang(),
                orders.getHarga_barang(),
                orders.getTotal_pembayaran()
        );
        return ordersRepo.save(orders1);
    }
    @CrossOrigin
    @DeleteMapping("orders/{kode}")
    public void deletetest(@PathVariable String kode){
        ordersRepo.deleteById(kode);
    }

}
