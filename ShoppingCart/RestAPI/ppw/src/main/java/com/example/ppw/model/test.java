package com.example.ppw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class test {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "kelas")

    private String kelas;

    public test(){

    }
    public test(Integer id, String nama, String kelas) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
