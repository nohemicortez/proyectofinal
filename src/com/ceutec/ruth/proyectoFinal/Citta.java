package com.ceutec.ruth.proyectoFinal;

import com.ceutec.ruth.proyectoFinal.datos.BaseDeDatos;
import com.ceutec.ruth.proyectoFinal.modelos.Producto;
import com.ceutec.ruth.proyectoFinal.servicios.ProcesosProductos;
import java.util.ArrayList;
import java.util.Scanner;

public class Citta {

    public static void main(String[] args) {
        Scanner ingresoInt = new Scanner(System.in);
        Scanner ingresoChar = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<Producto>();

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        ProcesosProductos accion = new ProcesosProductos();
        
        boolean control = true;
        String[] menu = {"1.- Mostrar productos.", "2.- Buscar producto.", "3.- Agregar producto.", "4.- Editar producto", "5.- Eliminar producto."};
        int opcion = 0;
        int codigo = 0;
        char eliminar = 'n';
        
        productos = baseDeDatos.obtenerBaseDeDatos();
        
        dividir(25);
        System.out.println("Proyecto final");
        System.out.println("Ruth Martinez | 31951116");
        System.out.println("Citta");
        dividir(25);
        
        do {            
            System.out.println("");
        
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }

            System.out.println("");
            System.out.println("Elija una opcion del menu: ");
            
            while(!ingresoInt.hasNextInt()) {
                ingresoInt.next();
            }
            
            opcion = ingresoInt.nextInt();

            Producto resultado = new Producto();
            int indice = 0;
            switch(opcion) {
                case 1:
                    accion.mostrarProductos(productos);
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del producto que desea buscar: ");
                    codigo = ingresoInt.nextInt();

                    resultado = accion.buscarProducto(productos, codigo);
                    accion.mostrarProducto(resultado);
                    break;
                case 3:
                    resultado = accion.crearProducto();
                    productos.add(resultado);

                    productos = accion.ordearProductos(productos);
                    break; 
                case 4:
                    System.out.println("Ingrese el codigo del producto que desea editar: ");
                    codigo = ingresoInt.nextInt();

                    resultado = accion.buscarProducto(productos, codigo);
                    accion.mostrarProducto(resultado);
                    resultado = accion.crearProducto();
                    indice = accion.editarYEliminarProducto(productos, codigo);
                    productos.set(indice, resultado);
                    break;
                case 5:
                    System.out.println("Ingrese el codigo del producto que desea eliminar: ");
                    codigo = ingresoInt.nextInt();

                    resultado = accion.buscarProducto(productos, codigo);
                    accion.mostrarProducto(resultado);

                    System.out.println("¿Esta seguro de que desea eliminar el producto (S o s: Si y N o n: No)?");
                    eliminar = ingresoChar.nextLine().charAt(0);
                    indice = accion.editarYEliminarProducto(productos, codigo);

                    switch(eliminar) {
                        case 'S':
                            productos.remove(indice);
                            break;
                        case 's':
                            productos.remove(indice);
                            break;
                        case 'N':
                            productos.remove(indice);
                            break;
                        case 'n':
                            productos.remove(indice);
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while(control);
        
        ingresoInt.close();
        ingresoChar.close();
    }
    
    public static void dividir(int tamanio) {
        String resultado = "";
        
        for (int i = 0; i < tamanio; i++) {
            resultado += "=";
        }
        
        System.out.println(resultado);
    }
}
