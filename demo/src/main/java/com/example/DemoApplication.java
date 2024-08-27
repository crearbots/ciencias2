package com.example;

// import com.example.productos.*;
// import com.example.blockchain.*;
// public class Main {
//     public static void main(String[] args) throws Exception {
//         // Crear una instancia de la clase Datos
//         Datos datos = new Datos();
//         // Cargar los productos desde el archivo JSON
//         datos.cargarProductosDesdeJSON("data/productos.json");
//         System.out.println("Se han cargado " + datos.productos.length + " productos");

//         // Crear la blockchain
//         Blockchain blockchain = new Blockchain();

//         // Simular algunas transacciones
//         blockchain.agregarTransaccion("1", new Producto[]{datos.productos[100062], datos.productos[100063]});
//         blockchain.agregarTransaccion("2", new Producto[]{datos.productos[100064]});
//         blockchain.agregarTransaccion("3", new Producto[]{datos.productos[100065], datos.productos[100066]});

//         // Mostrar la blockchain
//         System.out.println(blockchain);
        
//         // Validar la blockchain
//         System.out.println("¿Blockchain valida? " + blockchain.validarCadena());
//     }
// }
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}