package com.example;

import com.example.productos.*;
import com.example.blockchain.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear una instancia de la clase Datos
        Datos datos = new Datos();
        // Cargar los productos desde el archivo JSON
        datos.cargarProductosDesdeJSON("data/productos.json");
        System.out.println("Se han cargado " + datos.productos.length + " productos");

        // Crear la blockchain
        Blockchain blockchain = new Blockchain();

        // Simular algunas transacciones
        blockchain.agregarTransaccion("1", new Producto[]{datos.productos[100062], datos.productos[100063]});
        blockchain.agregarTransaccion("2", new Producto[]{datos.productos[100064]});
        blockchain.agregarTransaccion("3", new Producto[]{datos.productos[100065], datos.productos[100066]});

        // Mostrar la blockchain
        System.out.println(blockchain);
        
        // Validar la blockchain
        System.out.println("¿Blockchain valida? " + blockchain.validarCadena());

        // Modificar
        System.out.println("Se cambia el ID de la primera transacción");
        blockchain.modificarTransaccion(0, "3");
/*------------------------------------------------------------
        // Instanciar la búsqueda secuencial
        BusquedaSecuencial busqueda = new BusquedaSecuencial();
        BusquedaBinaria bina = new BusquedaBinaria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de búsqueda:");
            System.out.println("1. Buscar producto por ID");
            System.out.println("2. Buscar producto por ID B");
            System.out.println("3. Buscar producto por Nombre");
            System.out.println("4. Buscar producto por Nombre B");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            // Declaración de variables
            String id;
            long startTimeId,startTimeNombre;
            Producto productoId, productoNombre;
            long endTimeId, endTimeNombre;
            String nombre;

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
                    Arrays.sort(datos.productos, Comparator.comparing(Producto::getID));
                    System.out.print("Ingrese el ID del producto: ");
                    id = scanner.nextLine();
                    startTimeId = System.nanoTime();
                    productoId = bina.buscarPorId(datos.productos, id);
                    endTimeId = System.nanoTime();
                    if (productoId != null) {
                        System.out.println("Producto encontrado: " + productoId);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeId - startTimeId) + " nanosegundos.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto: ");
                    nombre = scanner.nextLine();
                    startTimeNombre = System.nanoTime();
                    productoNombre = busqueda.buscarPorNombre(datos.productos, nombre);
                    endTimeNombre = System.nanoTime();
                    if (productoNombre != null) {
                        System.out.println("Producto encontrado: " + productoNombre);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeNombre - startTimeNombre) + " nanosegundos.");
                    break;
                case 4:
                Arrays.sort(datos.productos, Comparator.comparing(p -> p.getNombre() == null ? "" : p.getNombre()));
                    System.out.print("Ingrese el nombre del producto: ");
                    nombre = scanner.nextLine();
                    startTimeNombre = System.nanoTime();
                    productoNombre = bina.buscarPorNombre(datos.productos, nombre);
                    endTimeNombre = System.nanoTime();
                    if (productoNombre != null) {
                        System.out.println("Producto encontrado: " + productoNombre);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    System.out.println("Tiempo de búsqueda: " + (endTimeNombre - startTimeNombre) + " nanosegundos.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }        
-------------------------------------------------------    */
    }
}
