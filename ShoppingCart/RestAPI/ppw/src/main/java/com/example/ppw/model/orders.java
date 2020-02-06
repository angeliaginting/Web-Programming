package com.example.ppw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class orders {
    @Id
    @Column(name = "kode")
    private String kode;
    @Column(name = "id_transaksi")
    private String id_transaksi;
    @Column(name = "nama_barang")
    private String nama_barang;
    @Column(name = "harga_barang")
    private Integer harga_barang;
    @Column(name = "total_pembayaran")
    private Integer total_pembayaran;

    public orders(){
    }
    public orders(String kode, String id_transaksi, String nama_barang, Integer harga_barang, Integer total_pembayaran) {
        this.kode = kode;
        this.id_transaksi = id_transaksi;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.total_pembayaran = total_pembayaran;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(Integer harga_barang) {
        this.harga_barang = harga_barang;
    }

    public Integer getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(Integer total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }
}
