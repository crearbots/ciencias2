package com.example.services;

import org.springframework.stereotype.Service;

import com.example.blockchain.Blockchain;
import com.example.productos.Datos;
import com.example.productos.Producto;

import lombok.Data;

@Data
@Service
public class BlockchainServices {
    public void getBlockchainTransactions(String id,int idProducto1,int idProducto2) {
        Datos datos = new Datos();
        try {
            datos.cargarProductosDesdeJSON("data/productos.json");
            Blockchain blockchain = new Blockchain();
            blockchain.agregarTransaccion(id, new Producto[]{datos.productos[idProducto1], datos.productos[idProducto2]});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
