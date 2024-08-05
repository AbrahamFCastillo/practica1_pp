package com.ejercicio.model;

public class Automovil { 
    private Integer id;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getanioFabricacion() {
        return anioFabricacion;
    }

    public void setanioFabricacion(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + "]";
    }
}
