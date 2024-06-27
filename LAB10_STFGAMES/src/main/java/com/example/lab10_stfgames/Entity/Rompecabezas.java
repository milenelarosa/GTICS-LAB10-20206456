package com.example.lab10_stfgames.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.Base64;


@Getter
@Setter
@Entity
@Table(name = "stf_puzzle_sv")
public class Rompecabezas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstf_puzzle_sv;

    @Column
    @NotBlank(message = "Debe ingresar un numero")
    @NumberFormat
    @Positive(message = "Debe ser positivo")
    private String n;

    @Column
    private String stf_game_board_structure;

    @Column
    @Lob
    private byte[] image;

    public void setImagen(byte[] imagen) {
        this.image = imagen;
    }

    //Método para obtener la imagen
    public String getImagenBase64() {
        return (image != null) ? Base64.getEncoder().encodeToString(image) : null;
    }
}
