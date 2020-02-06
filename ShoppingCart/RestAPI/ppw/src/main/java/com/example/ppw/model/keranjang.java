package com.example.ppw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keranjang" )
public class keranjang {
    @Id
    @Column(name = "kode")
    private Integer kode;
    @Column(name = "nama")
    private String nama;
    @Column(name = "harga")
    private Integer harga;
    @Column(name = "photo")
    private String photo;

    public keranjang(Integer kode, String nama, Integer harga, String photo) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.photo = photo;
    }

    public keranjang(){

    }

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
