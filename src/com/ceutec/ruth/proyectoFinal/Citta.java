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
        
        // Variables para validación de campos numéricos.
        boolean validacion = false;
        String validar = "";
        
        do { 
            System.out.println("");
        
            // Mostrar menú en pantalla.
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
               
            do {
                // Nos aprovechamos del error de conversión de texto a número (Integer.valueOf()) para identificar si es un número.
                try {
                    System.out.println("\nElija una opcion del menu: ");
                    validar = ingresoString.nextLine();

                    int conversion = Integer.valueOf(validar);

                    if (conversion >= 1 && conversion <= 6) {
                        validacion = true;
                        opcion = conversion;
                    } else {
                        validacion = false;
                        System.out.println("\n\tLa opción debe estar entre 1 y 6.");
                    }
                } catch(Exception error) {
                    validacion = false;
                    System.out.println("\n\tHa introducido un dato no numérico.");
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
                        System.out.println("Ingrese el código del producto que desea buscar: ");
                        codigo = ingresoString.nextLine();

                        // Verificar si existe el producot en la base de datos.
                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);
                        } else {
                            System.out.println("\n\tEl producto que desea buscar no existe.");
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
                        System.out.println("Ingrese el código del producto que desea editar: ");
                        codigo = ingresoString.nextLine();

                        // Verificar si existe el producot en la base de datos.
                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);
                            resultado = accion.crearProducto();
                            indice = accion.editarYEliminarProducto(productos, codigo);
                            productos.set(indice, resultado);
                            productos = accion.ordearProductos(productos);
                        } else {
                            System.out.println("\n\tEl producto que desea editar no existe.");
                            validacion = false;
                        }
                    } while(!validacion);
                    
                    break;
                case 5:
                    // Eliminar un producto (elemento) de la lista.
                    do {
                        System.out.println("Ingrese el código del producto que desea eliminar: ");
                        codigo = ingresoString.nextLine();

                        // Verificar si existe el producot en la base de datos.
                        if (accion.existeElProducto(productos, codigo)) {
                            validacion = true;
                            resultado = accion.buscarProducto(productos, codigo);
                            accion.mostrarProducto(resultado);                            

                            boolean validacionEliminacion = false;
                            
                            do {
                                // Segunda confirmación de eliminación de un producto (elemento) de la lista.
                                System.out.println("\n\t¿Está seguro que desea eliminar el producto (S o s: Sí y N o n: No)?");
                                eliminar = ingresoChar.nextLine().charAt(0);
                                indice = accion.editarYEliminarProducto(productos, codigo);

                                switch(eliminar) {
                                    case 'S':
                                        validacionEliminacion = true;
                                        productos.remove(indice);
                                        productos = accion.ordearProductos(productos);
                                        break;
                                    case 's':
                                        validacionEliminacion = true;
                                        productos.remove(indice);
                                        productos = accion.ordearProductos(productos);
                                        break;
                                    case 'N':
                                        validacionEliminacion = true;
                                        break;
                                    case 'n':
                                        validacionEliminacion = true;
                                        break;
                                    default:
                                        validacionEliminacion = false;
                                        System.out.println("\n\tOpcion inválida");
                                        break;
                                }
                            } while(!validacionEliminacion);
                        } else {
                            System.out.println("\n\tEl producto que desea eliminar no existe.");
                            validacion = false;
                        }
                    } while(!validacion);
                    
                    break;
                case 6:
                    control = false;
            }
        } while(control);
        
        // Cerrar objetos escanner para liberarlos de la memoria.
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
