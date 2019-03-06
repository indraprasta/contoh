/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.perpustakaan;

import org.sql2o.Connection;

/**
 *
 * @author asus
 */
public class Anggota {
    private int id_anggota;
    private String nama_anggota;
    private String kelas;

    public Anggota(String nama_anggota, String kelas) {
        this.nama_anggota = nama_anggota;
        this.kelas = kelas;
    }
    
    public int insertAnggota() {
        try (Connection connection = DB.sql2o.open()) {
            final String query = "INSERT INTO anggota (nama_anggota, kelas) VALUES (:nama_anggota, :kelas)";
            connection.createQuery(query).bind(this).executeUpdate();
            return connection.getResult();
        }
    }
    
    public static Anggota anggota(int id_anggota) {
        try (Connection connection = DB.sql2o.open()) {
            final String query = "SELECT * FROM anggota WHERE id_anggota = :id_anggota";
            return connection.createQuery(query)
                    .addParameter("id_anggota", id_anggota)
                    .executeAndFetchFirst(Anggota.class);
        }
    }

    public int getId_anggota() {
        return id_anggota;
    }

    public String getNama_anggota() {
        return nama_anggota;
    }

    public String getKelas() {
        return kelas;
    }
}
