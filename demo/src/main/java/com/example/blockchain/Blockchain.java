package com.example.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.example.productos.Producto;

public class Blockchain {
    private List<Transaccion> cadena;

    public Blockchain() {
        this.cadena = new ArrayList<>();
        // Crear el bloque genesis
        try {
            Transaccion genesis = new Transaccion("0", new Producto[0], System.currentTimeMillis(), "00000000");
            cadena.add(genesis);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void agregarTransaccion(String idTransaccion, Producto[] productos) throws NoSuchAlgorithmException {
        Transaccion ultimaTransaccion = cadena.get(cadena.size() - 1);
        Transaccion nuevaTransaccion = new Transaccion(idTransaccion, productos, System.currentTimeMillis(), ultimaTransaccion.getHashActual());
        cadena.add(nuevaTransaccion);
    }
    
    public boolean validarCadena() {
        for (int i = 1; i < cadena.size(); i++) { // Empieza desde el segundo bloque
            Transaccion actual = cadena.get(i);
            Transaccion anterior = cadena.get(i -1);
            
            // Mostrar el hash almacenado en la transacción actual
            //System.out.println("Hash actual (almacenado): " + actual.getHashActual());

            // Validar hash actual
            try {
                String hashGenerado = HashUtil.generarSHA256(actual.obtenerDatosParaHash());
                //System.out.println("Hash actual (generado): " + hashGenerado);

                // Comparar longitudes antes de hacer la comparación de contenido
                if (actual.getHashActual().trim().length() != hashGenerado.length()) {
                    System.out.println("Error: Longitudes no coinciden en la transacción " + i);
                    return false;
                }

                if (!actual.getHashActual().trim().equals(hashGenerado)) {
                    System.out.println("Error: Hashes no coinciden en la transacción " + i);
                    return false;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            // Mostrar el hash anterior almacenado en la transacción actual
            //System.out.println("Hash anterior (almacenado): " + actual.getHashAnterior());

            // Mostrar el hash actual del bloque anterior
            //System.out.println("Hash anterior (del bloque anterior): " + anterior.getHashActual());


            // Validar hash anterior
            if (!actual.getHashAnterior().equals(anterior.getHashActual())) {
                System.out.println("Error: Hashes anteriores no coinciden en la transacción " + i);
                return false;
            }
        }
        return true; // Si todos los hashes coinciden, la cadena es valida
    }

    public List<Transaccion> getCadena() {
        return cadena;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Transaccion transaccion : cadena) {
            builder.append(transaccion).append("\n");
        }
        return builder.toString();
    }

    public void modificarTransaccion(int indice,String idnuevo) throws NoSuchAlgorithmException {
        if (indice < 0 || indice >= cadena.size()) {
          throw new IllegalArgumentException("Índice inválido: " + indice);
        }
        Transaccion inicial = cadena.get(indice);
        Producto[] productos=inicial.getProductos();
        String currentHash = inicial.getHashActual();
        inicial= new Transaccion(idnuevo, productos, indice, currentHash);
        if (cadena.get(indice+1).getHashAnterior()!=inicial.getHashActual()) {
            System.out.println("¡Alerta! Intento de fraude en la transaccion " + indice);
            // Imprimir los hash
            System.out.println("Hash original: " + cadena.get(indice+1).getHashAnterior());
            System.out.println("Hash nuevo: " + inicial.getHashActual());
        }
      }

}