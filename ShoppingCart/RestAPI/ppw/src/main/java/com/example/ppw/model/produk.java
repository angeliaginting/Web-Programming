package com.example.ppw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="produk")
public class produk {
    @Id
    @Column(name = "kode")
    private Integer kode;
    @Column(name = "nama")
    private String nama;
    @Column(name = "harga")
    private Integer harga;
    @Column(name = "photo")
    private String photo;
    @Column(name = "ram")
    private String ram;
    @Column(name ="rom")
    private String rom;
    @Column (name = "processor")
    private String processor;

    public produk(){
    }

    public produk(Integer kode, String nama, Integer harga, String photo, String ram, String rom, String processor) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.photo = photo;
        this.ram = ram;
        this.rom = rom;
        this.processor = processor;
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

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
