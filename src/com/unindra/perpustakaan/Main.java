/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.perpustakaan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static com.unindra.perpustakaan.Anggota.anggota;

/**
 *
 * @author asus
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField namaField = new TextField();
        namaField.setPromptText("Nama Anggota");
        
        TextField kelasField = new TextField();
        kelasField.setPromptText("Kelas");
        
        Button tambahButton = new Button();
        tambahButton.setText("Tambah Anggota");
        
        tambahButton.setOnAction((ActionEvent event) -> {
            Anggota anggota = new Anggota(namaField.getText(), kelasField.getText());
            if (anggota.insertAnggota() > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Anggota");
                alert.setContentText("Data anggota berhasil ditambahkan");
                alert.show();
                
                namaField.setText("");
                kelasField.setText("");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Anggota");
                alert.setContentText("Data gagal ditambahkan");
                alert.show();
            }
        });
        
        TextField cariField = new TextField();
        cariField.setPromptText("Id Anggota");
        
        Button cariButton = new Button();
        cariButton.setText("Cari Anggota");
        
        cariButton.setOnAction((ActionEvent event) -> {
            Anggota anggota = anggota(Integer.valueOf(cariField.getText()));
            if (anggota != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Anggota");
                alert.setContentText("Data berhasil ditemukan. Nama = "+anggota.getNama_anggota()+", Kelas = "+anggota.getKelas());
                alert.show();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Anggota");
                alert.setContentText("Data tidak ditemukan");
                alert.show();
            }
        });
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10.0);
        root.getChildren().addAll(namaField, kelasField, tambahButton, cariField, cariButton);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Contoh");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
