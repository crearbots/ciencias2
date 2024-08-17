package com.example.productos;

public class BusquedaBinaria {

    public Producto buscarPorId(Producto[] productos, String id) {
        int inicio = 0;
        int fin = productos.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = productos[medio].id.compareTo(id);

            if (comparacion == 0) {
                return productos[medio];
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }

    public Producto buscarPorNombre(Producto[] productos, String nombre) {
        return null;
    }

}