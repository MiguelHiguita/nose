package com.example.Store.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas")

public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;
    @Column(name = "nombreMarca",nullable = false)
    private String nombreMarca; // no vacio obligario y maximo 50
    @Column(name = "nit",nullable = false)
    private String nit; //  solo numeros y maximo 10
    @Column(name = "anoCreacion",nullable = true)
    private String anoCreacion;// obligario
    @Column(name = "sedePrincipal",nullable = true)
    private String sedePrincipal; // no se valida

    public Marca() {
    }

    public Marca(Integer id, String nombreMarca, String nit, String anoCreacion, String sedePrincipal) {
        this.id_marca = id;
        this.nombreMarca = nombreMarca;
        this.nit = nit;
        this.sedePrincipal = sedePrincipal;
        anoCreacion = anoCreacion;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(String anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public String getSedePrincipal() {
        return sedePrincipal;
    }

    public void setSedePrincipal(String sedePrincipal) {
        this.sedePrincipal = sedePrincipal;
    }
}
