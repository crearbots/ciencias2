package com.example;

import com.example.productos.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear una instancia de la clase Datos
        Datos datos = new Datos();
        // Cargar los productos desde el archivo JSON
        datos.cargarProductosDesdeJSON("data/productos.json");
        System.out.println("Se han cargado " + datos.productos.length + " productos");

        // Instanciar la búsqueda secuencial
        BusquedaSecuencial busqueda = new BusquedaSecuencial();
        BusquedaBinaria bina = new BusquedaBinaria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de búsqueda:");
            System.out.println("1. Buscar producto por ID");
            System.out.println("2. Buscar producto por ID B");
            System.out.println("3. Buscar producto por Nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            // Declaración de variables
            String id;
            long startTimeId;
            Producto productoId;
            long endTimeId;
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto: ");
                    id = scanner.nextLine();
                    startTimeId = System.nanoTime();
                    productoId = busqueda.buscarPorId(datos.productos, id);
                    endTimeId = System.nanoTime();
                    if (productoId != null) {
                        System.out.println("Producto encontrado: " + productoId);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeId - startTimeId) + " nanosegundos.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del producto: ");
                    id = scanner.nextLine();
                    startTimeId = System.nanoTime();
                    productoId = bina.buscarPorId(datos.productos, id);
                    long endTimeId1 = System.nanoTime();
                    if (productoId != null) {
                        System.out.println("Producto encontrado: " + productoId);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeId1 - startTimeId) + " nanosegundos.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    long startTimeNombre = System.nanoTime();
                    Producto productoNombre = busqueda.buscarPorNombre(datos.productos, nombre);
                    long endTimeNombre = System.nanoTime();
                    if (productoNombre != null) {
                        System.out.println("Producto encontrado: " + productoNombre);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeNombre - startTimeNombre) + " nanosegundos.");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }        
    }
}
