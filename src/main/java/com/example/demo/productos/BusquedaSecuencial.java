package com.example.demo.productos;

public class BusquedaSecuencial {

    public Producto buscarPorId(Producto[] productos, String id) {
        for (Producto producto : productos) {
            if (producto.id.equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarPorNombre(Producto[] productos, String nombre) {
        for (Producto producto : productos) {
            if (producto.nombre != null && producto.nombre.equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

}
