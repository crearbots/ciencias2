package com.example.productos;

public class Producto {
    public String nombre;
    public String id;
    public double precio;
    public String descripcion;

    public Producto(String nombre, String id, double precio, String descripcion) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
