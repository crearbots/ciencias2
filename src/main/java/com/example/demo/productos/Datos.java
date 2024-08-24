package com.example.demo.productos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class Datos {
    public Producto[] productos;

    // Método para cargar los productos desde un archivo JSON
    public void cargarProductosDesdeJSON(String rutaArchivo) throws Exception {
        // Usar getResourceAsStream para cargar el archivo desde el classpath
        try (Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(rutaArchivo))) {
            Gson gson = new Gson();
            List<Producto> listaProductos = gson.fromJson(reader, new TypeToken<List<Producto>>() {
            }.getType());

            // Convertir la lista a un array
            productos = listaProductos.toArray(new Producto[0]);
        } catch (NullPointerException e) {
            System.out.println("No se encontró el archivo: " + rutaArchivo);
            e.printStackTrace();
        }
    }

    // Método para mostrar los productos
    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.id + ", Nombre: " + producto.nombre + ", Precio: " + producto.precio
                    + ", Descripción: " + producto.descripcion);
        }
    }
}
