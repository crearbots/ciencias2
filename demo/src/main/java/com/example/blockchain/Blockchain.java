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
        for (int i = 1; i < cadena.size(); i++) {
            Transaccion actual = cadena.get(i);
            Transaccion anterior = cadena.get(i -1);

            // Validar hash actual
            try {
                if (!actual.getHashActual().equals(HashUtil.generarSHA256(actual.toString())));
                return false;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            // Validar hash anterior
            if (!actual.getHashAnterior().equals(anterior.getHashActual())) {
                return false;
            }
        }
        return true;
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
}