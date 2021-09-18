package com.ceutec.ruth.proyectoFinal;

import com.ceutec.ruth.proyectoFinal.datos.BaseDeDatos;
import com.ceutec.ruth.proyectoFinal.modelos.Producto;
import com.ceutec.ruth.proyectoFinal.servicios.ProcesosProductos;
import java.util.ArrayList;
import java.util.Scanner;

public class Citta {

    public static void main(String[] args) {
        // Creación de varios objetos Scanner para los diferentes tipos de entradas por parte del usuario.
        Scanner ingresoString = new Scanner(System.in);
        Scanner ingresoInt = new Scanner(System.in);
        Scanner ingresoChar = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<Producto>();

        // Creación de los objetos de las clases donde están la base de datos y los métodos para manipular productos.
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        ProcesosProductos accion = new ProcesosProductos();
        
        boolean control = true;
        String[] menu = {"1.- Mostrar productos.", "2.- Buscar producto.", "3.- Agregar producto.", "4.- Editar producto", "5.- Eliminar producto.", "6.- Salir del programa."};
        int opcion = 0;
        String codigo = "";
        char eliminar = 'n';
        
        // Llenar lista con los datos de la base de datos.
        productos = baseDeDatos.obtenerBaseDeDatos();
        productos = accion.ordearProductos(productos);
        
        dividir(25);
        System.out.println("Proyecto final");
        System.out.println("Ruth Martinez | 31951116");
        System.out.println("Citta");
        dividir(25);
        
        boolean validacion = false;
        String validar = "";
        
        do { 
            System.out.println("");
        
            // Mostrar menú en pantalla.
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
             
            System.out.println("");
               
            do {    
                try {
                    System.out.println("Elija una opcion del menu: ");
                    validar = ingresoString.nextLine();

                    int conversion = Integer.valueOf(validar);

                    if (conversion >= 1 && conversion <= 6) {
                        validacion = true;
                        opcion = conversion;
                    } else {
                        validacion = false;
                        System.out.println("La opción debe estar entre 1 y 6.");
                    }
                } catch(Exception error) {
                    validacion = false;
                    System.out.println("Ha introducido un dato no numérico.");
                }
            } while(!validacion);
            
            // Validar opciones del menú.
            Producto resultado = new Producto();
            int indice = 0;
            switch(opcion) {
                case 1:
                    // Mostrar lista de productos.
                    accion.mostrarProductos(productos);
                    break;
                case 2:
                    // Buscar un poducto por código.
                    do {
                        System.out.println("Ingrese el codigo del producto que desea buscar: ");
                        codigo = ingresoString.nextLine();

                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);
                        } else {
                            System.out.println("El producto que desea buscar no existe.");
                            validacion = false;
                        }
                    } while(!validacion);
                    
                    break;
                case 3:
                    // Agregar un nuevo producto (elemento) a la lista.
                    resultado = accion.crearProducto();
                    productos.add(resultado);

                    productos = accion.ordearProductos(productos);
                    break; 
                case 4:
                    // Editar un producto (elemento) de la lista.
                     do {
                        System.out.println("Ingrese el codigo del producto que desea editar: ");
                        codigo = ingresoString.nextLine();

                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);
                            resultado = accion.crearProducto();
                            indice = accion.editarYEliminarProducto(productos, codigo);
                            productos.set(indice, resultado);
                            productos = accion.ordearProductos(productos);
                        } else {
                            System.out.println("El producto que desea editar no existe.");
                            validacion = false;
                        }
                    } while(!validacion);
                    
                    break;
                case 5:
                    // Eliminar un producto (elemento) de la lista.
                    do {
                        System.out.println("Ingrese el codigo del producto que desea eliminar: ");
                        codigo = ingresoString.nextLine();

                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);

                            // Segunda confirmación de eliminación de un producto (elemento) de la lista.
                            System.out.println("¿Esta seguro de que desea eliminar el producto (S o s: Si y N o n: No)?");
                            eliminar = ingresoChar.nextLine().charAt(0);
                            indice = accion.editarYEliminarProducto(productos, codigo);

                            switch(eliminar) {
                                case 'S':
                                    productos.remove(indice);
                                    productos = accion.ordearProductos(productos);
                                    break;
                                case 's':
                                    productos.remove(indice);
                                    productos = accion.ordearProductos(productos);
                                    break;
                                case 'N':
                                    break;
                                case 'n':
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        } else {
                            System.out.println("El producto que desea eliminar no existe.");
                            validacion = false;
                        }
                    } while(!validacion);
                    
                    break;
                case 6:
                    control = false;
                default:
                    System.out.println("Opcion invalida");
            }
        } while(control);
        
        // Cerrar objetos escanner para librarlos de memoria.
        accion.cerrarClase();
        ingresoString.close();
        ingresoInt.close();
        ingresoChar.close();
    }
    
    // Generar una línea del caracter =, n cantidad de veces.
    public static void dividir(int tamanio) {
        String resultado = "";
        
        for (int i = 0; i < tamanio; i++) {
            resultado += "=";
        }
        
        System.out.println(resultado);
    }
}
