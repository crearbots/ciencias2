package com.example;

import com.example.productos.Datos;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear una instancia de la clase Datos
        Datos datos = new Datos();

        // Cargar los productos desde el archivo JSON
        datos.cargarProductosDesdeJSON("data/productos.json");
        // Mostrar los productos cargados
        System.out.println("Se han cargado " + datos.productos.length + " productos");
    }
}
