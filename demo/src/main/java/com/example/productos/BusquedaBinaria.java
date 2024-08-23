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
        
    
        int inicio = 0;
        int fin = productos.length - 1;
    
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            String nombreMedio = productos[medio].getNombre();
            
            // Manejar casos nulos y realizar la comparación
            if (nombreMedio == null) {
                if (nombre == null) {
                    return productos[medio]; // Ambos nombres son nulos
                } else {
                    // El nombre del producto en la posición media es nulo, buscar en la mitad superior
                    inicio = medio + 1;
                }
            } else if (nombre == null) {
                // El nombre buscado es nulo, pero el nombre del producto en la posición media no lo es
                fin = medio - 1;
            } else {
                int comparacion = nombreMedio.compareToIgnoreCase(nombre);
                if (comparacion == 0) {
                    return productos[medio];
                } else if (comparacion < 0) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
        }
    
        return null;
    }
}