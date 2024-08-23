package com.example.blockchain;

import com.example.productos.Producto;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Transaccion {
    private String idTransaccion;
    private Producto[] productos;
    private long timestamp;
    private String hashAnterior;
    private String hashActual;

    public Transaccion(String idTransaccion, Producto[] productos, long timestamp, String hashAnterior) throws NoSuchAlgorithmException {
        this.idTransaccion = idTransaccion;
        this.productos = productos;
        this.timestamp = timestamp;
        this.hashAnterior = hashAnterior;
        this.hashActual = generarHash();
    }

    private String generarHash() throws NoSuchAlgorithmException {
        String datos = obtenerDatosParaHash();
        return HashUtil.generarSHA256(datos);
    }
    
    public String getHashActual() {
        return hashActual;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransaccion=" + idTransaccion + '\'' +
                ", productos=" + Arrays.toString(productos) +
                ", timestamp=" + timestamp +
                ", hashAnterior='" + hashAnterior + '\'' +
                ", hashActual='" + hashActual + '\'' +
                '}';
    }

    public String obtenerDatosParaHash() {
        return idTransaccion + Arrays.toString(productos) + timestamp + hashAnterior;
    }

}